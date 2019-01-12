package utils.interceptors.interfaces;

public interface InitializationInterceptor {
    void initialize(Object entity, Object[] state, String[] propertyNames);
}
