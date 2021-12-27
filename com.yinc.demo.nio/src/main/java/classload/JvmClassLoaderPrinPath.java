package classload;

import sun.misc.Launcher;

import java.lang.reflect.Field;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;

public class JvmClassLoaderPrinPath {

    public static void main(String[] args) {
        URL[] urLs = Launcher.getBootstrapClassPath().getURLs();
        System.out.println("启动类加载器");
        for (URL urL : urLs) {
            System.out.println("========>  " + urL.toExternalForm());
        }

        //扩展类加载器
        printClassLoader("扩展类加载器",JvmClassLoaderPrinPath.class.getClassLoader().getParent());

        //应用类加载器
        printClassLoader("应用类加载器",JvmClassLoaderPrinPath.class.getClassLoader());

    }


    public static void printClassLoader(String name, ClassLoader cl) {

        if (cl != null) {
            System.out.println(name + "===========>" + cl.toString());
            printURLClassLoader(cl);
        } else {
            System.out.println(name + "===========> null ");
        }

    }

    private static void printURLClassLoader(ClassLoader cl) {
        Object ucp = ins(cl, "ucp");
        Object path = ins(ucp, "path");
        ArrayList p = (ArrayList) path;
        for (Object o : p) {
            System.out.println("==================>"+o.toString());
        }

    }

    private static Object ins(Object obj, String name) {
        try {
            Field f = null;

            if (obj instanceof URLClassLoader) {
                f = URLClassLoader.class.getDeclaredField(name);
            } else {
                f = obj.getClass().getDeclaredField(name);
            }
            f.setAccessible(true);
            return f.get(obj);
        } catch (Exception e) {
            return null;
        }
    }
}
