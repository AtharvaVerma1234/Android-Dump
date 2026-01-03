package com.vermaatharva.chatapp

import android.net.Uri
import android.os.Message
import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.toObject
import com.google.firebase.storage.FirebaseStorage
import com.vermaatharva.chatapp.data.Event
import com.vermaatharva.chatapp.data.USER_NODE
import com.vermaatharva.chatapp.data.UserData
import dagger.hilt.android.lifecycle.HiltViewModel
import java.lang.Exception
import java.util.UUID
import javax.inject.Inject
import kotlin.math.sign

@HiltViewModel
class ChatViewModel @Inject constructor(
    val auth: FirebaseAuth,
    var db:FirebaseFirestore,
    val storage: FirebaseStorage
) : ViewModel() {


    var inProgress = mutableStateOf(false)
    val eventMutableState = mutableStateOf<Event<String>?>(null)
    var signIn= mutableStateOf(false)
    val userData= mutableStateOf<UserData?>(null)

    init {
        val currentUser=auth.currentUser
        signIn.value=currentUser!=null

        currentUser?.uid?.let {
            getUserData(it)
        }
    }


    fun SignUp(name: String, number: String, email: String, password: String) {
        inProgress.value = true
        if(name.isEmpty() or number.isEmpty() or email.isEmpty() or password.isEmpty()){
            handleException(customMessage = "Please enter all the fields")
            return
        }
        inProgress.value=true
        db.collection(USER_NODE).whereEqualTo("number", number).get().addOnSuccessListener {
            if(it.isEmpty){
                auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener {
                    if (it.isSuccessful) {
                        signIn.value=true
                        createOrUpdateProfile(name,number)
                    } else {
                        handleException(it.exception, "Sign Up Failed")
                    }
                }
            }else{
                handleException(customMessage = "number already exists")
                inProgress.value=false
            }
        }
    }

    fun logIn(email:String, password: String){
        if(email.isEmpty() or password.isEmpty()){
            handleException(customMessage = "Please fill in all the credentials")
            return
        }else{
            inProgress.value=true
            auth.signInWithEmailAndPassword(email,password)
                .addOnCompleteListener {
                    if(it.isSuccessful){
                        signIn.value=true
                        auth.currentUser?.uid?.let {
                            getUserData(it)
                        }
                    }else{
                        handleException(it.exception, "Login Failed")
                    }
                    inProgress.value=false
                }
        }
    }

     fun createOrUpdateProfile(name: String?=null, number: String?=null,imageUrl:String?=null) {
        var uid=auth.currentUser?.uid
         val userData=UserData(
             uid, name=name?:userData.value?.name,
             number?:userData.value?.number,
             imageUrl?:userData.value?.imageUrl
         )

         uid?.let {
             inProgress.value=true
             db.collection(USER_NODE).document(uid).get().addOnSuccessListener {
                 if(it.exists()){
                     //TODO: Update User Data
                 }else{
                     db.collection(USER_NODE).document(uid).set(userData)
                     inProgress.value=false
                     getUserData(uid)
                 }
             }.addOnFailureListener{
                 handleException(it,"Cant retrieve user")
             }
         }
    }

     fun getUserData(uid: String) {
        inProgress.value=true
        db.collection(USER_NODE).document(uid).addSnapshotListener{
            value,error->
            if(error!=null){
                handleException(error,"Cant retrieve user")
            }
            if(value!=null){
                var user=value.toObject<UserData>()
                userData.value=user
            }
        }
         inProgress.value=false
    }

    fun handleException(exception: Exception? = null, customMessage: String = "") {
        Log.e("Chat App", "Chat App Exception", exception)
        Log.e("Exception Handled", customMessage)
        exception?.printStackTrace()
        val errorMsg = exception?.localizedMessage ?: ""
        val message = if (customMessage.isNullOrEmpty()) errorMsg else customMessage

        eventMutableState.value = Event(message)
        inProgress.value = false
    }

    fun uploadProfileImage(uri:Uri){
        uploadImage(uri){
                createOrUpdateProfile(imageUrl = it.toString())
        }
    }
    fun uploadImage(uri:Uri, onSuccess:(Uri)->Unit){
        inProgress.value=true
        val storageReference=storage.reference
        val uuid= UUID.randomUUID()
        val imageRef=storageReference.child("images/$uuid")
        val uploadTask=imageRef.putFile(uri)
            uploadTask.addOnSuccessListener {
            val result=it.metadata?.reference?.downloadUrl
            result?.addOnSuccessListener(onSuccess)
                inProgress.value=false
        }.addOnFailureListener {
            handleException(it,customMessage = "Upload Image Failed")
               // inProgress.value=false
        }
    }
}
