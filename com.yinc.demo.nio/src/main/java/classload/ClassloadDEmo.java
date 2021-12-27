package classload;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;

public class ClassloadDEmo extends ClassLoader {

    public static void main(String[] args) throws IOException {
        File file = new File("D:\\workspance\\java\\demoTest\\com.yinc.demo.nio\\src\\main\\java\\jvm\\Hello.class");
        InputStream in = new FileInputStream(file);
        byte[] bytes = new byte[2048];
            int len;
        while ((len=in.read(bytes))!=-1){
            System.out.print("[");
            for (int i = 0; i < len; i++) {
                System.out.print(bytes[i]);
           //     System.out.print(",");
            }
           
            System.out.print("]");
        }

        System.out.println();
        in.close();
    }
}
