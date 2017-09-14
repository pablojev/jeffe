package it.dev4.jeffe.framework.core.application;

import it.dev4.jeffe.framework.core.processor.AnnotationProcessor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by pablojev on 11.07.2017.
 */
public class Application implements AbstractApplication {

    List<Class<?>> classes = null;

    public Application() {

    }

    public Application(String path) {
        scan(path);
    }

    public Application scan(String path) {
        List<String> ls = new LinkedList<>();
        ls.add(path);
        classes = AnnotationProcessor.mapPathToClass(ls);
        return this;
    }

    public <T> T get(Class<?> clazz) {
        for(Class<?> c : classes) {
            if(c.equals(clazz)) try {
                return (T) clazz.newInstance();
            } catch (InstantiationException|IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
