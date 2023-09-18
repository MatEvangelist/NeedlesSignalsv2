package br.com.fiap.needlessignals.presentation.models

import com.google.gson.annotations.SerializedName

data class User(
    val firstName:String = "",
    val lasstName:String = "",
    val email:String = "",
    val password:String = "",
    @SerializedName("cpfcnpj") val cnpj:String = ""
)