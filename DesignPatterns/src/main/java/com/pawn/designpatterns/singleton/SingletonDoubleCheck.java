package com.pawn.designpatterns.singleton;

/**
 * @ClassName: SingletonDCL
 * @Author: wangzhao
 * @CreateDate: 9/21/20 11:17 PM
 * @Description:
 * @Version: 1.0
 */
public class SingletonDoubleCheck {

    // volatile：原子性、可见性、有序性
    // 这里必须要用volatile，保证变量在多个线程可见性，强制从公共堆栈中获取变量值，而不从线程私有数据栈内取
    private static volatile SingletonDoubleCheck INSTANCE;

    private SingletonDoubleCheck() {

    }

    public static SingletonDoubleCheck getInstance() {
        if (INSTANCE == null) {
            synchronized (SingletonDoubleCheck.class) {
                if (INSTANCE == null) {
                    INSTANCE = new SingletonDoubleCheck();
                }
            }
        }
        return INSTANCE;
    }
}
