package cn.sdut.factorybean;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class MyAspect implements MethodInterceptor {
    /**
     * 实现此方法以在调用之前和之后执行额外的处理。
     * 礼貌的实现肯定会*想调用{@link proceed()}。
     *
     * @param invocation 方法调用联接点
     * @throws Throwable if the interceptors or the target object
     *                   throws an exception
     */
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        check_Permissions();
        //执行目标方法
        Object object = invocation.proceed();
        log();
        return object;
    }

    private void log() {
        System.out.println("模拟记录日志");
    }

    private void check_Permissions() {
        System.out.println("模拟检查权限");
    }
}
