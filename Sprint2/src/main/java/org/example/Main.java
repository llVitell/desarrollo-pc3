package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        int intents = 5;
        IWordSelector wordSelector = new WordSelector();
        IHintGenerator hintGenerator = new HintGenerator();
        IFeedBackGenerator feedBackGenerator = new FeedBackGenerator();

        Game game = new Game(wordSelector,hintGenerator, feedBackGenerator);
        game.setIntents(intents);
        game.start();

        do {
            System.out.println("Adivina una letra: ");
            String guess = scanner.nextLine();
            game.guessLetter(guess);
        }while (game.getIntents() > 0);

    }
}
