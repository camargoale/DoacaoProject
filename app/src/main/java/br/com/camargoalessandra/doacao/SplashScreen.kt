package br.com.camargoalessandra.doacao

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_splash_screen.*

class SplashScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)


        GlideApp.with (this)
                .load("https://drive.google.com/file/d/1K98NjY1stdaJ1zQTLT268xwiwEG64rSw/view")
                //.placeholder(R.mipmap.space)
                .into(imgLogo)

//        Handler().postDelayed({
//            val main = Intent(this, Main::class.java)
//            startActivity(main)
//            finish()
//        }, 2000)
    }
}
