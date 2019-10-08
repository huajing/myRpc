package c.c.k;

import c.c.k.framework.server.InstanceArray;
import c.c.k.framework.server.ServerBIO;
import c.c.k.framework.server.ServerNIO;
import c.c.k.framework.server.ServerNetty;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

/**
 * @Title PACKAGE_NAME
 * @Copyright: Copyright 2018
 * @Description: java <br/>
 * @Created on 2018/12/25 chenck
 */
public class ServerTest {

    @Before
    public void before(){
        //扫描包结构，初始化service
        InstanceArray.getInstanceArray().instances.put(ICalculator.class.getName(), new CalculatorImpl());
    }

//    @Test
    public void testServerBIO(){
        try {
            new ServerBIO().start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testServerNetty(){
        try {
            new ServerNetty().start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    @Test
    public void testServerNIO(){
//        try {
        new ServerNIO().start();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }
}
