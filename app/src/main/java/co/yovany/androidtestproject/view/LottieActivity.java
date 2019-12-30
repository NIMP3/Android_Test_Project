package co.yovany.androidtestproject.view;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.airbnb.lottie.LottieAnimationView;

import co.yovany.androidtestproject.R;

public class LottieActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lottie);

        LottieAnimationView lottieCheck = findViewById(R.id.lottieCheck);
        LottieAnimationView lottieError = findViewById(R.id.lottieError);
        LottieAnimationView lottieWarning = findViewById(R.id.lottieWarning);
        LottieAnimationView lottieInfo = findViewById(R.id.lottieInfo);


        lottieCheck.setSpeed(0.5f);
        lottieError.setSpeed(0.6f);
        lottieWarning.setSpeed(0.7f);
        lottieInfo.setSpeed(0.8f);
    }
}
