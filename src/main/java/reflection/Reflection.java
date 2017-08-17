package reflection;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Miha on 17.08.2017.
 */
public class Reflection {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        Rectangle rectangle = new Rectangle(0, 5, 20, 30);

        Class klass = rectangle.getClass();

        final List<Method> allMethods = new ArrayList<>(Arrays.asList(klass.getDeclaredMethods()));
        allMethods.forEach(method -> {
            if (method.isAnnotationPresent(MyAnnotation.class)) {
                try {
                    System.out.println(method.invoke(rectangle, 100, 50));
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        });

        System.out.println(klass.getSimpleName());

        Field[] fields = klass.getDeclaredFields();
        for (Field field : fields) {
            System.out.println("Name: " + field.getName() + ", Type: " + field.getType().getName() + ", Modifier: " + Modifier.toString(field.getModifiers()));
        }
        System.out.println();

        List<Annotation> classAnnotations = new ArrayList<>(Arrays.asList(klass.getDeclaredAnnotations()));
        classAnnotations.forEach(annotation -> System.out.println(annotation.toString()));

        Shape proxy = (Shape) Proxy.newProxyInstance(Rectangle.class.getClassLoader(), Rectangle.class.getInterfaces(), new ProxyObject(rectangle));

        proxy.move(20, 30);

        try {
            proxy.setHeight(20);
        } catch (Exception e) {
            System.err.println("Exception because of setter method !!");
        }


    }
}
