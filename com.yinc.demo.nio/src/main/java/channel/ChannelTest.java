package channel;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ChannelTest {

    private static volatile  int i = 10;

    public static void main(String[] args) throws IOException {
        RandomAccessFile aFile = new RandomAccessFile("D:\\workspance\\java\\demoTest\\com.yinc.demo.nio\\src\\main\\java\\channel\\nio-data.txt", "rw");
        FileChannel channel = aFile.getChannel();
        ByteBuffer allocate = ByteBuffer.allocate(1024);
        int read = channel.read(allocate);

        while (read!=-1){
            System.out.println("read: length:{}"+read);
            allocate.flip();
            while (allocate.hasRemaining()){
                System.out.println((char)allocate.get());
            }

            allocate.clear();
            read= channel.read(allocate);
        }

        aFile.close();


    }
}
