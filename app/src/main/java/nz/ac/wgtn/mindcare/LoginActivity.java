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
 * 3. Allow user to log in with entering matched email and password
 */
public class LoginActivity extends AppCompatActivity {

    final int MIN_PASSWORD_LENGTH = 6;

    private SharedPreferences loginPeference;
    private EditText loginEmail;
    private EditText loginPassword;
    String retrievedEmail;
    String retrievedPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();

        loginEmail = findViewById(R.id.editTextEmailSignup);
        loginPassword = findViewById(R.id.editTextPasswordSingup);
        retrieveData();
        setLogin();
    }

    public void retrieveData() {
        loginPeference = getSharedPreferences(getString(R.string.SIGNUPPREFERENCES), MODE_PRIVATE);
        retrievedEmail = loginPeference.getString("newEmail", null);
        retrievedPassword = loginPeference.getString("newPassword", null);
    }
    private void setLogin(){
       if(!isEmpty(retrievedEmail)){
           loginEmail.setText(retrievedEmail);
       }
       if(!isEmpty(retrievedPassword)){
            loginPassword.setText(retrievedPassword);
        }
    }

    public void loginBtnClick(View view) {
        if(checkDataEntered()){
            if(loginEmail.getText().toString().trim().equals(retrievedEmail)
                    && loginPassword.getText().toString().trim().equals(retrievedPassword)) {
                Intent intent = new Intent(this, FirstIntroActivity.class);
                startActivity(intent);
            }else{
                Toast.makeText(this, "Email or password does not match with saved credential.", Toast.LENGTH_SHORT).show();
                if(!loginEmail.getText().toString().trim().equals(retrievedEmail) ){
                    loginEmail.setError("Incorrect email!");
                }
                if(!loginPassword.getText().toString().trim().equals(retrievedPassword)){
                    loginPassword.setError("Incorrect password!");
                }
            }
        }
    }

    /**
     * Validate entered data
     */
    public boolean checkDataEntered() {
        if (isEmpty(loginPassword.getText().toString())) {
            loginPassword.setError("Please enter a password!");
            return false;
        }else if (loginPassword.getText().length() < MIN_PASSWORD_LENGTH) {
            loginPassword.setError("Password Length must be more than " + MIN_PASSWORD_LENGTH + " characters");
            return false;
        }

        if (isValidEmail(loginEmail.getText().toString()) == false) {
            loginEmail.setError("Please enter valid email!");
            return false;
        }
        return true;
    }


    boolean isValidEmail(String emailAddress) {
        CharSequence email = emailAddress;
        return (!TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }

    boolean isEmpty(String textContent) {
        CharSequence str = textContent;
        return TextUtils.isEmpty(str);
    }
}