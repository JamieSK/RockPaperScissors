package com.example.jamie.rockpaperscissors;

import java.util.ArrayList;

/**
 * Created by jamie on 08/11/2017.
 */

public class Paper implements Move {
  private ArrayList<String> beats;
  private ArrayList<String> loses;
  private int image;

  public Paper() {
    beats = new ArrayList<>();
    loses = new ArrayList<>();
    beats.add("Rock");
    beats.add("Spock");
    loses.add("Scissors");
    loses.add("Lizard");

    image = R.drawable.paper;
  }

  public String toString() {
    return "Paper";
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
