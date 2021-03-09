package com.mogere.variants.network

import com.mogere.variants.Entity.Product
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

private const val BASE_URL = ""

private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()


private val retrofit = Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .baseUrl(BASE_URL)
        .build()

interface VariantsApiService{

    @POST("variants")
    suspend fun addVariants(@Body product: Product)

    @GET("variant")
    suspend fun getVariant(id:Long)
}

object VariantsApi {
    val retrofitService : VariantsApiService by lazy { retrofit.create(VariantsApiService::class.java) }
}