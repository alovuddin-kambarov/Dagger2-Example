package uz.coder.dagger2example.ui.splash

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AlphaAnimation
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import uz.coder.dagger2example.R
import uz.coder.dagger2example.databinding.FragmentSplashBinding
import uz.coder.dagger2example.utils.MyUtils

class SplashFragment : Fragment() {

    private lateinit var binding: FragmentSplashBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSplashBinding.inflate(layoutInflater)


        activity?.window?.decorView?.systemUiVisibility = View.DRAG_FLAG_GLOBAL_URI_WRITE
        activity?.window?.statusBarColor = ContextCompat.getColor(binding.root.context,
            R.color.main
        )
        Handler(Looper.myLooper()!!).postDelayed({

            findNavController().navigate(R.id.onboardingFragment, Bundle(),MyUtils.setAnimation().build())

        }, 2000)

        val animation1 = AlphaAnimation(0.0f, 1.0f)
        animation1.duration = 1000
        animation1.startOffset = 100
        animation1.fillAfter = true
        binding.splashImage.startAnimation(animation1)

        return binding.root
    }


}