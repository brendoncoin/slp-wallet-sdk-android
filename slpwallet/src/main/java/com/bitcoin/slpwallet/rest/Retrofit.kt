package com.bitcoin.wallet.rest

import com.bitcoin.wallet.SLPWalletConfig
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

internal object Retrofit {

    private val client : OkHttpClient by lazy {
        OkHttpClient.Builder()
            .addInterceptor {
                var request = it.request()
                SLPWalletConfig.restAPIKey?.let {
                    request = request.newBuilder().addHeader("Authorization", "BITBOX:$it").build()
                }
                it.proceed(request)
            }
            .build()
    }

    val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://rest.bitcoin.com/v2/")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }

}