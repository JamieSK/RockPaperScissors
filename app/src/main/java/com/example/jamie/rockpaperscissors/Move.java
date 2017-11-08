package com.example.jamie.rockpaperscissors;

/**
 * Created by jamie on 08/11/2017.
 */

public interface Move {
  String toString();
  boolean beats(Move move);
  boolean loses(Move move);
  int getImage();
}
