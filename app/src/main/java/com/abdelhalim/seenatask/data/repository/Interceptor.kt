package com.abdelhalim.seenatask.data.repository

import android.content.Context
import com.abdelhalim.seenatask.data.services.NetworkStatus
import okhttp3.Interceptor
import okhttp3.Response

class Interceptor constructor(private val context: Context) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalResponse = chain.proceed(chain.request())
        return if (NetworkStatus(context = context).isOnline) {
            val maxAge = 60 // read from cache for 1 minute
            originalResponse.newBuilder()
                .header("Cache-Control", "public, max-age=$maxAge")
                .build()
        } else {
            val maxStale = 60 * 60 * 24 * 28 // tolerate 4-weeks stale
            originalResponse.newBuilder()
                .header("Cache-Control", "public, only-if-cached, max-stale=$maxStale")
                .build()
        }
    }
}