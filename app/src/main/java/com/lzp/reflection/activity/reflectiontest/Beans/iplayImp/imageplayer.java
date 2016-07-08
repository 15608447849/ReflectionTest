package com.lzp.reflection.activity.reflectiontest.Beans.iplayImp;

import android.content.Context;
import android.util.Log;
import android.view.ViewGroup;

import com.lzp.reflection.activity.reflectiontest.Beans.DataList;
import com.lzp.reflection.activity.reflectiontest.Beans.interfacePlay;

/**
 * Created by user on 2016/7/8.
 */
public class imageplayer implements interfacePlay {



    private Context context;
    private ViewGroup viewgroup;

    public imageplayer(Context context,ViewGroup view){
        this.context = context;
        this.viewgroup = viewgroup;
    }




    @Override
    public void loadData(DataList data) {
        Log.i("iplay",imageplayer.this.toString()+",loadData"+data.toString());
        startExecute();
    }

    @Override
    public void startExecute() {
        Log.i("iplay",imageplayer.this.toString()+",startExecute() ...");
    }

    @Override
    public void stopExecute() {
        Log.i("iplay",imageplayer.this.toString()+",stopExecute()...");
    }
}
