package com.example.permisssionsbasics

import android.Manifest
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
//FOR SINGLE PERMISSION
//    var x= {
//            isGranted:Boolean -> if(isGranted){
//        Toast.makeText(this,"Permission Granted",Toast.LENGTH_SHORT).show()
//    }
//    else{
//        Toast.makeText(this,"Permission denied", Toast.LENGTH_SHORT).show()
//    }
//    }
//    private var cameraResultLauncher:ActivityResultLauncher<String>
//    =registerForActivityResult(ActivityResultContracts.RequestPermission(),x)

    private var cameraAndLocationResultLauncher:ActivityResultLauncher<Array<String>>
            =registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()){ permissions ->
        permissions.entries.forEach{
            val permissionName=it.key
            val isGranted=it.value
            if(isGranted)
            {
                if(permissionName== Manifest.permission.ACCESS_FINE_LOCATION)
                {
                    Toast.makeText(this,"Location permission Granted",Toast.LENGTH_SHORT).show()
                }else if(permissionName== Manifest.permission.CAMERA){
                    Toast.makeText(this,"Camera permission granted",Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(this,"Coarse Location permission Granted",Toast.LENGTH_SHORT).show()
                }
            }
            else{
                if(permissionName== Manifest.permission.ACCESS_FINE_LOCATION)
                {
                    Toast.makeText(this,"Fine Location permission denied",Toast.LENGTH_SHORT).show()
                }else if(permissionName== Manifest.permission.CAMERA){
                    Toast.makeText(this,"Camera permission denied",Toast.LENGTH_SHORT).show()
                }
                else{
                    Toast.makeText(this,"Coarse Location permission denied", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.btn_camera_permission).setOnClickListener{
            if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M && shouldShowRequestPermissionRationale(Manifest.permission.CAMERA))
            {
                showRationaleDialog("Camera Permission", "permission not granted for the use of camera")
            }else{
                cameraAndLocationResultLauncher.launch(arrayOf(Manifest.permission.CAMERA, Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION))
            }
        }
    }
    private fun showRationaleDialog(title:String, message:String) {
        val builder:AlertDialog.Builder =AlertDialog.Builder(this)
        builder.setTitle(title)
        builder.setMessage(message)
            .setPositiveButton("Cancel"){dialog, _ ->dialog.dismiss()}
        builder.create().show()
    }
}