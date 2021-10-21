package nz.ac.wgtn.mindcare;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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
        String uName = userName.getText().toString();
        //Sign up logic should go here
        checkDataEntered();
    }

    boolean isValidEmail(EditText text) {
        CharSequence email = text.getText().toString();
        return (!TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }

    boolean isEmpty(EditText text) {
        CharSequence str = text.getText().toString();
        return TextUtils.isEmpty(str);
    }

    void checkDataEntered() {
        if (isEmpty(userName)) {
            Toast t = Toast.makeText(this, "You must enter user name to register!", Toast.LENGTH_SHORT);
            t.show();
        }

        if (userName.getText().length() < MIN_USERNAME_LENGTH) {
            userName.setError("Password Length must be more than " + MIN_USERNAME_LENGTH + "characters");
        }

        if (isEmpty(password)) {
            email.setError("Please enter a password!");
        }

        if (password.getText().length() < MIN_PASSWORD_LENGTH) {
            password.setError("Password Length must be more than " + MIN_PASSWORD_LENGTH + "characters");
        }

        if (isValidEmail(email) == false) {
            email.setError("Enter valid email!");
        }
    }
}
