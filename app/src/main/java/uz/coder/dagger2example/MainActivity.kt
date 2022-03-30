package uz.coder.dagger2example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import uz.coder.dagger2example.databinding.ActivityMainBinding
import uz.coder.dagger2example.utils.UserResource
import uz.coder.dagger2example.viewmodels.UserViewModel
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext
import kotlin.math.log

class MainActivity : AppCompatActivity(), CoroutineScope {

    @Inject
    lateinit var userViewModel: UserViewModel

    private  val tag = "MainActivity"
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        App.appComponent.inject(this)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        launch {
            userViewModel.getStateFlow().collect {

                when (it) {
                    is UserResource.Loading -> {}
                    is UserResource.Error -> {

                    }
                    is UserResource.Success -> {
                        Log.d(tag, "OnCreate: ${it.list}")
                    }
                }

            }
        }


    }

    override val coroutineContext: CoroutineContext
        get() = Job()
}