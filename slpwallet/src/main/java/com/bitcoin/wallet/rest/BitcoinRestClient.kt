package com.bitcoin.wallet.rest

import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

/**
 * @author akibabu
 */
internal interface BitcoinRestClient {

    @POST("address/utxo")
    fun getUtxos(@Body request: AddressUtxosRequest): Single<List<AddressUtxosResponse>>

    @GET("rawtransactions/sendRawTransaction/{hex}")
    fun sendRawTransaction(@Path("hex") hex: String): Single<String>

    @POST("transaction/details")
    fun getTransactions(@Body request: TxDetailsRequest): Single<List<TxResponse>>

    @POST("slp/validateTxid")
    fun validateSlpTxs(@Body request: SlpValidateTxRequest): Single<List<SlpValidateTxResponse>>

    companion object {
        val client : BitcoinRestClient by lazy { Retrofit.retrofit.create(BitcoinRestClient::class.java) }
    }
}
