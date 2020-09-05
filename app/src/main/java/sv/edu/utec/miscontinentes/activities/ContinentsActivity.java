package sv.edu.utec.miscontinentes.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import sv.edu.utec.miscontinentes.R;
import sv.edu.utec.miscontinentes.adapters.ContinentsAdapter;
import sv.edu.utec.miscontinentes.adapters.ContinentsListener;
import sv.edu.utec.miscontinentes.models.Continent;
import sv.edu.utec.miscontinentes.models.Country;
import sv.edu.utec.miscontinentes.models.NaturalDestination;

import static sv.edu.utec.miscontinentes.Constants.SELECTED_CONTINENT;
import static sv.edu.utec.miscontinentes.Constants.SELECTED_FILTER_TYPE;
import static sv.edu.utec.miscontinentes.Constants.SELECTED_NATURAL_DESTINATION;
import static sv.edu.utec.miscontinentes.Constants.SHOW_CHECKBOX;
import static sv.edu.utec.miscontinentes.Constants.SHOW_LAKES;
import static sv.edu.utec.miscontinentes.Constants.SHOW_RADIO_GROUPS;
import static sv.edu.utec.miscontinentes.Constants.SHOW_RIVERS;
import static sv.edu.utec.miscontinentes.Constants.SHOW_VOLCANOES;

public class ContinentsActivity extends AppCompatActivity implements ContinentsListener {

    private Button mButtonContinue;
    private Spinner mSpinnerFilterType;
    private RecyclerView mRecyclerViewContinents;
    private RadioGroup mRadioGroupSelectedNaturalDestination;
    private Toolbar mToolbar;

    private int selectedFilterType = SHOW_RADIO_GROUPS;
    private int selectedNaturalDestination = SHOW_RIVERS;
    private Continent selectedContinent = null;

