package com.example.trivia;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;

import com.example.trivia.databinding.ActivityResultBinding;

public class ResultActivity extends AppCompatActivity {

    private ActivityResultBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_result);

        Intent i = getIntent();
        int score = i.getIntExtra(getString(R.string.scoreText), -1);

        binding.scoreTextView.setText(String.format("%d%s", score, getString(R.string.outOf20Text)));

        binding.resetButton.setOnClickListener(view -> {
            Intent back = new Intent(this, MainActivity.class);
            startActivity(back);
        });
    }
}