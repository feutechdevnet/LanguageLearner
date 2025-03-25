package com.example.admin

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class Create : AppCompatActivity() {

    private lateinit var binding: Create
    private lateinit var databaseReference: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_create)

        val save: Button = findViewById(R.id.save)

        save.setOnClickListener {
            val school = binding.school.text.toString()
            val languages = binding.languages.text.toString()
            val website = binding.website.text.toString()

            databaseReference = FirebaseDatabase.getInstance().getReference("School Information")
            val schoolData = SchoolData(school, languages, website)
            databaseReference.child(school).setValue(schoolData).addOnSuccessListener {
                binding.school.text.clear()
                binding.languages.text.clear()
                binding.website.text.clear()

                Toast.makeText(this, "Saved!", Toast.LENGTH_SHORT).show()
                val intent = Intent(this@Create, MainActivity::class.java)
                startActivity(intent)
                finish()
            }.addOnFailureListener {
                Toast.makeText(this, "Failed!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}