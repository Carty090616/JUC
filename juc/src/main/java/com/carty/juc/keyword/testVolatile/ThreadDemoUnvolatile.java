package com.carty.juc.keyword.testVolatile;

import lombok.Data;

/**
 * 〈类变量没有被volatile修饰〉
 *
 * @author Lifeifei
 * @create 2018/11/26
 * @since 1.0.0
 */
@Data
public class ThreadDemoUnvolatile implements Runnable {

    private boolean flag = false;

    @Override
    public void run() {
        System.out.println("*******ThreadDemoUnvolatile*******");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        flag = true;
        System.out.println("flag: " + flag);
    }

}
