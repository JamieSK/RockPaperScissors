package com.example.jamie.rockpaperscissors;

import java.util.ArrayList;

/**
 * Created by jamie on 08/11/2017.
 */

public class Scissors implements Move {
  private ArrayList<String> beats;
  private ArrayList<String> loses;
  private int image;

  public Scissors() {
    beats = new ArrayList<>();
    loses = new ArrayList<>();
    beats.add("Paper");
    beats.add("Lizard");
    loses.add("Rock");
    loses.add("Spock");

    image = R.drawable.scissors;
  }

  public String toString() {
    return "Scissors";
  }

  public int getImage() {
    return image;
  }

  @Override
  public boolean beats(Move move) {
    return beats.contains(move.toString());
  }

  @Override
  public boolean loses(Move move) {
    return loses.contains(move.toString());
  }
}
