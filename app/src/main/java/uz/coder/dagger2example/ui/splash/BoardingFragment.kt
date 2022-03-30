package uz.coder.dagger2example.ui.splash

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import uz.coder.dagger2example.R
import uz.coder.dagger2example.adapters.SliderAdapter
import uz.coder.dagger2example.databinding.FragmentBoardingBinding
import uz.coder.dagger2example.utils.MyUtils
import kotlin.math.abs

class BoardingFragment : Fragment() {

    private lateinit var binding: FragmentBoardingBinding
    var handler = Handler(Looper.myLooper()!!)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBoardingBinding.inflate(layoutInflater)

        activity?.window?.decorView?.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        activity?.window?.statusBarColor =
            ContextCompat.getColor(binding.root.context, R.color.white)

        setHandleViewPager()
        nextPage()

        return binding.root
    }

    private fun setHandleViewPager() {

        binding.vp.adapter = SliderAdapter(MyUtils.loadImage(), binding.vp)
        binding.vp.clipToPadding = false
        binding.vp.clipChildren = false
        binding.vp.offscreenPageLimit = 3
        binding.vp.getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER
        binding.tabIndicator.setViewPager2(binding.vp)

        val compositePageTransformer = CompositePageTransformer()

        compositePageTransformer.addTransformer(MarginPageTransformer(40))
        compositePageTransformer.addTransformer { page, position ->

            val r = 1 - abs(position)

            page.scaleY = 0.85f + r * 0.15f

        }


        binding.vp.setPageTransformer(compositePageTransformer)

        binding.vp.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                handler.removeCallbacks(runnable)
                handler.postDelayed(runnable, 3000)

            }
        })

    }

    fun nextPage() {
        binding.card.setOnClickListener {
            findNavController().navigate(
                R.id.welcomeFragment,
                Bundle(), MyUtils.setAnimation().build()
            )
        }
    }

    private val runnable =
        Runnable { binding.vp.currentItem = binding.vp.currentItem + 1 }

}