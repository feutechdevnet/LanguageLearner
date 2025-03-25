package com.example.languagelearner

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

        // Sample data to be displayed in the table
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

        // Loop through the data and dynamically add rows to the table
        for (rowData in data) {
            val tableRow = TableRow(this)

            // Create TextViews for each cell
            for (cellData in rowData) {
                val textView = TextView(this)
                textView.text = cellData
                textView.setPadding(16, 8, 16, 8)
                textView.setSingleLine(false)  // Allow multiple lines for long data
                textView.maxLines = 3          // Limit to 2 lines if the text is too long
                textView.ellipsize = android.text.TextUtils.TruncateAt.END
                tableRow.addView(textView)
            }

            // Add the row to the table layout
            tableLayout.addView(tableRow)
        }
    }
}






