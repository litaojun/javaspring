package com.didispace.test.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/** 
 * 执行Linux的shell命令并在console端输出结果 
 * https://www.cnblogs.com/ontway/p/7455249.html
 * */  
public class CallShell {  
	
	public static String runShellCmd(String strcmd) throws IOException
	{
		 Process process = Runtime.getRuntime().exec(strcmd);//通过执行cmd命令调用protoc.exe程序  
	     BufferedReader strCon = new BufferedReader(new InputStreamReader(process.getInputStream()));  
	     String line;  
	     while ((line = strCon.readLine()) != null) 
	     {  
	            System.out.println("java print:"+line);  
	     }  
	     return "sucess";
	}
  
    /** 
     * @throws Exception  
     */  
//    public static void main(String[] args) throws Exception {  
//        String strCmd = "run.sh";//执行shell命令  
//        Process process = Runtime.getRuntime().exec(strCmd);//通过执行cmd命令调用protoc.exe程序  
//        BufferedReader strCon = new BufferedReader(new InputStreamReader(process.getInputStream()));  
//        String line;  
//        while ((line = strCon.readLine()) != null) {  
//            System.out.println("java print:"+line);  
//            }  
//    }  
}
