package nz.ac.wgtn.mindcare;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class ThirdIntroActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro_third);
        getSupportActionBar().hide();
    }

    public void skipThirdOnClick(View view){
        Intent intent = new Intent(this, DashboardMainActivity.class);
        startActivity(intent);
    }

    public void forwardThirdClick(View view){
        Intent intent = new Intent(this, DashboardMainActivity.class);
        startActivity(intent);
    }

    public void  backThirdClick(View view){
        Intent intent = new Intent(this, SecondIntroActivity.class);
        startActivity(intent);
    }
}
