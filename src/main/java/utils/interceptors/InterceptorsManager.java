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

@SuppressWarnings("unchecked")
public class InterceptorsManager extends EmptyInterceptor {
    private static final Class<Interceptor> TARGET_ANNOTATION = Interceptor.class;
    private static final String INSTANT_PATH = "utils/interceptors";
    private Map<Class<?>, Set> interceptors;
    private Reflections reflection;

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

    private void addToMap(Class key, Object value) {
        Set currentEntityInterceptorsSet;
        if ((currentEntityInterceptorsSet = interceptors.get(key)) == null) {
            currentEntityInterceptorsSet = new HashSet<>();
        }

        currentEntityInterceptorsSet.add(value);
        interceptors.put(key, currentEntityInterceptorsSet);
    }

    private void findInterceptors(String path) {
        interceptors = new HashMap<>();
        reflection = new Reflections(path);
        Set<Class<?>> annotated = reflection.getTypesAnnotatedWith(TARGET_ANNOTATION);
        for (Class<?> aClass : annotated) {
            Class<?> key = aClass.getAnnotation(TARGET_ANNOTATION).targetEntity();

            Object interceptor = null;
            try {
                interceptor = aClass.newInstance();
            } catch (InstantiationException | IllegalAccessException e) {
                System.out.println("*** Unknown interceptor type ***");
            }

            EntitiesScopeRealizationType.valueOf(aClass.getAnnotation(TARGET_ANNOTATION).scope().name()).applyFor(this, key, interceptor);
        }
    }

    private enum EntitiesScopeRealizationType {
        ALL {
            @Override
            void applyFor(InterceptorsManager manager, Class key, Object value) {
                Set<Class<?>> subTypes = reflection.getSubTypesOf(Object.class);
                subTypes.forEach(aClass -> manager.addToMap(aClass, value));
            }
        },
        THIS {
            @Override
            void applyFor(InterceptorsManager manager, Class key, Object value) {
                manager.addToMap(key, value);
            }
        },
        WITH_SUB_CLASSES {
            @Override
            void applyFor(InterceptorsManager manager, Class key, Object value) {
                Set<Class<?>> subTypes = reflection.getSubTypesOf(key);
                THIS.applyFor(manager, key, value);
                subTypes.forEach(aClass -> manager.addToMap(aClass, value));
            }
        };

        private static Reflections reflection = new Reflections("beans/entities/hibernate");
        abstract void applyFor(InterceptorsManager manager, Class key, Object value);
    }
}
