package com.example.admin

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.admin.databinding.ActivityCreateBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class Create : AppCompatActivity() {

    private lateinit var binding: ActivityCreateBinding
    private lateinit var databaseReference: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        
        // Initialize View Binding
        binding = ActivityCreateBinding.inflate(layoutInflater)
        setContentView(binding.root)

        databaseReference = FirebaseDatabase.getInstance().getReference("School Information")

        binding.save.setOnClickListener {
            val school = binding.school.text.toString()
            val languages = binding.languages.text.toString()
            val website = binding.website.text.toString()

            if (school.isNotEmpty() && languages.isNotEmpty() && website.isNotEmpty()) {
                val schoolData = SchoolData(school, languages, website)

                databaseReference.child(school).setValue(schoolData).addOnSuccessListener {
                    binding.school.text.clear()
                    binding.languages.text.clear()
                    binding.website.text.clear()

                    Toast.makeText(this, "Saved!", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this@Create, MainActivity::class.java))
                    finish()
                }.addOnFailureListener {
                    Toast.makeText(this, "Failed to save!", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Please fill all fields!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}

// Make sure you have this data class
data class SchoolData(val school: String, val languages: String, val website: String)
