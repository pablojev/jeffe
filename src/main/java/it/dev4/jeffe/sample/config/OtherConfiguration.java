package it.dev4.jeffe.sample.config;

import it.dev4.jeffe.framework.core.annotation.Autorun;
import it.dev4.jeffe.framework.core.annotation.Configuration;

/**
 * Created by pablojev on 12.07.2017.
 */
@Configuration
public class OtherConfiguration {

    @Autorun
    public void config() {
        System.out.println("I'm from @Autorun config() OtherConfiguration.class");
    }
}
