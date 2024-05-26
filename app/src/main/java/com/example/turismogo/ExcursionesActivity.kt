package com.example.turismogo

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import com.example.turismogo.databinding.ActivityExcursionesBinding
import com.google.android.material.datepicker.MaterialDatePicker

class ExcursionesActivity : AppCompatActivity() {
    private lateinit var binding: ActivityExcursionesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExcursionesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.selectDateButton.setOnClickListener {
            val builder = MaterialDatePicker.Builder.datePicker()
            val picker = builder.build()
            picker.show(supportFragmentManager, picker.toString())

            picker.addOnPositiveButtonClickListener { selection ->
                Toast.makeText(this, "Selected Date: $selection", Toast.LENGTH_SHORT).show()
            }
        }

        val spinner: Spinner = binding.excursionSpinner

        ArrayAdapter.createFromResource(
            this,
            R.array.excursion_list,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                val selectedItem = parent.getItemAtPosition(position).toString()
                Toast.makeText(this@ExcursionesActivity, "Selected: $selectedItem", Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>) {}
        }
    }
}
