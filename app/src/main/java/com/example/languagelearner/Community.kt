package com.example.languagelearner

import android.graphics.Color
import android.os.Bundle
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class Community : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_community)

        val tableLayout: TableLayout = findViewById(R.id.tableLayout)

        // Header Row
        val headerRow = TableRow(this)
        val headers = listOf("ID", "Institution Name", "Languages Offered")

        for (header in headers) {
            val textView = TextView(this)
            textView.text = header
            textView.setPadding(16, 8, 16, 8)
            textView.setBackgroundColor(Color.parseColor("#40E0D0")) // Turquoise
            textView.setTextColor(Color.parseColor("#FFFFFF")) // White
            textView.textSize = 16f
            textView.setTypeface(null, android.graphics.Typeface.BOLD)
            headerRow.addView(textView)
        }
        tableLayout.addView(headerRow)

        // Sample data
        val data = listOf(
            listOf("1", "University of the Philippines Department of Linguistics", "Bahasa, Mandarin, Japanese, Korean, and Thai"),
            listOf("2", "Alliance Française de Manille", "French language"),
            listOf("3", "TESDA Language Skills Institute", "Japanese, Arabic, Chinese, and Spanish"),
            listOf("4", "Instituto Cervantes", "Spanish language"),
            listOf("5", "Chiang Kai Shek College Language Center", "Mandarin and Hokkien"),
            listOf("6", "UST Language Center", "Mandarin Chinese, Spanish, Japanese, Korean"),
            listOf("7", "Ateneo Language Center", "Spanish, Mandarin, French, Japanese, Korean"),
            listOf("8", "DLSU Language Center", "German, Spanish, Mandarin, Japanese, Korean"),
            listOf("9", "FEU Language Center", "Spanish, Mandarin, Japanese, Korean, French"),
            listOf("10", "Mapúa University", "Spanish, Mandarin, French, Japanese, Korean")
        )

        // Add rows dynamically
        for ((index, rowData) in data.withIndex()) {
            val tableRow = TableRow(this)
            val backgroundColor = if (index % 2 == 0) "#F5F5F5" else "#FFFFFF" // Alternating row colors

            for (cellData in rowData) {
                val textView = TextView(this)
                textView.text = cellData
                textView.setPadding(16, 8, 16, 8)
                textView.setBackgroundColor(Color.parseColor(backgroundColor))
                textView.setSingleLine(false)
                textView.maxLines = 3
                textView.ellipsize = android.text.TextUtils.TruncateAt.END
                tableRow.addView(textView)
            }

            tableLayout.addView(tableRow)
        }
    }
}
