package br.com.camargoalessandra.doacao

import android.arch.persistence.room.Entity


@Entity
data class ItemDoacao (val itemNome: String,
                       val itemDescricao: String)
