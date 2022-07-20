package com.example.messageabregana;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSendListenerMethod();
        btnCallListenerMethod();
        btnMapListenerMethod();
        btnWebListenerMethod();
    }

    private void btnWebListenerMethod() {
        ImageButton btnWeb = findViewById(R.id.btnWeb);
        Uri webpage = Uri.parse("https://github.com/arcticmochi");
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        btnWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent);
            }
        });
    }

    private void btnMapListenerMethod() {
        ImageButton btnMap = findViewById(R.id.btnMap);
        Uri map = Uri.parse("geo:0,0?q=Cebu+Institute+of+Technology+Cebu+Philippines");
        Intent intent = new Intent(Intent.ACTION_VIEW, map);
        btnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent);
            }
        });
    }

    private void btnCallListenerMethod() {
        ImageButton btnCall = findViewById(R.id.btnCall);
        Uri number = Uri.parse("tel:1239797");
        Intent intent = new Intent(Intent.ACTION_DIAL, number);
        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent);
            }
        });
    }

    private void btnSendListenerMethod() {
        Intent intent = new Intent(this, MessageActivity.class);
        Button btnSend = findViewById(R.id.btnSend);
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText etMessage = findViewById(R.id.etMessage);
                String message = etMessage.getText().toString();
                intent.putExtra(MessageActivity.EXTRA_MESSAGE, message);
                startActivity(intent);
            }
        });
    }
}