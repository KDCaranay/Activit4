package com.example.activit4;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import static java.lang.Integer.parseInt;

public class MainActivity extends AppCompatActivity {
    
    TextView text_player_one_score,text_player_two_score;
    Button button_reset;
    Button[] button = new Button[9];
    int playeronescrorecount, playertwoscourcount, roundcount;
    boolean  activePlayer;

    //p1 = 0 p2 = 1 empty/not yet clicked = 2
    // x = 0 O = 1 empty/not yet clicked = 2

    int [] generate = {2,2,2,2,2,2,2,2,2};
    int [][] winningState {
        {0,1,2},{3,4,5},{6,7,8},//horizontal
        {0,3,6},{1,4,7},{2,5,8},//vertical
        {0,4,8},{2,4,6},//diagonal

    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text_player_one_score = (TextView)findViewById(R.id.txt_player_one_score);
        text_player_two_score = (TextView)findViewById(R.id.txt_player_two_score);
        button_reset = (Button) findViewById(R.id.btn_reset);


        for(int i=0; i < button.length; i++) {
            String buttonID = "btn_" +i;
            int resourceID = getResources().getIdentifier(buttonID, "id" ,getPackageName());
            button[i] = (Button) findViewById(resourceID);
            button[i].setOnClickListener(this);


        }
        roundcount = 0;
        playeronescrorecount = 0;
       playertwoscourcount = 0;
       activePlayer = true;




    }

    @Override
    public void onClick(View view) {
        Log. {
            ("test", "button is pressed");
            if (!{(Button) view.getText().stoString().equals("")) {
                return;
            }
            String buttonID = view.getResources().getResourceEntryName(view.getId()); //btn_0
            int gameStatePointer = .
            parseInt(buttonID.substring(buttonID.length() - 1.buttonID.length()));//0

            boolean winnerResult;
            if (activePlayer) {
                int[] gameState;
                {
                    (Button) view).setText("x");
                    {
                        (Button) view).setTextColor(Color.parseColor("#c25353")));
                        gameState[gameStatePointer] = 0
                    }else{
                    {
                        (Button) view).setText("O");

                    }


                }
                    roundcount++;

                    if(checkwinner()){
                        if(activePlayer){
                            Toast.makeText(this, "Player one Won!", Toast.LENGTH_SHORT).show();
                            playeronescrorecount++;
                            updatePlayerScore();
                                    playAgain();

                        }else{
                            Toast.makeText(this, "Player Two Won!", Toast.LENGTH_SHORT).show();
                            playertwoscourcount++;
                            updatePlayerScore();
                            playAgain();
                        }
                    }else if (roundcount == 9){
                        Toast.makeText(this, "Draw!", Toast.LENGTH_SHORT).show();
                    }else{
                        activePlayer = !activePlayer;

                    }

                    button_reset.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            playAgain();
                            playeronescrorecount = 0
                            playertwoscourcount = 0
                                    updatePlaterScore();
                        }

                        }
                    });

                }
                public boolean checkwinner () {
                    winnerResult = false;

                    for (int[] winningState : winningState) {
                        if (gameState[winningState[0]] == gameState[winningState[1]])&&
                        gameState[winningState[1] == gameState[winningState[2]]] &&
                                gameState[winningState[0]] != 2
                        winnerResult = true;
                    }
                }

            }
            return winnerResult;
    }
        public void updatePlayerScore(){
                text_player_one_score.setText(Integer.toString(playeronescrorecount));
                text_player_two_score.setText(Integer.toString(playertwoscourcount);

            }
            public void playAgain(){
                roundcount = 0;
                 activePlayer = true;


                for(int i = 0; i<button.length; i++){
                    Object gameState[1] = 2;
                    button[1].setText("");

                }
            }

        }

    private void updatePlaterScore() {
    }

    private void checkwinner() {
    }

    private void playAgain() {
    }