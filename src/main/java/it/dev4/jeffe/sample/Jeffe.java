package it.dev4.jeffe.sample;

import it.dev4.jeffe.framework.core.application.Application;
import it.dev4.jeffe.sample.config.SampleConfiguration;


/**
 * Created by pablojev on 11.07.2017.
 */
public class Jeffe {
    public static void main(String[] args) {
        // autoscan & call @Autorun annotated methods
        Application app = new Application("it.dev4.jeffe.sample");

        // manual call
        SampleConfiguration sc = app.get(SampleConfiguration.class);
        sc.superMethod();
    }
}
