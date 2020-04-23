package cn.sdut.cglib;

import cn.sdut.aspect.MyAspect;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CGLIB {
    public Object createProxy(Object target){
        return Enhancer.create(target.getClass(), new MethodInterceptor() {
            /**
             *
             * @param o 代理对象的引用（一般不用）
             * @param method 当前执行的方法
             * @param objects 当前执行方法所需的参数
             * @param methodProxy 当前执行方法的代理
             * @return 返回代理后的对象
             * @throws Throwable 异常
             */
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                MyAspect myAspect = new MyAspect();
                myAspect.check_Permission();
                Object obj = methodProxy.invokeSuper(o, objects);
                myAspect.log();
                return obj;
            }
        });
    }
}
