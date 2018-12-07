/**
 * Copyright (C), 2015-2018, 章鱼云商
 * FileName: TestSharedVariable
 * Author:   Lifeifei
 * Date:     2018/12/7 10:45
 * Description: 测试使用共享变量中断线程
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.carty.juc.keyword.Thread.interrupt;

import lombok.extern.slf4j.Slf4j;

/**
 * 〈测试使用共享变量中断线程〉
 *
 * @author Lifeifei
 * @create 2018/12/7
 * @since 1.0.0
 */
public class TestSharedVariable {

    public static void main(String[] args) throws InterruptedException {
        TestThread testThread = new TestThread();
        Thread t = new Thread(testThread);

        System.out.println("开始执行");
        t.start();

        System.out.println("开始sleeping");
        Thread.sleep(5000);
        // 改变共享变量的值
        Varable.stop = true;

    }

}

@Slf4j
class TestThread implements Runnable {

    @Override
    public void run() {
        while (!Varable.stop) {
            log.info("thread is running");

            long time = System.currentTimeMillis();
            while (System.currentTimeMillis() - time < 1000) {
//                log.info("sleeping");
            }
        }
        if (Varable.stop) {
            log.info("thread is stop 【{}】", Varable.stop);
        }
    }
}