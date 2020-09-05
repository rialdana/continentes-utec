package sv.edu.utec.miscontinentes.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import sv.edu.utec.miscontinentes.R;
import sv.edu.utec.miscontinentes.models.Continent;

import static sv.edu.utec.miscontinentes.Constants.SELECTED_CONTINENT;
import static sv.edu.utec.miscontinentes.Constants.SELECTED_FILTER_TYPE;
import static sv.edu.utec.miscontinentes.Constants.SELECTED_NATURAL_DESTINATION;

public class ContinentInfoActivity extends AppCompatActivity {

    private Continent continent;
    private int filterType;
    private int naturalDestination;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_continent_info);

        continent = (Continent) getIntent().getSerializableExtra(SELECTED_CONTINENT);
        filterType = getIntent().getIntExtra(SELECTED_FILTER_TYPE, 0);
        naturalDestination = getIntent().getIntExtra(SELECTED_NATURAL_DESTINATION, 0);

        Log.i("ContinentInfoActivity", "Selected continent: " + continent.getName());
        Log.i("ContinentInfoActivity", "Selected filterType: " + filterType);
        Log.i("ContinentInfoActivity", "Selected naturalDestination: " + naturalDestination);


    }
}