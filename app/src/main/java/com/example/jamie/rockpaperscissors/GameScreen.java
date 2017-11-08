package com.example.jamie.rockpaperscissors;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class GameScreen extends AppCompatActivity {
  private ArrayList<Move> moves;
  private Rock rock;
  private Scissors scissors;
  private Paper paper;
  private Lizard lizard;
  private Spock spock;

  private ImageView playerMoveImageView;
  private ImageView pcMoveImageView;
  private TextView resultView;
  private TextView playerWinsView;
  private TextView pcWinsView;

  private Button rockButton;
  private Button paperButton;
  private Button scissorsButton;
  private Button lizardButton;
  private Button spockButton;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_game_screen);
    getWindow().setStatusBarColor(getResources().getColor(R.color.gameStatusColour, getTheme()));

    rock = new Rock();
    scissors = new Scissors();
    paper = new Paper();
    lizard = new Lizard();
    spock = new Spock();

    moves = new ArrayList<Move>();
    moves.add(rock);
    moves.add(paper);
    moves.add(scissors);
    moves.add(lizard);
    moves.add(spock);

    playerMoveImageView = findViewById(R.id.playerMoveImageView);
    pcMoveImageView = findViewById(R.id.pcMoveImageView);
    resultView = findViewById(R.id.resultView);

    playerWinsView = findViewById(R.id.playerWinsView);
    playerWinsView.setText(String.valueOf(SaveScore.getPlayerScore(this)));
    pcWinsView = findViewById(R.id.pcWinsView);
    pcWinsView.setText(String.valueOf(SaveScore.getPcScore(this)));

    rockButton = findViewById(R.id.rockButton);
    scissorsButton = findViewById(R.id.scissorsButton);
    paperButton = findViewById(R.id.paperButton);
    lizardButton = findViewById(R.id.lizardButton);
    spockButton = findViewById(R.id.spockButton);
  }

  private Move randomPcMove() {
    return moves.get(new Random().nextInt(moves.size()));
  }

  private Result checkResult(Move playerMove, Move pcMove) {
    if (playerMove.beats(pcMove)) {
      playerWinsIncrement();
      return Result.WIN;
    } else if (playerMove.loses(pcMove)) {
      pcWinsIncrement();
      return Result.LOSE;
    } else {
      return Result.DRAW;
    }
  }

  private void pcWinsIncrement() {
    int currentWins = Integer.parseInt(pcWinsView.getText().toString());
    SaveScore.setPcScore(this, currentWins + 1);
    pcWinsView.setText(String.valueOf(currentWins + 1));
  }

  private void playerWinsIncrement() {
    int currentWins = Integer.parseInt(playerWinsView.getText().toString());
    SaveScore.setPlayerScore(this, currentWins + 1);
    playerWinsView.setText(String.valueOf(currentWins + 1));
  }

  public void clearScores(View view) {
    SaveScore.setPlayerScore(this, 0);
    SaveScore.setPcScore(this, 0);
    pcWinsView.setText("0");
    playerWinsView.setText("0");
  }

  private void displayResult(Move playerMove, Move pcMove) throws InterruptedException {
    Result result = checkResult(playerMove, pcMove);
    hideButtons();

    resultView.setText(getString(R.string.result, result.toString()));
    setMoveImages(playerMove, pcMove);

    Handler handler = new Handler();
    handler.postDelayed(new Runnable() {
      public void run() {
        showButtons();
      }
    }, 1500);
  }

  private void setMoveImages(Move playerMove, Move pcMove) {
    playerMoveImageView.setImageResource(playerMove.getImage());
    pcMoveImageView.setImageResource(pcMove.getImage());
  }

  private void hideButtons() {
    rockButton.setVisibility(View.INVISIBLE);
    scissorsButton.setVisibility(View.INVISIBLE);
    paperButton.setVisibility(View.INVISIBLE);
    lizardButton.setVisibility(View.INVISIBLE);
    spockButton.setVisibility(View.INVISIBLE);

    playerMoveImageView.setVisibility(View.VISIBLE);
    pcMoveImageView.setVisibility(View.VISIBLE);
    resultView.setVisibility(View.VISIBLE);
  }

  private void showButtons() {
    rockButton.setVisibility(View.VISIBLE);
    scissorsButton.setVisibility(View.VISIBLE);
    paperButton.setVisibility(View.VISIBLE);
    lizardButton.setVisibility(View.VISIBLE);
    spockButton.setVisibility(View.VISIBLE);

    playerMoveImageView.setVisibility(View.INVISIBLE);
    pcMoveImageView.setVisibility(View.INVISIBLE);
    resultView.setVisibility(View.INVISIBLE);
  }

  public void playRock(View view) throws InterruptedException {
    Move pcMove = randomPcMove();
    displayResult(rock, pcMove);
  }

  public void playScissors(View view) throws InterruptedException {
    Move pcMove = randomPcMove();
    displayResult(scissors, pcMove);
  }

  public void playPaper(View view) throws InterruptedException {
    Move pcMove = randomPcMove();
    displayResult(paper, pcMove);
  }

  public void playSpock(View view) throws InterruptedException {
    Move pcMove = randomPcMove();
    displayResult(spock, pcMove);
  }

  public void playLizard(View view) throws InterruptedException {
    Move pcMove = randomPcMove();
    displayResult(lizard, pcMove);
  }
}
