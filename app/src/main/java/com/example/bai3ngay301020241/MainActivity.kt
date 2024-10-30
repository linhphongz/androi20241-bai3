package com.example.bai3ngay301020241

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var mssvEditText: EditText
    private lateinit var nameEditText: EditText
    private lateinit var genderRadioGroup: RadioGroup
    private lateinit var emailEditText: EditText
    private lateinit var phoneEditText: EditText
    private lateinit var dateButton: Button
    private lateinit var calendarView: CalendarView
    private lateinit var currentLocationSpinner: Spinner
    private lateinit var sportsCheckBox: CheckBox
    private lateinit var moviesCheckBox: CheckBox
    private lateinit var musicCheckBox: CheckBox
    private lateinit var termsCheckBox: CheckBox
    private lateinit var submitButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mssvEditText = findViewById(R.id.mssvEditText)
        nameEditText = findViewById(R.id.nameEditText)
        genderRadioGroup = findViewById(R.id.genderRadioGroup)
        emailEditText = findViewById(R.id.emailEditText)
        phoneEditText = findViewById(R.id.phoneEditText)
        dateButton = findViewById(R.id.dateButton)
        calendarView = findViewById(R.id.calendarView)
        currentLocationSpinner = findViewById(R.id.currentLocationSpinner)
        sportsCheckBox = findViewById(R.id.sportsCheckBox)
        moviesCheckBox = findViewById(R.id.moviesCheckBox)
        musicCheckBox = findViewById(R.id.musicCheckBox)
        termsCheckBox = findViewById(R.id.termsCheckBox)
        submitButton = findViewById(R.id.submitButton)

        // Ẩn CalendarView ban đầu
        calendarView.visibility = View.GONE

        // Thay đổi hiển thị CalendarView khi nhấn nút chọn ngày sinh
        dateButton.setOnClickListener {
            if (calendarView.visibility == View.GONE) {
                calendarView.visibility = View.VISIBLE
            } else {
                calendarView.visibility = View.GONE
            }
        }

        // Thiết lập dữ liệu cho Spinner
        val locations = arrayOf("Phường 1", "Phường 2", "Quận 1", "Quận 2", "TP.HCM", "Hà Nội")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, locations)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        currentLocationSpinner.adapter = adapter

        submitButton.setOnClickListener {
            validateForm()
        }
    }

    private fun validateForm() {
        val mssv = mssvEditText.text.toString()
        val name = nameEditText.text.toString()
        val email = emailEditText.text.toString()
        val phone = phoneEditText.text.toString()
        val genderSelected = genderRadioGroup.checkedRadioButtonId != -1
        val termsAccepted = termsCheckBox.isChecked

        if (mssv.isEmpty() || name.isEmpty() || !genderSelected || email.isEmpty() || phone.isEmpty() || !termsAccepted) {
            Toast.makeText(this, "Vui lòng điền đầy đủ thông tin.", Toast.LENGTH_SHORT).show()
        } else {
            // Thực hiện hành động submit ở đây
            Toast.makeText(this, "Thông tin đã được gửi!", Toast.LENGTH_SHORT).show()
        }
    }
}
