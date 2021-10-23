package nz.ac.wgtn.mindcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class IntroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro_1st);
        getSupportActionBar().hide();
    }

    public void skipOnClick(View view){
        Intent intent = new Intent(this, DashboardMainActivity.class);
        startActivity(intent);
    }
}