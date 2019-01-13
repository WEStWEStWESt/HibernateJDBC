package utils.interceptors;

import org.hibernate.EmptyInterceptor;
import org.hibernate.type.Type;
import org.reflections.Reflections;
import utils.annotations.Interceptor;
import utils.interceptors.interfaces.InitializationInterceptor;
import utils.interceptors.interfaces.ValidationInterceptor;

import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class InterceptorsManager extends EmptyInterceptor {
    private static final Class<Interceptor> TARGET_ANNOTATION = Interceptor.class;
    private static final String INSTANT_PATH = "utils/interceptors";
    private Map<Class<?>, Set> interceptors;

    public InterceptorsManager() {
        findInterceptors(INSTANT_PATH);
    }

    public InterceptorsManager(String path) {
        findInterceptors(path);
    }

    @Override
    @SuppressWarnings("ALL")
    public boolean onSave(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {
        Set set;
        if ((set = interceptors.get(entity.getClass())) != null) {
            set.forEach(o -> {
                if (o instanceof InitializationInterceptor) {
                    InitializationInterceptor interceptor = (InitializationInterceptor) o;
                    interceptor.initialize(entity, state, propertyNames);
                }

                if (o instanceof ValidationInterceptor) {
                    ValidationInterceptor interceptor = (ValidationInterceptor) o;
                    interceptor.validate(entity);
                }
            });
        }
        return true;
    }

    public Map<Class<?>, Set> getInterceptors() {
        return interceptors;
    }

    @SuppressWarnings("unchecked")
    private void findInterceptors(String path) {
        interceptors = new HashMap<>();
        Reflections reflections = new Reflections(path);
        Set<Class<?>> annotated = reflections.getTypesAnnotatedWith(TARGET_ANNOTATION);
        Set currentEntityInterceptorsSet;
        for (Class<?> aClass : annotated) {
            Class<?> key = aClass.getAnnotation(TARGET_ANNOTATION).targetEntity();
            if ((currentEntityInterceptorsSet = interceptors.get(key)) == null) {
                currentEntityInterceptorsSet = new HashSet<>();
            }
            Object interceptor = null;
            try {
                interceptor = aClass.newInstance();
            } catch (InstantiationException | IllegalAccessException e) {
                System.out.println("*** Unknown interceptor type ***");
            }

            currentEntityInterceptorsSet.add(interceptor);
            interceptors.put(key, currentEntityInterceptorsSet);
        }
    }
}
