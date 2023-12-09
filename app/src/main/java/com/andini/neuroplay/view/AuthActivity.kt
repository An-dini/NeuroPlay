package com.andini.neuroplay.view

import android.content.res.ColorStateList
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.viewpager2.widget.ViewPager2
import com.airbnb.lottie.LottieAnimationView
import com.andini.neuroplay.R
import com.andini.neuroplay.viewmodel.AuthPageAdapter
import com.google.android.material.tabs.TabLayout

class AuthActivity : AppCompatActivity() {
    private lateinit var lottieAnimationView: LottieAnimationView
    private lateinit var tabLayout: TabLayout
    private lateinit var viewPager2: ViewPager2
    private lateinit var adapter: AuthPageAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE)
        setContentView(R.layout.activity_auth)

        lottieAnimationView = findViewById(R.id.animation_view)
        lottieAnimationView.setAnimation("login.json")
        lottieAnimationView.playAnimation()
        lottieAnimationView.loop(true)
        lottieAnimationView.speed = 1.0f

        tabLayout = findViewById(R.id.tabLayout)
        viewPager2 = findViewById(R.id.viPager)

        tabLayout.addTab(tabLayout.newTab().setText("Login"))
        tabLayout.addTab(tabLayout.newTab().setText("Register"))

        adapter = AuthPageAdapter(supportFragmentManager, lifecycle)
        viewPager2.adapter = adapter

        val colorDefault = ContextCompat.getColor(this@AuthActivity, R.color.blue_inactive)
        val colorSelected = ContextCompat.getColor(this@AuthActivity, R.color.blue)

        val tabColorStateList = ColorStateList(
            arrayOf(intArrayOf(android.R.attr.state_selected), intArrayOf()),
            intArrayOf(colorSelected, colorDefault)
        )

        tabLayout.tabTextColors = tabColorStateList

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                if (tab != null) {
                    viewPager2.currentItem = tab.position
                }
                tabLayout.setTabTextColors(tabColorStateList)
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }
        })
        viewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                tabLayout.selectTab(tabLayout.getTabAt(position))

                val layoutParams = viewPager2.layoutParams
                layoutParams.height = when (position) {
                    0 -> resources.getDimensionPixelSize(R.dimen.view_pager_height_login)
                    1 -> resources.getDimensionPixelSize(R.dimen.view_pager_height_register)
                    else -> LinearLayout.LayoutParams.MATCH_PARENT
                }
                viewPager2.layoutParams = layoutParams

            }
        })
    }
}