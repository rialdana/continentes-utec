package sv.edu.utec.miscontinentes.activities;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import sv.edu.utec.miscontinentes.R;
import sv.edu.utec.miscontinentes.adapters.CountryAdapter;
import sv.edu.utec.miscontinentes.adapters.CountryListener;
import sv.edu.utec.miscontinentes.adapters.NaturalDestAdapter;
import sv.edu.utec.miscontinentes.models.Continent;
import sv.edu.utec.miscontinentes.models.Country;
import sv.edu.utec.miscontinentes.models.NaturalDestination;

import static sv.edu.utec.miscontinentes.Constants.SELECTED_CONTINENT;
import static sv.edu.utec.miscontinentes.Constants.SELECTED_FILTER_TYPE;
import static sv.edu.utec.miscontinentes.Constants.SELECTED_NATURAL_DESTINATION;

public class ContinentInfoActivity extends AppCompatActivity implements CountryListener {

    private Continent continent;
    private int filterType;
    private int naturalDestination;
    private RecyclerView listButton,listNatural;
    private List<Country> myCountry;
    private List<NaturalDestination> myNaturaldest;
    private Country selectedCountryt = null;
    private Toolbar mToolbar;
    private TextView dest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_continent_info);

        continent = (Continent) getIntent().getSerializableExtra(SELECTED_CONTINENT);
        filterType = getIntent().getIntExtra(SELECTED_FILTER_TYPE, 0);
        naturalDestination = getIntent().getIntExtra(SELECTED_NATURAL_DESTINATION, 0);

        listButton = findViewById(R.id.list_button_rc);
        mToolbar = findViewById(R.id.toolbar_continents);

        listNatural = findViewById(R.id.listNatural);

        dest=findViewById(R.id.txtDest);

        myCountry = continent.getCountries();
        listButton.setAdapter(new CountryAdapter(myCountry, this, filterType));


        switch (naturalDestination) {
            case 0:
                dest.setText("Lagos");
                myNaturaldest = continent.getLakes();
                break;
            case 1:
                dest.setText("Rios");
                myNaturaldest = continent.getRivers();
                break;
            case 2:
                dest.setText("Volcanes");
                myNaturaldest = continent.getVolcanoes();
                break;
            default:
                dest.setText("");
                break;
        }


        listNatural.setAdapter(new NaturalDestAdapter(myNaturaldest,naturalDestination));






        Log.i("ContinentInfoActivity", "Selected continent: " + continent.getName());
        Log.i("ContinentInfoActivity", "Selected filterType: " + filterType);
        Log.i("ContinentInfoActivity", "Selected naturalDestination: " + naturalDestination);
        //edfertyu

        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


    }

    @Override
    public void selectCountry(Country country, int cantida){
        selectedCountryt = country;
        showToast("Seleccionaste "+ cantida + " Elementos"+ " filtro de lugares"+naturalDestination);
    }

    public void showToast(String message) {
        Toast.makeText(ContinentInfoActivity.this, message, Toast.LENGTH_SHORT-30).show();
    }
}