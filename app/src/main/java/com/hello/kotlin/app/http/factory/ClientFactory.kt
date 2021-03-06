package com.hello.kotlin.app.http.factory

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response

/**
 * Created by renan on 19/06/16.
 */
class ClientFactory {

    open fun create() : OkHttpClient{
        return OkHttpClient.Builder().addInterceptor(UrlInterceptor()).build()
    }

    class UrlInterceptor : Interceptor {

        override fun intercept(chain: Interceptor.Chain): Response? {
            val r = chain.request()
            val request = r.newBuilder()
                    .addHeader("X-Parse-Application-Id", "app.id")
                    .addHeader("X-Parse-REST-API-Key", "888")
                    .build()
            return chain.proceed(request)
        }
    }
}