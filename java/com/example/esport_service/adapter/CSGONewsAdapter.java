package com.example.esport_service.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.esport_service.CSGOPage;
import com.example.esport_service.ClashRoyalePage;
import com.example.esport_service.R;

public class CSGONewsAdapter extends RecyclerView.Adapter<CSGONewsAdapter.CSGONewsViewHolder> {

    String data1[], data2[], data3[], data4[];
    int images[];
    Context context;

    public CSGONewsAdapter(Context ct, String s1[], String s2[], int img[], String s3[], String s4[]){
        context = ct;
        data1 = s1;
        data2 = s2;
        images = img;
        data3 = s3;
        data4 = s4;
    }

    @NonNull
    @Override
    public CSGONewsAdapter.CSGONewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.csgonews_row, parent, false);
        return new CSGONewsAdapter.CSGONewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CSGONewsAdapter.CSGONewsViewHolder holder, int position) {
        holder.csText1.setText(data1[position]);
        holder.csText2.setText(data2[position]);
        holder.csImage.setImageResource(images[position]);

        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, CSGOPage.class);
                intent.putExtra("data3", data3[position]);
                intent.putExtra("data4", data4[position]);
                intent.putExtra("csImage", images[position]);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    public class CSGONewsViewHolder extends RecyclerView.ViewHolder{

        TextView csText1, csText2;
        ImageView csImage;
        ConstraintLayout mainLayout;

        public CSGONewsViewHolder(@NonNull View itemView){
            super(itemView);
            csText1 = itemView.findViewById(R.id.csText1);
            csText2 = itemView.findViewById(R.id.csText2);
            csImage = itemView.findViewById(R.id.csImage);
            mainLayout = itemView.findViewById(R.id.mainLayout);
        }
    }
}
