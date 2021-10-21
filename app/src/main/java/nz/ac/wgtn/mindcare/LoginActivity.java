package nz.ac.wgtn.mindcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * The login activity class provides method for:
 * 1. validate email and password
 * 2. log in user with retrieving email and password from shared preferences
 * 3. Allow user to log in with entering valid email and password
 */
public class LoginActivity extends AppCompatActivity {

    final int MIN_PASSWORD_LENGTH = 6;

    private SharedPreferences loginPeference;
    private EditText loginEmail;
    private EditText loginPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();

        loginEmail = findViewById(R.id.editTextEmailSignup);
        loginPassword = findViewById(R.id.editTextPasswordSingup);
        retrieveData();
    }

    public void retrieveData() {
        loginPeference = getSharedPreferences(getString(R.string.SIGNUPPREFERENCES), MODE_PRIVATE);
        String retrievedEmail = loginPeference.getString("newEmail", null);
        String retrievedPassword = loginPeference.getString("newPassword", null);
        loginEmail.setText(retrievedEmail);
        loginPassword.setText(retrievedPassword);
    }

    public void loginBtnClick(View view) {
        if(checkDataEntered()){
            Intent intent = new Intent(this, IntroActivity.class);
            startActivity(intent);
        }
    }

    /**
     * Validate entered data
     */
    public boolean checkDataEntered() {
        if (isEmpty(loginPassword)) {
            loginPassword.setError("Please enter a password!");
            return false;
        }else if (loginPassword.getText().length() < MIN_PASSWORD_LENGTH) {
            loginPassword.setError("Password Length must be more than " + MIN_PASSWORD_LENGTH + " characters");
            return false;
        }

        if (isValidEmail(loginEmail) == false) {
            loginEmail.setError("Please enter valid email!");
            return false;
        }
        return true;
    }


    boolean isValidEmail(EditText text) {
        CharSequence email = text.getText().toString();
        return (!TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }

    boolean isEmpty(EditText text) {
        CharSequence str = text.getText().toString();
        return TextUtils.isEmpty(str);
    }
}