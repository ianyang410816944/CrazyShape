package tw.edu.pu.s1081694.crazyshape

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.module.AppGlideModule
import kotlinx.android.synthetic.main.activity_main.*
@GlideModule
public final class MyAppGlideModule : AppGlideModule()
class MainActivity : AppCompatActivity() ,View.OnClickListener{
    lateinit var gDetector: GestureDetector
     //目前顯示第幾張圖

    var TotalPictures:Int = 4 //總共幾張圖片(假設僅顯示pu0-pu3)



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        imgNext.setOnClickListener(this)

        val img: ImageView = findViewById(R.id.imgTitle)
        GlideApp.with(this)
            .load(R.drawable.cover)
            .into(img)
        Toast.makeText(baseContext, "作者:楊宜學", Toast.LENGTH_LONG).show()


        imgNext.setOnLongClickListener(object : View.OnLongClickListener {
            override fun onLongClick(p0: View?): Boolean {
                intent = Intent(this@MainActivity, GameActivity::class.java)
                startActivity(intent)
                return true
            }
        })
    }
    override fun onClick(v: View?) {
        var X:Int =(0..3).random()
        if(X==0){
            imgNext.setImageResource(R.drawable.circle)
        }else if(X==1){
            imgNext.setImageResource(R.drawable.square)
        }else if(X==2){
            imgNext.setImageResource(R.drawable.star)
        }else if(X==3){
            imgNext.setImageResource(R.drawable.triangle)
        }
    }
}


