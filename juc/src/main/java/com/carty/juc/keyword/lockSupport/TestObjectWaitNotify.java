/**
 * Copyright (C), 2015-2018, 章鱼云商
 * FileName: TestObjectWaitNotify
 * Author:   Lifeifei
 * Date:     2018/12/6 9:46
 * Description: 测试Object的wait/notify方法
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.carty.juc.keyword.lockSupport;

/**
 * 〈测试Object的wait/notify方法〉
 *
 * @author Lifeifei
 * @create 2018/12/6
 * @since 1.0.0
 */
public class TestObjectWaitNotify {

    public static void main(String[] args) throws Exception {
        final Object obj = new Object();
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                int sum = 0;
                for (int i = 0 ; i < 10 ; i++) {
                    sum += i;
                }
                try {
                    synchronized (obj) {
                        obj.wait();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println(sum);
            }
        });
        t.start();
        // 睡眠一秒钟，保证线程t已经计算完成，阻塞在wait方法
//        Thread.sleep(2000);
        synchronized (obj) {
            obj.notify();
        }
    }
}