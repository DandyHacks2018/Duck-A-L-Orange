package dandy2018.duckalorange;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button button;
    RadioButton male;
    RadioButton female;
    EditText ageView;
    EditText weightView;
    EditText heightView;
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
    }
    public void sendMessage(View view){
        if(check()){
            Intent intent = new Intent(this, Preferences.class);
            boolean gender = female.isChecked();
            double age = Double.parseDouble(ageView.getText().toString());
            double weight = Double.parseDouble(weightView.getText().toString());
            double height = Double.parseDouble(heightView.getText().toString());
            System.out.println(calories(gender, age, weight, height));
            intent.putExtra("User info", calories(gender, age, weight, height));
            startActivity(intent);
        } else {
            Toast.makeText(this,"Please make sure all the fields are filled in correctly", Toast.LENGTH_SHORT).show();
        }
    }
    public boolean check(){
        return (male.isChecked() || female.isChecked()) && !ageView.getText().toString().equals("") && !weightView.getText().toString().equals("") && !heightView.getText().toString().equals("");
    }
    public double calories(boolean gender, double age, double weight, double height){
        if (gender){
            return 10*weight + 6.25*height - 5*age - 161;
        } else{
            return 10*weight + 6.25*height - 5*age + 5;
        }
    }
}
