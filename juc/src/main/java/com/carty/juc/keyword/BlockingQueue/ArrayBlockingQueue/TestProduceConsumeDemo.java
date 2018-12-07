/**
 * Copyright (C), 2015-2018, 章鱼云商
 * FileName: TestArrayBlockingQueue
 * Author:   Lifeifei
 * Date:     2018/12/6 11:39
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.carty.juc.keyword.BlockingQueue.ArrayBlockingQueue;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * 〈测试ArrayBlockingQueue〉
 *
 * @author Lifeifei
 * @create 2018/12/6
 * @since 1.0.0
 */
@Slf4j
public class TestProduceConsumeDemo {

    public static void main(String[] args) {
        ArrayBlockingQueue<Cookie> arrayBlockingQueue = new ArrayBlockingQueue<Cookie>(10);
        Produce produce = new Produce(arrayBlockingQueue);
        produce.start();
        // 一个生产者，5个消费者
        new Thread(new Consume(arrayBlockingQueue)).start();
        new Thread(new Consume(arrayBlockingQueue)).start();
        new Thread(new Consume(arrayBlockingQueue)).start();
        new Thread(new Consume(arrayBlockingQueue)).start();
        new Thread(new Consume(arrayBlockingQueue)).start();
    }

}

@Slf4j
class Produce extends Thread {

    private static int i = 0;

    private ArrayBlockingQueue<Cookie> arrayBlockingQueue;

    public Produce (ArrayBlockingQueue<Cookie> arrayBlockingQueue) {
        this.arrayBlockingQueue = arrayBlockingQueue;
    }

    @Override
    public void run() {
        try {
            log.info("开始生产");
            while (i < 1000) {
                arrayBlockingQueue.put(new Cookie("cookie" + i));
                if (++i % 100 == 0) {
                    // 每生产100个，休息10s
                    log.info("已经生产【{}】", i);
                    Thread.sleep(10000);
                }
            }
            log.info("结束生产");
        } catch (InterruptedException e) {
            System.out.println("produce queue InterruptedException");
        }

    }
}

@Slf4j
class Consume implements Runnable {

    private ArrayBlockingQueue<Cookie> arrayBlockingQueue;

    public Consume (ArrayBlockingQueue<Cookie> arrayBlockingQueue) {
        this.arrayBlockingQueue = arrayBlockingQueue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                // 如果queue为null，那么5秒之后再去队列中取数据
                Cookie poll = arrayBlockingQueue.poll(5, TimeUnit.SECONDS);
                if (poll == null) {
                    System.out.println(Thread.currentThread().getName()+"--consume --"+poll);
                } else {
                    System.out.println(Thread.currentThread().getName()+"--consume --"+poll);
                }
            }
        } catch (InterruptedException e) {
            System.out.println("consume queue InterruptedException");
        }
    }
}

class Cookie {

    private String number;

    public Cookie (String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return number + "";
    }
}