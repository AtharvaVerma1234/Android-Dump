package com.example.dialogbasics

import android.app.Dialog
import android.content.DialogInterface
import android.media.session.PlaybackState.CustomAction
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<ImageButton>(R.id.ib_snack_bar).setOnClickListener{
            Snackbar.make(it, "You have clicked the image button",Snackbar.ANIMATION_MODE_SLIDE).show()
        }
        findViewById<Button>(R.id.btn_alert).setOnClickListener {
            alertDialogFunction()
        }
        findViewById<Button>(R.id.btn_custom).setOnClickListener {
            customDialogFunction()
        }
        findViewById<Button>(R.id.btn_custom_progress).setOnClickListener {
            customProgressDialogFunction()
        }
    }
    private fun alertDialogFunction()
    {
        //Use the builder class for the construction of the dialog easily
        val builder= AlertDialog.Builder(this)
        builder.setTitle("Alert")
        builder.setMessage("This an alert dialog.")
        builder.setIcon(R.drawable.ic_launcher_background)
        //set positive action
        builder.setPositiveButton("Yes"){dialogInterface, _ ->
            Toast.makeText(this, "Pressed Yes", Toast.LENGTH_SHORT).show()
            dialogInterface.dismiss()
        }
        builder.setNeutralButton("Cancel"){
            dialogInterface, _->
            Toast.makeText(this, "Pressed Cancel", Toast.LENGTH_SHORT).show()
            dialogInterface.dismiss()
        }
        builder.setNegativeButton("No"){
            dialogInterface, _->
            Toast.makeText(this, "Pressed NO", Toast.LENGTH_SHORT).show()
            dialogInterface.dismiss()
        }
        val alertDialog:AlertDialog=builder.create()
        alertDialog.setCancelable(false) // will not allow user to cancel the dialog by clicking in the remaining area of the screen other than the dialog
        alertDialog.show()
    }
    private fun customDialogFunction()
    {
        val customDialog= Dialog(this)
        customDialog.setContentView(R.layout.dialog_custom)
        customDialog.findViewById<TextView>(R.id.tv_exit).setOnClickListener{
            Toast.makeText(this, "Pressed exit", Toast.LENGTH_SHORT).show()
            customDialog.dismiss()
        }
        customDialog.setCancelable(false)
        customDialog.show()
    }
    private fun customProgressDialogFunction()
    {
        val customProgressDialog=Dialog(this)
        //SET a layout which is to be displayed at when this dialog is displayed
       // customProgressDialog.setContentView(R.layout.)
        customProgressDialog.show()
    }
}


