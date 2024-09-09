package br.com.alura.leilao.model

import java.io.Serializable

data class Leilao(
    val descricao: String,
    var maiorLance: Double = Double.MIN_VALUE,
    var menorLance: Double = Double.MAX_VALUE,
) : Serializable {

    private val lances: MutableList<Lance> = mutableListOf()

    fun propoe(lance: Lance) {
        val valorDoLance = lance.valor
        if (valorDoLance > maiorLance) {
            maiorLance = valorDoLance
        }
        if(valorDoLance < menorLance) {
            menorLance = valorDoLance
        }
        lances.add(lance)
    }
}
