package com.example.esport_service;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.esport_service.model.UserHelperClass;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUp extends AppCompatActivity {

    Button regLogIn, regBtn;
    TextInputLayout regName, regUsername, regEmail, regPhone, regPassword;

    FirebaseDatabase rootNode;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_sign_up);

        regLogIn = findViewById(R.id.reg_log_in);
        regName = findViewById(R.id.reg_name);
        regUsername = findViewById(R.id.reg_username);
        regEmail = findViewById(R.id.reg_email);
        regPhone = findViewById(R.id.reg_phone);
        regPassword = findViewById(R.id.reg_password);
        regBtn = findViewById(R.id.reg_btn);

        regBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!validatePassword()){
                    if (!validatePhone()){
                        if (!validateEmail()){
                            if (!validateUsername()){
                                if (!validateName()){
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                }

                rootNode = FirebaseDatabase.getInstance();
                reference = rootNode.getReference("users");

                String name = regName.getEditText().getText().toString();
                String username = regUsername.getEditText().getText().toString();
                String email = regEmail.getEditText().getText().toString();
                String phone = regPhone.getEditText().getText().toString();
                String password = regPassword.getEditText().getText().toString();

                UserHelperClass helperClass = new UserHelperClass(name, username, email, phone, password);

                reference.child(phone).setValue(helperClass);
                Intent intent = new Intent(SignUp.this, MainActivity.class);
                startActivity(intent);
            }
        });
        regLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignUp.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private Boolean validateName(){
        String val = regName.getEditText().getText().toString();

        if (val.isEmpty()){
            regName.setError("Поле не может быть пустым");
            return false;
        }
        else{
            regName.setError(null);
            return true;
        }
    }
    private Boolean validateUsername(){
        String val = regUsername.getEditText().getText().toString();
        String noWhiteSpace = "\\A\\w{4,20}\\z";

        if (val.isEmpty()){
            regUsername.setError("Поле не может быть пустым");
            return false;
        }
        else if (val.length()>=15){
            regUsername.setError("Имя пользователя слишком длинное");
            return false;
        }
        else if(!val.matches(noWhiteSpace)){
            regUsername.setError("Пробелы не допускаются");
            return false;
        }
        else{
            regUsername.setError(null);
            regUsername.setErrorEnabled(false);
            return true;
        }
    }
    private Boolean validateEmail(){
        String val = regEmail.getEditText().getText().toString();
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        if (val.isEmpty()){
            regEmail.setError("Поле не может быть пустым");
            return false;
        }
        else if(!val.matches(emailPattern)){
            regEmail.setError("Неверный адрес электронной почты");
            return false;
        }
        else{
            regEmail.setError(null);
            return true;
        }
    }
    private Boolean validatePhone(){
        String val = regPhone.getEditText().getText().toString();

        if (val.isEmpty()){
            regPhone.setError("Поле не может быть пустым");
            return false;
        }
        else{
            regPhone.setError(null);
            return true;
        }
    }
    private Boolean validatePassword(){
        String val = regPassword.getEditText().getText().toString();
        String passwordVal = "^" +
                "(?=.*[0-9])" +
                "(?=.*[a-z])" +
                "(?=.*[A-Z])" +
                //"(?=.*[a-zA-Z])" +
                "(?=.*[@#$%^&+=])" +
                "(?=\\S+$)" +
                ".{4,}" +
                "$";

        if (val.isEmpty()){
            regPassword.setError("Поле не может быть пустым");
            return false;
        }
        else if(!val.matches(passwordVal)){
            regPassword.setError("Пароль слишком слабый");
            return false;
        }
        else{
            regPassword.setError(null);
            return true;
        }
    }

    public void registerUser (View view){

        //if (!validateName() | !validatePassword() | !validatePhone() | !validateEmail() | !validateUsername()){
        //    return;
        //}

        String name = regName.getEditText().getText().toString();
        String username = regUsername.getEditText().getText().toString();
        String email = regEmail.getEditText().getText().toString();
        String phone = regPhone.getEditText().getText().toString();
        String password = regPassword.getEditText().getText().toString();

        UserHelperClass helperClass = new UserHelperClass(name, username, email, phone, password);

        reference.child(username).setValue(helperClass);
    }
}