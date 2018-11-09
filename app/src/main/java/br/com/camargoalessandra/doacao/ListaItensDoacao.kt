package br.com.camargoalessandra.doacao

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_doar1.*
import kotlinx.android.synthetic.main.activity_lista_itens_doacao.*

class ListaItensDoacao : AppCompatActivity() {

    val listaDoacoes: MutableList<String> = mutableListOf("Ale")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_itens_doacao)

        val novaDoacao: String? = intent.getStringExtra("itemNome")


        val adapter = DoacaoAdapter(listaDoacoes)
        val layoutManager = LinearLayoutManager(this)

        rvDoacoes.adapter = adapter
        rvDoacoes.layoutManager = layoutManager

    }
}
