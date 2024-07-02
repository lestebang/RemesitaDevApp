package com.lesteban.remesitadevapp.data.model

import com.google.gson.annotations.SerializedName

data class Balance(
    @SerializedName("prepaidCardCombinedBalance")
    val prepaidCardCombinedBalance: Double,
    @SerializedName("prepaidCardCombinedBalanceUsd")
    val prepaidCardCombinedBalanceUsd: Double,
    @SerializedName("referralsCommission")
    val referralsCommission: Double,
    @SerializedName("usd2mxn")
    val usd2mxn: Double
)