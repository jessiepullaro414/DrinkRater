package com.example.jessiepullaro.drinkrater;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class LoginActivity extends AppCompatActivity {
    UserDBHelper userDBHelper;
    DrinkDBHelper drinkDBHelper;
    RatingDBHelper ratingDBHelper;

    private EditText email, password;
    private Button signInButton, registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = (EditText) findViewById(R.id.editText);
        password = (EditText) findViewById(R.id.editText2);

        userDBHelper = new UserDBHelper(this);
        drinkDBHelper = new DrinkDBHelper(this);
        ratingDBHelper = new RatingDBHelper(this);

    }

    public byte[] hashPassword( final char[] password) {
        int iterations = 20*1000;
        int keyLength = 512;

        try {
            byte[] salt =  SecureRandom.getInstance("SHA1PRNG").generateSeed(32);
            SecretKeyFactory skf = SecretKeyFactory.getInstance( "PBKDF2WithHmacSHA512" );
            PBEKeySpec spec = new PBEKeySpec( password, salt, iterations, keyLength );
            SecretKey key = skf.generateSecret( spec );
            byte[] res = key.getEncoded( );
            return res;

        } catch( NoSuchAlgorithmException | InvalidKeySpecException e ) {
            throw new RuntimeException( e );
        }
    }

    public void signIn(View view){
        try {
            User user = userDBHelper.getUser(email.getText().toString());
            if (user.getPassHash() == new String(hashPassword(password.getText().toString().toCharArray())))
                //TODO go to other activity
                ;
        }catch (Error e){
            Context context = getApplicationContext();
            CharSequence text = "Authentication FAILED!";
            int duration = Toast.LENGTH_LONG;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
    }

    public void register(View view){
        try {
            if (password.getText().toString() != null &&
                    password.getText().toString().length() >= 8 &&
                    password.getText().toString().matches("^.*[^a-zA-Z0-9 ].*$")) {
                String passHash = new String(hashPassword(password.getText().toString().toCharArray()));
                User user = new User(email.getText().toString(), passHash);

                userDBHelper.addUser(user);
            }
            else {
                Context context = getApplicationContext();
                CharSequence text = "Password cannot be null.\n" +
                        "Password must be at least 8 characters.\n" +
                        "Password must contain at least 1 symbol and 1 number.\n" +
                        "Password must contain at lower and uppercase letters.";
                int duration = Toast.LENGTH_LONG;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
        } catch (Error e){

        }
    }
}
