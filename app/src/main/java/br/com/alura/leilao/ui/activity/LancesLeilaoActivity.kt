package br.com.alura.leilao.ui.activity

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import br.com.alura.leilao.databinding.ActivityLancesLeilaoBinding
import br.com.alura.leilao.model.Leilao

class LancesLeilaoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLancesLeilaoBinding

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLancesLeilaoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dadosRecebidos = intent
        if (dadosRecebidos.hasExtra("leilao")) {
            val leilao = dadosRecebidos.getSerializableExtra("leilao") as Leilao
            binding.lancesLeilaoDescricao.text = leilao.descricao
            binding.lancesLeilaoMaiorLance.text = leilao.maiorLance.toString()
            binding.lancesLeilaoMenorLance.text = leilao.menorLance.toString()
        }

    }
}