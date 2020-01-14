package com.redolf.googlevrpro

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.vr.sdk.widgets.pano.VrPanoramaEventListener
import com.google.vr.sdk.widgets.pano.VrPanoramaView
import java.util.*

class MainActivity : AppCompatActivity() {

    //  默认待替换图片
    private val resArray = arrayOf(
        R.drawable.icon_001,
        R.drawable.icon_002,
        R.drawable.icon_003,
        R.drawable.icon_004,
        R.drawable.icon_005
    )
    private lateinit var mBitmap: Bitmap
    private lateinit var mOption: VrPanoramaView.Options
    private lateinit var mVrView: VrPanoramaView
    private lateinit var mRandom: Random

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }

    private fun initView() {
        //  随机
        mRandom = Random()
        //  VR 设置
        mOption = VrPanoramaView.Options()
        //  TYPE_MONO 是普通效果
          mOption.inputType = VrPanoramaView.Options.TYPE_MONO
        //  TYPE_STEREO_OVER_UNDER 是立体效果 不戴VR眼镜看不出来
        //  mOption.inputType = VrPanoramaView.Options.TYPE_STEREO_OVER_UNDER
        //  图片
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
        findViewById<Button>(R.id.mBtnChangeImg).setOnClickListener {

            /*
             * 修改对应图片
             *
             * 实际项目中 可通过推送或者Socket来远程控制切换图片 线程轮询切换也可以
             */

            runOnUiThread {
                mVrView.loadImageFromBitmap(
                    BitmapFactory.decodeResource(
                        resources,
                        resArray[mRandom.nextInt(resArray.size)]
                    ),
                    mOption
                )
            }
        }
    }


    /**
     * VRView 监听
     */
    private inner class ActivityEventListener : VrPanoramaEventListener() {
        override fun onLoadSuccess() {
            //  TODO 加载成功
        }

        override fun onLoadError(errorMessage: String?) {
            //  TODO 加载失败
        }
    }

}
