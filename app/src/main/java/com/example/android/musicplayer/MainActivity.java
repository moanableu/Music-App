package com.example.android.musicplayer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import static com.example.android.musicplayer.IndochineSongList.songs;

/**
 * Implemented using supporting information from SitePoint
 * https://www.sitepoint.com/transfer-data-between-activities-with-android-parcelable/
 */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // array list for activity one
        new ArtistList();
        //get parcelable data
        final Indochine data = new Indochine();

        final ArtistAdapter adapter = new ArtistAdapter(this, ArtistList.artists);

        GridView mainView = findViewById(R.id.main_view);
        mainView.setAdapter(adapter);

        mainView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView <?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, Album.class);
                if (getIntent() != null){
                    intent.putExtra("position", position);
                    intent.putParcelableArrayListExtra("dataKey", songs); // access to array via parcelable class
                }
                startActivity(intent);
            }
        });

    }
}
