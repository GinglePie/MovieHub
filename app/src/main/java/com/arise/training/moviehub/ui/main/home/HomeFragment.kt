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
import timber.log.Timber

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding: FragmentHomeBinding get() = _binding!!

    private val viewModel: MainViewModel by activityViewModels()

    // TODO: Rename and change types of parameters
    private var number: String? = null
    private var param2: String? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Timber.d("onAttach $number")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            number = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
        Timber.d("onCreate $number")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        Timber.d("onCreateView $number")
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.number.observe(viewLifecycleOwner) {
            binding.homeTv.text = "count $it"
        }

        binding.homeTv.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToDetailActivity(entryPoint = "open from home")
            findNavController().navigate(action)
        }

        Timber.d("onViewCreated $number")
    }

    override fun onStart() {
        super.onStart()
        Timber.d("onStart $number")
    }

    override fun onResume() {
        super.onResume()
        Timber.d("onResume $number")
    }

    override fun onPause() {
        super.onPause()
        Timber.d("onPause $number")
    }

    override fun onStop() {
        super.onStop()
        Timber.d("onStop $number")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Timber.d("onSaveInstanceState $number")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        Timber.d("onDestroyView $number")
    }

    override fun onDestroy() {
        super.onDestroy()
        Timber.d("onDestroy $number")
    }

    override fun onDetach() {
        super.onDetach()
        Timber.d("onDetach $number")
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
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}