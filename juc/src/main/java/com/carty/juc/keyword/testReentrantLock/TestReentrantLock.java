/**
 * Copyright (C), 2015-2018, 章鱼云商
 * FileName: TestReentrantLock
 * Author:   Lifeifei
 * Date:     2018/11/26 14:26
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.carty.juc.keyword.testReentrantLock;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 〈测试ReentrantLock，两个线程对相同变量操作，输出结果为10000000，20000000〉
 *
 * @author Lifeifei
 * @create 2018/11/26
 * @since 1.0.0
 */
public class TestReentrantLock {
    public static void main(String[] args) {
        ExecutorService es = Executors.newCachedThreadPool();
        ReentrantLockDemo rl1 = new ReentrantLockDemo();
        ReentrantLockDemo rl2 = new ReentrantLockDemo();
        Future<Integer> res1 = es.submit(rl1);
        Future<Integer> res2 = es.submit(rl2);
        es.shutdown();

        try {
            System.out.println("res1: " + res1.get());
            System.out.println("res2: " + res2.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}