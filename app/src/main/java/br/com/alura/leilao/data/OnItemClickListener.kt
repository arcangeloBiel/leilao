package br.com.alura.leilao.data

import br.com.alura.leilao.model.Leilao

interface OnItemClickListener {
    fun onItemClick(leilao: Leilao)
}