package uz.coder.dagger2example

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import uz.coder.dagger2example.adapters.SelectFavoriteAdapter
import uz.coder.dagger2example.databinding.FragmentSelectFovoriteBinding
import uz.coder.dagger2example.databinding.SelectFavoriteItemBinding
import uz.coder.dagger2example.utils.MyUtils

class SelectFavoriteFragment : Fragment() {

    lateinit var binding: FragmentSelectFovoriteBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSelectFovoriteBinding.inflate(layoutInflater)

        binding.rv.adapter = SelectFavoriteAdapter(MyUtils.getFavoriteData())

        return binding.root
    }

}