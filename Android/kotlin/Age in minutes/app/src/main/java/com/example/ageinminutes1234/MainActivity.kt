package com.example.ageinminutes1234


import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {


 private var tvSelectedDate:TextView?=null
    private var tvAnswer:TextView?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnDate:Button=findViewById(R.id.CalcBtn)
        btnDate.setOnClickListener {
            callDatePicker()
        }
      tvSelectedDate=findViewById(R.id.tvSelectedDate)
      tvAnswer=findViewById(R.id.answer1)
    }

    private fun callDatePicker()
    {
        val myCalendar= Calendar.getInstance()
        val year=myCalendar.get(Calendar.YEAR)
        val month=myCalendar.get(Calendar.MONTH)
        val day=myCalendar.get(Calendar.DAY_OF_MONTH)

        val dpd=DatePickerDialog(this,
            {_,Year,Month,dayOfMonth ->
            val selectedDate="$dayOfMonth/${Month+1}/$Year"

                tvSelectedDate?.text= selectedDate
                val dateObject=SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)
                val date1=dateObject.parse(selectedDate)
                date1?.let {
                    val getTime=date1.time/60000
                    val currentDate=dateObject.parse(dateObject.format(System.currentTimeMillis()))
                        currentDate?.let{
                            val getTime2= currentDate.time/60000
                            val answer=getTime2-getTime
                            tvAnswer?.text = answer.toString()
                        }

                }

                //Instead of the code below we can add a functionality to prevent the user from picking future dates
//                if(answer>0) {
//                    tvAnswer?.text = answer.toString()
//                }
//                else if(answer==0L)
//                {
//                    tvAnswer?.text="You are born today. Happy Birthday"
//                }
//                else
//                {
//                    tvAnswer?.text="You aren't born yet"
//                }

        }, year,month,day)
        dpd.datePicker.maxDate=System.currentTimeMillis()-86400000
        dpd.show()
    }
}