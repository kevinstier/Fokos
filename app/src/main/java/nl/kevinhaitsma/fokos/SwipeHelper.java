package nl.kevinhaitsma.fokos;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

public class SwipeHelper implements View.OnTouchListener {

    private GestureDetector mGestureDetector;

    public SwipeHelper(Context context) {
        mGestureDetector = new GestureDetector(context, new VerticalGestureListener());
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
            view.performClick();
        }
        return mGestureDetector.onTouchEvent(motionEvent);
    }

    public void onVerticalSwipe() {

    }

    private class VerticalGestureListener extends GestureDetector.SimpleOnGestureListener {

        private static final int SWIPE_THRESHOLD = 100;
        private static final int SWIPE_VELOCITY_THRESHOLD = 100;

        @Override
        public boolean onDown(MotionEvent e) {
            return true;
        }

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            boolean result = false;
            try {
                float diffY = e2.getY() - e1.getY();
                float diffX = e2.getX() - e1.getX();
                if (Math.abs(diffX) < Math.abs(diffY)) {
                    if (Math.abs(diffY) > SWIPE_THRESHOLD &&
                            Math.abs(velocityY) > SWIPE_VELOCITY_THRESHOLD) {
                        onVerticalSwipe();
                    }
                    result = true;
                }
            } catch (Exception exception) {
                exception.printStackTrace();
            }
            return result;
        }
    }
}
