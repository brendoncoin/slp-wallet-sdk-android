package com.bitcoin.wallet.persistence

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.math.BigDecimal

// TODO: Can achieve some of this with a join?

@Entity
data class SlpTokenBalance  (
    @PrimaryKey var tokenId: String,
    @ColumnInfo var amount: BigDecimal,
    @ColumnInfo var ticker: String?,
    @ColumnInfo var name: String?,
    @ColumnInfo var decimals: Int
)