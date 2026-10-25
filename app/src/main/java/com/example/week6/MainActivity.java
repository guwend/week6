package com.example.week6;

import android.os.Bundle;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    CheckBox checkBox;
    Button btnCheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkBox = findViewById(R.id.checkBox);
        btnCheck = findViewById(R.id.btnCheck);

        btnCheck.setOnClickListener(v -> {

            if (checkBox.isChecked()) {

                // Warna hijau untuk Online
                showToast("Online", Color.parseColor("#008000"));

            } else {

                // Warna merah untuk Offline
                showToast("Offline", Color.parseColor("#FF0000"));

            }

        });
    }

    private void showToast(String pesan, int warna) {

        // Menampilkan Toast
        Toast.makeText(
                MainActivity.this,
                pesan,
                Toast.LENGTH_SHORT
        ).show();

        // Membuat TextView untuk status
        TextView status = new TextView(this);

        status.setText(pesan);

        // Mengatur warna teks Online / Offline
        status.setTextColor(warna);

        status.setTextSize(22);
        status.setGravity(Gravity.CENTER);
        status.setPadding(20, 20, 20, 20);

        // Mengambil LinearLayout dari CheckBox
        android.widget.LinearLayout layout =
                checkBox.getParent()
                        instanceof android.widget.LinearLayout
                        ? (android.widget.LinearLayout)
                        checkBox.getParent()
                        : null;

        // Menampilkan status pada layar
        if (layout != null) {

            if (layout.getChildCount() > 2) {
                layout.removeViewAt(2);
            }

            layout.addView(status);
        }
    }
}
