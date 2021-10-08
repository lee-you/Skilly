package com.tapque.game.skilly;

import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.tapque.game.skilly.ui.adapter.FragmentVpAdapter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentContainerView;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.viewpager2.widget.ViewPager2;

public class SkillyActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skilly);
        drawerLayout = findViewById(R.id.drawer_layout);
        BottomNavigationView navView = findViewById(R.id.nav_view);

        ViewPager2 viewPager2 = findViewById(R.id.vp);
        viewPager2.setOffscreenPageLimit(3);
        viewPager2.setAdapter(new FragmentVpAdapter(this));
        navView.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.navigation_home) {
                viewPager2.setCurrentItem(0);
                return true;
            } else if (item.getItemId() == R.id.navigation_dashboard) {
                viewPager2.setCurrentItem(1);
                return true;
            } else if (item.getItemId() == R.id.navigation_notifications) {
                viewPager2.setCurrentItem(2);
                return true;
            }
            return false;
        });

        findViewById(R.id.btn_menu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (drawerLayout.isOpen()) {
                    drawerLayout.close();
                } else {
                    drawerLayout.openDrawer(GravityCompat.END);
                }
            }
        });
    }
}