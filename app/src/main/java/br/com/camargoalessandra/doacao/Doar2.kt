package br.com.camargoalessandra.doacao

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.support.v4.content.FileProvider
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_doar2.*
import java.io.File

class Doar2 : AppCompatActivity() {

    companion object {
        private const val REQUEST_CAMERA: Int = 10
    }

    var caminhoFoto:String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_doar2)

        foto1.setOnClickListener(){
            tirarFoto()
        }

        foto2.setOnClickListener(){
            tirarFoto()
        }

        foto3.setOnClickListener(){
            tirarFoto()
        }

        foto4.setOnClickListener(){
            tirarFoto()
        }

        foto5.setOnClickListener(){
            tirarFoto()
        }
    }

    private fun tirarFoto(){
        val tirarFoto = Intent(MediaStore.ACTION_IMAGE_CAPTURE)

        if(tirarFoto.resolveActivity(packageManager) != null){
            val arquivoFoto = montaArquivoFoto()
            val uriFoto = FileProvider.getUriForFile(this, "${BuildConfig.APPLICATION_ID}.fileprovider", arquivoFoto)
            tirarFoto.putExtra(MediaStore.EXTRA_OUTPUT, uriFoto)
            startActivityForResult(tirarFoto, REQUEST_CAMERA)
        } else{
            Toast.makeText( this, "Impossivel tirar foto", Toast.LENGTH_SHORT ).show()
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

        if (requestCode == REQUEST_CAMERA && resultCode == Activity.RESULT_OK){

            GlideApp.with(this)
                    .load(caminhoFoto)
                    .placeholder(R.drawable.ic_photo_camera)
                    .centerCrop()
                    .into(foto1)
        }

    }
}
