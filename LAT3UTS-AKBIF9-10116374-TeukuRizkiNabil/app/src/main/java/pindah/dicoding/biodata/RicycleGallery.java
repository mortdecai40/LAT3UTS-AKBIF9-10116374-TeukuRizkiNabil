package pindah.dicoding.biodata;

/*28-April-2019
    10116396
        Rizki Muhamad Fauzi
            AKB-9*/

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RicycleGallery extends AppCompatActivity {

    List<gallery> lstgallery ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ricycleview_gallery);
/*
        lstgallery = new ArrayList<>();
        lstgallery.add(new gallery("The Vegitarian",R.drawable.header));
        lstgallery.add(new gallery("The Wild Robot",R.drawable.logonya));
        lstgallery.add(new gallery("Maria Semples",R.drawable.ic_account));
        lstgallery.add(new gallery("The Martian",R.drawable.ic_image));*/

        RecyclerView myrv = (RecyclerView) findViewById(R.id.recycler_view);
        RicycleGalleryAdapter myAdapter = new RicycleGalleryAdapter(this,lstgallery);
        myrv.setLayoutManager(new GridLayoutManager(this,2));
        myrv.setAdapter(myAdapter);
    }
}
