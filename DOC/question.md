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
   调用interrupt，通知该线程应该中断
   如果现场处于阻塞状态，则该该线程立即退出阻塞状态，抛出一个InterruptedException
   如果该线程处于活跃的状态。则会将该线程的中断标志位设置为true.被设置中断标志的线程将继续正常运行，不受影响
   需要被调用的线程配合中断使用
 10. Reentrantlock
     位于java.util.locks
     基于AQS
     比synchronized更细粒度话控制
     lock后必须unlock
     
     synchronized与Reentrantlock区别
     - synchronized是关键字，Reentrantlock是类
     - Reentrantlock可与获取锁的等待时间避免死锁
     - Reentrantlock 可以获取锁的各种信息
     - synchronized 操作对象头的MarkWord ,lock调用unSafe类的park方法
 
 11. java内存模型JMM主内存与工作内存
      JMM主内存
      - 存储实例对象
      - 包含成员变量，类信息，常量，静态变量
     
      JMM工作内存
      - 存储当前方法的所有本地信息，本地信息对其他线程不可见
      
      volatile : JVM提供的轻量级同步机制
      - 保证volatile修饰的共享变量对所有线程总是可见的（并非真正的线程同步）
      
      synchronized 悲观锁
      CAS(Compare and Swap) 乐观锁机制（提交检测）atomic
        使用unsafe的方法
  11. java线程池
      - newFixedThreadPool(int nThread) 指定线程池数量的线程池
      - newCachedThread()
        处理大量短时间工作任务的线程池
      - newSingleThreadExcutor()
        创建唯一的工作线程来执行任务，如果线程异常结束，会有令一个线程取代他
      - newSingleThreadScheduledExcutor与newScheduledThreadPool(int corepoolSize)
        定时或者周期性任务调度
      - newWorkStealingPool()
      
        Executor/ExecutorService/ScheduledExecutorService