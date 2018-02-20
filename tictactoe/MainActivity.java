package ser210.quinnipiac.edu.tictactoe;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //checks if the start button was clicked
    protected void startClicked (View view) {
        EditText nameText = (EditText) findViewById(R.id.nameText); q
        Intent intent = new Intent(this, game.class);
        intent.putExtra("text", nameText.getText().toString());
        startActivity(intent);
    }


}
