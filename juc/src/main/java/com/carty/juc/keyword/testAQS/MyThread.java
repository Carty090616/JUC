/**
 * Copyright (C), 2015-2018, 章鱼云商
 * FileName: MyThread
 * Author:   Lifeifei
 * Date:     2018/11/27 9:31
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.carty.juc.keyword.testAQS;

import java.util.concurrent.locks.Lock;

/**
 * 〈〉
 *
 * @author Lifeifei
 * @create 2018/11/27
 * @since 1.0.0
 */
public class MyThread extends Thread {

    private Lock lock;

    public MyThread(String name, Lock lock) {
        super(name);
        this.lock = lock;
    }

    @Override
    public void run() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread() + " running");
        } finally {
            lock.unlock();
        }
    }
}