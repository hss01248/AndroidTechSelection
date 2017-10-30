# 开发工具,调试工具,性能监测和优化工具以及思路

# 1.网络调试的整套工具

## 抓包

> 侵入型或对具体框架有要求

* https://github.com/jgilfelt/chuck 通过添加okhttp拦截器的方式拿到请求和响应信息,然后显示在一个本手机上单独的activity中,不需要与电脑联网,json显示已格式化,很清晰,UI不错.
* [stetho](https://github.com/facebook/stetho) chrome上直接看,需要代码中添加okhttp拦截器.
* Android studio  3.0 : IDE上直接看,需要网络框架底层为okhttp或urlconnecttion

> 应用外抓包

- 手机端抓包工具-packet capture 
  在手机上自建vpn,并导入证书.可以抓所有手机http和https流量.但显示界面上json没有格式化显示.
- 电脑端抓包工具-fiddler 
  需要手机和电脑在同一个局域网,手机上设置代理,由电脑代理上网. 注意,https抓包需要安装一个证书制作插件,内置制作工具有bug,制作的证书不被系统承认.

## 模拟请求

### postman(客户端,pro版)

> 如果用Chrome插件,则需要在Chrome商店中再按住一个interceptor,否则postman会自己添加一些东西.
>
> 最好直接用客户端pro版.

### fiddler

fiddler可以直接在抓包的那个请求上修改点东西重新发送,简直是神器.



## 模拟不同强弱的网络状态(调整丢包率等等)

TODO



# 2.数据库查看

## 代码侵入型：

* [stetho](https://github.com/facebook/stetho): web上直接调试需要在Application的oncreate处init,


* [Android-Debug-Database](https://github.com/amitshekhariitbhu/Android-Debug-Database)  类似stetho的数据库查看功能,也是web端查看,需要与电脑联网.

  ​

# 3.查看顶层activity

https://github.com/hss01248/DemoCollections/tree/master/ViewDebugHelper  手机全局查看顶层activity.



# 4.快速点开开发者选项中内容

开发助手 

http://sj.qq.com/myapp/detail.htm?apkName=cn.trinea.android.developertools



# 5.代码优化

findbugs 插件+ PMD插件+ 配置CheckStyles(规范代码格式) + alibaba 代码检查插件
参见 https://juejin.im/post/58d4e35261ff4b00605326d9

# 6.全局开启stickMode:

> 便捷地看到代码中的性能问题

https://github.com/hss01248/TestTools/blob/master/app/src/main/java/com/hss01248/testtool/TestTools.java



