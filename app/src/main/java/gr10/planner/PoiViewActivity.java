package gr10.planner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class PoiViewActivity extends AppCompatActivity {

    String poiName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poi_view);
        Bundle extras = getIntent().getExtras();
        if(extras !=null)
        {
            poiName = extras.getString("PersonID");
        }
    }
}
