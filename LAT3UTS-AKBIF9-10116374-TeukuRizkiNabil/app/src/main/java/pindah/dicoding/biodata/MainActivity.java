package pindah.dicoding.biodata;

/*28-April-2019
    10116396
        Rizki Muhamad Fauzi
            AKB-9*/

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private int delay = 4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intent = new Intent(MainActivity.this, OnBoardingActivity.class);
                startActivity(intent);
                finish();
            }
        },delay);

    }
}
