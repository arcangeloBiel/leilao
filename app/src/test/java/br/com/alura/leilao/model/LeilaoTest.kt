package br.com.alura.leilao.model

import org.junit.Assert.*

import org.junit.Test

class LeilaoTest {

    @Test
    fun getDescricao() {
        //criar cenário de teste
        var console = Leilao("console")
        //executar ação esperada
        var descricaoDevolvida = console.descricao
        //testar resultado espeperado
        assertEquals("console", descricaoDevolvida)
    }

    @Test
    fun getMaiorLanceQuandoRecebeApenasUmLance() {
        var console = Leilao("console")
        console.propoe(Lance(Usuario("João"), 50.0))
        var maiorLanceDevolvidoDoConsole = console.maiorLance
        assertEquals(50.0, maiorLanceDevolvidoDoConsole, 0.0001)

    }

    @Test
    fun getMaiorLanceQuandoRecebeEmOrdemCrescente() {
        var computador = Leilao("computador")
        computador.propoe(Lance(Usuario("João"), 50.0))
        computador.propoe(Lance(Usuario("Thalia"), 150.0))
        var maiorLanceDoComputador = computador.maiorLance
        assertEquals(150.0, maiorLanceDoComputador, 0.0001)
    }

    @Test
    fun getMaiorLanceQuandoRecebeEmOrdemDeCrescente() {
        //verifica se devolve maior lance com mais de um lance em ordem descrescente
        var carro = Leilao("carro")
        carro.propoe(Lance(Usuario("João"), 50.0))
        carro.propoe(Lance(Usuario("Thalia"), 150.0))
        var maiorLanceDocarro = carro.maiorLance
        assertEquals(150.0, maiorLanceDocarro, 0.0001)
    }

}