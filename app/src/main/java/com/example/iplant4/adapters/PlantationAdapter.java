package com.example.iplant4.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.iplant4.R;
import com.example.iplant4.models.Plantation;
import java.util.List;

public class PlantationAdapter extends RecyclerView.Adapter<PlantationAdapter.PlantationViewHolder> {

    private List<Plantation> plantations;
    private Context context;

    public PlantationAdapter(Context context, List<Plantation> plantations) {
        this.context = context;
        this.plantations = plantations;
    }

    @NonNull
    @Override
    public PlantationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.plantation_item, parent, false);
        return new PlantationViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlantationViewHolder holder, int position) {
        Plantation plantation = plantations.get(position);
        holder.nomPlantation.setText(plantation.getName());
        holder.temperature.setText(plantation.getTemperature() + "°C");
        holder.humidite.setText(plantation.getHumidity() + " HR");
        holder.luminosite.setText(plantation.getLuminosity() + " LUX");
    }

    @Override
    public int getItemCount() {
        return plantations.size();
    }

    class PlantationViewHolder extends RecyclerView.ViewHolder {
        TextView nomPlantation, temperature, humidite, luminosite;

        public PlantationViewHolder(@NonNull View itemView) {
            super(itemView);
            nomPlantation = itemView.findViewById(R.id.nomPlantation);
            temperature = itemView.findViewById(R.id.temperature);
            humidite = itemView.findViewById(R.id.humidite);
            luminosite = itemView.findViewById(R.id.luminosite);
        }
    }
}
