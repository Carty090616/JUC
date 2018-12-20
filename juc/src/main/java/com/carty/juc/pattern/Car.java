/**
 * Copyright (C), 2015-2018, 章鱼云商
 * FileName: Car
 * Author:   Lifeifei
 * Date:     2018/12/19 16:39
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.carty.juc.pattern;

/**
 * 〈〉
 *
 * @author Lifeifei
 * @create 2018/12/19
 * @since 1.0.0
 */
public abstract class Car {

    public abstract String method01();

    public abstract String method02();

    public void run() {
        try {
            method01();
            method02();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}