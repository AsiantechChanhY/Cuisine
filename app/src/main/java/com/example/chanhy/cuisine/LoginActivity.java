package com.example.chanhy.cuisine;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.crashlytics.android.Crashlytics;
import com.example.chanhy.cuisine.Activity.MainActivity;
import io.fabric.sdk.android.Fabric;


/**
 * Created by chanhy on 12/05/2016.
 */
public class LoginActivity extends ActionBarActivity {

    LinearLayout mLogo, mLlemail, mLlpassword;
    Button mSignup, mBtnSignup, mSignin, mForgot;
    ImageView mTech, mAsian;
    TextView mWelcome;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics());
        setContentView(R.layout.activity_login);

        mTech = (ImageView) findViewById(R.id.imgTech);
        mAsian = (ImageView) findViewById(R.id.imgAsian);
        mWelcome = (TextView) findViewById(R.id.tvWelcome);
        mForgot = (Button) findViewById(R.id.btninForgot);
        mSignup = (Button) findViewById(R.id.btninSignup);
        mSignin = (Button) findViewById(R.id.btnSignIn);
        mLogo = (LinearLayout) findViewById(R.id.lnImgLogo);
        mLlemail = (LinearLayout) findViewById(R.id.llEmail);
        mLlpassword = (LinearLayout) findViewById(R.id.llPassword);

        final Animation animAsian = AnimationUtils.loadAnimation(this, R.anim.anim_asian);
        final  Animation animTech = AnimationUtils.loadAnimation(this, R.anim.anim_tech);
        final  Animation animup = AnimationUtils.loadAnimation(this, R.anim.anim_up);
        final  Animation animdown = AnimationUtils.loadAnimation(this, R.anim.anim_down);
        final  Animation animlogo = AnimationUtils.loadAnimation(this, R.anim.anim_logo);

        mAsian.startAnimation(animAsian);
        mTech.startAnimation(animTech);
        mLogo.startAnimation(animlogo);
        mWelcome.startAnimation(animdown);
        mLlemail.startAnimation(animup);
        mLlpassword.startAnimation(animup);
        mSignup.startAnimation(animup);
        mSignin.startAnimation(animup);
        mForgot.startAnimation(animup);

        signindialog();
        signupdialog();
        forgotdialog();
    }

    private void signindialog() {
        mSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void signupdialog() {

        mSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final Dialog dialogforgot = new Dialog(LoginActivity.this);

                dialogforgot.getWindow();
                dialogforgot.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialogforgot.setContentView(R.layout.activity_signup);
                dialogforgot.getWindow().getAttributes().windowAnimations = R.style.DialogTheme;
                dialogforgot.show();
            }
        });
    }

    private void forgotdialog() {
        mForgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Dialog dialogforgot = new Dialog(LoginActivity.this);

                dialogforgot.getWindow();
                dialogforgot.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialogforgot.setContentView(R.layout.activity_forgot);
                dialogforgot.getWindow().getAttributes().windowAnimations = R.style.DialogTheme;
                dialogforgot.show();
            }
        });
    }
}