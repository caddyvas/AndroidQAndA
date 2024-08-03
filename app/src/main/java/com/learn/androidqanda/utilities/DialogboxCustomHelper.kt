package com.learn.androidqanda.utilities

import android.app.AlertDialog
import android.content.Context
import android.graphics.drawable.Drawable
import android.text.method.ScrollingMovementMethod
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.learn.androidqanda.R

class DialogBoxCustomHelper {

    fun showCustomAndroidQAndADialog(
        context: Context,
        androidQuestions: Array<String>,
        androidAnswers: Array<String>,
        isQuestionsPartOne: Boolean,
        position: Int
    ) {
        val builder = AlertDialog.Builder(context)
        val customView = LayoutInflater.from(context).inflate(R.layout.dialog_custom_q_and_a, null)
        builder.setView(customView)
        val customDialog = builder.create()

        // textview and its functions
        val titleTxt = customView.findViewById<TextView>(R.id.androidDialogTextTitle)
        titleTxt.text = androidQuestions[position]
        val descriptionTxt = customView.findViewById<TextView>(R.id.androidDialogTextMessage)
        val imageView = customView.findViewById<ImageView>(R.id.androidDialogImageView)
        // handle part two set
        if (!isQuestionsPartOne && (position == 0 || position == 1)) {
            imageView.visibility = View.VISIBLE
            descriptionTxt.visibility = View.GONE
            if (position == 0) {
                imageView.setImageResource(R.drawable.activity_lifecycle)
            } else {
                imageView.setImageResource(R.drawable.fragment_lifecycle)
            }
        } else if (!isQuestionsPartOne && (position == 3)) {
            imageView.visibility = View.VISIBLE
            descriptionTxt.visibility = View.GONE
            imageView.setImageResource(R.drawable.service_lifecycle)
        } else {
            imageView.visibility = View.GONE
            descriptionTxt.visibility = View.VISIBLE
            descriptionTxt.text = androidAnswers[position]
        }

        // buttons and its functions
        val btnNext = customView.findViewById<Button>(R.id.androidDialogButtonNext)
        val btnPrevious = customView.findViewById<Button>(R.id.androidDialogButtonPrevious)
        btnNext.setOnClickListener {
            // add a special case to continue the loop
            if (position == (androidQuestions.size - 1)) {
                showCustomAndroidQAndADialog(
                    context,
                    androidQuestions,
                    androidAnswers,
                    isQuestionsPartOne,
                    0
                )
            } else {
                showCustomAndroidQAndADialog(
                    context,
                    androidQuestions,
                    androidAnswers,
                    isQuestionsPartOne,
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
                    isQuestionsPartOne,
                    (androidQuestions.size - 1)
                )
            } else {
                showCustomAndroidQAndADialog(
                    context,
                    androidQuestions,
                    androidAnswers,
                    isQuestionsPartOne,
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

    fun showCustomAndroidQAndADialogForLayouts(
        context: Context,
        androidQuestions: Array<String>,
        androidAnswers: Array<String>,
        position: Int
    ) {

        val builder = AlertDialog.Builder(context)
        val customView =
            LayoutInflater.from(context).inflate(R.layout.dialog_custom_q_and_a_layouts, null)
        builder.setView(customView)
        val customDialog = builder.create()

        val drawableList: IntArray = intArrayOf(
            R.drawable.img_linearlayout,
            R.drawable.img_relativelayout, 0, R.drawable.img_tablelayout, 0, 0,
            R.drawable.img_listview, R.drawable.img_gridlayout
        )

        // textview and its functions
        val titleTxt = customView.findViewById<TextView>(R.id.layoutDialogTextTitle)
        titleTxt.text = androidQuestions[position]
        val descriptionTxt = customView.findViewById<TextView>(R.id.layoutDialogTextMessage)
        descriptionTxt.text = androidAnswers[position]
        descriptionTxt.movementMethod = ScrollingMovementMethod()
        val imageView = customView.findViewById<ImageView>(R.id.layoutDialogImageView)
        if (drawableList[position] == 0) {
            imageView.visibility = View.GONE
        } else {
            imageView.visibility = View.VISIBLE
            imageView.setImageResource(drawableList[position])
        }

        // buttons and its functions
        val btnNext = customView.findViewById<Button>(R.id.layoutDialogButtonNext)
        val btnPrevious = customView.findViewById<Button>(R.id.layoutDialogButtonPrevious)
        btnNext.setOnClickListener {
            // add a special case to continue the loop
            if (position == (androidQuestions.size - 1)) {
                showCustomAndroidQAndADialogForLayouts(
                    context,
                    androidQuestions,
                    androidAnswers,
                    0
                )
            } else {
                showCustomAndroidQAndADialogForLayouts(
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
                showCustomAndroidQAndADialogForLayouts(
                    context,
                    androidQuestions,
                    androidAnswers,
                    (androidQuestions.size - 1)
                )
            } else {
                showCustomAndroidQAndADialogForLayouts(
                    context,
                    androidQuestions,
                    androidAnswers,
                    (position - 1)
                )
            }
            customDialog.dismiss()
        }

        // image view and its functions
        val closeIcon = customView.findViewById<ImageView>(R.id.layoutDialogImageClose)
        closeIcon.setOnClickListener {
            customDialog.dismiss()
        }
        customDialog.show()
    }
}