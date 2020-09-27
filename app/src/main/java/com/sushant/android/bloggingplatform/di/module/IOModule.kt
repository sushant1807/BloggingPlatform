package com.sushant.android.bloggingplatform.di.module

import com.google.gson.GsonBuilder
import com.squareup.picasso.BuildConfig
import com.sushant.android.data.data.Endpoint
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class IOModule {
  private val endpoint: Endpoint

  init {
    val okHttpBuilder = OkHttpClient.Builder()

    if (BuildConfig.BUILD_TYPE == "debug") {
      okHttpBuilder.addInterceptor { chain ->
        println(chain.request())
        chain.proceed(chain.request())
      }
    }

    val okHttpClient = okHttpBuilder.build()

    val gson = GsonBuilder().create()

    val retrofit = Retrofit.Builder()
      .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
      .addConverterFactory(GsonConverterFactory.create(gson))
      .baseUrl("https://sym-json-server.herokuapp.com/")
      .client(okHttpClient)
      .build()

    endpoint = retrofit.create(Endpoint::class.java)
  }

  @Provides
  @Singleton
  internal fun provideEndpoint(): Endpoint = endpoint
}