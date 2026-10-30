package com.example.zad12_progressbar;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        ProgressBar progressBar1 = findViewById(R.id.progress1);
        ProgressBar progressBar2 = findViewById(R.id.progress2);
        TextView endText = findViewById(R.id.endText);
        TextView currentTime = findViewById(R.id.text);

        progressBar1.setMax(10);
        progressBar2.setMax(10);
        new CountDownTimer(10000, 1000) {
            public void onTick(long durToEnd) {
                currentTime.setText("Pozostalo: " + (int) (durToEnd / 1000) + "s");
                progressBar1.setProgress((int) (durToEnd / 1000));
                progressBar2.setProgress((int) (durToEnd / 1000));
            }
            public void onFinish() {
                progressBar1.setVisibility(TextView.GONE);
                currentTime.setVisibility(View.GONE);
                endText.setText("Koniec !");
            }
        }.start();
    }
}