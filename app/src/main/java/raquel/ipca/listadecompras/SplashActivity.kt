package raquel.ipca.listadecompras

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.Animation.AnimationListener
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.lifecycle.lifecycleScope
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val auth = FirebaseAuth.getInstance()
        val currentUser = auth.currentUser

        val imageViewIcon = findViewById<ImageView>(R.id.imageViewIcon)
        val animFadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in)
        val animPosition = AnimationUtils.loadAnimation(this, R.anim.postion)
        imageViewIcon.startAnimation(animFadeIn)
        animFadeIn.setAnimationListener(object : AnimationListener{
            override fun onAnimationStart(p0: Animation?) {}
            override fun onAnimationEnd(p0: Animation?) {
                imageViewIcon.startAnimation(animPosition)
            }
            override fun onAnimationRepeat(p0: Animation?) {}
        })
        animPosition.setAnimationListener(object : AnimationListener{
            override fun onAnimationStart(p0: Animation?) {}
            override fun onAnimationEnd(p0: Animation?) {
                currentUser?.let {
                    startActivity(Intent(this@SplashActivity, MainActivity::class.java))
                    //finish()
                }?:run{
                    startActivity(Intent(this@SplashActivity, LoginActivity::class.java))
                    overridePendingTransition(R.anim.anim_hold, R.anim.fade_in);
                    //finish()
                }
            }
            override fun onAnimationRepeat(p0: Animation?) {}
        })



    }
}