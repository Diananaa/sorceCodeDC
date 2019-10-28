package com.example.namaikan_bydiana;

import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class detail_aktivity extends AppCompatActivity {
    private RecyclerView RvImgItemPhoto;
    private ArrayList<Hero> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_aktivity);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ImageView gambar = (ImageView) findViewById(R.id.img_item_photo);
        TextView nama = (TextView) findViewById(R.id.tv_item_name);
        TextView Detail = (TextView) findViewById(R.id.tv_isi_detail);

        String name = getIntent().getStringExtra("name");
        String detail = getIntent().getStringExtra("detail");
        int photo = getIntent().getIntExtra("photo", 0);

        Glide.with(detail_aktivity.this)
                .load(photo)
               .into(gambar);
        nama.setText(name);
        Detail.setText(detail);




        //CircleImageView civImg_item_photo = findViewById(R.id.img_item_photo);
        //TextView tvItemName = findViewById(R.id.tv_item_name);
        //TextView tvIsiDetail = findViewById(R.id.tv_isi_detail);

        //String name = getIntent().getStringExtra(EXTRA_NAME);
       // String detail = getIntent().getStringExtra(EXTRA_DETAIL);

       // String text = "name : "+name+",\ndetail : "+ detail;
        //tvItemName.setText(text);
       // tvIsiDetail.setText(text);


    }


}
