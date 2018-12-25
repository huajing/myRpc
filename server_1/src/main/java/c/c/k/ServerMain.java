package c.c.k;

import c.c.k.framework.server.InstanceArray;
import c.c.k.framework.server.Server;

/**
 * @Title c.c.k
 * @Copyright: Copyright 2018
 * @Description: java <br/>
 * @Created on 2018/12/25 chenck
 */
public class ServerMain {
    public static void main(String[] args) {
        //扫描包结构，初始化service
        InstanceArray.getInstanceArray().instances.put(ICalculator.class.getName(), new CalculatorImpl());

        new Server().start();
    }
}
