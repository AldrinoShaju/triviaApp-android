package com.example.trivia;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.trivia.data.Repository;
import com.example.trivia.databinding.ActivityMainBinding;
import com.example.trivia.model.Question;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private int currentQIndex = 0;

    List<Question> questionList;

    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        questionList = new Repository().getQuestions(questionArrayList1 -> updateQuestion());


        binding.buttonOpt1.setOnClickListener(view -> {
            score++;
            nextQuestion();
        });

        binding.buttonOpt2.setOnClickListener(view-> nextQuestion());

        binding.buttonOpt3.setOnClickListener(view-> nextQuestion());

        binding.buttonOpt4.setOnClickListener(view-> nextQuestion());



    }

    private void nextQuestion(){
        currentQIndex = currentQIndex + 1;

        if(questionList.size()-1<currentQIndex){
            Intent i = new Intent(this, ResultActivity.class);
            i.putExtra(getString(R.string.scoreText), score);
            startActivity(i);
        }else{
            updateQuestion();
        }
    }

    private void updateQuestion() {
        Question currentQuestion = questionList.get(currentQIndex);
        int actualQNumber = currentQIndex + 1;
        binding.textViewQuestion.setText(String.format(getString(R.string.questionNumberString), actualQNumber));

        binding.questionTextView.setText(currentQuestion.getQuestion());
        binding.buttonOpt1.setText(currentQuestion.getCorrectAnswer());
        List<String> incorrectAnswers = currentQuestion.getIncorrectAnswers();
        binding.buttonOpt2.setText(incorrectAnswers.get(0));
        binding.buttonOpt3.setText(incorrectAnswers.get(1));
        binding.buttonOpt4.setText(incorrectAnswers.get(2));
    }
}