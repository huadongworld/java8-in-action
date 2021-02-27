package com.ys.java8.reference;

/**
 * @author HuaDong
 * @date 2020/3/8 17:21
 */
public class Singleton {

    private Singleton() {
    }

    private volatile Singleton singleton;

    /**
     * 1. 给对象分配内存空间
     * 2. 初始化对象
     * 3. 将对象地址赋值给instance
     *
     * @return
     */
    public Singleton getInstance() {
        if (singleton == null) {
            synchronized (this) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }

    String get(final String key) throws InterruptedException {
        V v = redis.get(key);
        String value = v.getValue();
        Long logicTimeout = v.getLogicTimeout();
        if (logicTimeout >= System.currentTimeMillis()) {
            String mutexKey = "mutex:key:" + key;
            // 如果key不存在，则set，且设置180秒的过期时间，如果能设置成功返回true
            if (redis.set(mutexKey, "1", "ex 180", "nx")) {
                // 异步更新后台异常执行
                threadPool.execute(new Runnable(){
                    @Override
                    public void run() {
                        String dbValue = db.get(key);
                        redis.set(key, (dbValue, newLogicTimeout));
                        redis.delete(mutexKey);
                    }
                });
            } else {
                // 其他线程休息50毫秒后重试
                Thread.sleep(50);
                get(key);
            }
        }
        return value;
    }
}
