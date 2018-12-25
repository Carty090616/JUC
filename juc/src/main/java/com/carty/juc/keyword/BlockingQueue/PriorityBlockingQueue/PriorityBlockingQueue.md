1. 排序时机分为两次
 + 插入 - put/add/offer 对应使用 siftUpComparable 排序方法；
    + 每当加入一个元素 , 与当前队列队首元素compareTo比较 , 根据返回值决定是否排到队首
    ```（只能保证队首的元素是最小的或是最大的，根据自定义的compareTo()方法的返回值）```
 + 弹出 - poll(remove)/take 对应使用 siftDownComparable 排序方法；
    + 调用 dequeue 方法直接弹出队首元素 , 由于插入时保证队首永远为 compareTo 为1 的元素即符合判断顺序的元素 , siftDownComparable 方法使用建立最小堆的算法做元素重排序
    ```（保证队首的元素是最小的或是最大的，根据自定义的compareTo()方法的返回值）```