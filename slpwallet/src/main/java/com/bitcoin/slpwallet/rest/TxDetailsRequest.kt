package com.bitcoin.slpwallet.rest

/**
 * https://rest.bitcoin.com/#/address/utxoBulk
 *
 * @author akibabu
 */
internal data class TxDetailsRequest(val txids: List<String>)