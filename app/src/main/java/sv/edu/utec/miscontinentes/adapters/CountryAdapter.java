package sv.edu.utec.miscontinentes.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import sv.edu.utec.miscontinentes.R;
import sv.edu.utec.miscontinentes.models.Country;


public class ContryAdapter extends RecyclerView.Adapter<ContryAdapter.ContryViewHolder> {

    private List<Country> continents;
    private ContriListener listener;

    public ContryAdapter(List<Country> contry, ContriListener listener) {
        this.continents = contry;
        this.listener = listener;
    }


    @NonNull
    @Override
    public ContryAdapter.ContryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_radio_chech_button, parent, false);
        return new ContryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContryAdapter.ContryViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return continents.size();
    }

    public class ContryViewHolder extends RecyclerView.ViewHolder {

        public TextView nombre;
        public RadioButton selectionState;

        public ContryViewHolder(@NonNull View itemView) {
            super(itemView);
            nombre = itemView.findViewById(R.id.idNombre);
            selectionState =itemView.findViewById(R.id.radioButton3);

        }



    }
}
