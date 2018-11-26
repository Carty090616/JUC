/**
 * Copyright (C), 2015-2018, 章鱼云商
 * FileName: ThreadDemoVolatile
 * Author:   Lifeifei
 * Date:     2018/11/26 10:11
 * Description: 类变量没有被volatile修饰
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.carty.juc.keyword.testVolatile;

import lombok.Data;

/**
 * 〈类变量被volatile修饰〉
 *
 * @author Lifeifei
 * @create 2018/11/26
 * @since 1.0.0
 */
@Data
public class ThreadDemoVolatile implements Runnable {

    private volatile boolean flag = false;

    @Override
    public void run() {
        System.out.println("*******ThreadDemoVolatile*******");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        flag = true;
        System.out.println("flag: " + flag);
    }
}