package com.badan.ricardo.jokenpokemon

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    val VERMELHO = 1
    val AZUL = 2
    val BRANCO = 3

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        iv_palkia.setOnClickListener{
            realizarJogada(VERMELHO)
        }

        iv_arceus.setOnClickListener{
            realizarJogada(BRANCO)
        }

        iv_dialga.setOnClickListener{
            realizarJogada(AZUL)
        }
    }

    fun configuraImagemDaJogada(jogada: Int, imageView: ImageView){
        when (jogada){
            VERMELHO -> (configuraImagem(R.drawable.palkia, imageView))
            BRANCO -> (configuraImagem(R.drawable.arceus, imageView))
            AZUL -> (configuraImagem(R.drawable.dialga, imageView))
        }
    }

    fun configuraImagem(resourceID: Int, imageView: ImageView){
        imageView.setImageDrawable(ContextCompat.getDrawable(this, resourceID))
    }

    fun realizarJogada(jogadaUsuario: Int){
        val jogadaAdversario = Random().nextInt( 3) +1

        configuraImagemDaJogada(jogadaUsuario, iv_Jogador)
        configuraImagemDaJogada(jogadaAdversario, iv_Maquina)

        when (jogadaUsuario){
            VERMELHO ->{
                when (jogadaAdversario){
                    VERMELHO -> {empate()}
                    AZUL -> {vitoria()}
                    BRANCO -> {derrota()}
                }
            }
            BRANCO ->{
                when (jogadaAdversario){
                    VERMELHO -> {vitoria()}
                    AZUL -> {derrota()}
                    BRANCO -> {empate()}
                }
            }
            AZUL ->{
                when (jogadaAdversario){
                    VERMELHO -> {derrota()}
                    AZUL -> {empate()}
                    BRANCO -> {vitoria()}
                }
            }
        }
    }

    fun vitoria() {
        tv_Resultado.text = "Breath of the Wild"
    }
    fun empate() {
        tv_Resultado.text = "Cheiro de leite"
    }
    fun derrota() {
        tv_Resultado.text = "Dedo podre"
    }
}
