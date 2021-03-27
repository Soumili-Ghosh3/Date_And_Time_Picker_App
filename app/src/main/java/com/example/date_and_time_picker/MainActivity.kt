package com.example.date_and_time_picker

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.widget.Button
import android.widget.DatePicker
import android.widget.TextView
import android.widget.TimePicker
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class MainActivity : AppCompatActivity(), DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener{
    var day = 0
    var month = 0
    var year = 0
    var hour = 0
    var minute = 0

    var savedday = 0
    var savedmonth = 0
    var savedyear = 0
    var savedhour = 0
    var savedminute = 0

    lateinit var btntimePicker: Button
    lateinit var tvtextTime: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btntimePicker = findViewById(R.id.btn_timePicker)
        tvtextTime = findViewById(R.id.tv_textTime)
        pickDate()
    }

    private fun getDateTimeCalendar() {
        val cal: Calendar = Calendar.getInstance()
        day = cal.get(Calendar.DAY_OF_MONTH)
        month = cal.get(Calendar.MONTH)
        year = cal.get(Calendar.YEAR)
        hour = cal.get(Calendar.HOUR)
        minute = cal.get(Calendar.MINUTE)
    }

    private fun pickDate()
    {
        btntimePicker.setOnClickListener{
            getDateTimeCalendar()
        }
        DatePickerDialog(this,this, year, month, day).show()
    }

    override fun onDateSet(p0: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        savedday = dayOfMonth
        savedmonth = month
        savedyear = year

        getDateTimeCalendar()

        TimePickerDialog(this, this, hour, minute, true).show()
    }

    @SuppressLint("SetTextI18n")
    override fun onTimeSet(p0: TimePicker?, hourOfDay: Int, minute: Int) {
        savedhour = hourOfDay
        savedminute = minute

        tvtextTime.text = "$savedday-$savedmonth-$savedyear\n Hour:$savedhour Minute:$savedminute"
    }
}