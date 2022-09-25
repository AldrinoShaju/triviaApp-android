package com.example.trivia.data;

import static android.content.ContentValues.TAG;

import android.util.Log;

import com.android.volley.Request;
import com.android.volley.toolbox.JsonArrayRequest;
import com.example.trivia.controller.AppController;
import com.example.trivia.model.Question;
import com.google.gson.Gson;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

public class Repository {
    String url = "https://the-trivia-api.com/api/questions?limit=20&region=IN&difficulty=easy";

    List<Question> questions = new ArrayList<>();

    public List<Question> getQuestions(final AnswerListAsyncResponse callback){
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, resp->{

//            String s = resp.toString();
//            Log.d(TAG, "getQuestions: "+ s);

            for(int i=0;i<resp.length();i++){
                try {
                    Question curQ = (new Gson()).fromJson(resp.getString(i), Question.class);
                    questions.add(curQ);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }



            if(callback!=null){
                callback.processFinished(questions);
            }
        }, Exception::printStackTrace);

        AppController.getInstance().addToRequestQueue(jsonArrayRequest);

        return questions;
    }
}
