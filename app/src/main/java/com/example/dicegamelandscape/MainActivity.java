package com.example.dicegamelandscape;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends LogableActivity {

    // Step 1 : declare fields corresponding to UI elements
    private List<ImageView> diceImages = new ArrayList<>();
    private Button rollButton;
    //    private int[] diceIndexes; // for onSaveInstanceState solution
    private DataModel model; // ViewModel solution

    // table contains all image ids
    private final int[] dicesArray = {
            R.drawable.de1,
            R.drawable.de2,
            R.drawable.de3,
            R.drawable.de4,
            R.drawable.de5,
            R.drawable.de6,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Step 2 : references fields to UI objects
        rollButton = findViewById(R.id.rollButton);

        ConstraintLayout rootLayout = findViewById(R.id.rootLayout);
        for (int i = 0; i < rootLayout.getChildCount(); i++) {
            View child = rootLayout.getChildAt(i);
            if (child instanceof ImageView) {
                diceImages.add((ImageView) child);
            }
        }

        // --- onSaveInstanceState solution --- //
        /*
        diceIndexes = new  int[diceImages.size()];

        // init default
        for(int i = 0; i < diceIndexes.length; i++) {
            diceImages.get(i).setImageResource(dicesArray[diceIndexes[i]]);
        } */


        /*
        // restore state
        if (savedInstanceState != null) {

            for(int i = 0; i < diceIndexes.length; i++) {
                String key = "diceIndexes" + i;
               diceIndexes[i] = savedInstanceState.getInt(key);
                Log.d("onCreate", "" + key + "=" + diceIndexes[i]);
               diceImages.get(i).setImageResource(dicesArray[diceIndexes[i]]);
            }
        } */

        // --- ViewModel solution --- //

        // init model
        model = new ViewModelProvider(this).get(DataModel.class);

        // subscribe observers
        for(int i = 0; i < diceImages.size(); i++) {
            final int pos = i;
            model.getDiceIndex(pos).observe(this, diceIndex ->
            diceImages.get(pos).setImageResource(dicesArray[diceIndex]));
        }
    }

    /*
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        // save index of image
        for(int i = 0; i < diceIndexes.length; i++) {
            String key = "diceIndexes" + i;
            outState.putInt(key, diceIndexes[i]);
            Log.d("onSaveInstanceState", key + "=" + outState.getInt(key));
        }

    } */

    /*
    public void onClickRollButton(View view) {
        diceImages.forEach( diceImage -> {
            int i = diceImages.indexOf(diceImage);
            diceIndexes[i] = generateRandomIndex(dicesArray.length);
            // Show new image for two dices
            diceImage.setImageResource(dicesArray[diceIndexes[i]]);
        });
    } */

    public void onClickRollButton(View view) {
        model.launchDices(diceImages.size(), dicesArray.length);
    }

    /**
     * Generate an random number between 1-bound
     * @param bound
     * @return generated random number
     */
    /*
    private int generateRandomIndex(int bound) {
        // Generate an random number between 1-bound
        int randomNumber;
        Random random = new Random();
        randomNumber = random.nextInt(bound);

        // return the generated index
        return randomNumber;
    } */
}