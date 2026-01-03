package com.example.mycoroutines

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Switch
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    private var customDialog:Dialog?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnBackgroundTask: Button =findViewById(R.id.btn_background_process)
        btnBackgroundTask.setOnClickListener {
            showCustomDialog()
            lifecycleScope.launch{
                delay()
            }

        }
    }
    private suspend fun delay() //suspend function cant be used directly. It has to be run in background using coroutines
    {
        withContext(Dispatchers.IO){
            for(i in 1..1000000)
            {
                Log.e("delay", i.toString())
            }
            runOnUiThread {
                Toast.makeText(this@MainActivity, "Done", Toast.LENGTH_SHORT).show()
            }
            cancelCustomDialog()

        }
    }

    private fun cancelCustomDialog()
    {
//        if(customDialog !=null)
//        {
//            customDialog?.dismiss()
//            customDialog=null
//        }
        customDialog.let { customDialog?.dismiss()
        customDialog=null }
    }

    private fun showCustomDialog()
    {
        customDialog=Dialog(this@MainActivity)
        customDialog?.setContentView(androidx.core.R.layout.custom_dialog)
        customDialog?.show()
    }
}