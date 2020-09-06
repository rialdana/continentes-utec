package sv.edu.utec.miscontinentes.adapters;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import sv.edu.utec.miscontinentes.R;
import sv.edu.utec.miscontinentes.models.Country;
import sv.edu.utec.miscontinentes.models.NaturalDestination;
public class NaturalDestAdapter extends  RecyclerView.Adapter<NaturalDestAdapter.NaturalDestViewHolder>{
    private List<NaturalDestination> destinations;
    private int select;
    public NaturalDestAdapter(List<NaturalDestination> destinations, int type) {
        this.destinations = destinations;
        this.select = type;
    }
    @NonNull
    @Override
    public NaturalDestAdapter.NaturalDestViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_destination, null, false);
        return new NaturalDestAdapter.NaturalDestViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull final NaturalDestAdapter.NaturalDestViewHolder holder, int position) {
        holder.bindData(destinations.get(position));
    }
    @Override
    public int getItemCount() {
        return destinations.size();
    }
    public class NaturalDestViewHolder extends RecyclerView.ViewHolder {
        private TextView nombre;
        public NaturalDestViewHolder(@NonNull View view) {
            super(view);
            nombre=view.findViewById(R.id.idNombre);
        }
        public void bindData(final NaturalDestination dest) {
            nombre.setText(dest.getName());
        }
    }
    }

