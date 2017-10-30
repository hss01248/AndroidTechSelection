# AndroidTechSelection
TechSelection in Android ,for fast dev



> github主页: https://github.com/hss01248

# 重中之重： 
不管用什么第三方库，都要自己再封装一层api
不要直接用第三方库的api
不要直接用第三方库的api
不要直接用第三方库的api


#  log打印
> 一个log库的最佳实践为： 

* 既能打印到logcat，又能打印到文件
* 能打印一切对象，并且打印得便于查看：数组，集合，json，xml，html，java object以及android系统的特有对象
* 不用传入tag，能自动获取
* 堆栈信息,且点击能直接跳到对应的类
* 线程信息
* 对象继承和属性
* 能支持string.format拼接字符串(其实不支持也没事,我们封装顶层api时自己也可以写一下)

## 参赛选手
* [Logger](https://github.com/orhanobut/logger): log界元老和先驱,7600+star,不能打印集合和任意对象,有很多改进库,比如[LogDelegate](https://github.com/tianzhijiexian/LogDelegate)
* [Timber](https://github.com/JakeWharton/timber/blob/master/timber/src/main/java/timber/log/Timber.java) 就一个文件,是上层api封装,底层仅提供打印到logcat实现,打印到文件的话需要自己实现接口. 可以参考这个来设计自己app中的顶层api
* [logback-android](https://github.com/tony19/logback-android) logback在android上的实现,xml各种配置.没具体用过
* [XLog](https://github.com/elvishew/XLog/blob/master/README_ZH.md) 1300star,所有期望的功能都有,而且0依赖
* [LogUtils](https://github.com/pengwei1024/LogUtils) 600多star,所有期望的功能都有,依赖okio
* [KLog](https://github.com/ZhaoKaiQiang/KLog): 1400+star,功能不如xlog丰富

## 最终选择
> 综上,获奖选手为XLog,同时,timber可作为应用内部api再次封装的一个参考.或者你就简单包一层.

#  网络请求
> 我希望达到的目标是,对着接口文档,api链式调用着配置一下,一个请求就完成了.
> 懒得去记具体框架里的类啊注解啊什么的,
> 甚至,http协议的一些复杂内容我也不想涉及,比如缓存控制->把常用的那些缓存模式变成几个int值给我选就行了,我才懒得用的时候考虑请求头响应头什么的.
> 一句话,傻瓜式使用.
> 所以,从这个角度看,retrofit不是好的选择.

okhttp + chuck
对okhttp的封装:
https://github.com/hss01248/HttpUtilForAndroid  :我花最多精力维护的一个库,深度结合android平台特点,使用时爽得飞起.

https://github.com/jeasonlzy/okhttp-OkGo  这个很多人用,也是傻瓜式使用.

https://github.com/jgilfelt/chuck 通过拦截器的方式拿到请求和响应信息,然后显示在一个单独的activity中算是应用内抓包

## 工具
模拟请求: postman (需要翻墙到chrome商店内下载安装)
手机/电脑抓包: fiddler.
https抓包: fiddler4.4.9.2(https抓包成功率最高的一个版本) 请翻墙google下载,国内没有.

#  图片加载
包括普通图片加载和大图加载,以及大图轮播,以及图片的一些特殊效果,比如圆角,圆形,高斯模糊等等.
https://github.com/hss01248/ImageLoader
此库基于glide和fresco封装,实现了图片的常见特殊效果.
优化了sumsamplingImageView的大图轮播,使轮播时内存占用也一直维持在20M的水平.
配置全部链式api调用

# 本地图片选择,裁剪,压缩
系统intent被国产rom搞得不能用,各种兼容性bug,必须用框架
https://github.com/hss01248/PhotoOut  用链式api串起几个优秀的开源库,从而串起了整个流程.

https://github.com/crazycodeboy/TakePhoto/  这个star很多,也是将整个流程串起来了.

# 提示性UI

## toast: 
Toasty : https://github.com/hss01248/Toasty
带有状态的toast,有succes.error,warn,info,normal 五种,以及debug一种(只在debug模式下弹出).
## dialog : 
DialogUtil  : https://github.com/hss01248/DialogUtil
囊括所有常见的通用型dialog,既有ios风格又有android风格.不需要activity引用即可弹出.
https://github.com/saiwu-bigkoo/Android-AlertView  ios风格的dialog

## notification
NotifyUtil: https://github.com/hss01248/NotifyUtil
api链式调用,摆脱原生的难用的api.封装了常用的通知模式.

# 必用的UI小组件
## 选择器:
https://github.com/Bigkoo/Android-PickerView

内置时间日期选择器,UI自定义配置很丰富
还有三级,二级,一级联动选择器

https://github.com/gzu-liyujiang/AndroidPicker

各种丰富的内置选择器:
包括日期选择器、时间选择器、单项选择器、城市地址选择器、车牌号选择器、数字选择器、星座选择器、生肖选择器、颜色选择器、文件选择器、目录选择器等

https://github.com/yangxu4536/MeiTuanLocateCity
仿美团城市选择界面，可直接用在实际项目中

https://github.com/Bigkoo/EasySideBar
一款按字母排序库，已封装好城市数据，风格仿美团，可定制化强。

## 多条件筛选菜单
https://github.com/dongjunkun/DropDownMenu
类似美团，爱奇艺电影票下拉菜单

## 优惠券效果
https://github.com/dongjunkun/CouponView

## 轮播图
https://github.com/glassLake/AndroidImageSliderByFresco 第一次进入有快速滚动两张的bug

https://github.com/saiwu-bigkoo/Android-ConvenientBanner 

https://github.com/youth5201314/banner 
多种模式 Android广告图片轮播控件，支持无限循环和多种主题，可以灵活设置轮播样式、动画、轮播和切换时间、位置、图片加载框架等！

## 快速分组侧边栏
https://github.com/saiwu-bigkoo/Android-QuickSideBar
https://github.com/CaMnter/EasyRecyclerViewSidebar
https://github.com/gjiazhe/WaveSideBar

## 给图片打标签
https://github.com/saiwu-bigkoo/Android-PictureTagView

## 滚动刻度尺
https://github.com/LichFaker/ScaleView

## 加减号控制数字增减
https://github.com/saiwu-bigkoo/Android-SnappingStepper

## 广告弹窗
https://github.com/yipianfengye/android-adDialog
功能比较丰富


## 状态栏变色
毫无疑问是这个:
https://github.com/jgilfelt/SystemBarTint
api封装一下,简化使用:
[StatusbarUtil.java](https://github.com/hss01248/MainActivityUIUtil/blob/master/bottomtabs/src/main/java/com/hss01248/bottomtabs/StatusbarUtil.java)





## 文件下载
https://github.com/lingochamp/FileDownloader
专注于文件下载,各种高级特性.适用于对文件下载业务要求较高的项目

#  数据库
greendao太难用,还是ormlite好.
https://github.com/j256/ormlite-android
https://github.com/Raizlabs/DBFlow 这个api设计更优雅

数据库调试方式:  
无需root.在浏览器端通过http请求的方式直接查看和操作数据库,方便快捷
https://github.com/amitshekhariitbhu/Android-Debug-Database




# 页面状态管理
https://github.com/hss01248/PageStateManager 我自己用的,基于鸿洋的库改进
https://github.com/arieridwan8/pageloader 
https://github.com/weavey/LoadingLayoutDemo 

# 工具类库
这个也没有疑问,就是这个高大全的库了:
https://github.com/Blankj/AndroidUtilCode

# Rx全家桶
> 为什么没有retrofit? 因为它的api太难用了啊.设计很优美,但是使用起来坑太多,又繁琐.

## RxAndroid
让你随意地切换线程

## RxBinding
从此摆脱频繁点击导致的重复操作的烦恼

## RxLifecycle
生命周期管理,减少内存泄漏

## RxPermissions 
6.0运行时权限

## Rx Preferences 
通过 RxJava 的方式来访问 SharedPreferences

# 键盘监听
> 键盘监听是android一大坑.
> 防止自动弹出键盘:
> activity 标签里加android:windowSoftInputMode="stateHidden|stateAlwaysHidden"

https://github.com/yshrsmz/KeyboardVisibilityEvent

# 网络变更事件监听
https://github.com/pwittchen/NetworkEvents


# 屏幕适配
https://github.com/hongyangAndroid/AndroidAutoLayout

# UI特效

## 阴影效果
https://github.com/wangjiegulu/ShadowViewHelper
1.0.4效果不稳定,建议用1.0.2.   
> 第三方库兼容性总还是存在一定问题,最靠谱的还是用drawable: 看这个: [shadow.xml](https://github.com/hss01248/DialogUtil/blob/master/lib/src/main/res/drawable/shadow.xml)

## 水波纹效果
https://github.com/traex/RippleEffect  点击后产生水波纹,兼容到api9 补充: 发现在华为平板上会崩...




## 动画
https://github.com/florent37/ViewAnimator
A fluent Android animation library  api封装简化使用

https://github.com/airbnb/lottie-android
parses Adobe After Effects animations exported as json with Bodymovin and renders them natively on mobile

https://github.com/lgvalle/Material-Animations

## loading动画
https://github.com/race604/WaveLoading  : provides a wave loading animation as a Drawable. 也就是说,可以设置给任意一个view当背景



## 换皮肤主题
https://github.com/hongyangAndroid/ChangeSkin 一键换肤

https://github.com/garretyoder/Colorful 任何时候都能代码动态修改 主题色,摆脱了xml的限制

# 把textview 玩出花来
https://github.com/thoughtbot/stencil 渐渐出现的动画




# 文件和缓存相关

https://github.com/vincentbrison/dualcache
This android library provide a cache with 2 layers, one in RAM in top of one disk.

https://github.com/baoyongzhang/Treasure
Very easy to use wrapper library for Android SharePreferences

## content-provider
https://github.com/EverythingMe/easy-content-providers

# 原生组件的扩展

## edittext
https://github.com/rengwuxian/MaterialEditText
https://github.com/bufferapp/BufferTextInputLayout 对design包里的TextInputLayout的一个扩展
> 原生EditText在不同android版本上效果不一样,绝对不能用.

* 可以用appcompat包里的AppCompatEditText,
* 或者用design包里的TextInputEditText.
* 如果UI是自己搞,那么直接用TextInputLayout+TextInputEditText,各种提示UI,显示隐藏密码,基本的校验都集成了.
  使用很简单,看这里:[TextInput详解 · Material Design Part 1](https://zhuanlan.zhihu.com/p/22402340)


## button
写那么多的selector烦死人了,用这个吧:
https://github.com/niniloveyou/StateButton

## viewpager
https://github.com/Devlight/InfiniteCycleViewPager
> 禁止左右滑动 

```
@Override
    public boolean onTouchEvent(MotionEvent event) {
        return this.isCanScroll && super.onTouchEvent(event);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        return this.isCanScroll && super.onInterceptTouchEvent(event);
    }
```

> 当各page类型一致时,内部循环利用四个page

https://github.com/AlexMofer/RecyclePagerAdapter



## shape 和selector
> 写xml太麻烦,直接用上java代码:[通过代码定义shape/selector](http://www.cnblogs.com/liuyu0529/p/6510132.html)

## listview和recycleview
https://github.com/CymChad/BaseRecyclerViewAdapterHelper 对多类型的支持一般般? 
https://github.com/EvilBT/SherlockAdapter 

https://github.com/WuXiaolong/PullLoadMoreRecyclerView 少定制,快速上手
https://github.com/hongyangAndroid/baseAdapter 鸿洋大神出品
[关于Android RecyclerView的那些开源LayoutManager](https://mp.weixin.qq.com/s/59YLxK8C5IGwwpZ9P8NjZw)

## 下拉刷新
看这个汇总就好了:
https://github.com/android-cjj/BeautifulRefreshLayout

# 第三方分享和登录,统计
使用友盟的sdk,然后再封装一层
参见[第三方登录/分享最佳实践](https://juejin.im/post/58c21aa944d9040068e71e2c)
自己封装的一个:
https://github.com/hss01248/UmengUtil 
对umeng分享,第三方登录以及统计的api的封装,避免再出现api大幅改动而到处改源码.真正的一行代码完成分享和登录
注:上面最佳实践的一些好的思路还没有整合到这个库中,目前只集成了qq,weixin,sina三家.

# 第三方推送
[集成第三方推送最佳实践](http://www.jianshu.com/p/d650d02a1c7a)
一句话来,小米rom就用小米推送,其他用友盟推送,更细致一点,还可以华为rom用华为推送



# 权限申请
6.0以下的悬浮窗权限申请,以及判断:
https://github.com/hss01248/FloatWindowPermission
6.0以上,运行时权限,还包括悬浮窗权限,以及读写sd卡权限(非运行时,但华为手机和平板要求):
RxPermissions:
https://github.com/tbruyelle/RxPermissions
# 二维码扫描
> 基本上都是基于z-xing封装

[BGAQRCode-Android](https://github.com/bingoogolapple/BGAQRCode-Android)  我用的是这个
[barcodescanner](https://github.com/dm77/barcodescanner)  这个也很多人推荐



# 音频录制和播放

## 音频录制
> 当然是录制成跨平台的mp3格式:

https://github.com/hss01248/AndroidMP3Recorder 

基于start最多的AndroidMP3Recorder项目改进,经受了一个实际线上项目两年的考验
特点: 边录边转码,暂停可播,方法安全,回调丰富,6.0以下权限也适配了

## 音频播放
> mediaplayer 难用得你想死,有木有?路径设置很多rom互相不承认.操作方法不安全,各种异常.都给你封装好了:

https://github.com/hss01248/SafeMediaPlayer


# 视频相关
 ## 短视频录制和播放:
 >  第三方的趣拍已经收费了,一年5万,略贵.下面这个是开源中比较好的,不过没有特效.

 https://github.com/mabeijianxi/small-video-record

 > 有特效的要收费,比如这个,录制过程中有滤镜,录制后贴图,加音乐.

 https://github.com/rdsdk/rdVideoEditSDK-for-Android


# 视频播放

* Vitamio 
    支持格式较多，稳定性高，性能较高，功能强大，开发难度低。个人使用免费，商业使用收费.但是,已经停止更新了.
    https://github.com/yixia/VitamioBundle
* ijkplayer
    目前国内最火的,bilibili开源的.
    https://github.com/Bilibili/ijkplayer
    基于ijk的丰富的功能封装库:
    https://github.com/CarGuo/GSYVideoPlayer
    基于ijk的界面封装:(不如上一个丰富)
    https://github.com/jjdxmashl/jjdxm_ijkplayer

# 蓝牙
FastBle
https://github.com/Jasonchenlijian/FastBle

# android上建轻量级http服务器
> 本质上是提供http通信渠道
> 下面的库,是用java原生的serversocket来接收信息,然后用org.apache.http包来解析http相关信息,然后自己像写severlet一样处理.

https://github.com/yanzhenjie/AndServer

# 进程保活
> 对比了github的几个star数较多的库,最终选择[HelloDaemon](https://github.com/xingda920813/HelloDaemon),这个库是在其他两个库基础上的改进.

相关理论文章:
[Android进程保活的研究与实践](https://github.com/D-clock/AndroidDaemonService/blob/master/notes/Android%E8%BF%9B%E7%A8%8B%E4%BF%9D%E6%B4%BB%E7%9A%84%E7%A0%94%E7%A9%B6%E4%B8%8E%E5%AE%9E%E8%B7%B5.md)
[Android 进程常驻（2）----细数利用android系统机制的保活手段](http://blog.csdn.net/marswin89/article/details/50890708)
* [HelloDaemon](https://github.com/xingda920813/HelloDaemon) : 保活措施优秀,回调处理得好
* [MarsDaemon](https://github.com/Marswin/MarsDaemon) 即使允许自启,强杀后也无法自启
* [AndroidDaemonService](https://github.com/D-clock/AndroidDaemonService) 即使允许自启,强杀后无法自启

# 代码优化
findbugs 插件+ PMD插件+ 配置CheckStyles(规范代码格式) + alibaba 代码检查插件
参见 https://juejin.im/post/58d4e35261ff4b00605326d9



# 渠道打包

* 360加固宝 :  神速,还会加上360自己的一些统计功能
* [packer-ng-plugin](https://github.com/mcxiaoke/packer-ng-plugin) : 号称下一代Android打包工具，100个渠道包只需要10秒钟.但没有具体用过

# crash日志统计
想避免崩溃 用 https://github.com/jenly1314/NeverCrash ，但代码后续的一些逻辑要考虑清楚
日志统计： 腾讯的bugly，或者友盟统计.360加固时也可选日志统计功能,实时发送而不是下一次发送,比友盟的要全一些

# apk更新和热修复
> 自己搞

可以自己搭建服务器,写后台管理apk版本,并提供检测新版本和下载新版本的api,
app端核对版本号,下载apk,校验md5,安装. 
android端基本逻辑封装:
https://github.com/hss01248/ApkUpdater

热更新: tinker 配置稍显繁琐

> 利用bugly的更新和热修复功能 

注册账号,集成sdk,按文档配置好就ok,比较简单.推荐使用.
其热修复是通过tinker sdk +管理后台
文档:
https://bugly.qq.com/docs/user-guide/instruction-manual-android-hotfix/



# 云存储
* 七牛云: 云端图片处理功能真是牛逼上了天.之前还根据他们的api封装了个工具类:[QiniuUtils](https://github.com/hss01248/MyImageUtil/blob/master/lib/src/main/java/com/hss01248/frescoloader/QiniuUtils.java)
* 阿里云: 看api文档,该有的云端处理功能也有,但没有实际用过.有用过的吗?说说看


# 调试工具篇
## 代码侵入型：
[stetho](https://github.com/facebook/stetho)  web上直接调试网络和数据库
需要在Application的oncreate处init,网络的话需要给okhttp加一个拦截器.

### 网络抓包

https://github.com/jgilfelt/chuck 通过添加okhttp拦截器的方式拿到请求和响应信息,然后显示在一个本手机上单独的activity中,不需要与电脑联网,json显示已格式化,很清晰

### 数据库调试
[Android-Debug-Database](https://github.com/amitshekhariitbhu/Android-Debug-Database)  类似stetho的数据库查看功能,也是web端查看,需要与电脑联网.

## 非侵入型
### 网络抓包 
* 手机端抓包工具-packet capture 
  在手机上自建vpn,并导入证书.可以抓所有手机http和https流量.但显示界面上json没有格式化显示.

* 电脑端抓包工具-fiddler 
  需要手机和电脑在同一个局域网(比较难达成),手机上设置代理,由电脑代理上网. 注意,https抓包需要安装一个证书制作插件,内置制作工具有bug,制作的证书不被系统承认.

## 查看顶层activity
https://github.com/hss01248/DemoCollections/tree/master/ViewDebugHelper  手机全局查看顶层activity.







# 一些牛逼的小技巧

[awesome-android-tips](https://github.com/jiang111/awesome-android-tips)
[Android 系统中，那些能大幅提高工作效率的 API 汇总](https://juejin.im/post/58c407ee44d90400698757d8)
[Android开发中，那些让你相见恨晚的方法、类或接口](http://liukun.engineer/2016/04/11/Android%E5%BC%80%E5%8F%91%E4%B8%AD%EF%BC%8C%E9%82%A3%E4%BA%9B%E8%AE%A9%E4%BD%A0%E7%9B%B8%E8%A7%81%E6%81%A8%E6%99%9A%E7%9A%84%E6%96%B9%E6%B3%95%E3%80%81%E7%B1%BB%E6%88%96%E6%8E%A5%E5%8F%A3/)
[android-tips-tricks-cn](https://github.com/cctanfujun/android-tips-tricks-cn)
[corelink](https://github.com/lizhangqu/corelink)


# 提升开发效率工具汇总

[Android攻城狮—全套必备神级工具（开发，插件，效率）](http://www.jianshu.com/p/0911efbf8009)




> 以下不算技术选型,仅做备忘

# 几个全套型快速开发框架 -学习coding skill 用

https://github.com/meikoz/Basic
https://github.com/minggo620/Pluto-Android

# 别人总结的开源项目大礼包

https://github.com/Tim9Liu9/TimLiu-Android
https://github.com/Lafree317/ShareAndroidResource
https://github.com/limedroid/XDroid/wiki
https://github.com/aritraroy/UltimateAndroidReference


