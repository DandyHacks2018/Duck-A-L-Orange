package dandy2018.duckalorange;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Button button;
    RadioButton male;
    RadioButton female;
    EditText ageView;
    EditText weightView;
    EditText heightView;
    Spinner spinner;
    int spinnerIndex = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        male = findViewById(R.id.rdbMale);
        female = findViewById(R.id.rdbFemale);
        ageView = findViewById(R.id.txtAge);
        weightView = findViewById(R.id.txtWeight);
        heightView = findViewById(R.id.txtHeight);

        // Spinner element
        spinner = findViewById(R.id.spinner);
        // Spinner click listener
        spinner.setOnItemSelectedListener(this);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.activity_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        spinnerIndex = position;
        // On selecting a spinner item
        //item = parent.getItemAtPosition(position).toString();
        // Showing selected spinner item
    }
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }

    public void sendMessage(View view){
        if(check()){
            Intent intent = new Intent(this, Preferences.class);
            boolean gender = female.isChecked();
            double age = Double.parseDouble(ageView.getText().toString());
            double weight = Double.parseDouble(weightView.getText().toString());
            double height = Double.parseDouble(heightView.getText().toString());
            //int exercise = 2; // TODO
            //System.out.println(caloriesPerMeal(gender, age, weight, height, exercise));
            intent.putExtra("Info", caloriesPerMeal(gender, age, weight, height, spinnerIndex).toString());
            startActivity(intent);
        } else {
            Toast.makeText(this,"Please make sure all the fields are filled in correctly", Toast.LENGTH_SHORT).show();
        }
    }

    public boolean check(){
        return (male.isChecked() || female.isChecked()) && !ageView.getText().toString().isEmpty() && !weightView.getText().toString().isEmpty() && !heightView.getText().toString().isEmpty() && spinnerIndex != -1;
    }

    public Double caloriesPerMeal(boolean gender, double age, double weight, double height, int exercise){
        double xFact;
        if (exercise == 0) xFact = 1.2;
        else if (exercise == 1) xFact = 1.375;
        else if (exercise == 2) xFact = 1.55;
        else if (exercise == 3) xFact = 1.725;
        else if (exercise == 4) xFact = 1.9;
        else return -1.0;

        /*if (gender){
            return .26*(10*weight + 6.25*height - 5*age - 161)*xFact;
        } else{
            return .26*(10*weight + 6.25*height - 5*age + 5)*xFact;
        }*/

        return .32 * (10 * weight + 6.25 * height - 5 * age + (gender ? 5 : -161)) * xFact;
    }
}
