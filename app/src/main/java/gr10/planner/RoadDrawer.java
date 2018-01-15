package gr10.planner;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.JointType;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.gms.maps.model.RoundCap;

import java.util.ArrayList;

public class RoadDrawer {

    private GoogleMap map;
    private String locations;

    public RoadDrawer(GoogleMap googleMap, String locations) {
        this.map = googleMap;
        this.locations = locations;
    }

    public void draw() {
        if (locations.length() != 0) {
            String[] locationsStr = locations.split(";");
            ArrayList<LatLng> locationsLatLng = new ArrayList<>();
            for (String i : locationsStr) {
                String[] tmp = i.split(",");
                locationsLatLng.add(new LatLng(Double.valueOf(tmp[1]), Double.valueOf(tmp[0])));
            }

            map.moveCamera(CameraUpdateFactory.newLatLngZoom(locationsLatLng.get(0), 17.0f));

            PolylineOptions polylineOptions = new PolylineOptions().clickable(true).addAll(locationsLatLng).color(R.color.colorPrimaryDark);
            Polyline polyline = map.addPolyline(polylineOptions);
            polyline.setJointType(JointType.ROUND);
            polyline.setStartCap(new RoundCap());
            polyline.setEndCap(new RoundCap());
        }
    }
}
