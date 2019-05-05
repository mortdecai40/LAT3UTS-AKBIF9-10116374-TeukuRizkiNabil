package pindah.dicoding.biodata;

/*28-April-2019
    10116396
        Rizki Muhamad Fauzi
            AKB-9*/

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class RicycleActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    ArrayList<String> id = new ArrayList<>();
    ArrayList<String> title = new ArrayList<>();
    ArrayList<String> description = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ricycle);

        id.clear();
        title.clear();
        description.clear();

        id.add("1");
        title.add("CodeCry");
        description.add("CodeCry is a Code Repository comprised of codes from C, C++");

        id.add("2");
        title.add("TechRead");
        description.add("Read, Enjoy And Discover technology news & information");

        id.add("3");
        title.add("Techlines");
        description.add("Techlines brings you Tech News in one line.");

        id.add("4");
        title.add("Hackers Dictionary");
        description.add("Dictionary for Hackers. Anyone can contribute.");

        id.add("5");
        title.add("CyberChoco");
        description.add("Cyberchoco is an upcoming release");

        id.add("6");
        title.add("Tutorials Now");
        description.add("An Aroliant Training Initiative, android development");

        recyclerView = findViewById(R.id.recycler_view);
        mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));

        mAdapter = new RecyclerAdapter(getApplicationContext(), id, title, description);
        recyclerView.setAdapter(mAdapter);
    }
}
