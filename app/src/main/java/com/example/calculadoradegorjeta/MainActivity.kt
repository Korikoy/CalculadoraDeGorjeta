package com.example.calculadoradegorjeta

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import android.widget.Toast
import com.example.calculadoradegorjeta.databinding.ActivityMainBinding
import kotlin.properties.Delegates

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.seekBarPorcentagem.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                var porcentagem = p1.toDouble()
                binding.Porcentagem.text = Math.round(porcentagem).toString() + " %"
                //Recuperar valor digitado / Teste
                var recuperarValor = binding.valor.text.toString()
                if(recuperarValor == null || recuperarValor == "") {
                    Toast.makeText(applicationContext, "Digite um valor primeiro", Toast.LENGTH_LONG).show()
                }else{
                    var valorDigitado = recuperarValor.toDouble()
                    // Calculo Gorjeta
                    var  gorjeta = valorDigitado * (porcentagem/100)
                    binding.textGorjeta.text = "R$: $gorjeta"
                    // Calculo Total
                     var total = valorDigitado + gorjeta
                    binding.textTotal.text = "R$ $total"
                }



            }

            override fun onStartTrackingTouch(p0: SeekBar?) {

            }

            override fun onStopTrackingTouch(p0: SeekBar?) {

            }
        })

        }







    }


