package com.didispace.aspect;


import org.aspectj.lang.JoinPoint;  
import org.aspectj.lang.ProceedingJoinPoint;  
import org.aspectj.lang.annotation.After;  
import org.aspectj.lang.annotation.AfterReturning;  
import org.aspectj.lang.annotation.AfterThrowing;  
import org.aspectj.lang.annotation.Around;  
import org.aspectj.lang.annotation.Before;  
import org.aspectj.lang.annotation.Pointcut;  
  
//http://blog.csdn.net/xiaoxian8023/article/details/17285809


public class AspceJAdvice {  
  
	/** 
     * Pointcut 
     * 定义Pointcut，Pointcut的名称为aspectjMethod()，此方法没有返回值和参数 
     * 该方法就是一个标识，不进行调用 
     */  
    @Pointcut("execution(* *(..))")  
    private void aspectjMethod()
    {
    	System.out.println("AspceJAdvice---------aspectjMethod()");
    };  
      
    
   /**  
    * Before 
    * 在核心业务执行前执行，不能阻止核心业务的调用。 
    * @param joinPoint  
    */ 
    @Before("aspectjMethod()")    
    public void beforeAdvice(JoinPoint joinPoint) {    
        System.out.println("-----beforeAdvice().invoke-----");  
        int a = joinPoint.getArgs().length;
       
        System.out.println("-----End of beforeAdvice()------");  
    }  
      
    /**  
     * After  
     * 核心业务逻辑退出后（包括正常执行结束和异常退出），执行此Advice 
     * @param joinPoint 
     */  
    @After(value = "aspectjMethod()")    
    public void afterAdvice(JoinPoint joinPoint) {    
        System.out.println("-----afterAdvice().invoke-----");  

        System.out.println("-----End of afterAdvice()------");  
    }    
    /**  
     * Around  
     * 手动控制调用核心业务逻辑，以及调用前和调用后的处理, 
     *  
     * 注意：当核心业务抛异常后，立即退出，转向AfterAdvice 
     * 执行完AfterAdvice，再转到ThrowingAdvice 
     * @param pjp 
     * @return 
     * @throws Throwable 
     */  
     @Around(value = "aspectjMethod()")    
    public Object aroundAdvice(ProceedingJoinPoint pjp) throws Throwable {    
        System.out.println("-----aroundAdvice().invoke-----");  

          

        Object retVal = pjp.proceed();  

        System.out.println("-----End of aroundAdvice()------");  
        return retVal;  
    }    
     /**  
      * AfterReturning  
      * 核心业务逻辑调用正常退出后，不管是否有返回值，正常退出后，均执行此Advice 
      * @param joinPoint 
      */
    @AfterReturning(value = "aspectjMethod()", returning = "retVal")    
    public void afterReturningAdvice(JoinPoint joinPoint, String retVal) {    
        System.out.println("-----afterReturningAdvice().invoke-----");  
        System.out.println("Return Value: " + retVal);   

        System.out.println("-----End of afterReturningAdvice()------");  
    }  
    /** 
     * 核心业务逻辑调用异常退出后，执行此Advice，处理错误信息 
     *  
     * 注意：执行顺序在Around Advice之后 
     * @param joinPoint 
     * @param ex 
     */ 
    @AfterThrowing(value = "aspectjMethod()", throwing = "ex")    
    public void afterThrowingAdvice(JoinPoint joinPoint, Exception ex) {    
        System.out.println("-----afterThrowingAdvice().invoke-----");  

        System.out.println("-----End of afterThrowingAdvice()------");    
    }    
}  

