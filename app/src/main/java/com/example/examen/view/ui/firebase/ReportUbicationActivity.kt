package com.example.examen.view.ui.firebase

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.examen.R
import com.example.examen.compose.ViewModelActivity
import com.example.examen.models.entity.Ubication2
import com.example.examen.view.adapter.UbicationListAdapter
import com.google.firebase.FirebaseApp
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.skydoves.whatif.whatIfNotNull
import kotlinx.coroutines.*
import java.util.*


class ReportUbicationActivity: ViewModelActivity(){

    private var db: FirebaseFirestore? = null
    private var listUbicacion: List<Ubication2>? = null

    lateinit var mRecyclerView : RecyclerView
    val mAdapter : UbicationListAdapter = UbicationListAdapter()

    var superheros2:MutableList<Ubication2> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_ubication_reportes);

        //Instanciar Firebase
        FirebaseApp.initializeApp(this);
        db = Firebase.firestore
        setUpRecyclerView()
        bd_firestone();
    }

    companion object {
        private val TAG = ReportUbicationActivity::class.java.simpleName
        fun startActivityModel(context: Context?) {
            context.whatIfNotNull {
                val intent = Intent(it, ReportUbicationActivity::class.java).apply {}
                it.startActivity(intent)
            }
        }
    }


    fun setUpRecyclerView(){
        mRecyclerView = findViewById(R.id.recyclerViewReportx) as RecyclerView
        mRecyclerView.setHasFixedSize(true)
        mRecyclerView.layoutManager = GridLayoutManager(this, 1)
    }

    fun bd_firestone (){

        db?.collection("users")
            ?.get()
            ?.addOnSuccessListener { result ->
                /*var mull: MutableList<DocumentSnapshot> = result.documents
                var latitud: String = mull.get(0).data?.get("latitud").toString()
                var longitud: String = mull.get(0).data?.get("longitud").toString()
                var fecha: String = mull.get(0).data?.get("fecha_registro").toString()

                superheros2.add(Ubication2(fecha,latitud,longitud))
                Log.w("Lista3!!! -->", superheros2.toString())
                */
                superheros2 = result.toObjects(Ubication2::class.java)
                Log.w("Lista1!!! -->", superheros2.toString())
                Log.w("Lista2!!! -->", result.toString())
                //mAdapter.UbicationListAdapter(superheros2, this)
                //mRecyclerView.adapter = mAdapter
                //superheros = result.toObjects(Ubication2::class.java)
                //Log.w("Lista1!!! -->", superheros.toString())
            }
            ?.addOnFailureListener { exception ->
                Log.w("TAG", "Error getting documents.", exception)
            }?.addOnCompleteListener {
                mAdapter!!.notifyDataSetChanged()
                mAdapter.UbicationListAdapter(superheros2, this)
                mRecyclerView.adapter = mAdapter
            }
    }

}