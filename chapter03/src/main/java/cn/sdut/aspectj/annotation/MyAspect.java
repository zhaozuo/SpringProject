package cn.sdut.aspectj.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 切面类，在此类编写通知
 */
@Aspect
@Component
public class MyAspect {
    //定义切入点表达式
    @Pointcut("execution(* cn.sdut.jdk.*.*(..))")
    //使用一个返回值为void, 方法体为空的方法来命名切入点
    private void myPointCut(){}
    //前置通知
    @Before("myPointCut()")
    public void myBefore(JoinPoint joinPoint){
        System.out.print("前置通知：模拟执行权限检查...，");
        System.out.print("目标类是："+joinPoint.getTarget());
        System.out.println("，被植入增强处理的目标方法为："
                            +joinPoint.getSignature().getName());
    }
    //后置通知
    @AfterReturning(value = "myPointCut()")
    public void myAfterReturning(JoinPoint joinPoint){
        System.out.print("后置通知：模拟记录日志...，");
        System.out.println("，被植入增强处理的目标方法为："+joinPoint.getSignature().getName());
    }
    //环绕通知
    @Around("myPointCut()")
    public Object myAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("环绕开始：执行目标方法之前，模拟开启事务...");
        Object obj = proceedingJoinPoint.proceed();
        System.out.println("环绕结束：执行目标方法之后，模拟关闭事务...");
        return obj;
    }
    //异常通知
    @AfterThrowing(value = "myPointCut()", throwing = "error")
    public void myAfterThrowing(JoinPoint joinPoint, Throwable error){
        System.out.println("异常通知：出错了"+error.getMessage());
    }
    //最终通知
    @After("myPointCut()")
    public void myAfter(){
        System.out.println("最终通知：模拟方法结束后的释放资源...");
    }
}
