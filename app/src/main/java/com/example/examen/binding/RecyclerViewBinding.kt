package com.example.examen.binding

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.skydoves.baserecyclerviewadapter.BaseAdapter
import com.skydoves.baserecyclerviewadapter.RecyclerViewPaginator
import com.example.examen.extension.bindResource
import com.example.examen.extension.visible
import com.example.examen.models.Resource
import com.example.examen.models.Status
import com.example.examen.models.Video
import com.example.examen.models.entity.Movie
import com.example.examen.models.entity.Tv
import com.example.examen.models.entity.Ubication
import com.example.examen.view.adapter.MovieListAdapter
import com.example.examen.view.adapter.TvListAdapter
import com.example.examen.view.adapter.UbicationListAdapter
import com.example.examen.view.adapter.VideoListAdapter
import com.example.examen.view.ui.MainActivityViewModel
import com.skydoves.whatif.whatIfNotNullOrEmpty

@BindingAdapter("adapter")
fun bindRecyclerViewAdapter(view: RecyclerView, adapter: BaseAdapter) {
  view.adapter = adapter
}

@BindingAdapter("adapterMovieList")
fun bindAdapterMovieList(view: RecyclerView, resource: Resource<List<Movie>>?) {
  view.bindResource(resource) {
    val adapter = view.adapter as? MovieListAdapter
    adapter?.addMovieList(it)
  }
}

@BindingAdapter("moviePagination")
fun bindMoviePagination(view: RecyclerView, viewModel: MainActivityViewModel) {
  RecyclerViewPaginator(
    recyclerView = view,
    isLoading = { viewModel.getTvListValues()?.status == Status.LOADING },
    loadMore = { viewModel.postMoviePage(it) },
    onLast = { false }
  ).run {
    currentPage = 1
  }
}

@BindingAdapter("adapterTvList")
fun bindAdapterTvList(view: RecyclerView, resource: Resource<List<Tv>>?) {
  view.bindResource(resource) {
    val adapter = view.adapter as? TvListAdapter
    adapter?.addTvList(it)
  }
}

@BindingAdapter("tvPagination")
fun bindTvPagination(view: RecyclerView, viewModel: MainActivityViewModel) {
  RecyclerViewPaginator(
    recyclerView = view,
    isLoading = { viewModel.getTvListValues()?.status == Status.LOADING },
    loadMore = { viewModel.postTvPage(it) },
    onLast = { false }
  ).run {
    currentPage = 1
  }
}

@BindingAdapter("adapterVideoList")
fun bindAdapterVideoList(view: RecyclerView, resource: Resource<List<Video>>?) {
  view.bindResource(resource) {
    val adapter = view.adapter as? VideoListAdapter
    adapter?.addVideoList(it)
    it.data.whatIfNotNullOrEmpty {
      view.visible()
    }
  }

  //Pagination & Ubication

  /*@BindingAdapter("adapterUbicationList")
  fun bindAdapterUbicationList(view: RecyclerView, resource: List<Ubication>?) {
    view.bindResource(resource) {
      val adapter = view.adapter as? UbicationListAdapter
      adapter?.addUbicationList(it)
    }
  }*/

  /*@BindingAdapter("tvPagination")
  fun bindUbicationPagination(view: RecyclerView, viewModel: MainActivityViewModel) {
    RecyclerViewPaginator(
      recyclerView = view,
      isLoading = { viewModel.getTvListValues()?.status == Status.LOADING },
      loadMore = { viewModel.postTvPage(it) },
      onLast = { false }
    ).run {
      currentPage = 1
    }
  }*/

}
