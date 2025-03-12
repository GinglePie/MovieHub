package com.arise.training.moviehub

import android.content.Intent
import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.commit
import com.arise.training.moviehub.SplashActivity.Companion.EXTRA_NAME
import com.arise.training.moviehub.databinding.ActivityMainBinding
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val fragment = supportFragmentManager.findFragmentByTag("tagHome")

        if (fragment == null) {
            val newFragment = HomeFragment.newInstance(param1 = viewModel.number.value.toString())
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add(
                    R.id.mainFragmentContainer,
                    newFragment,
                    "tagHome"
                )
                addToBackStack(null)
            }
        } else {
            supportFragmentManager.commit {
                show(fragment)
            }
        }

        if (savedInstanceState != null) {
            viewModel.setCounter(value = savedInstanceState.getInt(STATE_COUNT))
        }

        val name = intent.getStringExtra(EXTRA_NAME)

        viewModel.number.observe(this) {
            binding.mainTv.text = "count $it"
        }

        binding.mainBtn.setOnClickListener {
            viewModel.counter()
//            goToDetailActivity()
            Timber.d("onClick")
        }

        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                val fragmentManager = supportFragmentManager
                if (fragmentManager.backStackEntryCount > 1) {
                    fragmentManager.popBackStack()
                } else {
                    finish()
                }
            }
        })

        Timber.d("onCreate")
    }

    override fun onStart() {
        super.onStart()
        Timber.d("onStart")
    }

    override fun onResume() {
        super.onResume()
        Timber.d("onResume")
    }

    override fun onPause() {
        super.onPause()
        Timber.d("onPause")
    }

    override fun onStop() {
        super.onStop()
        Timber.d("onStop")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(STATE_COUNT, viewModel.number.value ?: 0)
        Timber.d("onSaveInstanceState")
    }

    override fun onDestroy() {
        super.onDestroy()
        Timber.d("onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Timber.d("onRestart")
    }

    fun goToDetailActivity() {
        val intent = Intent(this, DetailActivity::class.java)
        startActivity(intent)
    }

    companion object {
        const val STATE_COUNT = "STATE_COUNT"
    }
}