package c.c.k.framework.util;

import c.c.k.framework.ParamObject;
import c.c.k.framework.server.InstanceArray;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Title c.c.k.framework.util
 * @Copyright: Copyright 2018
 * @Description: java <br/>
 * @Created on 2018/12/27 chenck
 */
public class ServiceUtil {
    public static void callService(ParamObject paramObject) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        String className = paramObject.getInterfaceClazz().getName();

        Object service = InstanceArray.getInstanceArray().getService(className);

        String methodName = paramObject.getMethodName();
        Method method = paramObject.getInterfaceClazz().getMethod(methodName, paramObject.getMethodTypes());
        Object returnObject = method.invoke(service, paramObject.getObjects());
        paramObject.setReturnObject(returnObject);
    }
}
