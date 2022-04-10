package com.example.androidmobiletestapp.activity

import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.androidmobiletestapp.databinding.ActivityCreateNewPlanetBinding
import com.google.android.material.textfield.TextInputLayout

class FormPlanetActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCreateNewPlanetBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateNewPlanetBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.topAppBar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        textInputFocusListener(binding.etCopyright, binding.tiCopyright)
        textInputFocusListener(binding.etDate, binding.tiDate)
        textInputFocusListener(binding.etTitle, binding.tiTitle)
        textInputFocusListener(binding.etImageUrl, binding.tiImageUrl)
        binding.btnCreatePlanet.setOnClickListener {
            validateForm()
        }
    }

    private fun textInputFocusListener(editText: EditText, textInputLayout: TextInputLayout) {
        editText.setOnFocusChangeListener { _, focused ->
            if (!focused) {
                textInputLayout.helperText = validTextInput(textInputLayout)
            }
        }
    }

    private fun validTextInput(textInputLayout: TextInputLayout): String? {
        val copyrightText = textInputLayout.editText?.text.toString()
        if (copyrightText.isEmpty()) {
            return "El campo no puede ser vacio"
        }
        return null
    }

    private fun validateForm() {
        val validCopyright = binding.tiCopyright.editText?.text.toString() != ""
        val validDate = binding.tiDate.editText?.text.toString() != ""
        val validTitle = binding.tiTitle.editText?.text.toString() != ""
        val validImageUrl = binding.tiImageUrl.editText?.text.toString() != ""

        if (validCopyright && validDate && validImageUrl && validTitle) {
            Toast.makeText(this, "Planeta creado", Toast.LENGTH_SHORT).show()
            finish()
        } else {
            Toast.makeText(this, "Faltan campos por rellenar", Toast.LENGTH_SHORT).show()
        }
    }
}