/**
 * Copyright (C), 2015-2018, 章鱼云商
 * FileName: TestPriorityBlockingQueue
 * Author:   Lifeifei
 * Date:     2018/12/21 15:28
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.carty.juc.keyword.BlockingQueue.PriorityBlockingQueue;

import java.util.concurrent.PriorityBlockingQueue;

/**
 * 〈〉
 *
 * @author Lifeifei
 * @create 2018/12/21
 * @since 1.0.0
 */
public class TestPriorityBlockingQueue {

    public static void main(String[] args) {
        PriorityBlockingQueue<Task> queue = new PriorityBlockingQueue<>();

        Task task1 = new Task("task1", 5);
        Task task2 = new Task("task2", 10);
        Task task3 = new Task("task3", 55);
        Task task4 = new Task("task4", 16);
        Task task5 = new Task("task5", 100);
        Task task6 = new Task("task6", 56);
        Task task7 = new Task("task7", 40);
        Task task8 = new Task("task8", 99);

        queue.add(task1);
        System.out.println(queue);
        queue.add(task2);
        System.out.println(queue);
        queue.add(task3);
        System.out.println(queue);
        queue.add(task4);
        System.out.println(queue);
        queue.add(task5);
        System.out.println(queue);
        queue.add(task6);
        System.out.println(queue);
        queue.add(task7);
        System.out.println(queue);
        queue.add(task8);
        System.out.println(queue);


        queue.poll();
        System.out.println(queue);
        queue.poll();
        System.out.println(queue);
        queue.poll();
        System.out.println(queue);
        queue.poll();
        System.out.println(queue);
        queue.poll();
        System.out.println(queue);
        queue.poll();
        System.out.println(queue);
        queue.poll();
        System.out.println(queue);
        queue.poll();
        System.out.println(queue);
    }
}