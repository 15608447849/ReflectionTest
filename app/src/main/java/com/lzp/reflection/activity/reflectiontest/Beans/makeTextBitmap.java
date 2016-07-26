package com.lzp.reflection.activity.reflectiontest.Beans;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;

/**
 * Created by user on 2016/7/26.
 */
public class makeTextBitmap {


    /**内容,高度,"汉仪大宋简体",前景色#000000 背景色#ffffff 文字大小12 父容器宽度 父容器高度*/
    public static Bitmap makeTextBitmap(String text, String textType, String fontcolor, String bgcolor, float textSize) {
        String txtcontext;
        Bitmap bitmap = null;
        try {
                txtcontext = text;//文本内容

                Paint p = new Paint(Paint.ANTI_ALIAS_FLAG);//画笔 反别名
                Typeface font = Typeface.create(textType, Typeface.BOLD);
                p.setColor(Color.parseColor(fontcolor));
                p.setTypeface(font);
                p.setTextSize(textSize);

                int width = getTextWidth(p, txtcontext);//文本宽度
                int height = getTextHeight2(p,textSize);
               /* if (width < fatherView_w) //宽度如果小于父控件
                    width = fatherView_w;

                int height = fatherView_h; //父控件的高度 */

                //如果背景 前景 为null
                if (bgcolor.equals("") || bgcolor == null) {
                    bgcolor = "#000000";
                }

                if (fontcolor.equals("") || fontcolor == null) {
                    fontcolor = "#FFFFFF";
                }
                bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);//创建位图

                Canvas canvasTemp = new Canvas(bitmap);//创建画布
                canvasTemp.drawColor(Color.TRANSPARENT);//透明色背景的画布
//                canvasTemp.drawColor(Color.RED);
                float textheight = p.getFontMetrics().bottom - p.getFontMetrics().top;//文本高度 = 画笔尺寸的最下面 - 最上面

                canvasTemp.drawBitmap(bitmap, 0, 0, p);//临时画布 画位图
                //如果 高度 > 文字大小
                if (height > textSize){
                    //String text, float x, float y, panit
                    canvasTemp .drawText(txtcontext, 0, (height - (textSize - 10))/ 2 + (textSize - 10), p);
                }
                else{
                    canvasTemp.drawText(txtcontext, 0, textSize - 10, p);
                }

        } catch (Exception e) {

        } catch (OutOfMemoryError oomE) {

        }
        return bitmap;
    }


    /**
     * 获取文本宽度
     * 画笔
     *  内容
      */
    public static int getTextWidth(Paint paint, String str) {
        int iRet = 0;
        if (str != null && str.length() > 0) {
            int len = str.length();
            float[] widths = new float[len];
            paint.getTextWidths(str, widths);
            for (int j = 0; j < len; j++) {
                iRet += (int) Math.ceil(widths[j]);
            }
        }
        return iRet;
    }

    public static double getTextHeight(Paint paint ,float textSize){

        paint.setTextSize(textSize);
        Paint.FontMetrics fm = paint.getFontMetrics();
        return  Math.ceil(fm.descent - fm.ascent);
    }

    public static int getTextHeight2(Paint paint ,float textSize){

        paint.setTextSize(textSize);
        Paint.FontMetrics fm = paint.getFontMetrics();
        return  (int) Math.ceil(fm.descent - fm.top) + 2;
    }



}
