package com.shibei.zb.zhongbacomplex;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.shibei.zb.zhongbacomplex.Fragment.HomePageFragment;
import com.shibei.zb.zhongbacomplex.Fragment.SeachFragment;
import com.shibei.zb.zhongbacomplex.Fragment.MineFragment;
import com.shibei.zb.zhongbacomplex.Fragment.WorkFragment;
import com.shibei.zb.zhongbacomplex.Util.CrashHandler;
import com.shibei.zb.zhongbacomplex.Util.Out;
import com.shibei.zb.zhongbacomplex.mode.PoliceInfo;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by wy250 on 2017/9/26.
 */

public class MyApplication extends Application{
    public static int schemeColors;
    public static  PoliceInfo myPliceinfo;
    public static HomePageFragment homePageFragment;
    /**
     * 偏移配置
     */
    public static Double[] offset = new Double[]{
            0.0, 0.0
    };


    public static WorkFragment workFragment;


    public static MineFragment mineFragment;
    public static SeachFragment seachFragment;
    private static MyApplication instance;
    public static double jd=0;
    public  static  double wd=0;
    private Context mainActivity;
    public static Context sContext;

    public static PoliceInfo getMyPliceinfo() {
        return myPliceinfo;
    }

    public static void setMyPliceinfo(PoliceInfo myPliceinfo) {
        MyApplication.myPliceinfo = myPliceinfo;
    }

    public static MineFragment getMineFragment() {
        return mineFragment;
    }

    public static void setMineFragment(MineFragment mineFragment) {
        MyApplication.mineFragment = mineFragment;
    }

    public static SeachFragment getSeachFragment() {
        return seachFragment;
    }

    public static void setSeachFragment(SeachFragment seachFragment) {
        MyApplication.seachFragment = seachFragment;
    }
    public static WorkFragment getWorkFragment() {
        return workFragment;
    }

    public static void setWorkFragment(WorkFragment workFragment) {
        MyApplication.workFragment = workFragment;
    }
    public static  String LOGIN_INFO="zhongbazhonghe";
    private List<Activity> activityList = new LinkedList<Activity>();

    public static HomePageFragment getHomePageFragment() {
        return homePageFragment;
    }

    public static void setHomePageFragment(HomePageFragment homePageFragment) {
        MyApplication.homePageFragment = homePageFragment;
    }




    @Override
    public void onCreate() {
        Out.out("APP木有启动吗？");
        super.onCreate();
        sContext=getApplicationContext();
        schemeColors = getApplicationContext().getResources().getColor(R.color.main_bg);
        DisplayImageOptions defaultOptions = new DisplayImageOptions.Builder()
                .showImageForEmptyUri(R.mipmap.img_defaultother)
                .showImageOnFail(R.mipmap.img_defaultother).cacheInMemory(true)
                .cacheOnDisc(true).build();
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(
                getApplicationContext())
                .defaultDisplayImageOptions(defaultOptions)
                .discCacheSize(50 * 1024 * 1024)//
                .discCacheFileCount(100)// 缂傚倹鎸搁悺銊︾▔閿熻姤顏ョ�殿喚濮村ù姗�鎮ч敓锟�
                .writeDebugLogs().build();
        ImageLoader.getInstance().init(config);

        CrashHandler crashHandler = CrashHandler.getInstance();
        crashHandler.init(getApplicationContext());
    }

    // 閸欏本顥呴柨浣稿礋娓氬膩瀵繗骞忛崣鏈紁plication鐎圭偘绶�
    public static MyApplication getInstance() {

        if (instance == null) {
            synchronized (MyApplication.class) {
                if (null == instance) {
                    instance = new MyApplication();
                }
            }
        }

        return instance;
    }


    // 濞ｈ濮炴潻鎰攽閻ㄥ垷ctivity
    public void addActivity(Activity activity) {
        activityList.add(activity);
    }
    // 闁拷閸戝搫绨查悽顭掔礉閸忔娊妫撮幍锟介張澶庣箥鐞涘瞼娈慳ctivity
    public void exit() {

        for (Activity activity : activityList) {
            activity.finish();
        }
        System.exit(0);
    }
    public void setMainActivity(Context mainActivity) {
        this.mainActivity = mainActivity;
    }

    public Context getMainActivity() {
        return mainActivity;
    }
    public boolean clearAct() {
        for (Activity activity : activityList) {
            activity.finish();
        }
        activityList.clear();
        mainActivity = null;
        return true;
    }
}
