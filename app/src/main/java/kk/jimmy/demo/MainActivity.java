package kk.jimmy.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.kk.request.KKRequestManager;

import java.util.List;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        KKRequestManager.getInstance().setBaseUrl("http://10.139.40.171:8080/").setInterceptor(new TestInterceptor()).setTimeOut(30);
        LoginRequest s = new LoginRequest();
        new LoginRequest().execute().onSuccess((List<yaozeyulist> data) -> {

            Log.e("jimmy", "最后 请求成功： " + data.get(0).totalBill);
        }).onFailed( e -> {
            Log.e("jimmy", "最后 请求失败");
        }).onComplete( e -> {
            Log.e("jimmy", "最后 请求结束");
        });
    }
}
