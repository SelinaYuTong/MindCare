package nz.ac.wgtn.mindcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * The signup activity class provides method for:
 * 1. validate entered user data
 * 2. register user with using shared preferences to store user data
 */
public class SignUpActivity extends AppCompatActivity {

    final int MIN_PASSWORD_LENGTH = 6;
    final int MIN_USERNAME_LENGTH = 3;

    private EditText userName;
    private EditText email;
    private EditText password;
    private Button btnSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_sign_up);

        userName = findViewById(R.id.editTextTextPersonName);
        email = findViewById(R.id.editTextTextEmailAddress);
        password = findViewById(R.id.editTextTextPassword);
        btnSignup = findViewById(R.id.btnregister);
    }

    public void signUpBtnClick(View view) {
        //Sign up logic should go here
        if(checkDataEntered()) {
            SharedPreferences preferences = getSharedPreferences(getString(R.string.SIGNUPPREFERENCES), MODE_PRIVATE);
            String newName = userName.getText().toString();
            String newEmail = email.getText().toString();
            String newPassword = password.getText().toString();
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString("newName", newName);
            editor.putString("newEmail", newEmail);
            editor.putString("newPassword", newPassword);
            editor.commit();
            Toast.makeText(this, "Your registration is successful!", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        }
    }

    boolean isValidEmail(EditText text) {
        CharSequence email = text.getText().toString();
        return (!TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }

    boolean isEmpty(EditText text) {
        CharSequence str = text.getText().toString();
        return TextUtils.isEmpty(str);
    }

    /**
     * Validate entered data
     */
    public boolean checkDataEntered() {
        if (isEmpty(userName)) {
            userName.setError("Please enter your user name!");
            Toast t = Toast.makeText(this, "You must enter user name to register!", Toast.LENGTH_SHORT);
            t.show();
            return false;
        }else if (userName.getText().length() < MIN_USERNAME_LENGTH) {
            userName.setError("Password Length must be more than " + MIN_USERNAME_LENGTH + " characters");
            return false;
        }

        if (isEmpty(password)) {
            password.setError("Please enter a password!");
            return false;
        }else if (password.getText().length() < MIN_PASSWORD_LENGTH) {
            password.setError("Password Length must be more than " + MIN_PASSWORD_LENGTH + " characters");
            return false;
        }

        if (isValidEmail(email) == false) {
            email.setError("Please enter valid email!");
            return false;
        }
        return true;
    }
}
