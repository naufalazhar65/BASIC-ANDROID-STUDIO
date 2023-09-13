package com.example.bottomnavigationdanfragment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import android.os.Bundle;
import android.view.MenuItem;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigation = findViewById(R.id.bottomnavigation); // Menginisialisasi bottomNavigation

        // Set fragment awal saat aktivitas dibuat
        bukaFragment(new Fragment1());

        bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                // Menangani item yang dipilih pada bottom navigation
                switch (item.getItemId()) {
                    case R.id.beranda:
                        bukaFragment(new Fragment1()); // Menampilkan Fragment1 ketika item Beranda dipilih
                        return true;
                    case R.id.profil:
                        bukaFragment(new Fragment2()); // Menampilkan Fragment2 ketika item Profil dipilih
                        return true;
                    case R.id.pengaturan:
                        bukaFragment(new Fragment3()); // Menampilkan Fragment3 ketika item Pengaturan dipilih
                        return true;
                    default:
                        return false;
                }
            }
        });
    }

    // Metode untuk mengganti fragment yang ditampilkan di konten utama
    Boolean bukaFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.konten, fragment) // Mengganti konten utama dengan fragment yang baru
                    .commit();
            return true;
        }
        return false;
    }
}
