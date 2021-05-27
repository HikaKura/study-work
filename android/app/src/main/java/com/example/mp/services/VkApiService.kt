package com.example.mp.services

import android.util.Log
import com.vk.api.sdk.VK
import com.vk.api.sdk.VKApiCallback
import com.vk.api.sdk.requests.VKRequest

class VkApiService {
    val tag: String = "vk"

    fun <T>execute(request: VKRequest<T>, onSuccess: (result: T) -> Unit) {
        VK.execute(request, object: VKApiCallback<T> {
            override fun fail(error: Exception) {
                Log.e(tag, error.toString())
            }

            override fun success(result: T) {
                onSuccess(result)
            }
        })
    }

    companion object {
        private var instance: VkApiService? = null

        fun getInstance(): VkApiService {
            if (instance == null) {
                instance = VkApiService()
            }

            return instance!!
        }
    }
}