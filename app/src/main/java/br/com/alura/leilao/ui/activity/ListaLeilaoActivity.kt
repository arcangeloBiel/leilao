package br.com.alura.leilao.ui.activity

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import br.com.alura.leilao.data.OnItemClickListener
import br.com.alura.leilao.databinding.ActivityListaLeilaoBinding
import br.com.alura.leilao.model.Lance
import br.com.alura.leilao.model.Leilao
import br.com.alura.leilao.model.Usuario
import br.com.alura.leilao.ui.recyclerview.adapter.ListaLeilaoAdapter

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
class ListaLeilaoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityListaLeilaoBinding

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListaLeilaoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = ListaLeilaoAdapter(leiloesDeExemplo())
        binding.listaLeilaoRecyclerview.adapter = adapter
        adapter.setOnItemClickListener(object : OnItemClickListener {
            override fun onItemClick(leilao: Leilao) {
                val vaiParaLancesLeilao = Intent(this@ListaLeilaoActivity, LancesLeilaoActivity::class.java)
                vaiParaLancesLeilao.putExtra("leilao", leilao)
                startActivity(vaiParaLancesLeilao)
            }
        })
    }

    private fun leiloesDeExemplo(): List<Leilao> {
        val console = Leilao("Console", 3.0)
        console.propoe(Lance(Usuario("João"), 50.0))
        return listOf(console)
    }

    companion object {
        private const val UI_ANIMATION_DELAY = 300
    }
}