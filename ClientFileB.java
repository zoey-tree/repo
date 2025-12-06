import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
//import java.util.List;
import java.util.List;

public class ClientFileB {
    //private static ArrayList<String> list = null;
    //
        public static void main(String[] args) throws IOException{
        //创建客户端Socket，指定服务器端口号和地址
        Socket clientSock = new Socket("127.0.0.1", 9999); 
		System.out.println("connected to server..");
        //字节输出流,获取输出流,向服务器发送信息
        OutputStream out = clientSock.getOutputStream();
        String temp = null;  
        //读取文件内容
        File file = new File("C://Users//华为//Desktop//代码//Code//信源B.txt"); 
        InputStream in = clientSock.getInputStream(); 
        //String adn=""; 
        InputStreamReader read = new InputStreamReader(new FileInputStream(file),"GBK");
        BufferedReader reader=new BufferedReader(read); 
        //使用List结构存储每行内容
        List<String> list = new  ArrayList<String>();
        list.add("The data to be written");
        while((temp=reader.readLine())!=null ){
            list.add(temp);
        }
        read.close();
        //长连接
        while(true){
            //然后读取List中存储的字符串传给服务端
            for ( String elem: list ){
                out.write(elem.getBytes());
                //byte[] response = new byte[1024];
                //in.read(response);
                //System.out.println("Received from server .." + new String(response).trim());
            }
            System.out.println("out");
			clientSock.close();
        }
        
    }
}
