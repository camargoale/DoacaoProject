package br.com.camargoalessandra.doacao

import android.arch.persistence.room.*


@Dao
interface DoacaoDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(itemDoacao: ItemDoacao)

    @Query("SELECT * FROM itemdoacao")
    fun getAll(): List<ItemDoacao>

    @Delete
    fun delete(itemDoacao: ItemDoacao)
/*   queries:

    @Query("SELECT * FROM itemDoacao WHERE id = :doacaoId LIMIT 1")
    fun getContatinho(contatinhoId: Int): ItemDoacao

    @Query("SELECT * FROM itemDoacao WHERE nome like :doacaoNome")
    fun findByName(contatinhoNome: String): List<ItemDoacao>
    */
}