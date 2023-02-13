package com.devdvs.testapplication.src.util

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo

/**
 * Created by Sánchez Deivis on 12,febrero,2023
 */
object NetworkUtil {
    private val TAG = NetworkUtil::class.java.simpleName

    /**
     * Returns true if device is connected to wifi or mobile network, false
     * otherwise.
     *
     * @param context
     * @return
     */
    @JvmStatic
    fun isConnected(context: Context): Boolean {
        val conMan = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val infoWifi = conMan.getNetworkInfo(ConnectivityManager.TYPE_WIFI)
        if (infoWifi != null) {
            val wifi = infoWifi.state
            if (wifi == NetworkInfo.State.CONNECTED) {
                return true
            }
        }
        val infoMobile = conMan.getNetworkInfo(ConnectivityManager.TYPE_MOBILE)
        if (infoMobile != null) {
            val mobile = infoMobile.state
            if (mobile == NetworkInfo.State.CONNECTED) {
                return true
            }
        }
        return false
    }

    /**
     * Check if there is any connectivity to a Wifi network
     *
     * @param context
     * @return
     */
    fun isConnectedWifi(context: Context): Boolean {
        val info = getNetworkInfo(context)
        return info != null && info.isConnected && (info.type
                == ConnectivityManager.TYPE_WIFI)
    }

    /**
     * Check if there is any connectivity to a mobile network
     *
     * @param context
     * @return
     */
    fun isConnectedMobile(context: Context): Boolean {
        val info = getNetworkInfo(context)
        return info != null && info.isConnected && (info.type
                == ConnectivityManager.TYPE_MOBILE)
    }

    /**
     * Get the network info
     *
     * @param context
     * @return
     */
    fun getNetworkInfo(context: Context): NetworkInfo? {
        val cm = context
            .getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        return cm.activeNetworkInfo
    }
}