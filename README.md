**Android 原生VR效果**



**需要引用官方依赖**

```gradle
implementation 'com.google.vr:sdk-panowidget:1.80.0'
```



**布局中引用**

```xml
<com.google.vr.sdk.widgets.pano.VrPanoramaView
    android:id="@+id/mVrPanoramaView"
    android:layout_width="0dp"
    android:layout_height="0dp"
    app:layout_constraintBottom_toBottomOf="parent"
    app:layout_constraintLeft_toLeftOf="parent"
    app:layout_constraintRight_toRightOf="parent"
    app:layout_constraintTop_toTopOf="parent" />
```



**MainActivity中核心代码**



```kotlin
mOption = VrPanoramaView.Options()
mBitmap = BitmapFactory.decodeResource(resources, R.drawable.icon_001)
mVrView = findViewById<VrPanoramaView>(R.id.mVrPanoramaView).apply {
    //  不隐藏全屏模式按钮[默认也是不]
    setFullscreenButtonEnabled(true)
    //  设置不隐藏最左边信息的按钮[默认也是不]
    setInfoButtonEnabled(true)
    //  设置不隐藏立体模型的按钮[默认也是不]
    setStereoModeButtonEnabled(true)
    //  设置监听
    setEventListener(ActivityEventListener())
    //  加载图片
    loadImageFromBitmap(mBitmap, mOption)
}
```





[**源码**]("https://github.com/RedWolfChao/GoogleVRPro")





