package com.example.group12android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.content.Intent;
import java.util.ArrayList;
import android.util.Log;
import android.view.View;
import android.widget.Toast;


import com.example.group12android.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private ArrayList<User> userList = new ArrayList<User>();
    String email;
    String password;
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(this.binding.getRoot());
        User user1 = new User("abcd", "1234");
         //User user2 = new User("riddhi@gmail.com", "riddhi123");

        userList.add(user1);
//         userList.add(user2);

        pref = getPreferences(Context.MODE_PRIVATE);
        editor = pref.edit();

        binding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Login Activity", "Login btn clicked");
                email = binding.etEmail.getText().toString();
                password = binding.etPassword.getText().toString();

                validateCredentials(email, password);
            }
        });
    }
        public void validateCredentials(String email, String password){
            for(User user : userList){
                if(user.getEmail().equals(email) && user.getPassword().equals(password)){
                    Log.d("Login", "credentials are correct"+this.binding.switchRememberMe.isChecked());
                    Toast.makeText(getApplicationContext(), "Successfully logged in!", Toast.LENGTH_SHORT).show();
                    if(this.binding.switchRememberMe.isChecked()){
                        editor.putString("email", this.email);
                        editor.putString("password", this.password);
                        editor.putBoolean("remember me", true);
                        editor.apply();
                    } else{
                        editor.putString("email", this.email);
                        editor.putString("password", this.password);
                        editor.putBoolean("remember me", false);
                        editor.apply();
                    }
                    Intent intent = new Intent(MainActivity.this, LectureList.class);
                    startActivity(intent);
                } else if(email.isEmpty() || password.isEmpty()){
                    Log.d("Login", "Please enter valid credentials");
                    Toast.makeText(getApplicationContext(), "Please enter valid credentials", Toast.LENGTH_SHORT).show();
                } else{
                    Log.d("Login", "Invalid credentials. Please try again!");
                    Toast.makeText(getApplicationContext(), "Invalid credentials. Please try again!", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }


