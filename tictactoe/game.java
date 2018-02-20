package ser210.quinnipiac.edu.tictactoe;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class game extends Activity {

    TicTacToe TTT;
    int current;
    TextView nameView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        String text = getIntent().getStringExtra("text");
        nameView = (TextView) findViewById(R.id.textView);
        nameView.setText("Hello, " + text);
        TTT = new TicTacToe();
    }

    //detects if a square is clicked
    public void buttonClick(View view){
        TTT.setMove(ITicTacToe.CROSS, view.getId() - R.id.imageButton1);
        view.setEnabled(false);
        makeBoard();
        if(!checkWin()){
            doAITurn();
        }
    }

    //takes the AI move from the tic tac toe class
    public void doAITurn(){
        TTT.setMove(ITicTacToe.NOUGHT, TTT.getComputerMove());
        makeBoard();
        checkWin();
    }

    //updates the whose turn it is or if anyone won
    public boolean checkWin(){
        current = TTT.checkForWinner();
        if (current == ITicTacToe.NOUGHT_WON){
            nameView.setText("You lose!");
            return true;
        } else if (current == ITicTacToe.CROSS_WON){
            nameView.setText("You win!");
            return true;
        }
        else if (current == ITicTacToe.TIE){
            nameView.setText("Its a tie!");
            return true;
        } else {
            nameView.setText("Your turn!");
            return false;
        }
    }

    //creates the board
    public void makeBoard() {
        checkCell(0,R.id.imageButton1);
        checkCell(1,R.id.imageButton2);
        checkCell(2,R.id.imageButton3);
        checkCell(3,R.id.imageButton4);
        checkCell(4,R.id.imageButton5);
        checkCell(5,R.id.imageButton6);
        checkCell(6,R.id.imageButton7);
        checkCell(7,R.id.imageButton8);
        checkCell(8,R.id.imageButton9);
    }

    //checks what is in a cell
    public void checkCell(int i, int id) {
        if (TTT.getCell(i) == ITicTacToe.CROSS) {
            ((ImageButton) findViewById(id)).setImageResource(R.drawable.cross);
            ((ImageButton) findViewById(id)).setEnabled(false);
        } else if (TTT.getCell(i) == ITicTacToe.NOUGHT) {
            ((ImageButton) findViewById(id)).setImageResource(R.drawable.naught);
            ((ImageButton) findViewById(id)).setEnabled(false);
        } else if(TTT.getCell(i) == ITicTacToe.EMPTY){
            ((ImageButton) findViewById(id)).setImageResource(R.drawable.android);
            ((ImageButton) findViewById(id)).setEnabled(true);
        }
    }

    //clears the board then remakes the board
    public void clearBoard(View view){
        TTT.clearBoard();
        this.makeBoard();
        nameView.setText("Your turn!");
    }


}
