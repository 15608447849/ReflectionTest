package com.lzp.reflection.activity.reflectiontest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.lzp.reflection.activity.reflectiontest.Beans.DataList;
import com.lzp.reflection.activity.reflectiontest.Beans.PlayExecute;

public class Main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
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



}
