package org.example;

import java.io.*;

public class FileReaderWriterStreaming {
    public  static  void main(String[] args ) throws IOException {
        FileReader filein = null;
        FileWriter fileout= null;

        filein = new  FileReader("C:\\Users\\CSC\\adv_java\\src\\main\\resources\\input\\source.txt");
        fileout = new FileWriter("C:\\Users\\CSC\\adv_java\\src\\main\\resources\\input\\dest1.txt");
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
            if (filein != null) {
                filein.close();
            }
            if (fileout != null) {
                fileout.close();
            }
        }
    }
}
