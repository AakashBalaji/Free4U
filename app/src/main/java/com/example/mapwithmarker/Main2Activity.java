package com.example.mapwithmarker;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Main2Activity extends AppCompatActivity {
    TextView texx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        texx = (TextView) findViewById(R.id.text1);
        Button but = (Button) findViewById(R.id.ButtonX);
        but.setOnClickListener(new View.OnClickListener(){

        public void onClick(View v){
        new doIt().execute();


        }
    });
      }

       public class doIt extends AsyncTask<Void, Void, Void> {
           String words;

           @Override
           protected Void doInBackground(Void... params) {
               Document document = null;
               try {
                   document = Jsoup.connect("http://sf.funcheap.com/free-admission-day-santa-cruz-museum-of-natural-history-36/").get();
                   words = document.text();
                   String question = document.select("#question .post-text").text();
               System.out.println("Question: " + question);
                   Elements answerers = document.select("#answers .user-details a");
               for (Element answerer : answerers) {
                   System.out.println("Answerer: " + answerers.text());
               }
               } catch (IOException e) {
                   e.printStackTrace();
               }

                /*try {
                    Document doc = Jsoup.connect("http://www.nature.com/authors/author_resources/article_types.html").get();
                    words = doc.text();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                */
               return null;
           }

           protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                texx.setText(words);
            }
    }
}
