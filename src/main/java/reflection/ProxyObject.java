package reflection;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by Miha on 17.08.2017.
 */
public class ProxyObject implements InvocationHandler{

    private Object object;

    public ProxyObject(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] objects) throws Throwable {

        if (method.getName().substring(0, 3).equals("set")) throw new Exception();
        else {
            System.out.println("Proxy object invoke : " + method.getName());
        }
        return method.invoke(object, objects) ;
    }
}
