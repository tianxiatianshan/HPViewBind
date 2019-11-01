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

**具体使用可参照demo**
