package reflection;

import javax.lang.model.element.Element;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Miha on 17.08.2017.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)

@interface MyAnnotation {
    String name();
    String value();
}

@Retention(RetentionPolicy.RUNTIME)
@interface MyClassAnnotation {
    String name();
}