package c.c.k.framework.client;

import c.c.k.framework.Contstants;
import c.c.k.framework.ParamObject;

import java.io.*;
import java.lang.reflect.Method;
import java.net.Socket;

/**
 * @Title c.c.k.framework.delegate
 * @Copyright: Copyright 2018
 * @Description: java <br/>
 * @Created on 2018/12/25 chenck
 */
public class ClientDelegate {
    public Object callRemote(Class interfaceClzz, Method method, Object[] objects){

        Socket socket = null;
        try {
            socket = new Socket("localhost", Contstants.SERVER_PORT);

            //构造参数
            ParamObject paramObject = new ParamObject();
            paramObject.setMethodTypes(method.getParameterTypes());
            paramObject.setInterfaceClazz(interfaceClzz);
            paramObject.setObjects(objects);

            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectOutputStream.writeObject(paramObject);

            InputStream inputStream = socket.getInputStream();
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            paramObject = (ParamObject)objectInputStream.readObject();

            socket.close();

            return paramObject.getReturnObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            if(socket != null){
                try {
                    socket.close();
                }catch (Exception e){

                }
            }
        }
        return null;
    }
}
