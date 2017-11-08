package com.example.jamie.rockpaperscissors;

import java.util.ArrayList;

/**
 * Created by jamie on 08/11/2017.
 */

public class Lizard implements Move {
  private ArrayList<String> beats;
  private ArrayList<String> loses;
  private int image;

  public Lizard() {
    beats = new ArrayList<>();
    loses = new ArrayList<>();
    beats.add("Paper");
    beats.add("Spock");
    loses.add("Scissors");
    loses.add("Rock");

    image = R.drawable.lizard;
  }

  public String toString() {
    return "Lizard";
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
