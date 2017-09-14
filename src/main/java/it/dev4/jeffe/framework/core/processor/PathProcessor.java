package it.dev4.jeffe.framework.core.processor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by pablojev on 12.07.2017.
 */
public class PathProcessor {
    public static List<String> getPackageContent(String pkg) {
        List<String> classes = new ArrayList<>();
        try {
            Files.walk(Paths.get("./target/classes/" + pkg.replaceAll("\\.", "/")))
                .filter(Files::isRegularFile)
                .forEach(f -> {
                    if(f.toString().endsWith("class"))
                        classes.add(f.toString().replace("./target/classes/", "").replaceAll("\\/", "\\.").replace(".class", ""));
                });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return classes;
    }
}
