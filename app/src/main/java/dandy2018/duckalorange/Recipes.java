package dandy2018.duckalorange;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Recipes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipes);
        System.out.println(getIntent().getStringExtra("User info"));
    }
}
