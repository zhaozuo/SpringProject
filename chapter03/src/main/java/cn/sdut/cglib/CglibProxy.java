package cn.sdut.cglib;

import cn.sdut.aspect.MyAspect;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

//代理类
public class CglibProxy implements MethodInterceptor {
    //代理方法
    public Object createProxy(Object target){
        //创建一个动态类对象
        Enhancer enhancer = new Enhancer();
        //确定需要增强的类，设置其父类
        enhancer.setSuperclass(target.getClass());
        //添加回调函数
        enhancer.setCallback(this);
        //返回创建的代理类
        return enhancer.create();
    }

    /**
     *
     * @param proxy CGlib根据父类生成的代理对象
     * @param method 拦截的方法
     * @param objects 拦截方法的参数数组
     * @param methodProxy 方法的代理对象，用于执行父类的方法
     */
    @Override
    public Object intercept(Object proxy, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        MyAspect myAspect = new MyAspect();
        myAspect.check_Permission();
        Object obj = methodProxy.invokeSuper(proxy, objects);
        myAspect.log();
        return obj;
    }
}
