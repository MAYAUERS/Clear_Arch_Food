package com.example.cleararch27feb.di

import com.example.cleararch27feb.data.Api
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val restrofitModule= module {

    single { provideRetrofit(client = get()) }
    factory { provideApi(retrofit = get()) }
    factory { provideOkHttpClient(httpLoggingInterceptor = get()) }
    factory { HttpLoggingInterceptor() }
}

fun provideRetrofit(client: OkHttpClient) :Retrofit{
    return Retrofit.Builder().baseUrl("https://api.fda.gov/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()
}

fun provideOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor):OkHttpClient{
    return OkHttpClient().newBuilder().addInterceptor(httpLoggingInterceptor).build()
}

fun provideApi(retrofit: Retrofit):Api{
    return retrofit.create(Api::class.java)
}