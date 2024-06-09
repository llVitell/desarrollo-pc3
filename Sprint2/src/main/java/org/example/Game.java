package org.example;

public class Game {
    private final IWordSelector wordSelector;
    private final IHintGenerator hintGenerator;
    private final IFeedBackGenerator feedBackGenerator;
    private int intents;

    public Game(IWordSelector wordSelector, IHintGenerator hintGenerator, IFeedBackGenerator feedBackGenerator){
        this.wordSelector = wordSelector;
        this.hintGenerator = hintGenerator;
        this.feedBackGenerator = feedBackGenerator;
    }
    public void start(){
        String word = wordSelector.selectWord();
        String hint = hintGenerator.generateHint(word);
        System.out.println("Pista: " + hint);
    }

    public void guessLetter(String letter){
        setIntents(intents-1);
        System.out.println("Feedback: " + feedBackGenerator.generateFeedback(letter));
    }

    public void setIntents(int intents){
        this.intents = intents;
    }

    public int getIntents(){
        return intents;
    }
}
