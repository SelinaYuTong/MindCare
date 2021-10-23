package nz.ac.wgtn.mindcare;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class DashboardActivity extends AppCompatActivity {
    //Initialise a bottom navigation view object
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        getSupportActionBar().hide();

        bottomNavigationView=findViewById(R.id.bottom_navigation);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new DashboardStatisticsFragment()).commit();
    }

    public void breathOnClick(View view){
        Intent intent = new Intent(this, BreathingActivity.class);
        startActivity(intent);
    }

    // Initialise and assign variable
    //BottomNavigationView bottomNavigationView=findViewById(R.id.bottom_navigation);

    // Set Activities selected
}