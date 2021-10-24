
package com.example.examen.api

import androidx.lifecycle.LiveData
import com.example.examen.models.network.KeywordListResponse
import com.example.examen.models.network.ReviewListResponse
import com.example.examen.models.network.VideoListResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface MovieService {
  /**
   * [Movie Keywords](https://developers.themoviedb.org/3/movies/get-movie-keywords)
   *
   * Get the keywords that have been added to a movie.
   *
   * @param [id] Specify the id of movie id.
   *
   * @return [KeywordListResponse] response
   */
  @GET("/3/movie/{movie_id}/keywords")
  fun fetchKeywords(@Path("movie_id") id: Int): LiveData<ApiResponse<KeywordListResponse>>

  /**
   * [Movie Videos](https://developers.themoviedb.org/3/movies/get-movie-videos)
   *
   * Get the videos that have been added to a movie.
   *
   * @param [id] Specify the id of movie id.
   *
   * @return [VideoListResponse] response
   */
  @GET("/3/movie/{movie_id}/videos")
  fun fetchVideos(@Path("movie_id") id: Int): LiveData<ApiResponse<VideoListResponse>>

  /**
   * [Movie Reviews](https://developers.themoviedb.org/3/movies/get-movie-reviews)
   *
   * Get the user reviews for a movie.
   *
   * @param [id] Specify the id of movie id.
   *
   * @return [ReviewListResponse] response
   */
  @GET("/3/movie/{movie_id}/reviews")
  fun fetchReviews(@Path("movie_id") id: Int): LiveData<ApiResponse<ReviewListResponse>>
}
