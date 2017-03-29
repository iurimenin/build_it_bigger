package io.github.iurimenin.javalib;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Iuri Menin on 29/03/17.
 */

public class Jokes {

    private static final List<String> jokes = new ArrayList<>();
    private Random random;

    public Jokes () {

        random = new Random();
        if (jokes.isEmpty())
            fillJokes();
    }

    private void fillJokes() {

        jokes.add( "Some Texans are mingling at the bar when an Oxford graduate walks in. " +
                "\"Howdy, stranger,\" one Texan says. \"Where are you from?\" <br/>" +
                "The Oxford graduate answers, \"I come from a place where we do not end our " +
                "sentences in prepositions.\" <br/>" +
                "\"Oh, I’m sorry,\" replies the Texan. \"Where are you from, jackass?\"");

        jokes.add("An amnesiac walks into a bar. He goes up to a beautiful blonde and says, " +
                "\"So, do I come here often?\"");

        jokes.add("A farmer counted 196 cows in \u2028the field. But when he rounded them up, " +
                "he had 200.");

        jokes.add("The problem with math puns is that calculus jokes are all derivative, " +
                "trigonometry jokes are too graphic, algebra jokes are usually formulaic, " +
                "and arithmetic jokes are pretty basic. But I guess the occasional statistics " +
                "joke is an outlier.");
    }

    public String getJoke() {
        return jokes.get(random.nextInt(jokes.size()));
    }
}
