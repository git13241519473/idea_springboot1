package com.qing.springboot1.DesignModule23.zu_he_M;

public class DemoTest {

    /**
     组合模式：
     对于树形结构，当容器对象（如文件夹）的某一个方法被调用时，将遍历整个树形结构，
     寻找也包含这个方法的成员对象（可以是容器对象，也可以是叶子对象）并调用执行，牵一而动百，
     其中使用了递归调用的机制来对整个结构进行处理。由于容器对象和叶子对象在功能上的区别，
     在使用这些对象的代码中必须有区别地对待容器对象和叶子对象，而实际上大多数情况下我们希望一致地处理它们，
     因为对于这些对象的区别对待将会使得程序非常复杂。组合模式为解决此类问题而诞生，
     它可以让叶子对象和容器对象的使用具有一致性。
     */


    public static void main(String[] args) {
        AbstractFile file = createFiles();
        file.sayName();

    }


    public static AbstractFile createFiles(){
        Folder folder1 = new Folder();
        folder1.setName("文件夹01");

        Folder folder2 = new Folder();
        folder2.setName("文件夹02");
        folder1.addFile(folder2);

        Folder folder3 = new Folder();
        folder3.setName("文件夹03");
        folder1.addFile(folder3);

        TextFile file1 = new TextFile();
        file1.setName("劫过九重城关");
        folder2.addFile(file1);

        TextFile file2 = new TextFile();
        file2.setName("我坐下马正酣");
        folder2.addFile(file2);

        ImageFile file3 = new ImageFile();
        file3.setName("图片01");
        folder3.addFile(file3);
        return folder1;
    }

}
