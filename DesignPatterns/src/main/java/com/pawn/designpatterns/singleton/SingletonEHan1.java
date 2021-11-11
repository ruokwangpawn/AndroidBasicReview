package com.pawn.designpatterns.singleton;

/**
 * 单例模式
 * 饿汉式(最基础)
 * 类再被加载到内存的时候就去初始化
 * 很容易造成资源浪费，而且也不符合lazy load
 */
public class SingletonEHan1 {

    private final static SingletonEHan1 INSTANCE = new SingletonEHan1();

    private SingletonEHan1() {
    }

    public static SingletonEHan1 getInstance() {
        return INSTANCE;
    }
}
