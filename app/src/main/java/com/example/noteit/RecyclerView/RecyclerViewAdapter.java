package com.example.noteit.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.noteit.R;
import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private SelectListener listener;
    private ArrayList<Data> arrayList;
    public RecyclerViewAdapter(ArrayList<Data> arrayList,SelectListener listener) {
        this.arrayList = arrayList;
        this.listener=listener;
    }
    
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.template,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
          holder.header.setText(arrayList.get(position).getHeading());
          holder.desc.setText(arrayList.get(position).getDescription());

          holder.cardView.setOnClickListener(v-> listener.onItemClicked(arrayList.get(position)));
    }
    @Override
    public int getItemCount() {
        return arrayList.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView header,desc;
        CardView cardView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView=itemView.findViewById(R.id.cardView);
            header=itemView.findViewById(R.id.txtHeader);
            desc=itemView.findViewById(R.id.txtDesc);
        }
    }
}
