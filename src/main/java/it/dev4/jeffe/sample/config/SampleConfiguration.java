package it.dev4.jeffe.sample.config;

import it.dev4.jeffe.framework.core.annotation.Autorun;
import it.dev4.jeffe.framework.core.annotation.Configuration;

/**
 * Created by pablojev on 11.07.2017.
 */
@Configuration
public class SampleConfiguration {

    @Autorun
    public static void config() {
        System.out.println("I'm from @Autorun config() SampleConfiguration.class");
    }

    @Autorun
    public void otherConfig() {
        System.out.println("I'm from @Autorun otherConfig() SampleConfiguration.class");
    }

    public void superMethod() {
        System.out.println("I'm from superMethod() SampleConfiguration.class");
    }
}
