package com.pawn.designpatterns.singleton;

/**
 * @ClassName: Singleton3
 * @Author: wangzhao
 * @CreateDate: 9/21/20 11:06 PM
 * @Description: 懒汉式---静态代码块，与饿汉式基础班其实没有什么区别
 * @Version: 1.0
 */
public class SingletonEHan2 {

    private static SingletonEHan2 INSTANCE;

    static {
        INSTANCE = new SingletonEHan2();
    }

    private SingletonEHan2() {

    }

    public static SingletonEHan2 getInstance() {
        return INSTANCE;
    }
}
