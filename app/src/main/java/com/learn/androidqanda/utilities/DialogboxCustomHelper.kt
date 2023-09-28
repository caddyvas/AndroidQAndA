package com.learn.androidqanda.utilities

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.learn.androidqanda.R

class DialogBoxCustomHelper {

    fun showCustomAndroidQAndADialog(
        context: Context,
        androidQuestions: Array<String>,
        androidAnswers: Array<String>,
        position: Int
    ) {
        val builder = AlertDialog.Builder(context)
        val customView = LayoutInflater.from(context).inflate(R.layout.dialog_custom_q_and_a, null)
        builder.setView(customView)
        val customDialog = builder.create()

        // textview and its functions
        val titleTxt = customView.findViewById<TextView>(R.id.androidDialogTextTitle)
        val descriptionTxt = customView.findViewById<TextView>(R.id.androidDialogTextMessage)
        titleTxt.text = androidQuestions[position]
        descriptionTxt.text = androidAnswers[position]

        // buttons and its functions
        val btnNext = customView.findViewById<Button>(R.id.androidDialogButtonNext)
        val btnPrevious = customView.findViewById<Button>(R.id.androidDialogButtonPrevious)
        btnNext.setOnClickListener {
            // add a special case to continue the loop
            if (position == (androidQuestions.size - 1)) {
                showCustomAndroidQAndADialog(context, androidQuestions, androidAnswers, 0)
            } else {
                showCustomAndroidQAndADialog(
                    context,
                    androidQuestions,
                    androidAnswers,
                    (position + 1)
                )
            }
            customDialog.dismiss()
        }

        btnPrevious.setOnClickListener {
            // add a special case to continue the loop
            if (position == 0) {
                showCustomAndroidQAndADialog(
                    context,
                    androidQuestions,
                    androidAnswers,
                    (androidQuestions.size - 1)
                )
            } else {
                showCustomAndroidQAndADialog(
                    context,
                    androidQuestions,
                    androidAnswers,
                    (position - 1)
                )
            }
            customDialog.dismiss()
        }

        // image view and its functions
        val closeIcon = customView.findViewById<ImageView>(R.id.androidDialogImageClose)
        closeIcon.setOnClickListener {
            customDialog.dismiss()
        }

        customDialog.show()
    }
}