package com.pawn.designpatterns.singleton;

/**
 * @ClassName: SingletonLanHan2
 * @Author: wangzhao
 * @CreateDate: 9/21/20 11:12 PM
 * @Description: 懒汉式---线程安全
 * @Version: 1.0
 */
public class SingletonLanHan2 {

    private static SingletonLanHan2 INSTANCE;

    private SingletonLanHan2() {
    }

    public static synchronized SingletonLanHan2 getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new SingletonLanHan2();
        }
        return INSTANCE;
    }
}
