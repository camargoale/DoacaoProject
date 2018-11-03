package br.com.camargoalessandra.doacao

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Matrix
import android.media.ExifInterface
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.os.WorkSource
import android.provider.MediaStore
import android.support.v4.content.FileProvider
import android.view.accessibility.AccessibilityEventSource
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

    fun verificaRotacao(bitmap: Bitmap): Bitmap {
        val ei = ExifInterface(caminhoFoto)
        val orientation = ei.getAttributeInt(ExifInterface.TAG_ORIENTATION, ExifInterface.ORIENTATION_UNDEFINED)

        return when (orientation){
            ExifInterface.ORIENTATION_ROTATE_90 -> rotateImage(bitmap, 90F)
            ExifInterface.ORIENTATION_ROTATE_180 -> rotateImage(bitmap, 180F)
            ExifInterface.ORIENTATION_ROTATE_270 -> rotateImage(bitmap, 270F)
            else -> bitmap
        }
    }

    private fun rotateImage(source: Bitmap, angle:Float):Bitmap {
        val matrix = Matrix()
        matrix.postRotate(angle)
        return Bitmap.createBitmap(source, 0, 0, source.width, source.height, matrix, true)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQUEST_CAMERA && resultCode == Activity.RESULT_OK){

            val arquivoFoto = File(caminhoFoto)
            if(arquivoFoto.exists()){
                var bitmap = BitmapFactory.decodeFile(arquivoFoto.absolutePath)
                bitmap = verificaRotacao(bitmap)
                foto1.setImageBitmap(bitmap)
            }

        }

    }
}
