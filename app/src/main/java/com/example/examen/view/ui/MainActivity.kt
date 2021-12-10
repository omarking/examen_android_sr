package com.example.examen.view.ui

import android.os.Bundle
import com.example.examen.R
import androidx.viewpager.widget.ViewPager
import com.example.examen.view.ui.firebase.GaleriaActivity
import com.example.examen.view.ui.firebase.ReportUbicationActivity
import com.example.examen.view.ui.firebase.UbicationActivity
import com.example.examen.view.ui.main.MainPagerAdapter
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : DaggerAppCompatActivity(), HasAndroidInjector{
    @Inject
    lateinit var fragmentInjector: DispatchingAndroidInjector<Any>

    override fun androidInjector() = fragmentInjector

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initializeUI()
        initializeUI2()
    }

    private fun initializeUI() {
        with(main_viewpager) {
            adapter = MainPagerAdapter(supportFragmentManager)
            offscreenPageLimit = 2
            addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
                override fun onPageScrollStateChanged(state: Int) = Unit
                override fun onPageScrolled(
                    position: Int,
                    positionOffset: Float,
                    positionOffsetPixels: Int
                ) = Unit

                override fun onPageSelected(position: Int) {
                    main_bottom_navigation.menu.getItem(position).isChecked = true
                }
            })
            main_bottom_navigation.setOnNavigationItemSelectedListener {
                when (it.itemId) {
                    R.id.action_one -> currentItem = 0
                    R.id.action_two -> currentItem = 1
                }
                true
            }
        }
    }

    private fun initializeUI2() {
     main_bottom_navigation2.setOnNavigationItemSelectedListener {
                when (it.itemId) {
                    R.id.action_three3 ->
                    ubicationFunction();

                    R.id.action_threex ->
                     reportsUbicationFunction();

                    R.id.action_four ->
                    reportsGaleriasFunction();
                }
                true
     }
    }

    private fun ubicationFunction(){
        UbicationActivity.startActivityModel(this)
    }

    private fun reportsUbicationFunction(){
        ReportUbicationActivity.startActivityModel(this)
    }

    private fun reportsGaleriasFunction(){
        GaleriaActivity.startActivityModel(this)
    }
}