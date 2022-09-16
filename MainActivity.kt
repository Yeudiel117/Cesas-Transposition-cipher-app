package com.example.cifrados

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    var btnCifrarTrans: Button? = null
    var btnDesifTrans: Button? = null
    var btnCifrarCesar: Button? = null
    var btnDeciCesar: Button? = null
    var txtMensaje: TextView? = null
    var pantalla: TextView? = null

    //Trans
    var texto = ""
    var bandera1 = false
    var m1 = 0
    var m2 = 0
    var contador = 1
    var tabla = arrayOf<Array<String>>()
    var txtCifrado = ""
    var renglones = 0
    var columnas = 0
    var listaMensaje = listOf<String>()

    //Cesar
    var seed: Int? = null
    var arrayChar: CharArray? = null
    var char  = Array<String?> (9) {null}
    var caracteres: CharArray? = null
    var Aux: Int? = null
    var mensajeCifrado: String? = null
    var mensajeDesCifrado: String? = null

    var c0: Int = 0
    var c1 : Int = 0
    var c2 : Int = 0
    var c3 : Int = 0
    var c4 : Int = 0
    var c5 : Int = 0
    var c6 : Int = 0
    var c7 : Int = 0
    var c8 : Int = 0
    var c9 : Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCifrarTrans = findViewById(R.id.btnCifrarTrans)
        btnDesifTrans = findViewById(R.id.btnDecifTans)
        btnCifrarCesar = findViewById(R.id.btnCifrarCesar)
        btnDeciCesar = findViewById(R.id.btnDeciCesar)
        txtMensaje = findViewById(R.id.txtMensaje)
        pantalla = findViewById(R.id.pantalla)

        btnCifrarTrans!!.setOnClickListener(){
            texto = txtMensaje!!.text.toString()
            listaMensaje = texto.split("")
            while(bandera1 != true){
                m1 = aleatorio(listaMensaje.size)
                m2 = aleatorio(listaMensaje.size)
                if(m1%2 != 0 && m2%2 != 0){
                    if((m1*m2)>= listaMensaje.size){
                        renglones = m1
                        columnas = m2

                        pantalla!!.setText("")
                        for(i in 0..renglones-1){
                            var x = arrayOf<String>()
                            for (j in 0..columnas-1){
                                if (contador<listaMensaje.size) {
                                    x += listaMensaje[contador]
                                    contador++
                                }else{
                                    var L = aleatorio(255)
                                    x += L.toChar().toString()
                                }
                            }
                            tabla += x
                        }
                        contador = 0

                        for (x in tabla){
                            for (value in x){
                                pantalla!!.append(value.toString())
                            }
                            pantalla!!.append("\n")
                        }
                        bandera1 = true
                        println("Columnas: "+columnas)
                        println("renglones: "+renglones)

                    }else{
                        m1 = 0
                        m2 = 0
                    }//else if m1*m2
                }else{
                    while (m1%2 == 0 || m2%2 == 0){
                        if(m1%2 == 0){m1 = aleatorio(listaMensaje.size)}
                        if(m2%2 == 0){m2 = aleatorio(listaMensaje.size)}
                    }//else while m1%2
                }//else
            }//while bandera 1
        }//Click listener cifrar

        btnDesifTrans!!.setOnClickListener(){
            bandera1 = false
            for(i in 0..columnas-1){
                var x = arrayOf<String>()
                for (j in 0..renglones-1){
                        var k = tabla[j][i]
                        txtCifrado += k
                }
            }
            pantalla!!.setText("")
            pantalla!!.append("Cifrado: "+txtCifrado)
            pantalla!!.append("\n")
            pantalla!!.append("Texto decifrado: $texto")

            var spliteado = txtCifrado.split("")
        }

        btnCifrarCesar!!.setOnClickListener(){
            var car: String = txtMensaje!!.text.toString()
            if(car.length <= 10){
                semilla(1,255)
                println("Primer Semilla: "+seed!!)

                var arrayCaracteres: CharArray = toCharacterArray(car)

                c0 = arrayCaracteres.get(0).code
                c1 = arrayCaracteres.get(1).code
                c2 = arrayCaracteres.get(2).code
                c3 = arrayCaracteres.get(3).code
                c4 = arrayCaracteres.get(4).code
                c5 = arrayCaracteres.get(5).code
                c6 = arrayCaracteres.get(6).code
                c7 = arrayCaracteres.get(7).code
                c8 = arrayCaracteres.get(8).code
                c9 = arrayCaracteres.get(9).code


                c0 += seed!!
                c1 += seed!!
                c2 += seed!!
                c3 += seed!!
                c4 += seed!!
                c5 += seed!!
                c6 += seed!!
                c7 += seed!!
                c8 += seed!!
                c9 += seed!!

                println(c0)
                println(c1)
                println(c2)
                println(c3)
                println(c4)
                println(c5)
                println(c6)
                println(c7)
                println(c8)
                println(c9)

                while(c0>255 || c1>255 || c2>255 || c3>255 || c4>255 || c5>255 || c6>255 || c7>255 || c8>255 || c9>255) {
                    c0 -= seed!!
                    c1 -= seed!!
                    c2 -= seed!!
                    c3 -= seed!!
                    c4 -= seed!!
                    c5 -= seed!!
                    c6 -= seed!!
                    c7 -= seed!!
                    c8 -= seed!!
                    c9 -= seed!!

                    semilla(1, 255)
                    c0 += seed!!
                    c1 += seed!!
                    c2 += seed!!
                    c3 += seed!!
                    c4 += seed!!
                    c5 += seed!!
                    c6 += seed!!
                    c7 += seed!!
                    c8 += seed!!
                    c9 += seed!!
                    Aux = seed!!
                    println("Semilla Real: " + Aux!!)
                }

                println(car)
                println(arrayCaracteres.contentToString())

                println(c0)
                println(c1)
                println(c2)
                println(c3)
                println(c4)
                println(c5)
                println(c6)
                println(c7)
                println(c8)
                println(c9)
                mensajeCifrado = c0.toChar().toString()+c1.toChar()+c3.toChar()+c4.toChar()+c5.toChar()+
                        c6.toChar()+c7.toChar()+c8.toChar()+c9.toChar()
                println(mensajeCifrado)
                pantalla!!.setText("")
                pantalla!!.text = mensajeCifrado
                pantalla!!.append("\nMensaje Cifrado: "+c0.toChar()+c1.toChar()+c3.toChar()+c4.toChar()+c5.toChar()+
                        c6.toChar()+c7.toChar()+c8.toChar()+c9.toChar())
                println("Mensaje Cifrado: "+c0.toChar()+c1.toChar()+c3.toChar()+c4.toChar()+c5.toChar()+
                        c6.toChar()+c7.toChar()+c8.toChar()+c9.toChar())
            }
        }

        btnDeciCesar!!.setOnClickListener(){
            c0 -= seed!!
            c1 -= seed!!
            c2 -= seed!!
            c3 -= seed!!
            c4 -= seed!!
            c5 -= seed!!
            c6 -= seed!!
            c7 -= seed!!
            c8 -= seed!!
            c9 -= seed!!
            mensajeDesCifrado = c0.toChar().toString()+c1.toChar()+c3.toChar()+c4.toChar()+c5.toChar()+
                    c6.toChar()+c7.toChar()+c8.toChar()+c9.toChar()
            pantalla!!.setText("")
            pantalla!!.append(mensajeDesCifrado)
        }
    }

    fun aleatorio(rango: Int): Int {
        val enteroR = (1..rango).shuffled().first()
        return enteroR
    }

    fun semilla(inicio: Int, final: Int):Int{

        seed = (inicio..final).shuffled().first()
        return seed!!

    }
    fun toCharacterArray(str: String): CharArray {
        return str.toCharArray()
    }
}