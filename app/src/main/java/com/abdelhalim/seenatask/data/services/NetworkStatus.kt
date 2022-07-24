package com.abdelhalim.seenatask.data.services

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities


class NetworkStatus(val context: Context) {
    var connectivityManager: ConnectivityManager? = null
    val isOnline: Boolean
        get() {
            connectivityManager = context
                .getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            return if (connectivityManager != null) {
                val capabilities = connectivityManager!!.getNetworkCapabilities(
                    connectivityManager!!.activeNetwork
                )
                if (capabilities != null) {
                    if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)) {
                        return true
                    }
                    if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)) {
                        true
                    } else capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET)
                } else {
                    false
                }
            } else false
        }
}