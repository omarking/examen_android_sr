package com.example.examen.view.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.example.examen.R
import com.example.examen.models.entity.Ubication2

class UbicationListAdapter:  RecyclerView.Adapter<UbicationListAdapter.ViewHolder>() {

  var superheros: MutableList<Ubication2>  = ArrayList()
  lateinit var context:Context

  fun UbicationListAdapter(superheros : MutableList<Ubication2>, context: Context){
    this.superheros = superheros
    this.context = context
  }
  override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    val item = superheros.get(position)
    holder.bind(item, context)
  }
  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    val layoutInflater = LayoutInflater.from(parent.context)
    return ViewHolder(layoutInflater.inflate(R.layout.item_report_ubication, parent, false))
  }
  override fun getItemCount(): Int {
    return superheros.size
  }
  class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val item_latitud = view.findViewById(R.id.item_latitud) as AppCompatTextView
    val item_longitud = view.findViewById(R.id.item_longitud) as AppCompatTextView
    val item_fecha = view.findViewById(R.id.item_fecha) as AppCompatTextView

    fun bind(superhero:Ubication2, context: Context){
      item_latitud.text = superhero.latitud
      item_longitud.text = superhero.longitud
      item_fecha.text = superhero.fecha_registro
      itemView.setOnClickListener(View.OnClickListener { Toast.makeText(context, "Fecha de Registro: "+superhero.fecha_registro, Toast.LENGTH_SHORT).show() })
    }
  }
}
