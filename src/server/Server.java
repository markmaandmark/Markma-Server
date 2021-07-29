package server;

import java.net.*;
import java.io.*;

public class Server
{
  public static void main(String[] args) throws Exception
  {
    while(true)
    { //一直运行
      ServerSocket server = new ServerSocket(8080); //监听在8080端口
      Socket sock = server.accept(); //建立一个与客户机的socket
      
      FileInputStream in = new FileInputStream("d:\\a.html"); //读取数据
      OutputStream out = sock.getOutputStream();
      out.write("HTTP/1.1 200 OK\r\n".getBytes());
      out.write("Content-Type:text/html;charset=utf-8\r\n".getBytes());
      out.write("\r\n".getBytes());//写入响应头
      int len = 0;
      byte buffer[] = new byte[1024]; //缓冲区
      while((len=in.read(buffer))>0)
      { //假如缓冲区有数据
        out.write(buffer,0,len);
      }
      in.close();
      out.close();
      sock.close();
      server.close();
    }
  }
}
