package com.example.jamie.rockpaperscissors;

import java.util.ArrayList;

/**
 * Created by jamie on 08/11/2017.
 */

public class Rock implements Move {
  private ArrayList<String> beats;
  private ArrayList<String> loses;
  private int image;

  public Rock() {
    beats = new ArrayList<>();
    loses = new ArrayList<>();
    beats.add("Scissors");
    beats.add("Lizard");
    loses.add("Paper");
    loses.add("Spock");

    image = R.drawable.rock;
  }

  public String toString() {
    return "Rock";
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
