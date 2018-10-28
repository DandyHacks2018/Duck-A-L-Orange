package dandy2018.duckalorange;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Recipes extends AppCompatActivity {

    String r;
    String calories;
    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipes);
        r = getIntent().getStringExtra("Info");
        calories = r.split("$")[0];
        textView = findViewById(R.id.txtCal);
        textView.setText(calories);
        //r += findViewById(R.id.recp4);
    }

    public void startMap(View view){
        Intent intent = new Intent(this, Maps.class);
        //intent.putExtra("Recipe", r);
        startActivity(intent);
    }
}
