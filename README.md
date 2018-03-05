# AndFixDemo
AndFix热修复使用Demo简单快捷


##AndFix 简单的使用指南
1. 添加依赖   compile 'com.alipay.euler:andfix:0.3.1@aar'
2. 在AndroidManifest.xml中添加使用读写SD卡得权限
3. 在Application中初始化Andfix中的PatchManager类。通过此类来进行加载补丁；
4. 将两个打包好的apk进行打补丁，使用工具打包补丁文件：apkpatch-1.0.3，打包的时候需要把签名文件，新包和旧包放在同一个文件中
    H:\AndroidCode\androidFix\AndFix\apkpatch-1.0.3>apkpatch.bat -f new.apk -t old.apk -o output -k debug.keystore -p android -a androiddebugkey -e android

     -f <new.apk> ：新版本
     -t <old.apk> : 旧版本
     -o <output> ： 输出目录
     -k <keystore>： 打包所用的keystore
     -p <password>： keystore的密码
     -a <alias>： keystore 用户别名
     -e <alias password>： keystore 用户别名密码

     使用官方提供的工具[apkpatch](https://github.com/alibaba/AndFix/blob/master/tools/apkpatch-1.0.3.zip)生成.apatch补丁文件**
     点击上面的链接下载apkpatch之后解压；

5. 然后将打包好的out.patch放到SD卡中；
6.混淆注意事项：
    -keep class * extends java.lang.annotation.Annotation
    -keepclasseswithmembernames class * { native <methods>; }
    -keep class com.alipay.euler.andfix.** { *; }