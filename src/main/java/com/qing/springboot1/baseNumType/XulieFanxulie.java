package com.qing.springboot1.baseNumType;

import java.io.*;

public class XulieFanxulie {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        User1 user = new User1();
        user.setName("佳佳");
        user.setAge(24);
        System.out.println(user);

        //第一种方式：使用  ByteArrayOutputStream 和 ByteArrayInputStream
        //序列化
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(user); //序列化完成
        byte[] bytes = bos.toByteArray();
        oos.close();
        bos.close();

        //反序列化
        ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
        ObjectInputStream ois = new ObjectInputStream(bis);
        Object o = ois.readObject();
        if(o instanceof User1){
            User1 user1 = (User1) o;
            System.out.println(user1);
        }
        ois.close();
        bis.close();
        /*//第二种方式：使用文件作为存储介质
        //序列化
        File file = createFile("C:\\F\\xuliehuaFile\\user");
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oops = new ObjectOutputStream(fos);
        oops.writeObject(user);
        oops.close();
        fos.close();
        //反序列化
        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream oips = new ObjectInputStream(fis);
        Object o1 = oips.readObject();
        if(o1 instanceof User1){
            User1 user1 = (User1) o1;
            System.out.println(user1);
        }
        oips.close();
        fis.close();*/

    }


    public static File createFile(String path){
        File file = new File(path);
        if(!file.exists()){
            try {
                boolean newFile = file.createNewFile();
                System.out.println("创建文件成功了");
            } catch (IOException e) {
                System.out.println("创建文件失败了");
                e.printStackTrace();
            }
        }
        return file;
    }
}
