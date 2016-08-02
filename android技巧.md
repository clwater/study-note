# Android

## 很好的开源库

* [PullToRefresh](http://lumenghz.com/2016/07/08/pulltorefresh/) 下拉刷新(火箭发射,太阳升起)
* [EventBus](http://www.jianshu.com/p/da9e193e8b03) 事件交互.
* [okhttp](https://github.com/square/okhttp) 网络交互
* [nohttp](http://www.yanzhenjie.com/nohttp.html) 网络交互
* [PswInput](https://github.com/huage2580/PswInputViewDemo) 仿支付宝密码输入
* [ElemeShoppingView](https://github.com/JeasonWong/ElemeShoppingView) 仿饿了么点击购物效果
* [HTextView](https://github.com/hanks-zyh/HTextView) TextView特殊效果显示
* [CheckBox](https://github.com/CoXier/CheckBox) 自定义checkout.
* [recyclerview-animators](https://github.com/wasabeef/recyclerview-animators) 某个recyclerview动画

## 一些很好用的方法

* TextUtils.isEmpty() 判断是否为空
* 创建单例模式

        public class SingleInstance {
        	private static volatile SingleInstance sInstance;
        	private SingleInstance() {}
        	public static SingleInstance getInstance() {
        		if (null == sInstance) {
          			synchronized (SingleInstance.class) {
              			if (null == sInstance) {
                  			sInstance = new SingleInstance();
              			}
          			}
        		}
        	return sInstance;
        	}
        }



## 一些很好的学资料

* [一些android常用方法](http://www.jianshu.com/p/72494773aace)


