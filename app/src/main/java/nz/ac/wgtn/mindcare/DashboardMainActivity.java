package nz.ac.wgtn.mindcare;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class DashboardMainActivity extends AppCompatActivity  {
    //Initialise a bottom navigation view object
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_main);
        getSupportActionBar().hide();

        //loading the default fragment
        loadFragment(new DashboardActivityFragment());

        //getting bottom navigation view and attaching the listener
        bottomNavigationView=findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            Fragment fragment;

            switch (item.getItemId()) {
                case R.id.nav_activities:
                    fragment = new DashboardActivityFragment();
                    break;
                case R.id.nav_stats:
                    fragment = new DashboardStatisticsFragment();
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + item.getItemId());
            }

            return loadFragment(fragment);
        });

    }

    private boolean loadFragment(Fragment fragment) {
        //switching fragment
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.dashboard_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }

    public void breathOnClick(View view){
        Intent intent = new Intent(this, BreathingActivity.class);
        startActivity(intent);
    }
}