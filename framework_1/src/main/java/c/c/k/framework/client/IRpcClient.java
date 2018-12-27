package c.c.k.framework.client;

import c.c.k.framework.ParamObject;
import io.netty.handler.codec.serialization.ObjectEncoder;

import java.lang.reflect.Method;

/**
 * @Title c.c.k.framework.client
 * @Copyright: Copyright 2018
 * @Description: java <br/>
 * @Created on 2018/12/27 chenck
 */
public abstract class IRpcClient {
    public Object callRemote(Class interfaceClzz, Method method, Object[] objects){
        //构造参数
        ParamObject paramObject = new ParamObject();
        paramObject.setInterfaceClazz(interfaceClzz);
        paramObject.setObjects(objects);
        paramObject.setMethodName(method.getName());
        paramObject.setMethodTypes(method.getParameterTypes());
        this.callRemote(paramObject);

        return paramObject.getReturnObject();
    }

    protected abstract Object callRemote(ParamObject paramObject);
}
