package com.quackfactory.duckapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class FactActivity extends AppCompatActivity {

    Button factGoHomeButton;
    Button refreshFactButton;
    TextView factGoesHere;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fact);
        establishRealFactList();
        factGoesHere = findViewById(R.id.fact_textView);
        Fact currentFact = pickRandomFact(totalFacts);
        factGoesHere.setText(currentFact.writtenFact);

        refreshFactButton = findViewById(R.id.refresh_fact_button);
        refreshFactButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fact newFact = pickRandomFact(totalFacts);
                factGoesHere.setText(newFact.writtenFact);
            }
        });

        factGoHomeButton = findViewById(R.id.fact_return_home_button);
        factGoHomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    // create ArrayList to hold facts
    ArrayList<Fact> factList = new ArrayList<Fact>();
    int totalFacts; // may need to declare it with: = factList.size

    // generate the real facts
    public void establishRealFactList(){
        Fact fact1= new Fact(1, "Some duck species can use winds to help them reach flight speeds of up to 60 mph.");
        Fact fact2 = new Fact(2, "Ducklings communicate with siblings before hatching.");
        Fact fact3 = new Fact(3, "Some duck species can dive as deep as 240 feet under water.");
        Fact fact4 = new Fact(4, "Since ducks' eyes are located on the sides of their head, they can see almost 340 degrees around.");
        Fact fact5 = new Fact(5,"There are many names for a group of ducks, including: a paddling, a flock, a plump, a raft (when on water).");
        Fact fact6 = new Fact(6, "Ducks can partake in unihemispheric slow-wave sleep. This allows half of their brain to sleep while keeping one eye open to protect them from predators.");
        Fact fact7 = new Fact(7, "Duck eggs tend to be more nutritious than chicken eggs.");

        factList.add(fact1);
        factList.add(fact2);
        factList.add(fact3);
        factList.add(fact4);
        factList.add(fact5);
        factList.add(fact6);
        factList.add(fact7);

        totalFacts = factList.size();
    }

    // pick random fact
    public int generateRandomNumber(int max){
        double randomNumber = Math.random();
        double result = max * randomNumber;
        return (int) result;
    }

    public Fact pickRandomFact(int totalFacts){
        int factIndex = generateRandomNumber(totalFacts - 1);
        return factList.get(factIndex);
    }

}