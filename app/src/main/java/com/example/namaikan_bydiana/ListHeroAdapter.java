package com.example.namaikan_bydiana;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class ListHeroAdapter extends RecyclerView.Adapter<ListHeroAdapter.ListViewHolder> {



    private ArrayList<Hero> listHero;
    private Context context;
    private Activity activity;
    private RelativeLayout ItemList;

    public ListHeroAdapter(Context context, Activity activity) {
        this.context = context;
        this.activity = activity;
    }

    public ListHeroAdapter(ArrayList<Hero> list) {
        this.listHero = list;
    }




    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_row_hero, viewGroup, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListViewHolder holder, int position) {
        final Hero hero = listHero.get(position);
        Glide.with(holder.itemView.getContext())
                .load(hero.getPhoto())
                .apply(new RequestOptions().override(55, 55))
                .into(holder.imgPhoto);
        holder.tvName.setText(hero.getName());
        holder.tvDetail.setText(hero.getDetail());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, hero.getName(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, detail_aktivity.class);
                intent.putExtra("name", hero.getName());
                intent.putExtra("detail", hero.getDetail());
                intent.putExtra("photo", hero.getPhoto());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return listHero.size();
    }

    public void startactivity(Intent intent){

    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvName, tvDetail;

        ListViewHolder(View itemView) {
            super(itemView);

            context = itemView.getContext();

            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvDetail = itemView.findViewById(R.id.tv_item_detail);
            ItemList=itemView.findViewById(R.id.item_row_hero);


    /*        itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, detail_aktivity.class);
                    intent.putExtra("name", hero.getName());
                    intent.putExtra("detail", hero.getDetail());
                    intent.putExtra("photo", hero.getPhoto());
                    context.startActivity(intent);
                }
            });*/


        }


     /*   public interface OnItemClickCallback {
            void onItemClicked(Hero data);
        } */

      //  @Override
      //  public void onClick(View view){
           // Intent intent = new Intent(context, )
        //}

    }


}
