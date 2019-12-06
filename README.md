# java基础篇-注解

## java注解

定义：注解（Annotation），也叫元数据。一种代码级别的说明。它是JDK1.5及以后版本引入的一个特性，与类、接口、枚举是在同一个层次。它可以声明在包、类、字段、方法、局部变量、方法参数等的前面，用来对这些元素进行说明，注释。《摘自-百度百科》

通常用作：

* 编写文档：通过代码里标识的元数据生成文档【生成文档doc文档】
* 代码分析：通过代码里标识的元数据对代码进行分析【使用反射】
* 编译检查：通过代码里标识的元数据让编译器能够实现基本的编译检查【Override】

## 元注解

* 


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
