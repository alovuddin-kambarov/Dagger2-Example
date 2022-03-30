package uz.coder.dagger2example.ui.splash

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import uz.coder.dagger2example.R
import uz.coder.dagger2example.databinding.FragmentWelcomeBinding
import uz.coder.dagger2example.utils.MyUtils

class WelcomeFragment : Fragment() {

    private lateinit var binding: FragmentWelcomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWelcomeBinding.inflate(layoutInflater)

        binding.card.setOnClickListener {
            findNavController().navigate(
                R.id.selectFovoriteFragment,
                Bundle(), MyUtils.setAnimation().build()
            )
        }

        return binding.root
    }

}