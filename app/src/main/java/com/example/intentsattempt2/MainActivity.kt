package com.example.intentsattempt2

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    companion object {
        var imageList: ArrayList<ImageData> = ArrayList()
        var index = 0
        val INITIAL_SELECTION = 1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        add_button.setOnClickListener {
            val intent = Intent(Intent.ACTION_GET_CONTENT)
            intent.type = "image/*"
            if (intent.resolveActivity(packageManager) != null) {
                startActivityForResult(intent, INITIAL_SELECTION)
            }
        }

    }
    fun createTextView(string: String?, int: Int): TextView {
        val view = TextView(this)
        view.tag = imageList[int]
        view.text = string
        view.textSize = 24f

        view.setOnClickListener {
            val intent = Intent(this, DetailsView::class.java)
            intent.putExtra("picture", imageList[int].fileUri)
            startActivity(intent)
        }
        return view
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        val fullPhotoUri: Uri? = data!!.data
        Log.i("stage1","stage1")
        if (requestCode == INITIAL_SELECTION && resultCode == RESULT_OK) {
            imageList.add(index, ImageData(fullPhotoUri))
            Log.i("stage2","stage2")
            picture_linear_layout.addView(
                createTextView(imageList[index].fileUriString, index++)
            )
        } else if (requestCode == 2 && resultCode == RESULT_OK) {
            // Make sure the request was successful
            val returnedData = data.getSerializableExtra("object") as ImageData

            for (i in 0..imageList.size) {
                if (imageList[i].fileUriString == returnedData.fileUriString) {
                    imageList[i] = returnedData
                }
            }
        }
    }

}
