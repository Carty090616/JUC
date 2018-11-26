/**
 * Copyright (C), 2015-2018, 章鱼云商
 * FileName: testReentrantLock
 * Author:   Lifeifei
 * Date:     2018/11/26 14:13
 * Description: 测试ReentrantLock
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.carty.juc.keyword.testReentrantLock;

import java.util.concurrent.Callable;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 〈测试ReentrantLock〉
 *
 * @author Lifeifei
 * @create 2018/11/26
 * @since 1.0.0
 */
public class ReentrantLockDemo implements Callable<Integer> {

    public static ReentrantLock lock = new ReentrantLock();

    public static int i = 0;

    @Override
    public Integer call() throws Exception {
        // 加锁
        lock.lock();
        try {
            for (int j = 0; j < 10000000; j++) {
                i++;
            }
        } finally {
            // 释放锁
            lock.unlock();
        }

        return i;
    }
}