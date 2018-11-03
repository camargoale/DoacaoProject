package br.com.camargoalessandra.doacao

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_doar1.*

class Doar1 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_doar1)

        btnAddDonationNext1.setOnClickListener(){
            val addDonationNext = Intent(this, Doar2::class.java)
            startActivity(addDonationNext)
        }
    }
}
