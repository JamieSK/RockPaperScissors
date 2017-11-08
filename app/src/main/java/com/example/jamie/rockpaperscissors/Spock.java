package com.example.jamie.rockpaperscissors;

import java.util.ArrayList;

/**
 * Created by jamie on 08/11/2017.
 */

public class Spock implements Move {
  private ArrayList<String> beats;
  private ArrayList<String> loses;
  private int image;

  public Spock() {
    beats = new ArrayList<>();
    loses = new ArrayList<>();
    beats.add("Scissors");
    beats.add("Rock");
    loses.add("Paper");
    loses.add("Lizard");

    image = R.drawable.spock;
  }

  public String toString() {
    return "Spock";
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
