package com.example.zad11__ratingbar;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    RatingBar ratingBar;
    TextView textView;
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
        ratingBar = findViewById(R.id.ratingBar);
        textView = findViewById(R.id.text);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                float num = (float) ratingBar.getRating();
                int color;
                String txt;
                if (num <= 3) {
                    color = Color.RED;
                    txt = " Ocena: Slabo";
                } else if (num < 5) {
                    color = Color.YELLOW;
                    txt = "Ocena: Dobrze";
                } else {
                    color = Color.GREEN;
                    txt = "Ocena: Doskonale";
                }
                ratingBar.setProgressTintList(ColorStateList.valueOf(color));
                textView.setTextColor(color);
                textView.setText(txt);
                Toast.makeText(MainActivity.this, "Ocena: " + num,
                        Toast.LENGTH_SHORT).show();
                Log.d("RATING BAR", "v: " + rating + "  b: " + fromUser);
            }
        });
    }
}