    private List<Continent> myContinents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_continents);

        bindViews();
        setListeners();
        myContinents = loadContinents();

        mRecyclerViewContinents.setAdapter(new ContinentsAdapter(myContinents, this));
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void bindViews() {
        mButtonContinue = findViewById(R.id.button_continue);
        mSpinnerFilterType = findViewById(R.id.spinner_filter_capitals);
        mRecyclerViewContinents = findViewById(R.id.recycler_view_continents);
        mRadioGroupSelectedNaturalDestination = findViewById(R.id.radio_group_natural_destinations);
        mToolbar = findViewById(R.id.toolbar_continents);
    }

    private void setListeners() {
        mRadioGroupSelectedNaturalDestination.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int id) {
                switch (id) {
                    case R.id.radio_button_lakes: {
                        selectedNaturalDestination = SHOW_LAKES;
                        break;
                    }
                    case R.id.radio_button_rivers: {
                        selectedNaturalDestination = SHOW_RIVERS;
                        break;
                    }
                    case R.id.radio_button_volcanoes: {
                        selectedNaturalDestination = SHOW_VOLCANOES;
                        break;
                    }
                }
            }
        });

        mSpinnerFilterType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                if (position == 0) {
                    selectedFilterType = SHOW_RADIO_GROUPS;
                } else {
                    selectedFilterType = SHOW_CHECKBOX;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                //
            }
        });

        mButtonContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (selectedContinent == null) {
                    showToast("Por favor selecciona un continente antes de continuar");
                } else {
                    Intent intent = new Intent(ContinentsActivity.this, ContinentInfoActivity.class);

                    intent.putExtra(SELECTED_FILTER_TYPE, selectedFilterType);
                    intent.putExtra(SELECTED_NATURAL_DESTINATION, selectedNaturalDestination);
                    intent.putExtra(SELECTED_CONTINENT, selectedContinent);

                    startActivity(intent);
                }
            }
        });
    }

    private List<Continent> loadContinents() {
        List<Continent> continents = new ArrayList<>();

        /**
         * AMERICA
         */
        Continent america = new Continent();
        america.setName("America");
        america.setImage("https://www.turismonuevayork.com/wp-content/uploads/2014/09/La-Estatua-de-la-Libertad-en-Nueva-York-760x500.jpg");

        List<Country> americaCountries = new ArrayList<>();
        americaCountries.add(new Country("El Salvador", "San Salvador"));
        americaCountries.add(new Country("El Salvador", "San Salvador"));
        americaCountries.add(new Country("El Salvador", "San Salvador"));
        americaCountries.add(new Country("El Salvador", "San Salvador"));
        americaCountries.add(new Country("El Salvador", "San Salvador"));
        americaCountries.add(new Country("El Salvador", "San Salvador"));
        americaCountries.add(new Country("El Salvador", "San Salvador"));

        List<NaturalDestination> americaRivers = new ArrayList<>();
        americaRivers.add(new NaturalDestination("Lempa", "n/a"));
        americaRivers.add(new NaturalDestination("Lempa", "n/a"));
        americaRivers.add(new NaturalDestination("Lempa", "n/a"));
        americaRivers.add(new NaturalDestination("Lempa", "n/a"));
        americaRivers.add(new NaturalDestination("Lempa", "n/a"));

        List<NaturalDestination> americaLakes = new ArrayList<>();
        americaLakes.add(new NaturalDestination("Coatepeque", "n/a"));
        americaLakes.add(new NaturalDestination("Coatepeque", "n/a"));
        americaLakes.add(new NaturalDestination("Coatepeque", "n/a"));
        americaLakes.add(new NaturalDestination("Coatepeque", "n/a"));
        americaLakes.add(new NaturalDestination("Coatepeque", "n/a"));

        List<NaturalDestination> americaVolcanoes = new ArrayList<>();
        americaVolcanoes.add(new NaturalDestination("Chaparrastique", "n/a"));
        americaVolcanoes.add(new NaturalDestination("Chaparrastique", "n/a"));
        americaVolcanoes.add(new NaturalDestination("Chaparrastique", "n/a"));
        americaVolcanoes.add(new NaturalDestination("Chaparrastique", "n/a"));
        americaVolcanoes.add(new NaturalDestination("Chaparrastique", "n/a"));

        america.setCountries(americaCountries);
        america.setRivers(americaRivers);
        america.setLakes(americaLakes);
        america.setVolcanoes(americaVolcanoes);

        /**
         * EUROPA
         */
        Continent europa = new Continent();
        europa.setName("Europa");
        europa.setImage("https://www.toureiffel.paris/sites/default/files/actualite/image_principale/IMG_20200526_123909.jpg");

        List<Country> europaCountries = new ArrayList<>();
        europaCountries.add(new Country("El Salvador", "San Salvador"));
        europaCountries.add(new Country("El Salvador", "San Salvador"));
        europaCountries.add(new Country("El Salvador", "San Salvador"));
        europaCountries.add(new Country("El Salvador", "San Salvador"));
        europaCountries.add(new Country("El Salvador", "San Salvador"));
        europaCountries.add(new Country("El Salvador", "San Salvador"));
        europaCountries.add(new Country("El Salvador", "San Salvador"));

        List<NaturalDestination> europaRivers = new ArrayList<>();
        europaRivers.add(new NaturalDestination("Lempa", "n/a"));
        europaRivers.add(new NaturalDestination("Lempa", "n/a"));
        europaRivers.add(new NaturalDestination("Lempa", "n/a"));
        europaRivers.add(new NaturalDestination("Lempa", "n/a"));
        europaRivers.add(new NaturalDestination("Lempa", "n/a"));

        List<NaturalDestination> europaLakes = new ArrayList<>();
        europaLakes.add(new NaturalDestination("Coatepeque", "n/a"));
        europaLakes.add(new NaturalDestination("Coatepeque", "n/a"));
        europaLakes.add(new NaturalDestination("Coatepeque", "n/a"));
        europaLakes.add(new NaturalDestination("Coatepeque", "n/a"));
        europaLakes.add(new NaturalDestination("Coatepeque", "n/a"));

        List<NaturalDestination> europaVolcanoes = new ArrayList<>();
        europaVolcanoes.add(new NaturalDestination("Chaparrastique", "n/a"));
        europaVolcanoes.add(new NaturalDestination("Chaparrastique", "n/a"));
        europaVolcanoes.add(new NaturalDestination("Chaparrastique", "n/a"));
        europaVolcanoes.add(new NaturalDestination("Chaparrastique", "n/a"));
        europaVolcanoes.add(new NaturalDestination("Chaparrastique", "n/a"));

        europa.setCountries(europaCountries);
        europa.setRivers(europaRivers);
        europa.setLakes(europaLakes);
        europa.setVolcanoes(europaVolcanoes);

        /**
         * AFRICA
         */
        Continent africa = new Continent();
        africa.setName("África");
        africa.setImage("https://cdn2.wanderlust.co.uk/media/1061/dreamstime_xxl_80975530.jpg?anchor=center&mode=crop&width=1200&height=0&rnd=132030046790000000");

        List<Country> africaCountries = new ArrayList<>();
        africaCountries.add(new Country("El Salvador", "San Salvador"));
        africaCountries.add(new Country("El Salvador", "San Salvador"));
        africaCountries.add(new Country("El Salvador", "San Salvador"));
        africaCountries.add(new Country("El Salvador", "San Salvador"));
        africaCountries.add(new Country("El Salvador", "San Salvador"));
        africaCountries.add(new Country("El Salvador", "San Salvador"));
        africaCountries.add(new Country("El Salvador", "San Salvador"));

        List<NaturalDestination> africaRivers = new ArrayList<>();
        africaRivers.add(new NaturalDestination("Lempa", "n/a"));
        africaRivers.add(new NaturalDestination("Lempa", "n/a"));
        africaRivers.add(new NaturalDestination("Lempa", "n/a"));
        africaRivers.add(new NaturalDestination("Lempa", "n/a"));
        africaRivers.add(new NaturalDestination("Lempa", "n/a"));

        List<NaturalDestination> africaLakes = new ArrayList<>();
        africaLakes.add(new NaturalDestination("Coatepeque", "n/a"));
        africaLakes.add(new NaturalDestination("Coatepeque", "n/a"));
        africaLakes.add(new NaturalDestination("Coatepeque", "n/a"));
        africaLakes.add(new NaturalDestination("Coatepeque", "n/a"));
        africaLakes.add(new NaturalDestination("Coatepeque", "n/a"));

        List<NaturalDestination> africaVolcanoes = new ArrayList<>();
        africaVolcanoes.add(new NaturalDestination("Chaparrastique", "n/a"));
        africaVolcanoes.add(new NaturalDestination("Chaparrastique", "n/a"));
        africaVolcanoes.add(new NaturalDestination("Chaparrastique", "n/a"));
        africaVolcanoes.add(new NaturalDestination("Chaparrastique", "n/a"));
        africaVolcanoes.add(new NaturalDestination("Chaparrastique", "n/a"));

        africa.setCountries(africaCountries);
        africa.setRivers(africaRivers);
        africa.setLakes(africaLakes);
        africa.setVolcanoes(africaVolcanoes);

        /**
         * ASIA
         */
        Continent asia = new Continent();
        asia.setName("Asia");
        asia.setImage("https://blogs.griffith.edu.au/asiainsights/wp-content/uploads/sites/2/2018/11/cities-900x500-1000x0-c-default.jpg");

        List<Country> asiaCountries = new ArrayList<>();
        asiaCountries.add(new Country("El Salvador", "San Salvador"));
        asiaCountries.add(new Country("El Salvador", "San Salvador"));
        asiaCountries.add(new Country("El Salvador", "San Salvador"));
        asiaCountries.add(new Country("El Salvador", "San Salvador"));
        asiaCountries.add(new Country("El Salvador", "San Salvador"));
        asiaCountries.add(new Country("El Salvador", "San Salvador"));
        asiaCountries.add(new Country("El Salvador", "San Salvador"));

        List<NaturalDestination> asiaRivers = new ArrayList<>();
        asiaRivers.add(new NaturalDestination("Lempa", "n/a"));
        asiaRivers.add(new NaturalDestination("Lempa", "n/a"));
        asiaRivers.add(new NaturalDestination("Lempa", "n/a"));
        asiaRivers.add(new NaturalDestination("Lempa", "n/a"));
        asiaRivers.add(new NaturalDestination("Lempa", "n/a"));

        List<NaturalDestination> asiaLakes = new ArrayList<>();
        asiaLakes.add(new NaturalDestination("Coatepeque", "n/a"));
        asiaLakes.add(new NaturalDestination("Coatepeque", "n/a"));
        asiaLakes.add(new NaturalDestination("Coatepeque", "n/a"));
        asiaLakes.add(new NaturalDestination("Coatepeque", "n/a"));
        asiaLakes.add(new NaturalDestination("Coatepeque", "n/a"));

        List<NaturalDestination> asiaVolcanoes = new ArrayList<>();
        asiaVolcanoes.add(new NaturalDestination("Chaparrastique", "n/a"));
        asiaVolcanoes.add(new NaturalDestination("Chaparrastique", "n/a"));
        asiaVolcanoes.add(new NaturalDestination("Chaparrastique", "n/a"));
        asiaVolcanoes.add(new NaturalDestination("Chaparrastique", "n/a"));
        asiaVolcanoes.add(new NaturalDestination("Chaparrastique", "n/a"));

        asia.setCountries(asiaCountries);
        asia.setRivers(asiaRivers);
        asia.setLakes(asiaLakes);
        asia.setVolcanoes(asiaVolcanoes);

        /**
         * OCEANIA
         */
        Continent oceania = new Continent();
        oceania.setName("Oceanía");
        oceania.setImage("https://www.todaaustralia.com/wp-content/uploads/2018/07/sidney-sydney-australia-1170x658.jpg");

        List<Country> oceaniaCountries = new ArrayList<>();
        oceaniaCountries.add(new Country("El Salvador", "San Salvador"));
        oceaniaCountries.add(new Country("El Salvador", "San Salvador"));
        oceaniaCountries.add(new Country("El Salvador", "San Salvador"));
        oceaniaCountries.add(new Country("El Salvador", "San Salvador"));
        oceaniaCountries.add(new Country("El Salvador", "San Salvador"));
        oceaniaCountries.add(new Country("El Salvador", "San Salvador"));
        oceaniaCountries.add(new Country("El Salvador", "San Salvador"));

        List<NaturalDestination> oceaniaRivers = new ArrayList<>();
        oceaniaRivers.add(new NaturalDestination("Lempa", "n/a"));
        oceaniaRivers.add(new NaturalDestination("Lempa", "n/a"));
        oceaniaRivers.add(new NaturalDestination("Lempa", "n/a"));
        oceaniaRivers.add(new NaturalDestination("Lempa", "n/a"));
        oceaniaRivers.add(new NaturalDestination("Lempa", "n/a"));

        List<NaturalDestination> oceaniaLakes = new ArrayList<>();
        oceaniaLakes.add(new NaturalDestination("Coatepeque", "n/a"));
        oceaniaLakes.add(new NaturalDestination("Coatepeque", "n/a"));
        oceaniaLakes.add(new NaturalDestination("Coatepeque", "n/a"));
        oceaniaLakes.add(new NaturalDestination("Coatepeque", "n/a"));
        oceaniaLakes.add(new NaturalDestination("Coatepeque", "n/a"));

        List<NaturalDestination> oceaniaVolcanoes = new ArrayList<>();
        oceaniaVolcanoes.add(new NaturalDestination("Chaparrastique", "n/a"));
        oceaniaVolcanoes.add(new NaturalDestination("Chaparrastique", "n/a"));
        oceaniaVolcanoes.add(new NaturalDestination("Chaparrastique", "n/a"));
        oceaniaVolcanoes.add(new NaturalDestination("Chaparrastique", "n/a"));
        oceaniaVolcanoes.add(new NaturalDestination("Chaparrastique", "n/a"));

        oceania.setCountries(oceaniaCountries);
        oceania.setRivers(oceaniaRivers);
        oceania.setLakes(oceaniaLakes);
        oceania.setVolcanoes(oceaniaVolcanoes);

        /**
         * Adding continents
         */
        continents.add(america);
        continents.add(europa);
        continents.add(africa);
        continents.add(asia);
        continents.add(oceania);

        return continents;
    }

    @Override
    public void selectContinent(Continent continent) {
        selectedContinent = continent;
        showToast("Seleccionaste el continente: " + continent.getName());
    }

    public void showToast(String message) {
        Toast.makeText(ContinentsActivity.this, message, Toast.LENGTH_SHORT).show();
    }
}