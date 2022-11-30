package NhomTTPTT.example.BaiTapCuoiKi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

import com.example.otpverification.R;

public class LoadingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);
//        getSupportActionBar().hide();
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);


        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                Intent intent =new Intent(LoadingActivity.this,ActivitySignIn.class);
                startActivity(intent);
                finish();
            }
        }, 1000);
    }
}