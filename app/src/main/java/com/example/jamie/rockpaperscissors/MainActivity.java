package com.example.jamie.rockpaperscissors;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    getWindow().setStatusBarColor(getResources().getColor(R.color.startStatusColour, getTheme()));
  }

  public void toGameScreen(View view) {
    Intent i = new Intent(this, GameScreen.class);
    startActivity(i);
  }
}
