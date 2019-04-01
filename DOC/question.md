1. Thread中的start与run
    run 沿用主线程方法调用
    start 会开辟新线程进行调用
2. Thread与runnable的区别
     Thread是实现了Runnable接口的类，使用run支持多线程
     
     实现线程的方式
       继承Thread,重写run方法,
       实现runnable接口，传入Thread.
       start 方法最后还是找run
3. 如何给run()方法传参 
    构造方法传参
    成员变量传参
    回调函数传参  
4.  线程返回值
     - 主线程等待子线程
     - 使用Thread类的join()方法阻塞当前线程以等待处理子线程完毕
     - 通过Callable接口实现：通过FutuerTask OR 线程池获取
5. 线程的状态

   新建
   运行
   无限期等待
   限期等待
   阻塞
   结束

6. sleep与wait的区别   
   sleep是Thread的方法 ， wait是Object类中定义的方法       
   sleep可以在任何地方使用
   wait只能在synchronized方法(块)中使用
   
   wait会释放同步锁
   
7. notify与notifyall唤醒线程
    锁池：EntryList
    等待池：WaitSet
    
    notifyall 会让所有处于等待池的线程进入锁池去获取锁
    notify  随机选取一个属于等待池的线程进入锁池去获取锁
8. 当调用Thread.yied()函数时，会给线程调度器一个当前线程愿意让处cpu的暗示，但线程调度器可能会忽视这个暗示
9. 如何中断线程
   通过调用stop方法停止线程(已过期)
   #调用interrupt，通知该线程应该中断
   如果现场处于阻塞状态，则该该线程立即退出阻塞状态，抛出一个InterruptedException
   如果该线程处于活跃的状态。则会将该线程的中断标志位设置为true.被设置中断标志的线程将继续正常运行，不受影响
   需要被调用的线程配合中断使用
      