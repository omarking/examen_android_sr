package com.example.examen.view.ui.firebase

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.core.net.toFile
import androidx.core.net.toUri
import com.example.examen.R
import com.example.examen.compose.ViewModelActivity
import com.google.android.gms.tasks.OnFailureListener
import com.google.android.gms.tasks.OnSuccessListener
import com.google.firebase.FirebaseApp
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.UploadTask
import com.skydoves.whatif.whatIfNotNull
import kotlinx.coroutines.*
import java.util.*


class GaleriaActivity: ViewModelActivity(){

    private var db: FirebaseFirestore? = null
    var imageView: ImageView? =null
    lateinit var button: Button
    lateinit var button2: Button
    private val pickImage = 100
    private var imageUri: Uri? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_galeria);

        //Instanciar Firebase
        FirebaseApp.initializeApp(this);
        db = Firebase.firestore

        imageView = findViewById(R.id.imageView)
        button = findViewById(R.id.buttonLoadPicture)
        button.setOnClickListener {
            val gallery = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
            startActivityForResult(gallery, pickImage)
        }

        button2 = findViewById(R.id.buttonLoadFirebase)
        button2.setOnClickListener {
            if(imageUri!=null){
                val file_uri = imageUri
                if (file_uri != null) {
                    uploadImageToFirebase(file_uri)
                }
            }else{
                Toast.makeText(this, "Favor cargar una imagen de la Galeria....", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK && requestCode == pickImage) {
            imageUri = data?.data
            imageView?.setImageURI(imageUri)
        }
    }

    private fun uploadImageToFirebase(fileUri: Uri) {
        if (fileUri != null) {
            val fileName = UUID.randomUUID().toString() +".jpg"

            //val database = FirebaseDatabase.getInstance()
            val refStorage = FirebaseStorage.getInstance().reference.child("images/$fileName")

            refStorage.putFile(fileUri)
                .addOnSuccessListener(
                    OnSuccessListener<UploadTask.TaskSnapshot> { taskSnapshot ->
                        taskSnapshot.storage.downloadUrl.addOnSuccessListener {
                            Toast.makeText(this, "Imagen subida exitosamente....", Toast.LENGTH_SHORT).show()
                        }
                    })

                ?.addOnFailureListener(OnFailureListener { e ->
                    print(e.message)
                    Toast.makeText(this, "Error al subir o cargar imagen....", Toast.LENGTH_SHORT).show()
                })
        }
    }

    companion object {
        private val TAG = GaleriaActivity::class.java.simpleName
        fun startActivityModel(context: Context?) {
            context.whatIfNotNull {
                val intent = Intent(it, GaleriaActivity::class.java).apply {}
                it.startActivity(intent)
            }
        }
    }
}