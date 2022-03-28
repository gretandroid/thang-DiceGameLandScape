package com.example.dicegamelandscape;

import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DataModel extends LogableViewModel {
    private List<MutableLiveData<Integer>> mDiceIndexes = new ArrayList<>();

    public MutableLiveData<Integer> getDiceIndex(int pos) {
        if (pos >= mDiceIndexes.size()) {
            mDiceIndexes.add(new MutableLiveData<>());
            return mDiceIndexes.get(mDiceIndexes.size() - 1);
        }
        else {
            return mDiceIndexes.get(pos);
        }
    }

    public void setDiceIndex(int pos, int value) {
        mDiceIndexes.get(pos).setValue(value);
    }

    public void launchDices(int numberDices, int indexBound) {
        for (int i = 0 ; i < numberDices; i++ ) {
            int generatedDiceIndex = generateRandomIndex(indexBound);
            setDiceIndex(i, generatedDiceIndex);
        }
    }

    /**
     * Generate an random number between 1-bound
     * @param bound
     * @return generated random number
     */
    private int generateRandomIndex(int bound) {
        // Generate an random number between 1-bound
        int randomNumber;
        Random random = new Random();
        randomNumber = random.nextInt(bound);

        // return the generated index
        return randomNumber;
    }

}
