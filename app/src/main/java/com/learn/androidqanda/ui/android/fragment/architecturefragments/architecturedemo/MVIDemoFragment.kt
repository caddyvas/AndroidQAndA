package com.learn.androidqanda.ui.android.fragment.architecturefragments.architecturedemo

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.learn.androidqanda.R
import kotlinx.coroutines.launch

class MVIDemoFragment : Fragment(R.layout.fragment_mvi_architecture_demo) {

    private lateinit var userNameEditText: EditText
    private lateinit var passwordEdit: EditText
    private lateinit var loginButtonSubmit: Button
    private lateinit var progressBar: ProgressBar
    private lateinit var statusText: TextView

    private val viewModel: LoginViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        userNameEditText = view.findViewById(R.id.mvi_edit_user_name)
        passwordEdit = view.findViewById(R.id.mvi_edit_password)
        loginButtonSubmit = view.findViewById(R.id.mvi_buttonSubmit)
        progressBar = view.findViewById(R.id.mvi_progressBar)
        statusText = view.findViewById(R.id.mvi_textViewResult)

        view.findViewById<ImageButton>(R.id.mvi_info_button).setOnClickListener {
            showInfoDialog()
        }

        // Send intents on user input
        userNameEditText.doAfterTextChanged { viewModel.processIntent(LoginIntent.EnterUserName(it.toString())) }

        passwordEdit.doAfterTextChanged { viewModel.processIntent(LoginIntent.EnterPassword(it.toString())) }

        loginButtonSubmit.setOnClickListener {
            viewModel.processIntent(LoginIntent.SubmitLogin)
        }

        // 👀 Observe state
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.state.collect { state ->
                    renderState(state)
                }
            }
        }
    }

    private fun renderState(state: LoginState) {
        progressBar.visibility = if (state.isLoading) View.VISIBLE else View.GONE
        statusText.text = when {
            state.successMessage != null -> state.successMessage
            state.errorMessage != null -> "Error: ${state.errorMessage}"
            else -> ""
        }
    }

    private fun showInfoDialog() {
        AlertDialog.Builder(requireContext())
            .setTitle("APP FLOW")
            .setMessage(resources.getText(R.string.architecture_mvi_info))
            .setPositiveButton("OK") { dialog, _ ->
                dialog.dismiss()
            }.show()
    }
}