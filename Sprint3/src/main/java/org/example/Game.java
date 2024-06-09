package org.example;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private final IWordSelector wordSelector ;
    private final IHintGenerator hintGenerator;
    private final IFeedBackGenerator feedBackGenerator;
    private int intents;
    private String wordSelected;
    private List<Character> guessedLetters;

    public Game(IWordSelector wordSelector, IHintGenerator hintGenerator, IFeedBackGenerator feedBackGenerator){
        this.wordSelector = wordSelector;
        this.hintGenerator = hintGenerator;
        this.feedBackGenerator = feedBackGenerator;
        this.wordSelected = wordSelector.selectWord();
        this.guessedLetters = new ArrayList<>();
    }

    public void start(){
        String hint = hintGenerator.generateHint(wordSelected);
        System.out.println("Pista: " + hint);
    }

    public void guessLetter(String letter){
        setIntents(intents-1);
        guessedLetters.add(letter.charAt(0));
        System.out.println("Feedback: " + feedBackGenerator.generateFeedback(letter));
    }

    public boolean isWon(){
        for (char c : wordSelected.toCharArray()) {
            if (!guessedLetters.contains(c)) {
                return false;
            }
        }
        return true;
    }
    public String checkGameStatus(){
        if (isWon()){
            return "Ganaste :), la palabra era: " + wordSelected;
        }else {
            return "Perdiste :(, la palabra era: " + wordSelected;
        }
    }
    public void setIntents(int intents){
        this.intents = intents;
    }

    public int getIntents(){
        return intents;
    }
}
