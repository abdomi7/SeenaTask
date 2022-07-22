package com.example.instabuginternshiptask.data.services

import android.content.Context
import android.net.ConnectivityManager
import android.util.Log


class NetworkStatus(val context: Context) {
    var connectivityManager: ConnectivityManager? = null
    var connected = false
    val isOnline: Boolean
        get() {
            try {
                connectivityManager = context
                    .getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
                val networkInfo = connectivityManager!!.activeNetworkInfo
                connected = networkInfo != null && networkInfo.isAvailable &&
                        networkInfo.isConnected
                return connected
            } catch (e: Exception) {
                println("CheckConnectivity Exception: " + e.message)
                Log.v("connectivity", e.toString())
            }
            return connected
        }
}