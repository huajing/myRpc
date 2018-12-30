package c.c.k.framework;

import java.io.Serializable;
import java.lang.reflect.Method;

/**
 * 一次远程调用，要包含以下信息，server端才知道如何处理
 * @Title c.c.k
 * @Copyright: Copyright 2018
 * @Description: java <br/>
 * @Created on 2018/12/25 chenck
 */
public class ParamObject implements Serializable{
    /**
     * 服务器端的实现类
     */
    private Class interfaceClazz;

    /**
     * 实现类的方法名
     */
    private String methodName;

    /**
     * 实现类的参数类型是什么
     */
    private Class[] methodTypes;

    /**
     * 实现类的参数值
     */
    private Object[] objects;

    /**
     * 返回值
     */
    private Object returnObject;

    public Class getInterfaceClazz() {
        return interfaceClazz;
    }

    public void setInterfaceClazz(Class interfaceClazz) {
        this.interfaceClazz = interfaceClazz;
    }

    public Class[] getMethodTypes() {
        return methodTypes;
    }

    public void setMethodTypes(Class[] methodTypes) {
        this.methodTypes = methodTypes;
    }

    public Object[] getObjects() {
        return objects;
    }

    public void setObjects(Object[] objects) {
        this.objects = objects;
    }

    public void setReturnObject(Object returnObject) {
        this.returnObject = returnObject;
    }

    public Object getReturnObject() {
        return returnObject;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }
}
