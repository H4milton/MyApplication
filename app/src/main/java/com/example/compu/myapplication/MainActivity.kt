package com.example.compu.myapplication

import android.app.ProgressDialog.show
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.InputType
import android.text.TextWatcher
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity(), TextWatcher, View.OnClickListener, CompoundButton.OnCheckedChangeListener {


    private var editName: EditText? = null
    private var editAge: EditText? = null
    private var textVName: TextView? = null
    private var textVAge: TextView? = null
    private var BEjecutar: Button? = null
    private var radioM : RadioButton? = null
    private var radioF : RadioButton? = null
    private var name: String? = null
    private var age = ""
    private var mensaje = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Hacer referencia a Objetos
        editName = findViewById(R.id.editText_Name) as EditText
        editAge = findViewById(R.id.editText_Age) as EditText
        textVAge = findViewById(R.id.textView_Age) as TextView
        textVName = findViewById(R.id.textView_Name) as TextView
        BEjecutar = findViewById(R.id.Button_Ejecutar) as Button
        radioF = findViewById(R.id.rButtonF) as RadioButton
        radioM = findViewById(R.id.rButtonM) as RadioButton

        BEjecutar!!.setOnClickListener(this)
        editAge!!.addTextChangedListener(this)
        editName!!.addTextChangedListener(this)

        /* Deshabilitado C19
        radioM!!.setOnCheckedChangeListener(this)
        radioF!!.setOnCheckedChangeListener(this)
        */

        //Usar Button para llamar onclick
        radioM!!.setOnClickListener(this)
        radioF!!.setOnClickListener(this)

        //Permite hacer que nuestro teclado ingrese la primera palabra en mayuscula
        editName!!.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_FLAG_CAP_CHARACTERS

    }//FIN ON CREATE


    //FUNCIONE RADIO BUTTON
    override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) { //setOnCheckedChangeListener es su creador

        when(buttonView!!.id){  //Cuando el id de radioButton, sus id estan identificados con numeros.
            R.id.rButtonM ->    if(isChecked)Toast.makeText(this,"Ha seleccionado Masculino", Toast.LENGTH_LONG).show()
            R.id.rButtonF ->    if(isChecked)Toast.makeText(this,"Ha seleccionado Femenino", Toast.LENGTH_LONG).show()
        }
    }

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
    override fun onClick(v: View?) {        // V= Identificador de los objetos que estan solicitando la funcion onClick
        when(v!!.id){   //Valuamos segun id de nuestros objetos
            R.id.Button_Ejecutar    -> operacion()
            R.id.rButtonM ->   Toast.makeText(this,"Ha seleccionado Masculino", Toast.LENGTH_LONG).show()
            R.id.rButtonF ->   Toast.makeText(this,"Ha seleccionado Femenino", Toast.LENGTH_LONG).show()
        }

    }

    //MIS FUNCIONES CREADAS
    private fun operacion(){

        var miarrayInt = IntArray(10)

        var ArrayString = arrayOf("Hamilton","Bac") //Devuelve in tipo de datos, conforme a lo ingresado dentro del parentesis
        ArrayString[1]
        
        /*name = editName?.text.toString()
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
        }*/
    }

}
