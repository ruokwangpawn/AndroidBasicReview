package com.pawn.designpatterns.singleton;

/**
 * @ClassName: Singleton2
 * @Author: wangzhao
 * @CreateDate: 9/21/20 10:53 PM
 * @Description: 懒汉式---使用者调用时再去初始化
 * @Version: 1.0
 */
public class SingletonLanHan1 {

    private static SingletonLanHan1 INSTANCE;

    private SingletonLanHan1() {
    }

    public static SingletonLanHan1 getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new SingletonLanHan1();
        }
        return INSTANCE;
    }
}
