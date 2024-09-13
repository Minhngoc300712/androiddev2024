package vn.edu.usth.weather;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import android.graphics.Color;
import androidx.fragment.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import vn.edu.usth.weather.R;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ForecastFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ForecastFragment extends Fragment {
    //TODO: using linear layout to display weather info (param: background color, image, weather status)
    //set these param in WeatherActivity (fragid: status(textview): dynamic_text, image(imageview): weather_icon)
    String day;
    String image;
    String background_color;

    public ForecastFragment() {
        // Required empty public constructor
    }

    public static ForecastFragment newInstance(String day, String image, String background_color) {
        ForecastFragment fragment = new ForecastFragment();
        Bundle args = new Bundle();
        args.putString("day", day);
        args.putString("image", image);
        args.putString("background_color", background_color);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_forecast, container, false);
        Bundle args = getArguments();

        if (args != null) {
            day = args.getString("day");
            image = args.getString("image");
            background_color = args.getString("background_color");
            rootView.setBackgroundColor(Color.parseColor(background_color));
            ImageView imageView = (ImageView) rootView.findViewById(R.id.weather_icon);
            imageView.setImageResource(getResources().getIdentifier(image, "drawable", getActivity().getPackageName()));
            TextView textViewStatus = (TextView) rootView.findViewById(R.id.dynamic_text);
            TextView textViewDay = (TextView) rootView.findViewById(R.id.dynamic_text_day);
            textViewDay.setText(day);
            return rootView;
        }
        return rootView;
    }

}