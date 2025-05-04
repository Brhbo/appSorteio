package com.example.aplicativodesorteio

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.random.Random
import android.view.animation.AnimationUtils


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun sortear(view : View) {
        val textResultado = findViewById<TextView>(R.id.textResultado)
        val numero = Random.nextInt(1000)

        textResultado.text = ("Número sorteado: " + numero)


    // Depois de atualizar o texto com o número sorteado:
        textResultado.text = numero.toString()

    // Carrega e aplica a animação
        val anim = AnimationUtils.loadAnimation(this, R.anim.fade_in_scale)
        textResultado.startAnimation(anim)



        // Primeiro, faz o botão piscar
        view.alpha = 0.3f
        view.animate()
            .alpha(1f)
            .setDuration(300)
            .start()

        // E também faz o botão pular
        view.animate()
            .translationYBy(-50f) // Pula para cima
            .setDuration(150)
            .withEndAction {
                view.animate()
                    .translationYBy(50f) // Volta para baixo
                    .setDuration(150)
                    .start()
            }
            .start()

    }
}