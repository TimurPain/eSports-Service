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

import com.example.esport_service.ClashRoyalePage;
import com.example.esport_service.FortnitePage;
import com.example.esport_service.R;

public class FortniteNewsAdapter extends RecyclerView.Adapter<FortniteNewsAdapter.FortniteNewsViewHolder> {

    String data1[], data2[], data3[], data4[];
    int images[];
    Context context;

    public FortniteNewsAdapter(Context ct, String s1[], String s2[], int img[], String s3[], String s4[]){
        context = ct;
        data1 = s1;
        data2 = s2;
        images = img;
        data3 = s3;
        data4 = s4;
    }

    @NonNull
    @Override
    public FortniteNewsAdapter.FortniteNewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.fortnite_news_row, parent, false);
        return new FortniteNewsAdapter.FortniteNewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FortniteNewsAdapter.FortniteNewsViewHolder holder, int position) {
        holder.fnText1.setText(data1[position]);
        holder.fnText2.setText(data2[position]);
        holder.fnImage.setImageResource(images[position]);

        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, FortnitePage.class);
                intent.putExtra("data3", data3[position]);
                intent.putExtra("data4", data4[position]);
                intent.putExtra("fnImage", images[position]);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    public class FortniteNewsViewHolder extends RecyclerView.ViewHolder{

        TextView fnText1, fnText2;
        ImageView fnImage;
        ConstraintLayout mainLayout;

        public FortniteNewsViewHolder(@NonNull View itemView){
            super(itemView);
            fnText1 = itemView.findViewById(R.id.fnText1);
            fnText2 = itemView.findViewById(R.id.fnText2);
            fnImage = itemView.findViewById(R.id.fnImage);
            mainLayout = itemView.findViewById(R.id.mainLayout);
        }
    }
}
