package com.example.chanhy.cuisine.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.chanhy.cuisine.R;

/**
 * Created by chanhy on 19/05/2016.
 */
public class SignupActivity extends Activity implements View.OnClickListener {

    TextView mTvisconected;
    EditText mUsernamesignup, mPasswordsignup, mEmailsignup;
    Button mBtnsignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().getAttributes().windowAnimations = R.style.DialogTheme;
        setContentView(R.layout.activity_signup);

        mTvisconected  = (TextView) findViewById(R.id.tvIsConnected);
        mUsernamesignup = (EditText) findViewById(R.id.etusernamsignup);
        mPasswordsignup = (EditText) findViewById(R.id.etpasswordsignup);
        mEmailsignup = (EditText) findViewById(R.id.etmailsignup);
        mBtnsignup = (Button) findViewById(R.id.btnSignup);



    }

    @Override
    public void onClick(View view) {

    }
}
