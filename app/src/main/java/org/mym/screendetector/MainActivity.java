package org.mym.screendetector;

import android.graphics.Point;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView tvResult = (TextView) findViewById(R.id.main_tv_result);

        WindowManager wm = (WindowManager)getSystemService(WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();

        Point point = new Point();
        display.getSize(point);
        Point realPoint = new Point();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1){
            display.getRealSize(realPoint);
        }

        DisplayMetrics dm = new DisplayMetrics();
        DisplayMetrics realDm = new DisplayMetrics();
        display.getMetrics(dm);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            display.getRealMetrics(realDm);
        }

        tvResult.setText(getString(R.string.main_detect_result, point.x, point.y,
                realPoint.x, realPoint.y,
                dm.widthPixels, dm.heightPixels, dm.density, dm.densityDpi,
                realDm.widthPixels, realDm.heightPixels, realDm.density, realDm.densityDpi));

    }
}
