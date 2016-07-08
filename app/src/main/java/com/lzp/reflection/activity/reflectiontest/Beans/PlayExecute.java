package com.lzp.reflection.activity.reflectiontest.Beans;

import android.content.Context;
import android.util.Log;
import android.view.ViewGroup;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by user on 2016/7/8.
 */
public class PlayExecute {

    private static PlayExecute player;
    private Context context;
    private ViewGroup vg;

   private HashMap<String,interfacePlay> existIplay = new HashMap<String,interfacePlay>();

    private class iClassEntiy {
        private String className;//全类名


        public iClassEntiy(String className) {
            this.className = className;
        }
    }
   private HashMap<String,iClassEntiy> referenceMap = new HashMap<String,iClassEntiy>();

    private PlayExecute(){

        referenceMap.put("image",
                new iClassEntiy("com.lzp.reflection.activity.reflectiontest.Beans.iplayImp.imageplayer")
                );
    }

    public static PlayExecute getInstence(Context context,ViewGroup vg){

        if (player==null){
            player = new PlayExecute();
        }
        player.context = context;
        player.vg = vg;
        return player;
    }

    /**
     * 开始
     */
    public void startAction(DataList list){
        Log.i("iplay","开始执行所在线程 "+Thread.currentThread().getName());
        //先获取 type
        String type = list.GetStringDefualt("type","");
        if (!referenceMap.containsKey(type)){
            Log.i("iplay","无法执行的类型");
            return;
        }
        try {
            String key = list.getKey();
            interfacePlay iplay = null;
            if (!existIplay.containsKey(key)) {  //不包含这个具体实现 创建

                //反射机制
                iClassEntiy ice = referenceMap.get(type); //获取对应的 类名 方法名
                //创建 类实体
                Class cls = Class.forName(ice.className);//得到类
                Constructor constructor = cls.getConstructor(Context.class, //得到构造
                        ViewGroup.class);
                iplay = (interfacePlay) constructor.newInstance(context, vg); //得到具体实例

                existIplay.put(key, iplay);
            }else{ //存在 取出
                iplay = (interfacePlay) existIplay.get(key);
            }

            iplay.loadData(list); //执行

        } catch (ClassNotFoundException e) {
            Log.i("iplay","无法找到这个类");
        }catch(NoSuchMethodException e1){
            Log.i("iplay","不匹配类构造 ");
        }
        catch (InstantiationException e) {
            e.printStackTrace();
         } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
             e.printStackTrace();
         }
    }

    /**
     * 结束
     */
    public void stopAction(){
        Log.i("iplay","停止执行所在线程 "+Thread.currentThread().getName());
        try {
        Iterator iter = existIplay.entrySet().iterator();
            while (iter.hasNext()) {
                Map.Entry entry = (Map.Entry) iter.next();
                interfacePlay play = (interfacePlay) entry.getValue();
                play.stopExecute();
            }
    } catch (Exception e) {
            Log.i("iplay","停止执行失败... ");
    }
    }

}
