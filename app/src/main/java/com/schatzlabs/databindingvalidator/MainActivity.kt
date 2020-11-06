package com.schatzlabs.databindingvalidator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.schatzdesigns.databindingvalidator.R
import com.schatzdesigns.databindingvalidator.databinding.ActivityMainBinding
import com.schatzlabs.validator.Validator

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var validator: Validator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        validator = Validator(binding)
        validator.setFormValidationMode()

        binding.submit.setOnClickListener {
            if (validator.validate()) {
                Toast.makeText(this, "Submit validated form!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}