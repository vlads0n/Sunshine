package com.example.android.sunshine.app;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.*;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);

            ArrayList<String> weekForecast = new ArrayList<>();
            weekForecast.add("Today - Sunny - 88/63");
            weekForecast.add("Tomorrow - Foggy - 80/57");
            weekForecast.add("Wednesday - Cloudy - 75/50");
            weekForecast.add("Thursday - Rainy - 70/53");
            weekForecast.add("Friday - Foggy - 70/46");
            weekForecast.add("Saturday - Sunny - 85/66");
            weekForecast.add("Sunday - Sunny - 90/70");

            ArrayAdapter<String> adapter = new ArrayAdapter<>
                    (getActivity(), R.layout.list_item_forecast, R.id.list_item_forecast_textview, weekForecast);

            ListView listView = (ListView) rootView.findViewById(R.id.listview_forecast);
            listView.setAdapter(adapter);

            return rootView;
        }
    }
}
