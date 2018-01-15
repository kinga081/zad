package gr10.planner;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.google.android.gms.maps.model.PointOfInterest;

public class POIInteraction {

    public void doIt(Context context, PointOfInterest poi) {
        Toast.makeText(context, "Kliknięto: " +
                        poi.name,
                Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(context, PoiViewActivity.class);
        intent.putExtra("PoiName", poi.name);
        context.startActivity(intent);
    }
}
