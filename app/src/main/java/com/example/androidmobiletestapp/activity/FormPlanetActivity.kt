package com.example.androidmobiletestapp.activity

import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.androidmobiletestapp.R
import com.example.androidmobiletestapp.databinding.ActivityFormPlanetBinding
import com.example.androidmobiletestapp.fragment.DatePickerFragment
import com.google.android.material.textfield.TextInputLayout

class FormPlanetActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFormPlanetBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormPlanetBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.topAppBar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        if (intent.hasExtra("topAppBar")) {
            getViewHolderData()
        }

        textInputFocusListener(binding.etCopyright, binding.tiCopyright)
        textInputFocusListener(binding.etDate, binding.tiDate)
        textInputFocusListener(binding.etTitle, binding.tiTitle)
        textInputFocusListener(binding.etImageUrl, binding.tiImageUrl)
        binding.btnCreatePlanet.setOnClickListener {
            validateForm()
        }
        binding.etDate.setOnClickListener {
            onEditTextDateClicked()
        }
    }

    private fun getViewHolderData() {
        val planetCopyright = intent.getStringExtra("planetCopyright")
        val planetDate = intent.getStringExtra("planetDate")
        val planetTitle = intent.getStringExtra("planetTitle")
        val planetImageUrl = intent.getStringExtra("planetImageUrl")
        val topAppBar = intent.getStringExtra("topAppBar")

        supportActionBar!!.title = topAppBar
        binding.etCopyright.setText(planetCopyright)
        binding.etDate.setText(planetDate)
        binding.etTitle.setText(planetTitle)
        binding.etImageUrl.setText(planetImageUrl)
    }

    private fun textInputFocusListener(editText: EditText, textInputLayout: TextInputLayout) {
        editText.setOnFocusChangeListener { _, focused ->
            if (!focused) {
                textInputLayout.helperText = validTextInput(textInputLayout)
            }
        }
    }

    private fun onEditTextDateClicked() {
        val newFragment = DatePickerFragment.newInstance { _, year, month, day ->
            val selectedDate = year.toString() + "-" + (month + 1) + "-" + day
            binding.etDate.setText(selectedDate)
        }

        newFragment.show(supportFragmentManager, "datePicker")
    }

    private fun validTextInput(textInputLayout: TextInputLayout): String? {
        val copyrightText = textInputLayout.editText?.text.toString()
        if (copyrightText.isEmpty()) {
            return getString(R.string.empty_field_error)
        }
        return null
    }

    private fun validateForm() {
        val validCopyright = binding.tiCopyright.editText?.text.toString() != ""
        val validDate = binding.tiDate.editText?.text.toString() != ""
        val validTitle = binding.tiTitle.editText?.text.toString() != ""
        val validImageUrl = binding.tiImageUrl.editText?.text.toString() != ""

        if (validCopyright && validDate && validImageUrl && validTitle) {
            if (supportActionBar!!.title == getString(R.string.create_planet_app_bar)) {
                Toast.makeText(this, getString(R.string.created_text), Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, getString(R.string.updated_text), Toast.LENGTH_SHORT).show()
            }
            finish()
        } else {
            Toast.makeText(this, getString(R.string.invalid_form_text), Toast.LENGTH_SHORT).show()
        }
    }
}