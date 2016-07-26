package com.lzp.reflection.activity.reflectiontest;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsoluteLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.lzp.reflection.activity.reflectiontest.Beans.DataList;
import com.lzp.reflection.activity.reflectiontest.Beans.PlayExecute;
import com.lzp.reflection.activity.reflectiontest.Beans.makeTextBitmap;

public class Main extends AppCompatActivity {
    ImageView iv2 = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // init();

        RelativeLayout rl = (RelativeLayout) LayoutInflater.from(this).inflate(R.layout.activity_main,null);
        RelativeLayout.LayoutParams rlp=new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        rlp.addRule(RelativeLayout.CENTER_IN_PARENT);
        ImageView iv = new ImageView(this);
       // rl.addView(iv,rlp);

        Bitmap bitmap = makeTextBitmap.makeTextBitmap(" - - - - - -  -123- - - -  - - ","汉仪大宋简体","#000000","#ffffff",24);
        BitmapDrawable bd = new BitmapDrawable(bitmap);

        iv.setImageDrawable(bd);

        iv2 = (ImageView) findViewById(R.id.iv);
        AbsoluteLayout layout = (AbsoluteLayout)findViewById(R.id.llt);
        ;

        iv2.setImageDrawable(bd);
        AbsoluteLayout.LayoutParams lp = (AbsoluteLayout.LayoutParams) iv2.getLayoutParams();
        lp.x = - 249;

        iv2.setLayoutParams(lp);


    }

    private void init(){
        //初始化 数据

        DataList list = new DataList();
        list.setKey("15608447849");
        list.put("type","image");
        list.put("x","image");
        list.put("y","image");
        list.put("width","image");
        list.put("height","image");

       PlayExecute player =  PlayExecute.getInstence(Main.this, (ViewGroup) LayoutInflater.from(Main.this).inflate(R.layout.activity_main,null));
       player.startAction(list);
       player.stopAction();
    }
    int w = -1;
public void move(View v){
    //得到布局大小

    RelativeLayout viewGroup = (RelativeLayout) LayoutInflater.from(this).inflate(R.layout.activity_main,null);

    AbsoluteLayout layout = (AbsoluteLayout)findViewById(R.id.llt);

//   int w =  viewGroup.getLayoutParams().width;
    w = layout.getLayoutParams().width;

    //平移
    /*TranslateAnimation move = new TranslateAnimation(0,w+iv2.getLayoutParams().width,0,0);//  x 平移200
    move.setDuration(10000);
    move.setFillAfter(true);
    iv2.startAnimation(move);*/

//    ObjectAnimator.ofFloat(iv2,"translationX",0,w+iv2.getLayoutParams().width)
//            .setDuration(12*1000)
//            .start();

    repertText();




}




    private void repertText(){

        int ww = iv2.getLayoutParams().width;

        int www = iv2.getWidth();

        ObjectAnimator animator =
                ObjectAnimator.ofFloat(iv2,"translationX",0,w+www);
        animator.setDuration(15*1000);
        animator.setRepeatCount(ValueAnimator.INFINITE);
        //animator.setInterpolator(new LinearOutSlowInInterpolator());

        animator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);

            }

            @Override
            public void onAnimationRepeat(Animator animation) {
                super.onAnimationRepeat(animation);
                animation.start();
            }
        });

        animator.start();
    }


}
