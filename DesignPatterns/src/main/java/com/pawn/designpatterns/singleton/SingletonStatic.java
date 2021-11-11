package com.pawn.designpatterns.singleton;

/**
 * @ClassName: SingletonStatic
 * @Author: wangzhao
 * @CreateDate: 9/21/20 11:22 PM
 * @Description: 静态内部类实现单例 --- 类加载在加载类的时候，是线程安全的
 * 这种方案的缺点是不能在初始化的时候传参
 * 反射和序列化不安全？
 * @Version: 1.0
 */
public class SingletonStatic {

    private SingletonStatic() {

    }

    private static class HOLDER {
        private static final SingletonStatic INSTANCE = new SingletonStatic();
    }

    public static SingletonStatic getInstance() {
        return HOLDER.INSTANCE;
    }
}
