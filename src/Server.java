import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args){
        ServerSocket ss=null;
        Socket s=null;
        InputStream is=null;
        try {
            ss = new ServerSocket(10086);
            System.out.println("服务器套接字创建成功");
            while(true) {
                System.out.println("服务器等待客户端连接");
                s = ss.accept();
                is = s.getInputStream();
                byte[] bys = new byte[1024];
                int len = is.read(bys);
                InetAddress address = s.getInetAddress();
                System.out.println("sender:" + address);
                System.out.println(new String(bys, 0, len));
            }
        }
        catch (IOException e){
            // TODO: 2020/8/14
            System.out.println("Server异常");
            e.printStackTrace();
        }
        finally {
            try {
                if (s != null) {
                    //关闭套接字
                    s.close();
                }
                if (is != null) {
                    //关闭输入流
                    is.close();
                }
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }
}
