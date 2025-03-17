package com.arise.training.moviehub.ui.main.search

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.arise.training.moviehub.R
import com.arise.training.moviehub.databinding.FragmentHomeBinding
import com.arise.training.moviehub.databinding.FragmentSeachBinding
import com.arise.training.moviehub.ui.main.MainViewModel
import com.arise.training.moviehub.ui.main.adapter.MovieListAdapter
import com.arise.training.moviehub.ui.main.home.adapter.PosterLargeListAdapter
import com.arise.training.moviehub.ui.main.home.adapter.PosterSmallListAdapter

class SeachFragment : Fragment() {

    private var _binding: FragmentSeachBinding? = null
    private val binding: FragmentSeachBinding get() = _binding!!

    private val viewModel: MainViewModel by activityViewModels()

    private val adapter by lazy { MovieListAdapter() }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSeachBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.movieRcv.adapter = adapter
        observe()
    }

    private fun observe() {
        viewModel.movies.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment SeachFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SeachFragment()
    }
}