package br.com.fiap.needlessignals.service

import br.com.fiap.needlessignals.models.User
import br.com.fiap.needlessignals.models.UserTokenDto
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface RegisterService {

    //localhost:8080/api/v1/auth/register
    @POST("auth/register")
    fun setRegister(@Body user: User): Call<UserTokenDto>
}