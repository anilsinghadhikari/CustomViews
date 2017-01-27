package customview.android.com.customview;

import android.animation.ObjectAnimator;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private boolean animationDone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.editText);
        Button btn = (Button) findViewById(R.id.btn);

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(validEmail(s.toString())){
                    editText.setCompoundDrawablesWithIntrinsicBounds(null, null, ContextCompat.getDrawable(getApplicationContext(),R.drawable.rotate), null);
                    if(!animationDone)
                        animateMe();
                }else{
                    animationDone=false;
//                    animateMe();
                    editText.setCompoundDrawables(null, null, null,null);

                }


            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animateMe();
            }


        });

//        editText.setCompoundDrawables(null, null, ContextCompat.getDrawable(getApplicationContext(),R.drawable.ic_hotel_check), null);



    }

    private void animateMe() {
        animationDone=true;
        int MAX_LEVEL = 10000;

        Drawable[] myTextViewCompoundDrawables = editText.getCompoundDrawables();
        for(Drawable drawable: myTextViewCompoundDrawables) {

            if(drawable == null)
                continue;

            ObjectAnimator anim = ObjectAnimator.ofInt(drawable, "level", 0, MAX_LEVEL);
            anim.start();
        }
    }

    public static boolean validEmail(String email) {
        if(TextUtils.isEmpty(email))
            return false;
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
}
