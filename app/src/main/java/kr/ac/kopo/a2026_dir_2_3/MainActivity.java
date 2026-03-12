package kr.ac.kopo.a2026_dir_2_3;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button btnHome, btnCall, btnGallery, btnEnd;

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

        btnHome = findViewById(R.id.btn_homepage);
        btnCall = findViewById(R.id.btn_call);
        btnGallery = findViewById(R.id.btn_gallery);
        btnEnd = findViewById(R.id.btn_end);

        btnHome.setOnClickListener(btnListener);
        btnCall.setOnClickListener(btnListener);
        btnGallery.setOnClickListener(btnListener);
        btnEnd.setOnClickListener(btnListener);
    }

    View.OnClickListener btnListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Button btn = (Button) v;
            Intent intent;

            if(btn == btnHome) {
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.naver.com/"));
                startActivity(intent);
            } else if(btn == btnCall) {
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:/010-3333-4444"));
                startActivity(intent);
            } else if(btn == btnGallery) {
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("content://media/internal/images/media"));
                startActivity(intent);
            } else if(btn == btnEnd) {
                finish();
            }
        }
    };
}