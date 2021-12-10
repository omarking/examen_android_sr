package com.example.examen.view.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import com.example.examen.models.Resource
import com.example.examen.models.entity.Movie
import com.example.examen.models.entity.Tv
import com.example.examen.models.entity.Ubication
import com.example.examen.repository.DiscoverRepository
import com.example.examen.utils.AbsentLiveData
import javax.inject.Inject
import timber.log.Timber

class MainActivityViewModel @Inject constructor(
  private val discoverRepository: DiscoverRepository
) : ViewModel() {

  private var moviePageLiveData: MutableLiveData<Int> = MutableLiveData()
  val movieListLiveData: LiveData<Resource<List<Movie>>>

  private var tvPageLiveData: MutableLiveData<Int> = MutableLiveData()
  val tvListLiveData: LiveData<Resource<List<Tv>>>

  //private var ubicationPageLiveData: List<Int> = MutableLiveData()
  //val ubicationListLiveData: List<Ubication> = TODO()

  init {
    Timber.d("injection MainActivityViewModel")

    movieListLiveData = moviePageLiveData.switchMap {
      moviePageLiveData.value?.let { discoverRepository.loadMovies(it) }
        ?: AbsentLiveData.create()
    }

    tvListLiveData = tvPageLiveData.switchMap {
      tvPageLiveData.value?.let { discoverRepository.loadTvs(it) } ?: AbsentLiveData.create()
    }

    /*var ubication: Ubication? = null
    val list: ArrayList<Ubication> = ArrayList()
    if (ubication != null) {
      list.add(ubication)
    }*/

    /*ubicationListLiveData = ubicationPageLiveData.switchMap {
      ubicationPageLiveData.value?.let { list } ?: AbsentLiveData.create()
    }*/

  }

    //Load values reports ubication
    /*ubicationListLiveData = ubicationPageLiveData.switchMap {
      ubicationPageLiveData.value?.let {
        myList(1)
      /*discoverRepository.loadTvs(it)*/
      }
    }

  }*/

  fun getMovieListValues() = movieListLiveData.value
  fun postMoviePage(page: Int) = moviePageLiveData.postValue(page)

  fun getTvListValues() = tvListLiveData.value
  fun postTvPage(page: Int) = tvPageLiveData.postValue(page)

  //fun getUbicationListValues() = ubicationListLiveData.value
  //fun postUbicationPage(page: Int) = ubicationPageLiveData.postValue(page)

}
