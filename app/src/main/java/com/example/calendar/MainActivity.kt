package com.example.calendar

import android.app.DatePickerDialog
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.DatePicker
import android.widget.TextView
import androidx.annotation.RequiresApi
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var pickDateBtn:Button
    lateinit var dateTv:TextView
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        pickDateBtn=findViewById(R.id.pickDateBtn)
        dateTv=findViewById(R.id.dateTv)

        val c= Calendar.getInstance()
        val year=c.get(Calendar.YEAR)  //
        val month=c.get(Calendar.MONTH)
        val day=c.get(Calendar.DAY_OF_MONTH)

        pickDateBtn.setOnClickListener {
            val dpb=DatePickerDialog(this,DatePickerDialog.OnDateSetListener { view:DatePicker, year:Int, month:Int, dayOfMonth :Int->
                dateTv.setText(""+dayOfMonth +"/"+(month+1)+"/"+year)
            },year,month,day)
            dpb.show()
        }
    }
}