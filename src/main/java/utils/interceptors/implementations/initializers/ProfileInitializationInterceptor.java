package utils.interceptors.implementations.initializers;

import beans.entities.hibernate.profiles.Profile;
import utils.annotations.Interceptor;
import utils.enums.EntitiesScopeType;
import utils.interceptors.interfaces.InitializationInterceptor;

@Interceptor(targetEntity = Profile.class, scope = EntitiesScopeType.WITH_SUB_CLASSES)
public class ProfileInitializationInterceptor implements InitializationInterceptor {
    @Override
    public void initialize(Object entity, Object[] state, String[] propertyNames) {
        System.out.println("*** UserProfile initialization ***");
        if (entity instanceof Profile) {
            Profile profile = (Profile) entity;
            if (profile.getAge() < 6 || profile.getAge() > 100) {
                for (int i = 0; i < propertyNames.length; i++) {
                    if (propertyNames[i].equals("age")){
                        state[i] = 6;
                        break;
                    }
                }
            }
        }
    }
}
