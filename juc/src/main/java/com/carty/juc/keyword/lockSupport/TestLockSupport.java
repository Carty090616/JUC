/**
 * Copyright (C), 2015-2018, 章鱼云商
 * FileName: TestLockSupport
 * Author:   Lifeifei
 * Date:     2018/12/6 9:34
 * Description: 测试LockSupport--样例1
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.carty.juc.keyword.lockSupport;

import java.util.concurrent.locks.LockSupport;

/**
 * 〈测试LockSupport--样例1〉
 *
 * @author Lifeifei
 * @create 2018/12/6
 * @since 1.0.0
 */
public class TestLockSupport {

    public static void main(String[] args) throws Exception {
        Thread A = new Thread(new Runnable() {
            @Override
            public void run() {
                int sum = 0;
                System.out.println("开始结算");
                for (int i = 0 ; i < 10 ; i++) {
                    sum += i;
                }
                System.out.println("计算结束");
                LockSupport.park();
                System.out.println(sum);
            }
        });
        A.start();
        System.out.println("开始沉睡");
        Thread.sleep(3000);
        System.out.println("结束沉睡");
        LockSupport.unpark(A);
    }
}