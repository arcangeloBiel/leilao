package br.com.alura.leilao.model

import java.io.Serializable


data class Leilao(
    val descricao: String,
    val maiorlance: Float
    ) : Serializable {
    private val lances: List<Lance> = ArrayList()
}