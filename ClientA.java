import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;
import java.io.IOException;
import java.io.InputStream;

//gitdev修改代码333333
//客户端代码
public class ClientA {
	public static void main(String[] args) throws IOException {
		// 创建客户端Socket，指定服务器端口号和地址
		Socket clientSock = new Socket("127.0.0.1", 9999);
		System.out.println("connected to server..");
		// 读取服务器端返回的数据
		InputStream in = clientSock.getInputStream();
		// 字节输出流,获取输出流,向服务器发送信息
		OutputStream out = clientSock.getOutputStream();
		// 通过键盘输入向服务端发送信息
		Scanner sc = new Scanner(System.in);
		System.out.print("please enter the message: ");
		// 长连接
		while (true) {
			String message = sc.nextLine();
			out.write(message.getBytes());
			// 将字节流转化为字符流
			byte[] response = new byte[1024];
			in.read(response);
			System.out.println("Received from server .." + new String(response).trim());
			// 客户端需要结束交流时即发送“exit”来结束与服务端的交流
			if (message.equals("exit")) {
				sc.close();
				clientSock.close();
			}
		}
	}
}