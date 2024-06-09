package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GameTest {
    Game game;
    IWordSelector wordSelector;
    IHintGenerator hintGenerator;
    IFeedBackGenerator feedBackGenerator;

    @BeforeEach
    void start(){
        wordSelector = new WordSelector();
        hintGenerator = new HintGenerator();
        feedBackGenerator = new FeedBackGenerator();
        game = new Game(wordSelector,hintGenerator, feedBackGenerator);
    }

    @Test
    void wordSelectorShouldSelectAWord(){
        assertThat(wordSelector.selectWord()).isEqualTo("example");
    }

    @Test
    void hintGeneratorShouldReturnAHint(){
        assertThat(hintGenerator.generateHint("test")).isEqualTo("The word has 4 letters");
    }
    @Test
    void feedBackGeneratorShouldReturnFeedback(){
        assertThat(feedBackGenerator.generateFeedback("r")).isEqualTo("feedback");
    }

    @Test
    void tryesShouldDecrementAfterEveryGuess() {
        int intents = game.getIntents();
        game.guessLetter("e");
        assertThat(intents - 1).isEqualTo(game.getIntents());
    }
}