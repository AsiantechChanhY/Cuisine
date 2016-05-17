package com.example.chanhy.cuisine;

import android.app.Dialog;
import android.content.Context;
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


/**
 * Created by chanhy on 12/05/2016.
 */
public class LoginActivity extends ActionBarActivity {

    final Context context = this;
    LinearLayout logo, llemail, llpassword;
    Button signup, mBtnSignup, signin, forgot;
    ImageView tech, asian;
    TextView welcome;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        tech = (ImageView) findViewById(R.id.imgTech);
        asian = (ImageView) findViewById(R.id.imgAsian);
        welcome = (TextView) findViewById(R.id.tvWelcome);
        forgot = (Button) findViewById(R.id.btninForgot);
        signup = (Button) findViewById(R.id.btninSignup);
        signin = (Button) findViewById(R.id.btnSignIn);
        logo = (LinearLayout) findViewById(R.id.lnImgLogo);
        llemail = (LinearLayout) findViewById(R.id.llEmail);
        llpassword = (LinearLayout) findViewById(R.id.llPassword);

        final Animation animAsian = AnimationUtils.loadAnimation(this, R.anim.anim_asian);
        final  Animation animTech = AnimationUtils.loadAnimation(this, R.anim.anim_tech);
        final  Animation animup = AnimationUtils.loadAnimation(this, R.anim.anim_up);
        final  Animation animdown = AnimationUtils.loadAnimation(this, R.anim.anim_down);
        final  Animation animlogo = AnimationUtils.loadAnimation(this, R.anim.anim_logo);

        asian.startAnimation(animAsian);
        tech.startAnimation(animTech);
        logo.startAnimation(animlogo);
        welcome.startAnimation(animdown);
        llemail.startAnimation(animup);
        llpassword.startAnimation(animup);
        signup.startAnimation(animup);
        signin.startAnimation(animup);
        forgot.startAnimation(animup);

       signin.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent = new Intent(LoginActivity.this, MainActivity.class);
               startActivity(intent);
           }
       });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Dialog dialog = new Dialog(LoginActivity.this);

                dialog.getWindow();
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.activity_signup);
                dialog.getWindow().getAttributes().windowAnimations = R.style.DialogTheme;
                dialog.show();
            }
        });

        forgot.setOnClickListener(new View.OnClickListener() {
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