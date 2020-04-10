package com.example.remarksolutions.MainArea.ExploreFragment;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.remarksolutions.MainArea.ExploreFragment.ShopLayout.ShopLayoutActivity;
import com.example.remarksolutions.Models.ShopModel;
import com.example.remarksolutions.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ShopRecycleAdapter extends RecyclerView.Adapter<ShopRecycleAdapter.ViewHolder>
{

    ArrayList<ShopModel> shops;

    public ShopRecycleAdapter(ArrayList<ShopModel> shops) {
        this.shops = shops;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_shopmodel,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {

        holder.shopName.setText(shops.get(position).getName());
        //Picasso.get().load(shops.get(position).getSrc()).into(holder.imageView);
        holder.itemView.setClickable(true);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(view.getContext(), ShopLayoutActivity.class);
                intent.putExtra("ID",shops.get(position).shopID);


                view.getContext().startActivity(intent);
            }
        });



    }

    @Override
    public int getItemCount() {
        return shops.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {

        TextView shopName;
        ImageView imageView ;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            shopName=itemView.findViewById(R.id.tvShopName);

            imageView = itemView.findViewById(R.id.ivShopImage);
        }
    }

}
