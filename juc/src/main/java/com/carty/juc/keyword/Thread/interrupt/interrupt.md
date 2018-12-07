## interrupt

   + Java的中断是一种协作机制。也就是说调用线程对象的interrupt方法并不一定就中断了正在运行的线程，它只是要求线程自己在合适的时机中断自己。每个线程都有一个boolean的中断状态（这个状态不在Thread的属性上），interrupt方法仅仅只是将该状态置为true。
   + 对于处于`sleep()\join()`等操作的线程，在被调用`interrupt()`之后，会抛出`InterruptException`，并且线程中断标志位会由true转为false，因为线程为了处理异常已经重新处于就绪状态
   + 不可中断的操作，包括进入synchronized段以及`Lock.lock()`，`inputSteam.read()`等，调用interrupt()对于这几个问题无效，因为它们都不抛出中断异常。如果拿不到资源，它们会无限期阻塞下去。
     + 对于`Lock.lock()`，可以改用`Lock.lockInterruptibly()`，可被中断的加锁操作，它可以抛出中断异常。等同于等待时间无限长的`Lock.tryLock(long time, TimeUnit unit)`。
     + 对于inputStream等资源，有些(实现了interruptibleChannel接口)可以通过close()方法将资源关闭，对应的阻塞也会被放开。
   + 一般说来，如果一个方法声明抛出InterruptedException，表示该方法是可中断的,比如wait,sleep,join，也就是说可中断方法会对interrupt调用做出响应（例如sleep响应interrupt的操作包括清除中断状态，抛出InterruptedException）,异常都是由可中断方法自己抛出来的，并不是直接由interrupt方法直接引起的。
     + `Object.wait`, `Thread.sleep`方法，会不断的轮询监听 interrupted 标志位，发现其设置为true后，会停止阻塞并抛出 InterruptedException异常。

## 与interrupt相关的方法

| 方法 | 说明 |
| :--- | :--- |
|public static boolean interrupted|public static boolean interrupted|

## 参考博客
   + http://www.cnblogs.com/onlywujun/p/3565082.html