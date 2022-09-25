package com.example.trivia;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.example.trivia.databinding.ActivityResultBinding;

public class ResultActivity extends AppCompatActivity {

    public static final String MESG = "MESG";
    private ActivityResultBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_result);

        Intent i = getIntent();
        int score = i.getIntExtra(getString(R.string.scoreText), -1);

        SharedPreferences sharedPreferences = getSharedPreferences(MESG, MODE_PRIVATE);
        String highScoreText = "highScore";
        int highScore = sharedPreferences.getInt(highScoreText, 0);

        binding.textView.setText(String.format("Highest Score: %d/20", highScore));

        if(highScore<score){
            SharedPreferences sharedPreferences2 = getSharedPreferences(MESG, MODE_PRIVATE);
            SharedPreferences.Editor edit2 = sharedPreferences2.edit();
            edit2.putInt(highScoreText, score);
            edit2.apply();
        }



        binding.scoreTextView.setText(score+getString(R.string.outOf20Text));

        binding.resetButton.setOnClickListener(view -> {
            Intent back = new Intent(this, MainActivity.class);
            startActivity(back);
        });
    }
}