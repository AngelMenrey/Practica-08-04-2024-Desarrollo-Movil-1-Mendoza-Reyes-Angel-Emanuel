package com.example.actividad_08_04_2024

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {

    private lateinit var metros: EditText
    private lateinit var pies: Chip
    private lateinit var pulgadas: Chip
    private lateinit var yardas: Chip
    private lateinit var resultado : TextView
    private lateinit var opciones : ChipGroup

    private lateinit var obj : Convertidor

    private val formatoDecimales : DecimalFormat = DecimalFormat("#.##")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        metros = findViewById(R.id.edtMetros)
        pies = findViewById(R.id.chPies)
        pulgadas = findViewById(R.id.chPulgadas)
        yardas = findViewById(R.id.chYardas)
        resultado = findViewById(R.id.idResultado)
        opciones = findViewById(R.id.chipOpciones)
        obj = Convertidor()
    }

 fun onClick(v: View?){
     when(v?.id){
         R.id.ibtnConvertir ->{
             btnConvertir();
         }
         R.id.ibtnMostrar ->{
             btnMostrar();
         }
         R.id.ibtnLimpiar ->{
             btnLimpiar();
         }
     }
 }

    fun btnConvertir(){
        if(metros.text.isNotEmpty() && metros.text.isNotBlank()){
            obj.meter = metros.text.toString().toInt()
            if(pies.isChecked) obj.calculateFeet()
            if(pulgadas.isChecked) obj.calculateInch()
            if(yardas.isChecked) obj.calculateYard()
            Toast.makeText(applicationContext, "Metros convertidos", Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(applicationContext, "Ingrese cantidad de metros", Toast.LENGTH_SHORT).show()
        }
    }

    fun btnMostrar (){
        var res : String = "Cantidad de metros convertida a: \n"
        res += "Pies: ${formatoDecimales.format(obj.feet)}\n"
        res += "Pulgadas: ${formatoDecimales.format(obj.inch)}\n"
        res += "Yardas: ${formatoDecimales.format(obj.yard)}\n"
        resultado.text = res
    }

    fun btnLimpiar(){
        metros.text = null
        resultado.text = "Cantidad de metros convertida a: \n"
        opciones.clearCheck()
        metros.requestFocus()
        obj = Convertidor()
    }
}
