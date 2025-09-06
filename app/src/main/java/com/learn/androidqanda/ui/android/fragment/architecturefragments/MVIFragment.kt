package com.learn.androidqanda.ui.android.fragment.architecturefragments

import android.graphics.Typeface
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.learn.androidqanda.R
import com.learn.androidqanda.databinding.FragmentArchitectureLayoutBinding

class MVIFragment : Fragment() {

    private var _binding: FragmentArchitectureLayoutBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // the Fragment's onCreateView inflater. In a Fragment, you should always use the inflater passed as a parameter
        _binding = FragmentArchitectureLayoutBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // set the action bar title
        (requireActivity() as AppCompatActivity).supportActionBar?.title = "MVI Pattern"

        // Setup views using view binding
        binding.fragmentArchitectureTextView.apply {
            text = "MVI PATTERN"
            setTypeface(typeface, Typeface.BOLD)
        }

        binding.fragmentArchitectureImageView.setImageResource(R.drawable.mvi_architecture)

        // content text view
        binding.fragmentArchitectureContentTextView.apply {
            text = resources.getText(R.string.architecture_mvi)
            movementMethod = ScrollingMovementMethod()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}