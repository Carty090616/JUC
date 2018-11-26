/**
 * Copyright (C), 2015-2018, 章鱼云商
 * FileName: CallableDemo
 * Author:   Lifeifei
 * Date:     2018/11/26 11:25
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.carty.juc.keyword.testCallable;

import java.util.concurrent.Callable;

/**
 * 〈测试Callable线程类〉
 *
 * @author Lifeifei
 * @create 2018/11/26
 * @since 1.0.0
 */
public class CallableDemo implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println("********子线程正在进行计算********");
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            sum += i;
        }
        // 线程沉睡5s，模拟计算过程比较长的情况
        Thread.sleep(5000);
        return sum;
    }
}