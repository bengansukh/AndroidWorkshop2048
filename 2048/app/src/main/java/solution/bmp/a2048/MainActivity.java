package solution.bmp.a2048;

import android.support.v4.view.MotionEventCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private float x1,x2,y1,y2;
    static final int MIN_DISTANCE_L_R = 150;
    static final int MIN_DISTANCE_R_L = -150;

    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        switch(event.getAction())
        {
            case MotionEvent.ACTION_DOWN:
                x1 = event.getX();
                y1 = event.getY();

                break;
            case MotionEvent.ACTION_UP:
                x2 = event.getX();
                y2 = event.getY();

                float deltaX = x2 - x1;
                float deltaY = y2 - y1;
                if (deltaX > MIN_DISTANCE_L_R)
                {
                    Log.d("DEBUG", "left2right swipe " + deltaX);
                }
                else if (deltaX < MIN_DISTANCE_R_L)
                {
                    Log.d("DEBUG", "right2left swipe" + deltaX);
                }
                else if (deltaY > MIN_DISTANCE_L_R)
                {
                    Log.d("DEBUG", "top2bottom swipe" + deltaY);
                }
                else if (deltaY < MIN_DISTANCE_R_L)
                {
                    Log.d("DEBUG", "bottom2top swipe" + deltaY);
                }
                break;
        }
        return super.onTouchEvent(event);
    }
}

