import java.io.IOException;
import java.io.OutputStream;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        Socket s=null;
        OutputStream os=null;
        try {
        InetAddress host1 = InetAddress.getLocalHost();
        InetAddress host2 = InetAddress.getByName("127.0.0.1");
        s=new Socket(host1,10086);
        os=s.getOutputStream();
        String str="This is a TCP connection.";
        os.write(str.getBytes());
        } catch(UnknownHostException e) {
            // TODO: 2020/8/14
            e.printStackTrace();
        }catch (IOException e){
            // TODO: 2020/8/14
            e.printStackTrace();
        }finally{
            try {
                if (s != null) {
                    //关闭套接字
                    s.close();
                }
                if(os!=null){
                    //关闭输出流
                    os.close();
                }
            }catch(IOException e){
                // TODO: 2020/8/14
                e.printStackTrace();
            }
        }
}
}
