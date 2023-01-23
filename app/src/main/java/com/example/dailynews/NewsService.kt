package com.example.dailynews

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

// https://newsapi.org/v2/top-headlines?country=in&category=business&apiKey=84c9c84233964ab4873fea741b52e5a7
// https://newsapi.org/v2/top-headlines?sources=techcrunch&apiKey=84c9c84233964ab4873fea741b52e5a7


const val Base_URL="https://newsapi.org/"
const val API_KEY="84c9c84233964ab4873fea741b52e5a7"

interface NewsInterface {
    @GET( "v2/top-headlines?apiKey=$API_KEY")
    fun getHeadLines(@Query("country") country:String, @Query("Page")  page: Int):Call<News>

//    https://newsapi.org/v2/top-headlines?apiKey=$API_KEY&country=in&page=1
//    https://newsapi.org/v2/top-headlines?country=in&category=business&apiKey=84c9c84233964ab4873fea741b52e5a7

}
object NewsService{
    val newsInstance:NewsInterface
    init {
        val retrofit= Retrofit.Builder()
            .baseUrl(Base_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        newsInstance= retrofit.create(NewsInterface::class.java)



    }
}