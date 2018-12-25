/**
 * Copyright (C), 2015-2018, 章鱼云商
 * FileName: Task
 * Author:   Lifeifei
 * Date:     2018/12/21 15:28
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.carty.juc.keyword.BlockingQueue.PriorityBlockingQueue;

import lombok.Data;

/**
 * 〈〉
 *
 * @author Lifeifei
 * @create 2018/12/21
 * @since 1.0.0
 */
@Data
public class Task implements Comparable<Task> {

    private int id;

    public Task(String name, Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                '}';
    }

    @Override
    public int compareTo(Task task) {
        return task.getId() > this.getId() ? 1 : -1;
    }
}