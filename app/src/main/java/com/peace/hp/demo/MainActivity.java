package com.peace.hp.demo;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.peace.hp.viewbind.HpBind;
import com.peace.hp.viewbind.annotation.BindView;
import com.peace.hp.viewbind.annotation.OnClick;
import com.peace.hp.viewbind.annotation.RBindView;
import com.peace.hp.viewbind.annotation.ROnClick;

public class MainActivity extends AppCompatActivity {


    @BindView("button1")
    private Button mButton1;
    @RBindView(R.id.button2)
    Button mButton2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        HpBind.bind(this);
        mButton1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(MainActivity.this, "button1 long click", Toast.LENGTH_LONG).show();
                return true;
            }
        });

        mButton2.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(MainActivity.this, "button2 long click", Toast.LENGTH_LONG).show();
                return true;
            }
        });
    }

    @ROnClick(R.id.button1)
    public void hello(View view) {
        Toast.makeText(this, "hellow1", Toast.LENGTH_LONG).show();
    }

    @OnClick("button2")
    public void hello1(View view) {
        Toast.makeText(this, "hellow2", Toast.LENGTH_LONG).show();
    }


    private static boolean isApkDebug(Context context) {
        ApplicationInfo info = context.getApplicationInfo();
        return (info.flags & ApplicationInfo.FLAG_DEBUGGABLE) != 0;
    }

}
