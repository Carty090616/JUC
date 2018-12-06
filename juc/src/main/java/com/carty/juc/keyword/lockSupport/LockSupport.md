## LockSupport的park()/unpark()和Object的wait()/notify()比较

### Object的wait()/notify()

   + 必须要在同步代码块中执行
   + *`wait()`*必须要在*`notify()`*之前执行，否则有可能造成线程阻塞
---

### LockSupport的park()/unpark()

   + 可以不再同步代码块中执行
   + *`unpark()`*可以在*`park()`*前执行，不会有阻塞的风险
   + *`unpark()`*和*`park()`*分别调用了`sun.misc.Unsafe`的*`unpark()`*和*`park()`*
   
### 参考博客

   + [https://www.cnblogs.com/qingquanzi/p/8228422.html](https://www.cnblogs.com/qingquanzi/p/8228422.html)