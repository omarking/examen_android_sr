package com.example.examen.di

import com.example.examen.view.ui.MainActivity
import com.example.examen.di.annotations.ActivityScope
import com.example.examen.view.ui.details.movie.MovieDetailActivity
import com.example.examen.view.ui.details.tv.TvDetailActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {

  @ActivityScope
  @ContributesAndroidInjector(modules = [MainActivityFragmentModule::class])
  internal abstract fun contributeMainActivity(): MainActivity

  @ActivityScope
  @ContributesAndroidInjector
  internal abstract fun contributeMovieDetailActivity(): MovieDetailActivity

  @ActivityScope
  @ContributesAndroidInjector
  internal abstract fun contributeTvDetailActivity(): TvDetailActivity
}
