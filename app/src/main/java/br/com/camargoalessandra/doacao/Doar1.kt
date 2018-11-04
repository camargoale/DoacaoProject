package br.com.camargoalessandra.doacao

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_doar1.*

class Doar1 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_doar1)

        if(itemNome != null && itemDescricao != null) {
            val doacao = ItemDoacao(itemNome.text.toString(), itemDescricao.text.toString())

            btnAddDonationNext1.setOnClickListener() {
                val addDonationNext = Intent(this, Doar2::class.java)
                addDonationNext.putExtra("itemNome", doacao.itemNome)
                addDonationNext.putExtra("itemDescricao", doacao.itemDescricao)
                startActivity(addDonationNext)
            }
        }
    }
}
