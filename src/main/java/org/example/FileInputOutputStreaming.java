package org.example;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInputOutputStreaming {
    public  static  void main(String[] args ) throws IOException {

        FileInputStream filein = null;
        FileOutputStream fileout= null;

        filein = new  FileInputStream("C:\\Users\\CSC\\adv_java\\src\\main\\resources\\input\\source.txt");
        fileout = new FileOutputStream("C:\\Users\\CSC\\adv_java\\src\\main\\" +
        "resources\\input\\dest.txt");
        try {
            int content;
            while((content = filein.read())!= -1){
                fileout.write(content);

            }
        }
        catch(Exception e){
            System.out.println("print exception"+ e);

        }
        finally {
            if(filein!= null){
                filein.close();
            }
            if(fileout!= null){
                fileout.close();
            }
        }
    }


}
