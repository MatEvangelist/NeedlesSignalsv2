package br.com.fiap.needlessignals.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitFactory {

    private val URL = "https://startup-one-production.up.railway.app/api/v1/"

    private val retrofitFactory = Retrofit
        .Builder()
        .baseUrl(URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun setRegister(): RegisterService {
        return retrofitFactory.create(RegisterService::class.java)
    }
}