package com.carty.juc.keyword.testVolatile;

/**
 * volatile可以保证线程可见性且提供了一定的有序性，但是无法保证原子性。在JVM底层volatile是采用“内存屏障”来实现的。
 * 上面一段话表示两层语义
 * 1. 保证可见性、不保证原子性
 * 2. 禁止指令重排序
 *
 * @author Lifeifei
 * @create 2018/11/26
 * @since 1.0.0
 */
public class TestVolatile {

    public static void main(String[] args) {
//        test01();
        test02();
    }

    /**
     * <测试volatile修饰变量>
     *
     * @return void
     * @author Lifeifei
     * @date 2018/11/26 10:14
     */
    public static void test01() {
        ThreadDemoVolatile td = new ThreadDemoVolatile();
        new Thread(td).start();
        while (true) {
            if (td.isFlag()) {
                System.out.println("***********表明主线程回去到了被volatile修饰的变量值***********");
                break;
            }
        }
    }

    /**
     * <测试没有volatile修饰变量>
     *
     * @return void
     * @author Lifeifei
     * @date 2018/11/26 10:14
     */
    public static void test02() {
        ThreadDemoUnvolatile td = new ThreadDemoUnvolatile();
        new Thread(td).start();
        while (true) {
            if (td.isFlag()) {
                System.out.println("***********表明主线程回去到了被volatile修饰的变量值***********");
                break;
            }
        }
    }

}
