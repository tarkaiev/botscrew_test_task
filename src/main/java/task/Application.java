package task;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import task.config.AppConfig;
import task.util.DataInjector;

public class Application {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context
                = new AnnotationConfigApplicationContext(AppConfig.class);
        DataInjector dataInjector = context.getBean(DataInjector.class);

        dataInjector.injectDataToDB();
    }
}
