package br.com.alura.leilao.ui.recyclerview.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import br.com.alura.leilao.data.OnItemClickListener
import br.com.alura.leilao.databinding.ItemLeilaoBinding
import br.com.alura.leilao.model.Leilao

class ListaLeilaoAdapter(
    private val leiloes: List<Leilao>
) : RecyclerView.Adapter<ListaLeilaoAdapter.ViewHolder>() {

    private var onItemClickListener: OnItemClickListener? = null

    fun setOnItemClickListener(onItemClickListener: OnItemClickListener) {
        this.onItemClickListener = onItemClickListener
    }

    inner class ViewHolder(val binding: ItemLeilaoBinding) : RecyclerView.ViewHolder(binding.root) {
        private lateinit var leilao: Leilao

        init {
            itemView.setOnClickListener {
                if (::leilao.isInitialized) {
                    onItemClickListener?.onItemClick(leilao)
                }
            }
        }

        fun bind(leilao: Leilao) {
            this.leilao = leilao
            binding.itemLeilaoDescricao.text = leilao.descricao
            binding.itemLeilaoMaiorLance.text = leilao.maiorLance.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemLeilaoBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = leiloes.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(leiloes[position])
    }
}

