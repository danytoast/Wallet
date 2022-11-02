package com.example.myapplication

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import android.widget.RadioGroup
public  var flag2:String="JOD"
class MainActivity : AppCompatActivity() {
    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button: Button =findViewById(R.id.button)
        val balance: TextView = findViewById(R.id.balance)//result
        val currency :TextView= findViewById(R.id.currency)
        val editText:EditText= findViewById(R.id.numInput)
        //val jodradioButton:RadioButton=findViewById(R.id.jodRB)
        //val usdradioButton:RadioButton=findViewById(R.id.usdRB)
        val radioGroup :RadioGroup=findViewById<RadioGroup>(R.id.radioGroup)
        var flag:String= "give"

        val spinnerVal:Spinner=findViewById(R.id.spinner)
        var arrayofobtions= arrayOf("give","get")
        spinnerVal.adapter=ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,arrayofobtions)
        spinnerVal.onItemSelectedListener=object :AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                flag=arrayofobtions.get(p2)
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        //if(jodradioButton==)

        button.setOnClickListener(){
            val selectedOption:Int= radioGroup.checkedRadioButtonId
            val radioButton1 =findViewById<RadioButton>(selectedOption)
            //Toast.makeText(context.radioButton)
                //we dont need to make the toast one

            var num: Float = editText.text.toString().toFloat();
            var tempBl:Float= balance.text.toString().toFloat();
            if(flag=="give")
                balance.text= transfare(num,tempBl,selectedOption).toString();
            else
                balance.text=add(num,tempBl,selectedOption).toString();
        }

    }
}


public fun add(a:Float,b:Float,s:Int):Double{
    if(s==1)
    return UsdToJod(a)+b
    else
        return (a+b).toDouble()
}

public fun transfare(a:Float,b: Float,s:Int): Double {
    if(s==1)
        return UsdToJod(a)-b
    else
        return (a+b).toDouble()
}

/*public fun jodToUsd(j:Float):Double{
    return j*1.41
}*/
public fun UsdToJod(u:Float):Double{
    return u/1.41
}

/*
fun onRadioButtonClicked(view: View) {
    if (view is RadioButton) {
        // Is the button now checked?
        val checked = view.isChecked

        // Check which radio button was clicked
        when (view.getId()) {
            R.id.jodRB ->
                if (checked) {
                    flag2="JOD"
                }
            R.id.usdRB ->
                if (checked) {
                    flag2="USD"
                }
        }
    }
}*/