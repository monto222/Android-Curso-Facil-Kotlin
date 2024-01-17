package com.pruebas.kotlinDesdeCero.superheroapp

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("/api/7233084160084235/search/{name}")
    suspend fun getSuperheroes(@Path("name") superHeroName: String): Response<SuperHeroDataResponse>

    @GET("/api/7233084160084235/{id}")
    suspend fun getSuperheroDetail(@Path("id") superheroId:String): Response<SuperHeroDetailResponse>

}