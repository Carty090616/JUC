/**
 * Copyright (C), 2015-2018, 章鱼云商
 * FileName: TestInterrupt
 * Author:   Lifeifei
 * Date:     2018/12/7 10:18
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.carty.juc.keyword.Thread.interrupt;

import lombok.extern.slf4j.Slf4j;

/**
 * 〈测试Thread.interrupt〉
 *
 *  Thread.interrupt不会终止一个正在运行的线程，
 *  Thread.interrupt实质上是设置线程的中断标识位，
 *  在线程被阻塞处抛出一个InterruptException，并且中断状态会被清除，使得线程退出阻塞状态继续运行
 *
 * @author Lifeifei
 * @create 2018/12/7
 * @since 1.0.0
 */
public class TestInterrupt {

    public static void main(String[] args) {
        Interrupt interrupt = new Interrupt();
        Thread t = new Thread(interrupt);

        t.start();
        t.interrupt();
    }

}

@Slf4j
class Interrupt implements Runnable {

    @Override
    public void run() {
        log.info("开始工作");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            log.error("中断");
        }
        log.info("结束工作");
    }
}