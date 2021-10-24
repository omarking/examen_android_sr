package com.example.examen.api

import androidx.lifecycle.LiveData
import com.example.examen.models.network.DiscoverMovieResponse
import com.example.examen.models.network.DiscoverTvResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface TheDiscoverService {
  /**
   * [Movie Discover](https://developers.themoviedb.org/3/discover/movie-discover)
   *
   *  Discover movies by different types of data like average rating, number of votes, genres and certifications.
   *  You can get a valid list of certifications from the  method.
   *
   *  @param [page] Specify the page of results to query.
   *
   *  @return [DiscoverMovieResponse] response
   */
  @GET("/3/discover/movie?language=en&sort_by=popularity.desc")
  fun fetchDiscoverMovie(@Query("page") page: Int): LiveData<ApiResponse<DiscoverMovieResponse>>

  /**
   * [Tv Discover](https://developers.themoviedb.org/3/discover/tv-discover)
   *
   *  Discover TV shows by different types of data like average rating, number of votes, genres, the network they aired on and air dates.
   *
   *  @param [page] Specify the page of results to query.
   *
   *  @return [DiscoverTvResponse] response
   */
  @GET("/3/discover/tv?language=en&sort_by=popularity.desc")
  fun fetchDiscoverTv(@Query("page") page: Int): LiveData<ApiResponse<DiscoverTvResponse>>
}
