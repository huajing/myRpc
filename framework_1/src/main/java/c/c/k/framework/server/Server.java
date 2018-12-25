package c.c.k.framework.server;

import c.c.k.framework.Contstants;
import c.c.k.framework.ParamObject;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Title c.c.k
 * @Copyright: Copyright 2018
 * @Description: java <br/>
 * @Created on 2018/12/25 chenck
 */
public class Server {

    public void start(){
        ServerSocket ss = null;
        try {
            ss = new ServerSocket(Contstants.SERVER_PORT);
            System.out.println("server start...");
            while (true){
                Socket socket = ss.accept();
                ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());

                ParamObject paramObject = (ParamObject)objectInputStream.readObject();
                String className = paramObject.getInterfaceClazz().getName();

                Object service = InstanceArray.getInstanceArray().getService(className);

                String methodName = paramObject.getMethodName();
                Method method = paramObject.getInterfaceClazz().getMethod(methodName, paramObject.getMethodTypes());
                Object returnObject = method.invoke(service, paramObject.getObjects());
                paramObject.setReturnObject(returnObject);

                objectOutputStream.writeObject(paramObject);
                socket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(ss != null){
                if(ss.isClosed()){
                    try {
                        ss.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
