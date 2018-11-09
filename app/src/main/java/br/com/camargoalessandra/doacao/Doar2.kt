package br.com.camargoalessandra.doacao

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.support.v4.content.FileProvider
import android.support.v7.app.AppCompatActivity
import android.widget.ImageView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_doar2.*
import java.io.File

class Doar2 : AppCompatActivity() {

//    companion object {
//        private const val REQUEST_CAMERA: Int = 10
//    }

    var caminhoFoto: String? = null
//    var fotoNro: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_doar2)

        val itemNomeDoacao: String? = intent.getStringExtra("itemNome")

        if(itemNomeDoacao != null) {
            itemNomeD2.setText(itemNomeDoacao)
        }

        foto1.setOnClickListener() {
            tirarFoto(1)
        }

        foto2.setOnClickListener() {
            tirarFoto(2)
        }

        foto3.setOnClickListener() {
            tirarFoto(3)
        }

        foto4.setOnClickListener() {
            tirarFoto(4)
        }

        foto5.setOnClickListener() {
            tirarFoto(5)
        }

        foto6.setOnClickListener() {
            tirarFoto(6)
        }
    }

    private fun tirarFoto(fotoNro:Int) {
        val tirarFoto = Intent(MediaStore.ACTION_IMAGE_CAPTURE)

        if (tirarFoto.resolveActivity(packageManager) != null) {
            val arquivoFoto = montaArquivoFoto()
            val uriFoto = FileProvider.getUriForFile(this, "${BuildConfig.APPLICATION_ID}.fileprovider", arquivoFoto)
            tirarFoto.putExtra(MediaStore.EXTRA_OUTPUT, uriFoto)
            startActivityForResult(tirarFoto, fotoNro)
        } else {
            Toast.makeText(this, "Impossivel tirar foto", Toast.LENGTH_SHORT).show()
        }

    }

    private fun montaArquivoFoto(): File {
        val nomeArquivo = System.currentTimeMillis().toString()
        val diretorioArquivo = getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        val arquivoFoto = File.createTempFile(nomeArquivo, "jpg", diretorioArquivo)

        caminhoFoto = arquivoFoto.absolutePath

        return arquivoFoto
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == Activity.RESULT_OK) {
            when(requestCode) {
                1 -> exibeFoto(foto1)
                2 -> exibeFoto(foto2)
                3 -> exibeFoto(foto3)
                4 -> exibeFoto(foto4)
                5 -> exibeFoto(foto5)
                6 -> exibeFoto(foto6)
            }
        }
    }

    private fun exibeFoto(imageView: ImageView) {
        GlideApp.with(this)
                .load(caminhoFoto)
                .placeholder(R.drawable.ic_photo_camera)
                .centerCrop()
                .into(imageView)
    }
}