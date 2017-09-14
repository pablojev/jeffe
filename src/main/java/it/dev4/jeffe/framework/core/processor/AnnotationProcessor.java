package it.dev4.jeffe.framework.core.processor;


import it.dev4.jeffe.framework.core.annotation.Autorun;
import it.dev4.jeffe.framework.core.annotation.Configuration;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by pablojev on 11.07.2017.
 */
public class AnnotationProcessor {

    private static List<Class<?>> _config = new ArrayList<>();
    private static Logger logger = Logger.getAnonymousLogger();

    public static <T> T mapPathToClass(String path) {
        Class<?> clazz = null;
        try {
            clazz = Class.forName(path);
            if(clazz.isAnnotationPresent(Configuration.class)) {
                _config.add(clazz);
                for(Method m : clazz.getDeclaredMethods()) {
                    if(m.isAnnotationPresent(Autorun.class)) {
                        Parameter[] parameters = m.getParameters();
                        if(parameters.length == 0) {
                            m.invoke(Modifier.isStatic(m.getModifiers()) ? clazz : clazz.newInstance());
                            logger.log(Level.INFO, "Invoking " + m.getName() + " method from " + clazz.getSimpleName() + ".class");
                        } else {
                            logger.log(Level.WARNING, "Cannot invoke method " + m.getName() + " from " + clazz.getSimpleName() + ".class [method has " + parameters.length + " params].");
                        }
                    }
                }
                return (T) clazz;
            }
        } catch (ClassNotFoundException|IllegalAccessException|InvocationTargetException|InstantiationException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<Class<?>> mapPathToClass(List<String> paths) {
        List<String> classes = null;
        for(String pkg : paths) {
             classes = PathProcessor.getPackageContent(pkg);
             for(String clazz : classes) {
                 mapPathToClass(clazz);
             }
        }
        return _config;
    }
}
