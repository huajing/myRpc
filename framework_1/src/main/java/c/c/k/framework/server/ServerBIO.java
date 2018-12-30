package c.c.k.framework.server;

import c.c.k.framework.Constants;
import c.c.k.framework.ParamObject;
import c.c.k.framework.util.ServiceUtil;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Title c.c.k
 * @Copyright: Copyright 2018
 * @Description: java <br/>
 * @Created on 2018/12/25 chenck
 */
public class ServerBIO implements IRpcServer {

    public void start() throws IOException{
        ServerSocket ss = new ServerSocket(Constants.SERVER_PORT);
        System.out.println("server start...");
        while (true){
            try {
                Socket socket = ss.accept();
                ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());

                ParamObject paramObject = (ParamObject)objectInputStream.readObject();
                ServiceUtil.callService(paramObject);

                objectOutputStream.writeObject(paramObject);
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (SecurityException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }
}
