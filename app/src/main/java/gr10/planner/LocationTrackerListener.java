package gr10.planner;

import android.location.Location;

/**
 * Created by Przemcio on 2017-12-04.
 */

public interface LocationTrackerListener {
    void onLocationChanged(Location l);
}
