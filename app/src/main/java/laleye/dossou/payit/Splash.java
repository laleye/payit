package laleye.dossou.payit;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import laleye.dossou.payit.Application.Config;
import laleye.dossou.payit.Helper.Typewriter;

public class Splash extends AppCompatActivity {
    ImageView icon;
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        icon = findViewById(R.id.fade);

        Animation fadeAnimation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in_animation);
        icon.startAnimation(fadeAnimation);

        final Typewriter tw = (Typewriter) findViewById(R.id.tw);
        tw.setCharacterDelay(600);
        tw.animateText("Pay It");


        handler = new Handler(Looper.getMainLooper());

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                finish();
                /**
                 * Check for login session. If not logged in launch
                 * login activity
                 * */
                if (!Config.has_passed_registration_step) {
                    launchLoginActivity();
                }else {
                    startActivity(new Intent(Splash.this, MainActivity.class));
                }


            }
        }, 5000);

    }


    private void launchLoginActivity() {
        Intent intent = new Intent(Splash.this, PhoneRegistrationActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }

}
