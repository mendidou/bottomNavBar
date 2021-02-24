package com.mendya.rbknails;

import android.os.Bundle;

import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.shape.CornerFamily;
import com.google.android.material.shape.MaterialShapeDrawable;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.fragment.NavHostFragment;

import androidx.navigation.ui.NavigationUI;

public class MainActivity extends AppCompatActivity {
    BottomAppBar bottomAppBar;
    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomAppBar = findViewById(R.id.nav_view);
        bottomNavigationView.setBackground(null);
        bottomNavigationView.getMenu().getItem(3).setEnabled(false);

        setupNavigation();
        roundedBottomAppBar(bottomAppBar);


    }
//initialise BottomAppBar with rounded border
    private void roundedBottomAppBar(BottomAppBar bottomAppBar) {
        MaterialShapeDrawable bottomBarBackground = (MaterialShapeDrawable) bottomAppBar.getBackground();
        bottomBarBackground.setShapeAppearanceModel(
                bottomBarBackground.getShapeAppearanceModel()
                        .toBuilder()
                        .setTopRightCorner(CornerFamily.ROUNDED,60)
                        .setTopLeftCorner(CornerFamily.ROUNDED,60)
                        .build());
        setupBottomNavBarAsSquare();
    }

    //TODO: make it as a square
    private void setupBottomNavBarAsSquare() {


    }

    //here we are connecting the bottom navigation to the Nav graph / Nav host Fragment.
    private void setupNavigation(){
        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
        NavigationUI.setupWithNavController(bottomNavigationView,navHostFragment.getNavController());

    }

}