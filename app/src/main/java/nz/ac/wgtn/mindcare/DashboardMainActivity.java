package nz.ac.wgtn.mindcare;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class DashboardMainActivity extends AppCompatActivity  {
    //Initialise a bottom navigation view object
    BottomNavigationView bottomNavigationView;
    private TextView userName;

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
//                    SharedPreferences sharedPreferences = getSharedPreferences(getString(R.string.SIGNUPPREFERENCES), MODE_PRIVATE);
//                    String retrievedUserName = sharedPreferences.getString("newName", null);
//                    userName = findViewById(R.id.username_text);
//                    userName.setText(retrievedUserName);
                    fragment = new DashboardActivityFragment();
                    break;
                case R.id.nav_stats:
                    fragment = new DashboardStatisticsFragment();
                    break;
                case R.id.nav_contact:
                    fragment = new DashboardContactFragment();
                    break;
                case R.id.nav_settings:
                    fragment = new DashboardSettingFragment();
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