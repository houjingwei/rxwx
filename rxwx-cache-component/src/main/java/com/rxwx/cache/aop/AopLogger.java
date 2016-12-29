package com.rxwx.cache.aop;

import java.util.Arrays;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopLogger {
	
	
	
//	
//	@Around("execution(* com.rxwx.cache.component..*(..))")
//    public Object process(ProceedingJoinPoint point) throws Throwable {
//        System.out.println("@Around：执行目标方法之前...");
//        //访问目标方法的参数：
//        Object[] args = point.getArgs();
//        if (args != null && args.length > 0 && args[0].getClass() == String.class) {
//            args[0] = "改变后的参数1";
//        }
//        //用改变后的参数执行目标方法
//        Object returnValue = point.proceed(args);
//        System.out.println("@Around：执行目标方法之后...");
//        System.out.println("@Around：被织入的目标对象为：" + point.getTarget());
//        return "原返回值：" + returnValue + "，这是返回结果的后缀";
//    }
	
	
    @Before("execution(* com.rxwx.cache.component..*(..))")  
    public void foundBefore(JoinPoint point){  
    	System.out.println("@Before：模拟权限检查...");
        System.out.println("@Before：目标类为：" + 
                point.getSignature().getDeclaringTypeName() + 
                "－－目标方法为：" + point.getSignature().getName());
        System.out.println("@Before：参数为：" + point.getArgs());
        System.out.println("@Before：参数为：" + Arrays.toString(point.getArgs()));
        System.out.println("@Before：被织入的目标对象为：" + point.getTarget());
        System.out.println("@Before：被织入的目标对象为：" + point.getKind());
        System.out.println("@Before：被织入的目标对象为：" + point.getClass());
        System.out.println("@Before：被织入的目标对象为：" + point.getSignature().toString());
        System.out.println("@Before：执行的方法：" + point.getStaticPart());
    }  
      
    @AfterReturning(pointcut="execution(* com.rxwx.cache.component..*(..))", 
            returning="returnValue")
        public void log(JoinPoint point, Object returnValue) {
    
            System.out.println("@AfterReturning：模拟日志记录功能...");
            System.out.println("@AfterReturning：目标方法为：" + 
                    point.getSignature().getDeclaringTypeName() + 
                    "." + point.getSignature().getName());
            System.out.println("@AfterReturning：参数为：" + 
                    Arrays.toString(point.getArgs()));
            System.out.println("@AfterReturning：返回值为：" + returnValue);
            System.out.println("@AfterReturning：被织入的目标对象为：" + point.getTarget());
            
        }
}
