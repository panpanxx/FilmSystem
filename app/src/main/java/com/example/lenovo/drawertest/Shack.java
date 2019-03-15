package com.example.lenovo.drawertest;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.lenovo.drawertest.R;

public class Shack extends AppCompatActivity implements SensorEventListener, MediaPlayer.OnCompletionListener, View.OnClickListener {
    private static final String TAG = "Main2Activity";
    private MediaPlayer mediaPlayer;
    private SensorManager sensorManager;
    private Sensor sensor;
    private int DEFAULT_VALUES = 20;
    private Button btnSOP, btnStop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shake );
        Log.d(TAG, "onCreate: ");
        initData();
        initView();
    }

    private void initView() {
        btnStop = findViewById(R.id.btn_stop);
        btnStop.setOnClickListener(this);
        btnStop.setEnabled(false);
    }

    /**
     * 初始化数据
     */
    private void initData() {
        Log.d(TAG, "initData: ");
        //获取传感器管理者对象
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        //获取加速度传感器
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        mediaPlayer = MediaPlayer.create(this, R.raw.music1);
        mediaPlayer.setOnCompletionListener(this);
        mediaPlayer.setOnBufferingUpdateListener(new MediaPlayer.OnBufferingUpdateListener() {
            @Override
            public void onBufferingUpdate(MediaPlayer mp, int percent) {
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (sensorManager != null) {
            sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (sensorManager != null) {
            sensorManager.unregisterListener(this);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //释放播放器
        mediaPlayer.release();
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        float[] values = event.values;
        //x 方向的重力加速度 ==> 右为正
        float x = values[0];
        //y 方向的重力加速度 ==> 左为正
        float y = values[1];
        //z 方向的重力加速度 ==> 上为正
        float z = values[2];
        if (Math.abs(x) > DEFAULT_VALUES || Math.abs(y) > DEFAULT_VALUES || Math.abs(z) > DEFAULT_VALUES) {
            // 如果播放器没有播放，执行播放
            if (!mediaPlayer.isPlaying()) {
                //设置播放器的进度为0
                mediaPlayer.seekTo(0);
                mediaPlayer.start();
                btnStop.setEnabled(true);
            }
        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    @Override
    public void onCompletion(MediaPlayer mp) {
        Toast.makeText(this, "音乐播放结束", Toast.LENGTH_SHORT).show();
        btnStop.setEnabled(false);
        btnStop.setText("停止");
    }

    @Override
    public void onClick(View v) {

        mediaPlayer.stop();
        mediaPlayer.reset();
        btnStop.setEnabled(false);
        btnStop.setText("停止");

    }
}
