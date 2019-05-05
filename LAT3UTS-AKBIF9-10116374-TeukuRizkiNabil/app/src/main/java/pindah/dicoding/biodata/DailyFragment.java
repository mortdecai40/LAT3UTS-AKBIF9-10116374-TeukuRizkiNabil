package pindah.dicoding.biodata;

/*28-April-2019
    10116396
        Rizki Muhamad Fauzi
            AKB-9*/

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class DailyFragment extends Fragment  {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    ArrayList<String> id = new ArrayList<>();
    ArrayList<String> title = new ArrayList<>();
    ArrayList<String> description = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_ricycle, container, false);

        id.clear();
        title.clear();
        description.clear();

        id.add("1");
        title.add("Membaca");
        description.add("Membaca buku menarik Pada waktu sengang  ");

        id.add("2");
        title.add("Menyapu");
        description.add("Menyapu setiap Bangun tidur");

        id.add("3");
        title.add("Mengepel");
        description.add("Mengepel kotoran .");

        id.add("4");
        title.add("Mencuci Baju");
        description.add("Membersihkan Pakaina Tiap seminggu");

        id.add("5");
        title.add("Mebersihkan Kamar");
        description.add("Mebersihkan Kamar pada saat bangun Tidur");

        id.add("6");
        title.add("Olahraga");
        description.add("Lari pagi tiaphari minggu di gasibu");


        recyclerView = view.findViewById(R.id.recycler_view);
        mLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new RecyclerAdapter(getActivity().getApplicationContext(), id, title, description);
        recyclerView.setAdapter(mAdapter);

        return view;
    }

}
