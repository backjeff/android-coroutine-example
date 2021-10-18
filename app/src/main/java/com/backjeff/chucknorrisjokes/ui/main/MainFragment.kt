package com.backjeff.chucknorrisjokes.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.backjeff.chucknorrisjokes.databinding.MainFragmentBinding
import org.koin.android.viewmodel.ext.android.viewModel

class MainFragment : Fragment() {

    private lateinit var binding: MainFragmentBinding

    companion object {
        fun newInstance() = MainFragment()
    }

    private val viewModel: MainViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = MainFragmentBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        addObservers()
        setupViews()
    }

    private fun setupViews() {
        binding.button.setOnClickListener {
            binding.message.text = ""
            binding.progressBar.isVisible = true

//            viewModel.getRandomJoke()
//            viewModel.getRandomJokeCoroutine()
            viewModel.getRandonJokeUseCase()
        }

        binding.anotherButton.setOnClickListener {
            Toast.makeText(context, "Chuck Norris can instantiate an abstract class.", Toast.LENGTH_SHORT).show()
        }
    }

    private fun addObservers() {
        with(viewModel) {
            joke.observe(viewLifecycleOwner, {
                binding.progressBar.isVisible = false
                binding.message.text = it
            })
        }
    }
}
