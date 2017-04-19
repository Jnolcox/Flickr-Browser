package com.example.john.flickrbrowser;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GetRawData theRawData = new GetRawData("https://api.flickr.com/services/feeds/photos_public.gne?tags=nintendo,switch&format=json&lang=en-us&nojsoncallback=1");
        GetFlickrJsonData jsonData = new GetFlickrJsonData("nintendo, switch, nintendoswitch, zelda, botw", true);
        jsonData.execute();
    }
}
