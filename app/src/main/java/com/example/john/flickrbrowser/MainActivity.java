package com.example.john.flickrbrowser;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = "MainActivity";
    private List<Photo> mPhotosList = new ArrayList<Photo>();
    private RecyclerView mRecyclerView;
    private FlickrRecylerViewAdapter flickrRecylerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        GetRawData theRawData = new GetRawData("https://api.flickr.com/services/feeds/photos_public.gne?tags=nintendo,switch&format=json&lang=en-us&nojsoncallback=1");
        GetFlickrJsonData jsonData = new GetFlickrJsonData("nintendo, switch, nintendoswitch, zelda, botw", true);
        jsonData.execute();
    }

    public class ProcessPhotos extends GetFlickrJsonData {
        public ProcessPhotos(String searchCriteria, boolean matchAll) {
            super(searchCriteria, matchAll);
        }

        public void execute() {
            super.execute();
            ProcessData processData = new ProcessData();
            processData.execute();
        }

        public class ProcessData extends DownloadJsonData {

            protected void onPostExecute(String webData) {
                super.onPostExecute(webData);
                flickrRecylerViewAdapter = new FlickrRecylerViewAdapter(MainActivity.this, getMPhotos());
                mRecyclerView.setAdapter(flickrRecylerViewAdapter);
            }
        }
    }
}
