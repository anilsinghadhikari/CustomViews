package customview.android.com.customview;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import android.widget.ScrollView;

public class ScrollViewWorkActivity extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll_view_work);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        final ScrollView mScrollView = (ScrollView) findViewById(R.id.scrollViewSignUp);
        final LinearLayout btnParnetLayout = (LinearLayout) findViewById(R.id.btnParnetLayout);


//        final int height = btnParnetLayout.getHeight();
        final int height= getResources().getDimensionPixelSize(R.dimen.btnTopLayoutHeight);

        mScrollView.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {
            @Override
            public void onScrollChanged() {
                int scrollY = Math.min(Math.max(mScrollView.getScrollY(), 0), height);
                int scrollOffset = scrollY / 2;
                btnParnetLayout.setTranslationY(-(scrollY / 3));
                float alpha = scrollY / (float) height;
                int actualHight = mScrollView.getLayoutParams().height;
//                mScrollView.getLayoutParams().height=actualHight+scrollOffset;

            }
        });


    }

}
