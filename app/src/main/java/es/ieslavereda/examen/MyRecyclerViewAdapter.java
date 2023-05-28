package es.ieslavereda.examen;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder> {


    private List<String> values;
    private LayoutInflater inflater;
    private Context context;

    public MyRecyclerViewAdapter(@NonNull Context context) {
        this.context = context;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        values = new ArrayList<>();
    }
    public void insertValue(String value){
        values.add(value);
        notifyItemInserted(values.size());
    }

    @NonNull
    @Override
    public MyRecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.simple_element,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyRecyclerViewAdapter.MyViewHolder holder, int position) {
        holder.tvId.setText(String.valueOf(position));
        holder.tvValue.setText(values.get(position));
        holder.updateBackground(context.getResources().getColor((position%2==0)?R.color.recycler_even:R.color.recycler_odd, context.getTheme()));
    }

    @Override
    public int getItemCount() {
        return values.size();
    }



    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tvId;
        TextView tvValue;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvId = itemView.findViewById(R.id.tvId);
            tvValue = itemView.findViewById(R.id.tvValue);
        }
        public void updateBackground(int color){
            itemView.setBackgroundColor(color);
        }
    }
}
