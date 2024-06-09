package org.example;

public class FeedBackGenerator implements IFeedBackGenerator{
    IWordSelector wordSelector = new WordSelector();

    @Override
    public String generateFeedback(String guess) {
        if(wordSelector.selectWord().contains(guess)){
            return "Buen intento";
        }
        else{
            return "Mal intento";
        }
    }
}
