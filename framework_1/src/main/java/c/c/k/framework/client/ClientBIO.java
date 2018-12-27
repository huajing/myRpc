package c.c.k.framework.client;

import c.c.k.framework.Constants;
import c.c.k.framework.ParamObject;

import java.io.*;
import java.net.Socket;

/**
 *
 * @Title c.c.k.framework.delegate
 * @Copyright: Copyright 2018
 * @Description: java <br/>
 * @Created on 2018/12/25 chenck
 */
public class ClientBIO extends IRpcClient {
    protected Object callRemote(ParamObject paramObject){

        Socket socket = null;
        try {
            socket = new Socket(Constants.SERVER_ADDR, Constants.SERVER_PORT);

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
