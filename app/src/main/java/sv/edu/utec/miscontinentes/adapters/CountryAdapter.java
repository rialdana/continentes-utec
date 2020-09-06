package sv.edu.utec.miscontinentes.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import sv.edu.utec.miscontinentes.R;
import sv.edu.utec.miscontinentes.models.Country;


public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.ContryViewHolder> {

    private List<Country> contry;
    private CountryListener listener;
    private int select;
    private int lastSelectedPosition = -1;
    private boolean mAreCheckboxesVisible = false;


    public CountryAdapter(List<Country> Country, CountryListener listener, int slcb) {
        this.contry = Country;
        this.listener = listener;
        this.select = slcb;
    }

    @NonNull
    @Override
    public ContryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_radio_chech_button, null, false);
        return new ContryViewHolder(view);
    }



    @Override
    public void onBindViewHolder(@NonNull CountryAdapter.ContryViewHolder holder, int position) {
        holder.bindData(contry.get(position), listener);
        holder.selectionStateR.setChecked(lastSelectedPosition == position);
        holder.capital.setVisibility(holder.selectionStateR.isChecked() ? View.VISIBLE : View.GONE);
    }

    @Override
    public int getItemCount() {
        return contry.size();
    }

    public class ContryViewHolder extends RecyclerView.ViewHolder {

        public TextView nombre;
        public TextView capital;
        public CheckBox selectionStateC;
        public RadioButton selectionStateR;

        public ContryViewHolder(@NonNull View itemView) {
            super(itemView);
            nombre = itemView.findViewById(R.id.idNombre);
            capital = itemView.findViewById(R.id.Capital);
            capital.setVisibility(View.GONE);
            selectionStateR = itemView.findViewById(R.id.radioButton3);
            selectionStateR.setVisibility(View.GONE);
            selectionStateC = itemView.findViewById(R.id.checkBox3);
            selectionStateC.setVisibility(View.GONE);

            if (select == 1) {
                selectionStateC.setVisibility(View.VISIBLE);
            } else {
                selectionStateR.setVisibility(View.VISIBLE);
            }

        }


        public void bindData(final Country contry, final CountryListener listener) {
            nombre.setText(contry.getName());
            capital.setText("Capital: "+contry.getCapital());

            selectionStateR.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    listener.selectCountry(contry);


                    lastSelectedPosition = getAdapterPosition();
                    notifyDataSetChanged();

                }

            });

            selectionStateC.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.selectCountry(contry);
                    if(selectionStateC.isChecked()){
                        capital.setVisibility(view.VISIBLE);
                    }else{
                        capital.setVisibility(view.GONE);
                    }

                }
            });
        }

    }
}
