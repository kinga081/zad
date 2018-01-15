package gr10.planner;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.SensorManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button mapa;
    private SensorManager manager;
    private static final int RECORD_REQUEST_CODE =101 ;
    private static final String TAG ="MainActivity" ;
    private long changeTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manager = (SensorManager) getSystemService(SENSOR_SERVICE);
        int permissionCheck = ContextCompat.checkSelfPermission(this,//pozwolenie
                Manifest.permission.ACCESS_FINE_LOCATION);;
        int permissionCheck2 = ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_COARSE_LOCATION);
        int permissionCheck3 = ContextCompat.checkSelfPermission(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE);

        if (permissionCheck != PackageManager.PERMISSION_GRANTED || permissionCheck2 !=
                PackageManager.PERMISSION_GRANTED || permissionCheck3 !=
                PackageManager.PERMISSION_GRANTED  ) {
            Log.i(TAG, "Permission to record denied");
            makeRequest();
        }

        mapa=(Button)findViewById(R.id.button);
        mapa.setBackgroundResource(R.drawable.icon_map);

        mapa.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mapa.setBackgroundResource(R.drawable.gray_icon);
                changeTime = 300L;
                v.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mapa.setBackgroundResource(R.drawable.icon_map);
                    }
                }, changeTime);

                Intent startNewActivity = new Intent(MainActivity.this, MapsActivity.class);
                startActivity(startNewActivity);
            }
        });
    }

    protected void makeRequest() {
        ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.ACCESS_FINE_LOCATION,
                        Manifest.permission.ACCESS_COARSE_LOCATION,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE
                },
                RECORD_REQUEST_CODE);
    }
}
