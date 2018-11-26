### Callable学习
   + 带泛型的接口
   + call() 拥有返回类型，可抛异常

### Future学习
   + 带泛型的接口
   + 用于接受Callable类型任务的返回结果
~~~
    public interface Future<V> {
        // 用于取消任务
        boolean cancel(boolean mayInterruptIfRunning);
        // 查询任务是否取消
        boolean isCancelled();
        // 查询任务是否完成
        boolean isDone();
        // 获取任务执行的结果
        V get() throws InterruptedException, ExecutionException;
        // 获取任务执行的结果。在指定的时间内未获取到结果则返回null
        V get(long timeout, TimeUnit unit)
            throws InterruptedException, ExecutionException, TimeoutException;
    }
~~~

### FutureTask学习
   + 带泛型的类，实现自RunnableFuture(继承Runnable和Future)
   + 用于接受Callable类型任务的返回结果
   + 时Future的唯一实现类