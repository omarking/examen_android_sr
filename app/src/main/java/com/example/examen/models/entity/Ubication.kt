package com.example.examen.models.entity

import com.google.gson.annotations.SerializedName

open class Ubication(
     @SerializedName("fecha_registro")
     var fecha_registro: String,
     @SerializedName("latitud")
     var latitud: String,
     @SerializedName("longitud")
     var longitud: String
)
