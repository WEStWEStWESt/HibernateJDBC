package utils.annotations;

import utils.enums.EntitiesScopeType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Interceptor {
    Class<?> targetEntity();

    EntitiesScopeType scope() default EntitiesScopeType.THIS;
}
