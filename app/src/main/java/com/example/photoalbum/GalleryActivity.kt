package com.example.photoalbum

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class GalleryActivity : AppCompatActivity() {
    private lateinit var imageViewIV: ImageView
    private lateinit var nextBTN: Button
    private var currentPhotoIndex = 0
    private val photos = listOf(
        R.drawable.photo1,
        R.drawable.photo2,
        R.drawable.photo3,
        R.drawable.photo4,
        R.drawable.photo5
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_gallery)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        imageViewIV = findViewById(R.id.imageViewIV)
        nextBTN = findViewById(R.id.nextBTN)

        imageViewIV.setImageResource(photos[currentPhotoIndex])

        nextBTN.setOnClickListener {
            currentPhotoIndex++
            if (currentPhotoIndex >= photos.size) {
                val intent = Intent(this, EndActivity::class.java)
                startActivity(intent)
            } else {
                imageViewIV.setImageResource(photos[currentPhotoIndex])
            }
        }
    }
}