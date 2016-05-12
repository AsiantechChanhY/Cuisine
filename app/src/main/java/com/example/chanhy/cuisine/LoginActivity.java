package com.example.chanhy.cuisine;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
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


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ImageView tech = (ImageView) findViewById(R.id.imgTech);
        ImageView asian = (ImageView) findViewById(R.id.imgAsian);
        TextView welcome = (TextView) findViewById(R.id.tvWelcome);
        Button forgot = (Button) findViewById(R.id.btnForgot);
        Button signup = (Button) findViewById(R.id.btnSignup);
        Button signin = (Button) findViewById(R.id.btnSignIn);
        LinearLayout logo = (LinearLayout) findViewById(R.id.lnImgLogo);
        LinearLayout llemail = (LinearLayout) findViewById(R.id.llEmail);
        LinearLayout llpassword = (LinearLayout) findViewById(R.id.llPassword);

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
            public void onClick(View v) {
                Intent intent1 = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent1);
            }
        });
    }

}