package com.arise.training.moviehub.ui.main.home

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.arise.training.moviehub.databinding.FragmentHomeBinding
import com.arise.training.moviehub.ui.main.MainViewModel
import com.arise.training.moviehub.ui.main.home.adapter.PosterLargeListAdapter
import com.arise.training.moviehub.ui.main.home.adapter.PosterSmallListAdapter
import timber.log.Timber

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding: FragmentHomeBinding get() = _binding!!

    private val viewModel: MainViewModel by activityViewModels()

    private val posterLargeAdapter by lazy { PosterLargeListAdapter() }
    private val posterSmallAdapter by lazy { PosterSmallListAdapter() }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.homeMovieRcv.adapter = posterLargeAdapter
        binding.homeMovieGridRcv.adapter = posterSmallAdapter
        observe()
    }

    private fun observe() {
        viewModel.movies.observe(viewLifecycleOwner) {
            posterLargeAdapter.submitList(it)
            posterSmallAdapter.submitList(it)
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HomeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String = "", param2: String = "") =
            HomeFragment()
    }
}