package c.c.k.framework.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Title c.c.k.framework.test
 * @Copyright: Copyright 2018
 * @Description: java <br/>
 * @Created on 2018/12/27 chenck
 */
public class Test {
    public static void main(String[] args) {
        do{
            try {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                String line = br.readLine();
                if(line.equals("exit"))
                    break;
                System.out.println("input line is " + line);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }while (true);
    }
}
