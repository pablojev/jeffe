package it.dev4.jeffe.sample.examplePackage;

import it.dev4.jeffe.framework.core.annotation.Autorun;
import it.dev4.jeffe.framework.core.annotation.Configuration;

/**
 * Created by pablojev on 13.07.2017.
 */
@Configuration
public class SuperOther {

    @Autorun
    public void show() {
        System.out.println("I'm from show() SuperOther.class");
    }

    @Autorun
    public void showTwo(String x) {
        System.out.println("I'm from showTwo(String x) SuperOther.class");
    }
}
