package com.peace.hp.demo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.peace.hp.viewbind.HpBind;
import com.peace.hp.viewbind.annotation.OnClick;
import com.peace.hp.viewbind.annotation.BindView;
import com.peace.hp.viewbind.annotation.ROnClick;

public class MainActivity extends AppCompatActivity {

    @BindView("button1") private Button mButton1;

    @BindView("layout1") private ConstraintLayout mLayout;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        HpBind.bind(this);
        mButton1.performClick();
    }

    @ROnClick(R.id.button1)
    public void hello(View view) {
        Toast.makeText(this, "hellow1" , Toast.LENGTH_LONG).show();
    }

    @OnClick("button2")
    public void hello1(View view) {
        Toast.makeText(this, "hellow2", Toast.LENGTH_LONG).show();
    }

}
