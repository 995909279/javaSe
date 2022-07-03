

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test1 {
    public static void main(String[] args) throws SecurityException, NoSuchMethodException, IllegalArgumentException,
            IllegalAccessException, InvocationTargetException {
        Method m = A.class.getDeclaredMethod("getName");
        System.out.println(m.isAccessible());
        // getName是public的,猜猜输出是true还是false

        A a = new A();
        a.setName("Mr Lee");
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            m.invoke(a, new Object[] {});
        }
        System.out.println("Simple              :" + (System.currentTimeMillis() - start));

        m.setAccessible(true); // 注意此处不同
        long start1 = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            m.invoke(a, new Object[] {});
        }
        System.out.println("setAccessible(true) :" + (System.currentTimeMillis() - start1));
    }
}

class A {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}