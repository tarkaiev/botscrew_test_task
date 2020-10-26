package task;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import task.config.AppConfig;

public class Application {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context
                = new AnnotationConfigApplicationContext(AppConfig.class);
    }
}
