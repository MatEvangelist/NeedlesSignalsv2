package br.com.fiap.needlessignals.service

import br.com.fiap.needlessignals.presentation.models.User
import br.com.fiap.needlessignals.presentation.models.UserLogin
import br.com.fiap.needlessignals.presentation.models.UserTokenDto
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface RegisterService {
    companion object {
        const val BASE_URL = "https://startup-one-production.up.railway.app/api/v1/"
    }
    //localhost:8080/api/v1/auth/register
    @POST("auth/register")
    fun setRegister(@Body user: User): Call<UserTokenDto>

    @POST("auth/authenticate")
    fun login(@Body user: UserLogin): Call<UserTokenDto>
}