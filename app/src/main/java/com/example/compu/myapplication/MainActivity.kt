package com.example.compu.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.InputType
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity(), TextWatcher, View.OnClickListener {
    private var editName: EditText? = null
    private var editAge: EditText? = null
    private var textVName: TextView? = null
    private var textVAge: TextView? = null
    private var BEjecutar: Button? = null

    private var name: String? = null
    private var age = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Hacer referencia a Objetos
        editName = findViewById(R.id.editText_Name) as EditText
        editAge = findViewById(R.id.editText_Age) as EditText
        textVAge = findViewById(R.id.textView_Age) as TextView
        textVName = findViewById(R.id.textView_Name) as TextView
        BEjecutar = findViewById(R.id.Button_Ejecutar) as Button

        BEjecutar!!.setOnClickListener(this)
        editAge!!.addTextChangedListener(this)
        editName!!.addTextChangedListener(this)

        editName!!.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_FLAG_CAP_CHARACTERS

        //operacion()

    }//FIN ON CREATE

    //LISTENER TEXTVIEW
    override fun afterTextChanged(s: Editable?) {    }
    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

        name = editName?.text.toString()
        if (name?.equals("") ?: (""===null)){
            editName!!.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_FLAG_CAP_CHARACTERS
        }else{
            editName!!.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_NORMAL
        }

        //name = editName?.text.toString()
        //age = editAge?.text.toString()
        //if (name !="")textVName?.text = name
        //if (age != "")textVAge?.text = age
        //Toast.makeText(this,s.toString(),Toast.LENGTH_LONG).show()
    }

    //ONLICK BOTON EJECUTAR
    override fun onClick(v: View?) {
        operacion()
    }

    //MIS FUNCIONES CREADAS
    private fun operacion(){
        name = editName?.text.toString()
        age = editAge?.text.toString()

        if (name?.equals("")?: ("" ==null)){ //name es igual a nulo, es nullo si.
            editName!!.requestFocus()   //llamamos a requesto focus si no nuestra campo name esta vacia
        }else{
            textVName?.text = name
            if (age?.equals("")?: ("" ==null)){
                editAge!!.requestFocus()
            }else  {
                textVAge?.text = age
            }
        }
    }

}
