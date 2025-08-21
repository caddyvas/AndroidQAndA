package com.learn.androidqanda.ui.android.fragment.architecturefragments

import android.graphics.Typeface
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.learn.androidqanda.R
import com.learn.androidqanda.databinding.FragmentArchitectureLayoutBinding

class MVPFragment : Fragment() {
    private lateinit var fragmentArchitectureLayout: FragmentArchitectureLayoutBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        activity?.actionBar?.title = "MVP Pattern"
        fragmentArchitectureLayout = FragmentArchitectureLayoutBinding.inflate(layoutInflater)
        return fragmentArchitectureLayout.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val textViewTitle = view.findViewById<TextView>(R.id.fragmentArchitectureTextView)
        textViewTitle.text = "MVP PATTERN"
        val imgView = view.findViewById<ImageView>(R.id.fragmentArchitectureImageView)
        imgView.setImageResource(R.drawable.mvp_architecture)
        textViewTitle.setTypeface(textViewTitle.typeface, Typeface.BOLD)

        // content text view
        val textViewContent = view.findViewById<TextView>(R.id.fragmentArchitectureContentTextView)
        textViewContent.text = resources.getText(R.string.architecture_mvp)
        textViewContent.movementMethod = ScrollingMovementMethod()
    }
}