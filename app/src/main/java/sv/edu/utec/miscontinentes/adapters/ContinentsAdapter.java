package sv.edu.utec.miscontinentes.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import sv.edu.utec.miscontinentes.R;
import sv.edu.utec.miscontinentes.models.Continent;

public class ContinentsAdapter extends RecyclerView.Adapter<ContinentsAdapter.ContinentsViewHolder> {

    private List<Continent> continents;
    private ContinentsListener listener;

    public ContinentsAdapter(List<Continent> continents, ContinentsListener listener) {
        this.continents = continents;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ContinentsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_continent, parent, false);
        return new ContinentsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContinentsViewHolder holder, int position) {
        holder.bindData(continents.get(position), listener);
    }

    @Override
    public int getItemCount() {
        return continents.size();
    }

    public static class ContinentsViewHolder extends RecyclerView.ViewHolder {

        TextView textViewContinentName;
        ImageView imageViewContinent;
        CardView cardViewContinent;

        public ContinentsViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewContinentName = itemView.findViewById(R.id.text_continent_name);
            imageViewContinent = itemView.findViewById(R.id.image_continent);
            cardViewContinent = itemView.findViewById(R.id.card_view_continent);
        }

        public void bindData(final Continent continent, final ContinentsListener listener) {
            textViewContinentName.setText(continent.getName());
            Glide.with(imageViewContinent.getContext()).load(continent.getImage()).into(imageViewContinent);
            cardViewContinent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.selectContinent(continent);
                }
            });
        }
    }
}
