package com.example.note;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterClass1 extends RecyclerView.Adapter<AdapterClass1.HolderClass> {
    private final RecyclerViewInterface recyclerViewInterface;
    ArrayList <HelperClass1> helperClass1;

    public AdapterClass1(ArrayList<HelperClass1> helperClass1, MainActivity2 mainActivity2 , RecyclerViewInterface recyclerViewInterface) {
        this.helperClass1 = helperClass1;
        this.recyclerViewInterface = recyclerViewInterface;
    }

    @NonNull
    @Override
    public AdapterClass1.HolderClass onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.note_item,parent,false);
        HolderClass holderClass1 = new HolderClass(v , recyclerViewInterface);
        return holderClass1;
    }

    @Override
    public void onBindViewHolder(@NonNull HolderClass holder, int position) {
        HelperClass1 helperClass2 = helperClass1.get(position);
        holder.s1.setText(helperClass2.getS1());
        holder.s2.setText(helperClass2.getS2());

    }

    @Override
    public int getItemCount() {
        return helperClass1.size();
    }

    public  static class HolderClass extends RecyclerView.ViewHolder {
    TextView s1,s2;
        public HolderClass(@NonNull View itemView , RecyclerViewInterface recyclerViewInterface) {
            super(itemView);
            s1 =itemView.findViewById(R.id.TextView1_item);
            s2=itemView.findViewById(R.id.TextView2_item);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (recyclerViewInterface != null){
                        int pos = getAdapterPosition();
                        if (pos != RecyclerView.NO_POSITION){
                            recyclerViewInterface.ItemClick(pos);
                        }
                    }
                }
            });
        }
    }
}


