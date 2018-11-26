## ReentrantLock

synchronized原语和ReentrantLock在一般情况下没有什么区别，但是在非常复杂的同步应用中，请考虑使用ReentrantLock，特别是遇到下面2种需求的时候。 
   + 某个线程在等待一个锁的控制权的这段时间需要中断 
   + 需要分开处理一些wait-notify，ReentrantLock里面的Condition应用，能够控制notify哪个线程 
   + 具有公平锁功能，每个到来的线程都将排队等候 