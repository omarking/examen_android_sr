package com.example.examen.view.ui.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.examen.view.ui.MovieListFragment
import com.example.examen.view.ui.TvListFragment

class MainPagerAdapter(fm: FragmentManager) :
  FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

  override fun getItem(position: Int): Fragment{
    return when (position) {
      0 -> MovieListFragment()
      else -> TvListFragment()
    }
  }

  override fun getCount() = 2
}
