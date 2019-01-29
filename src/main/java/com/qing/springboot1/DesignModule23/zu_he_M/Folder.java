package com.qing.springboot1.DesignModule23.zu_he_M;

import java.util.ArrayList;
import java.util.List;

public class Folder extends AbstractFile {
    private List<AbstractFile> files = new ArrayList<>();

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int addFile(AbstractFile file){
        files.add(file);
        return files.size();
    }

    public int removeFile(AbstractFile file){
        files.remove(file);
        return files.size();
    }

    public AbstractFile getFile(int index){
        return files.get(index);
    }

    @Override
    public void sayName() {
        System.out.println(getName());
        if(files.size() > 0){
            for(int i = 0; i < files.size(); i++){
                files.get(i).sayName();
            }
        }
    }
}
