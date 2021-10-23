package nz.ac.wgtn.mindcare;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class SecondIntroActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro_second);
        getSupportActionBar().hide();
    }

    public void skipSecondOnClick(View view){
        Intent intent = new Intent(this, DashboardMainActivity.class);
        startActivity(intent);
    }

    public void forwardSecondClick(View view){
        Intent intent = new Intent(this, ThirdIntroActivity.class);
        startActivity(intent);
    }

    public void  backSecondClick(View view){
        Intent intent = new Intent(this, FirstIntroActivity.class);
        startActivity(intent);
    }
}
