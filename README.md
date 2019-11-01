# HPViewBind 安卓view绑定 

## 导入方式

引入BuildResult目录下hp-viewbind1.0.0.jar即可

*pack.gradle为打包脚本*


## 使用

```
HpBind.bind(Activity)

HpBind.bind(target, view)
```

### R引用 

1. id绑定： @RBindView
2. onClick绑定: @ROnClick

### 不使用R引用（SDK开发）

1. id绑定： @BindView
2. onClick绑定：@OnClick

### 具体使用可参照demo
```
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

```
