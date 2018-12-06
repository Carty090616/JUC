/**
 * Copyright (C), 2015-2018, 章鱼云商
 * FileName: TestAQS
 * Author:   Lifeifei
 * Date:     2018/11/27 9:36
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.carty.juc.keyword.testAQS;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 〈〉
 *
 * @author Lifeifei
 * @create 2018/11/27
 * @since 1.0.0
 */
public class TestAQS {

    public static void main(String[] args) {
        Lock lock = new ReentrantLock();

        MyThread mt1 = new MyThread("mt1", lock);
        MyThread mt2 = new MyThread("mt2", lock);
        mt1.start();
        mt2.start();
    }
}