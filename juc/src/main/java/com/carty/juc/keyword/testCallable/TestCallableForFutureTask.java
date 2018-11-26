/**
 * Copyright (C), 2015-2018, 章鱼云商
 * FileName: TestCallableForFutureTask
 * Author:   Lifeifei
 * Date:     2018/11/26 11:39
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.carty.juc.keyword.testCallable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * 〈测试返回结果用FutureTask接收〉
 *
 * @author Lifeifei
 * @create 2018/11/26
 * @since 1.0.0
 */
public class TestCallableForFutureTask {

    public static void main(String[] args) {
        ExecutorService es = Executors.newCachedThreadPool();
        CallableDemo callableDemo = new CallableDemo();
        FutureTask<Integer> res = new FutureTask<>(callableDemo);
        es.submit(res);
        es.shutdown();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }

        System.out.println("主线程在执行任务");

        try {
            // get()方法会一直阻塞到线程返回结果为止
            System.out.println("task运行结果" + res.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("所有任务执行完毕");
    }
}