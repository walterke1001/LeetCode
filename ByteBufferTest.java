import java.io.IOException;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.charset.StandardCharsets;

public class ByteBufferTest {
    public static void main(String[] args) throws IOException {
        ByteBuffer buffer = ByteBuffer.allocate(10);
        buffer.put(new byte[]{1, 2, 3, 4});
        buffer.clear();
        System.out.println((int) buffer.get(2));
        ServerSocketChannel sc = ServerSocketChannel.open();
        Selector selector = Selector.open();
        sc.register(selector, 0, null);
    }
}
