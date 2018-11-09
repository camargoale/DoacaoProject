package br.com.camargoalessandra.doacao

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.view.LayoutInflater
import kotlinx.android.synthetic.main.activity_doar1.view.*
import kotlinx.android.synthetic.main.item_doacao.view.*

class DoacaoAdapter(val doacao: List<String>)
    : RecyclerView.Adapter<DoacaoAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_doacao, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return doacao.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(doacao[position])
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindView(doacaoNome: String) {
            itemView.tvNome.text = doacaoNome
        }

    }
}