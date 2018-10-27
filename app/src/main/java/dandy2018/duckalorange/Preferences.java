package dandy2018.duckalorange;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

public class Preferences extends AppCompatActivity {
    String s;
    CheckBox[] chks = new CheckBox[9];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferences);
        s = getIntent().getStringExtra("User info");
        chks[0] = findViewById(R.id.pref0);
        chks[1] = findViewById(R.id.pref1);
        chks[2] = findViewById(R.id.pref2);
        chks[3] = findViewById(R.id.pref3);
        chks[4] = findViewById(R.id.pref4);
        chks[5] = findViewById(R.id.pref5);
        chks[6] = findViewById(R.id.pref6);
        chks[7] = findViewById(R.id.pref7);
        chks[8] = findViewById(R.id.pref8);
    }
    public void startRecipes(View view){
        //Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
        for(CheckBox c : chks){
            if(c.isChecked()){
                s += c.getText() + "$";
            }
        }
        Intent intent = new Intent(this, Recipes.class);
        intent.putExtra("User info", s);
        startActivity(intent);
    }
}
