package br.com.up.devegaresecalmos.model

import com.google.firebase.Timestamp

data class Race (
    val distance:String,
    val time:Float,
    val hour:Timestamp,
    val opponent:String
        )