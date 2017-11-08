package com.example.jamie.rockpaperscissors;

import android.content.Context;
import android.preference.PreferenceManager;

/**
 * Created by jamie on 08/11/2017.
 */

public class SaveScore {
  private static final String PC_SCORE = "pcScore";
  private static final String PLAYER_SCORE = "playerScore";

  public static void setPcScore(Context context, int score) {
    PreferenceManager.getDefaultSharedPreferences(context)
            .edit()
            .putInt(PC_SCORE, score)
            .apply();
  }

  public static void setPlayerScore(Context context, int score) {
    PreferenceManager.getDefaultSharedPreferences(context)
            .edit()
            .putInt(PLAYER_SCORE, score)
            .apply();
  }

  public static int getPcScore(Context context) {
    return PreferenceManager.getDefaultSharedPreferences(context)
            .getInt(PC_SCORE, 0);
  }

  public static int getPlayerScore(Context context) {
    return PreferenceManager.getDefaultSharedPreferences(context)
            .getInt(PLAYER_SCORE, 0);
  }
}
