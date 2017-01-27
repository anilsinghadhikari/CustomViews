package customview.android.com.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by qainfotech on 20/1/17.
 */

public class CustomView  extends View{

    int defaultWidth=170;
    int defaultHeight=170;
    private Rect rect;

    public CustomView(Context context) {
        super(context);
    }

    public CustomView(Context context, AttributeSet attrs) {
        super(context, attrs);


    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


        if(getParent()!=null){

        }
        if (defaultWidth==0) {
            performCalculation();
        }
        Paint paint = new Paint();
        paint.setColor(Color.BLUE);
        paint.setStyle(Paint.Style.FILL);
        rect = new Rect(0,10,defaultWidth,defaultHeight);
//        rect.set(0,0,defaultWidth,defaultHeight);
        canvas.drawRect(rect, paint);


    }

    private void performCalculation() {
        defaultWidth=getWidth();
        defaultHeight=getHeight();
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

//        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);


        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        int width,height=0;

        //determine width
        switch (widthMode){

            case MeasureSpec.EXACTLY:
                width=widthSize;
                break;


            case MeasureSpec.AT_MOST:
//                width= Math.max(defaultWidth, widthSize);
                width=defaultWidth;
                break;

            case MeasureSpec.UNSPECIFIED:
            default:
                width=defaultWidth;
                break;
        }

        //Determine Height
        switch(heightMode){
            case MeasureSpec.EXACTLY:
                height = heightSize;
                break;
            case MeasureSpec.AT_MOST:
//                height = Math.min(defaultHeight, heightSize);
                height=defaultHeight;
                break;
            case MeasureSpec.UNSPECIFIED:
            default:
                height = defaultHeight;
                break;
        }
        defaultHeight=height;
        defaultWidth=width;

        setMeasuredDimension(width,height);
//        setMeasuredDimension(300,300);

    }

}
