package productfilter;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class SpringApplicationContext implements ApplicationContextAware {

    private static ApplicationContext contextSingleton;

    public void setApplicationContext(final ApplicationContext context) {
        setContextInternal(context);
    }

    private static synchronized void setContextInternal(ApplicationContext context) {
        contextSingleton = context;
    }

    public static <T> T getBean(Class<T> clazz) {
        return contextSingleton.getBean(clazz);
    }

    public static <T> T getBean(String name, Class<T> clazz) {
        return contextSingleton.getBean(name, clazz);
    }

}
