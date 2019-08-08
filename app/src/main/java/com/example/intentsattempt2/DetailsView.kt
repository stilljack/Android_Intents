package com.example.intentsattempt2

import android.os.Bundle
import android.provider.ContactsContract
import android.widget.ImageView
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.net.toUri

import kotlinx.android.synthetic.main.activity_details_view.*
import java.net.URI

class DetailsView (uriIntent: URI?) : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details_view)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()

            val intent =getIntent()
            val picture:String? = getIntent().getStringExtra("picture")
            val getURIstring = picture!!.toUri()

         /*   val imageView = findViewById<ImageView>(R.id.detail_image_display)
            val imgResId = R.drawable.ic_launcher_background
            //look up what, if anything, this does
            val myObject = intent.getSerializableExtra("picture") as ImageData
*/

            //detail_image_display.setImageURI(getURIstring)


        }
    }

}
