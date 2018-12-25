package c.c.k.framework;

import java.io.Serializable;
import java.lang.reflect.Method;

/**
 * @Title c.c.k
 * @Copyright: Copyright 2018
 * @Description: java <br/>
 * @Created on 2018/12/25 chenck
 */
public class ParamObject implements Serializable{
    private Class interfaceClazz;

    private String methodName;

    private Class[] methodTypes;

    private Object[] objects;

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
