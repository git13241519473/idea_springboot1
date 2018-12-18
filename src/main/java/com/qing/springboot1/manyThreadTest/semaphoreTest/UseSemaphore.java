package com.qing.springboot1.manyThreadTest.semaphoreTest;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class UseSemaphore {

    private static Semaphore semaphore = new Semaphore(10);

    static class Conn implements Runnable{
        private String name;
        public Conn() {

        }
        public Conn(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            try {
                semaphore.acquire(); //获取一个许可证
                System.out.println(getName() + " 开始执行，");
                Thread.sleep(new Random().nextInt(3000));
                System.out.println(getName() + " 执行完毕，释放资源");
                semaphore.release();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        for(int i = 0; i <= 50; i++){
            Conn conn = new Conn("连接：" + i + "  ");
            Thread thread = new Thread(conn);
            thread.start();

        }
    }

}
