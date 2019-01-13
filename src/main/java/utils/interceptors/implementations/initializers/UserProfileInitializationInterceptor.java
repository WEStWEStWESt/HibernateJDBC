package utils.interceptors.implementations.initializers;

import beans.entities.hibernate.profiles.UserProfile;
import utils.annotations.Interceptor;
import utils.interceptors.interfaces.InitializationInterceptor;

@Interceptor(targetEntity = UserProfile.class)
public class UserProfileInitializationInterceptor implements InitializationInterceptor {
    @Override
    public void initialize(Object entity, Object[] state, String[] propertyNames) {
        System.out.println("*** UserProfile initialization ***");
        if (entity instanceof UserProfile) {
            UserProfile userProfile = (UserProfile) entity;
            if (userProfile.getAge() < 6 || userProfile.getAge() > 100) {
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
