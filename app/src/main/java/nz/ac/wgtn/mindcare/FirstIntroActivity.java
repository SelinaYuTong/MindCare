package nz.ac.wgtn.mindcare;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class FirstIntroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro_first);
        getSupportActionBar().hide();
    }

    public void skipFirstOnClick(View view){
        Intent intent = new Intent(this, DashboardMainActivity.class);
        startActivity(intent);
    }

    public void forwardFirstClick(View view){
        Intent intent = new Intent(this, SecondIntroActivity.class);
        startActivity(intent);
    }

    public void  backFirstClick(View view){
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
}
