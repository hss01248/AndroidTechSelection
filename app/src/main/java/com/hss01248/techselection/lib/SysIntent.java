package com.hss01248.techselection.lib;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;

/**
 * Created by huangshuisheng on 2018/1/8.
 *
 * 系统级intent跳转,
 * 包括但不限于:
 *
 * 跳转到分享/邮件
 * 跳转到拍照
 * 跳转到图片选择
 * 跳转到拨号界面
 * 跳转到打开文件
 *
 *
 *
 *
 *  跳到应用市场的适配:
 *  作者：咻咻ing
 链接：https://www.jianshu.com/p/2165acb5d1eb

 */

public class SysIntent {

    private static  Context context;

    public static void init(Context context){
        SysIntent.context = context;

    }

    /**
     * 调到应用市场
     * 如果有多个,则列表
     * @param packageName
     */
    public static void goToMarket( String packageName) {
        Context context = SysIntent.context;
        String manufacture = Build.MANUFACTURER;
        if(!TextUtils.isEmpty(manufacture)){
            if(manufacture.contains("samsung")){
                goToSamsungappsMarket(context,packageName);
                return;
            }

            if(manufacture.contains("letv")){
                goToLeTVStoreDetail(context,packageName);
            }
        }
        Uri uri = Uri.parse("market://details?id=" + packageName);
        Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
        try {
            context.startActivity(goToMarket);
        } catch (ActivityNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 限定调到某一个市场
     * @param context
     * @param packageName
     * @param targetMarketPackageName
     * @param targetMarketActivityClassName
     */
    public static void goToMarket(Context context, String packageName,String targetMarketPackageName,String targetMarketActivityClassName) {
        Uri uri = Uri.parse("market://details?id=" + packageName);
        Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
        try {
           // goToMarket.setClassName("com.tencent.android.qqdownloader", "com.tencent.pangu.link.LinkProxyActivity");
            goToMarket.setClassName(targetMarketPackageName, targetMarketActivityClassName);
            context.startActivity(goToMarket);
        } catch (ActivityNotFoundException e) {
            e.printStackTrace();
        }
    }


    private static void goToSamsungappsMarket(Context context, String packageName) {
        Uri uri = Uri.parse("http://www.samsungapps.com/appquery/appDetail.as?appId=" + packageName);
        Intent goToMarket = new Intent();
        goToMarket.setClassName("com.sec.android.app.samsungapps", "com.sec.android.app.samsungapps.Main");
        goToMarket.setData(uri);
        try {
            context.startActivity(goToMarket);
        } catch (ActivityNotFoundException e) {
            e.printStackTrace();
        }
    }

   private static void goToLeTVStoreDetail(Context context, String packageName) {
        Intent intent = new Intent();
        intent.setClassName("com.letv.app.appstore", "com.letv.app.appstore.appmodule.details.DetailsActivity");
        intent.setAction("com.letv.app.appstore.appdetailactivity");
        intent.putExtra("packageName", packageName);
        context.startActivity(intent);
    }











}
