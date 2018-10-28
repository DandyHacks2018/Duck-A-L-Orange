package dandy2018.duckalorange;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Recipes extends AppCompatActivity {

    String r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipes);
        r = getIntent().getStringExtra("Recipe");
        //r += findViewById(R.id.recp4);
    }

    public void startMap(View view){
        Intent intent = new Intent(this, Maps.class);
        //intent.putExtra("Recipe", r);
        startActivity(intent);
    }
}
