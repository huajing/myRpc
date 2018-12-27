package c.c.k.framework.client;

/**
 * RpcClient工厂类，选择BIO、NIO、或者Netty来请求服务器
 * @Title c.c.k.framework.client
 * @Copyright: Copyright 2018
 * @Description: java <br/>
 * @Created on 2018/12/27 chenck
 */
public class RpcClientFactory {
    public static IRpcClient getRpcClient(){
        return new ClientBIO();
    }
}
