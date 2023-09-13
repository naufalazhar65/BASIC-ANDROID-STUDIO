package com.example.webview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    WebView web;
    Button go, beranda; // Tombol untuk pergi ke URL dan kembali ke beranda
    EditText alamat; // Input teks untuk alamat URL

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inisialisasi elemen-elemen UI
        web = findViewById(R.id.webview);
        go = findViewById(R.id.go);
        alamat = findViewById(R.id.alamat);
        beranda = findViewById(R.id.beranda);

        // Mengaktifkan JavaScript pada WebView
        web.getSettings().setJavaScriptEnabled(true);

        // Memuat URL awal (Google.com) pada WebView
        String url = "https://www.google.com";
        web.loadUrl(url);

        // Mengatur listener untuk tombol "Pergi"
        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newUrl = alamat.getText().toString();
                web.loadUrl(newUrl);
            }
        });

        // Mengatur listener untuk tombol "Beranda"
        beranda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String homeUrl = "https://www.google.com";
                web.loadUrl(homeUrl);
            }
        });

        // Mengatur WebViewClient untuk menangani URL yang dimuat
        web.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                // Mengubah teks alamat menjadi URL saat ini
                alamat.setText(request.getUrl().toString());
                return false;
            }

            @Override
            public void onPageFinished(WebView webView, String url) {
                // Mengatur judul aplikasi sesuai dengan judul halaman web
                getSupportActionBar().setTitle(webView.getTitle());
                super.onPageFinished(webView, url);
            }
        });
    }
}
