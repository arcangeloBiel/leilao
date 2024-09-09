package br.com.alura.leilao.model

import java.io.Serializable

data class Leilao(
    val descricao: String,
    var maiorLance: Double = Double.NEGATIVE_INFINITY // Default value
) : Serializable {

    private val lances: MutableList<Lance> = mutableListOf()

    fun propoe(lance: Lance) {
        val valorDoLance = lance.valor
        if (valorDoLance > maiorLance) {
            maiorLance = valorDoLance
        }
        lances.add(lance)
    }
}
