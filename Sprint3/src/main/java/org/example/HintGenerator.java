package org.example;

public class HintGenerator implements IHintGenerator{

    @Override
    public String generateHint(String word) {
        return "The word has " + word.length() + " letters";
    }
}
