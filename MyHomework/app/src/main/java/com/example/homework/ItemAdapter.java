package com.example.homework;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONObject;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {

    JSONArray jsonArray;
    Context context;

    public ItemAdapter(JSONArray jsonArray, Context context) {
        this.jsonArray = jsonArray;
        this.context = context;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        try {
            JSONObject jobj = jsonArray.getJSONObject(position);
            holder.context = context;
            JSONObject jobjAvatar = new JSONObject(jobj.getString("avatar"));
            holder.textUserName.setText(jobj.getString("username"));
            holder.textEmail.setText(jobj.getString("email"));
            Log.v("TAG", jobjAvatar.getString("thumbnail"));
            Picasso.get().load("https://lebavui.github.io/" + jobjAvatar.getString("thumbnail")).into(holder.imageAvata);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return jsonArray.length();
    }

    class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        ImageView imageAvata;
        TextView textUserName;
        TextView textEmail;
        Context context;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            imageAvata = itemView.findViewById(R.id.image_avata);
            textUserName = itemView.findViewById(R.id.username);
            textEmail = itemView.findViewById(R.id.text_email);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(context, DetailActivity.class);
            intent.putExtra("id",getAdapterPosition());
            context.startActivities(new Intent[]{intent});
        }

    }

}
