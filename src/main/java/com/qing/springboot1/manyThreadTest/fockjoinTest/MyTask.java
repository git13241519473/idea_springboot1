package com.qing.springboot1.manyThreadTest.fockjoinTest;

import org.springframework.util.CollectionUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

public class MyTask extends RecursiveTask<Integer> {

    private Integer num = 0;

    private File file;

    public MyTask(File file){
        this.file = file;
    }

    @Override
    protected Integer compute() {
        List<MyTask> list = new ArrayList<>();
        if(file != null){
            if(file.isDirectory()){
                for(File subFile: file.listFiles()){
                    System.out.println(subFile.getAbsolutePath());
                    if(subFile.isDirectory()){
                        list.add(new MyTask(subFile));
                    }else{
                        num++;
                    }
                }
            }else{
                num = 1;
            }

            if(!CollectionUtils.isEmpty(list)){
                for(MyTask myTask: invokeAll(list)){
                    num += myTask.join();
                }
            }

        }
        return num;
    }
}
