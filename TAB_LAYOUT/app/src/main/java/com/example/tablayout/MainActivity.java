package com.example.tablayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;
import android.content.Context;
import android.os.Bundle;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;
    Halaman adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inisialisasi elemen UI
        tabLayout = findViewById(R.id.Tab);
        viewPager = findViewById(R.id.viewpager);

        // Inisialisasi adapter untuk ViewPager
        adapter = new Halaman(getApplicationContext(), getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);

        // Menambahkan listener perubahan halaman untuk TabLayout
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        // Menambahkan listener untuk menangani perubahan tab yang dipilih
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                // Tidak ada tindakan yang perlu diambil saat tab tidak dipilih.
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                // Tidak ada tindakan yang perlu diambil saat tab yang sama dipilih kembali.
            }
        });
    }
}

class Halaman extends FragmentStatePagerAdapter {
    Context context;
    int jumlah_tab;

    Halaman(Context context, FragmentManager fm, int jml_tab) {
        super(fm);

        this.context = context;
        this.jumlah_tab = jml_tab;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        // Mengembalikan fragment sesuai dengan posisi tab yang dipilih
        switch (position) {
            case 0:
                return new fragment1();
            case 1:
                return new fragment2();
            case 2:
                return new fragment3();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        // Mengembalikan jumlah tab yang ada
        return jumlah_tab;
    }
}
