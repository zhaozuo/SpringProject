package test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.concurrent.Callable;

public class Task implements Callable<BigDecimal> {


    /**
     * 计算结果，如果无法执行，则抛出异常。
     *
     * @return 计算结果
     * @throws Exception 如果无法计算结果
     */
    @Override
    public BigDecimal call() throws Exception {
        Thread.sleep(1000);
        double d = 5 + Math.random() * 20;
        return new BigDecimal(d).setScale(2, RoundingMode.DOWN);
    }
}
