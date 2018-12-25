package c.c.k.framework.server;

import java.util.Currency;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 * 实例对象管理，在生产一下用xml配置，或者用spring管理bean
 * @Title c.c.k.framework.server
 * @Copyright: Copyright 2018
 * @Description: java <br/>
 * @Created on 2018/12/25 chenck
 */
public class InstanceArray {
    public static final Map<String, Object> instances = new HashMap<String, Object>();

    public static InstanceArray instanceArray;
    static {
        instanceArray = new InstanceArray();
    }

    private InstanceArray(){

    }

    public void putService(String serviceName, Object object){
        instances.put(serviceName, object);
    }

    public Object getService(String serviceName){
        return instances.get(serviceName);
    }

    public final static InstanceArray getInstanceArray() {
        return instanceArray;
    }
}
