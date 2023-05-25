import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.InvocationTargetException;
import ok.ok1.EntityManagerFactoryS;
public class JavaClassAnalyzer {

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Please provide the path to the .class file as an argument.");
            return;
        }

        String classFilePath = args[0];

        try {
            Class<?> clazz = Class.forName(getClassName(classFilePath));
            System.out.println("Class: " + clazz.getName());
            System.out.println("Package: " + clazz.getPackage().getName());

            // Analyzing methods
            Method[] methods = clazz.getDeclaredMethods();
            for (Method method : methods) {
                System.out.println("Method: " + method.getName());
                System.out.println("Modifiers: " + Modifier.toString(method.getModifiers()));
            }

            // Invoking test methods
            for (Method method : methods) {
                if (method.isAnnotationPresent(EntityManagerFactoryS.class) && Modifier.isStatic(method.getModifiers())
                        && method.getParameterCount() == 0) {
                    try {
                        method.invoke(null);
                        System.out.println("Test passed: " + method.getName());
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        System.out.println("Test failed: " + method.getName());
                        e.printStackTrace();
                    }
                }
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found: " + e.getMessage());
        }
    }

    private static String getClassName(String classFilePath) {
        String className = classFilePath.replace(".class", "");
        className = className.replace(System.getProperty("file.separator"), ".");
        return className;
    }

}
