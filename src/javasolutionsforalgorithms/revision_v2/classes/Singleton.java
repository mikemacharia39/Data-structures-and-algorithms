package javasolutionsforalgorithms.revision_v2.classes;

/**
 * In object-oriented programming, a java singleton class is a class that can have only one object
 * (an instance of the class) at a time. After the first time, if we try to instantiate the Java Singleton classes,
 * the new variable also points to the first instance created. So whatever modifications we do to any variable
 * inside the class through any instance, affects the variable of the single instance created and is visible
 * if we access that variable through any variable of that class type defined.
 *
 * Remember the key points while defining a class as a singleton class that is while designing a singleton class:
 *
 * 1. Make a constructor private.
 * 2. Write a static method that has the return type object of this singleton class.
 *
 * Purpose of Singleton Class
 * 1. The primary purpose of a java Singleton class is to restrict the limit of the number of object creations to only one.
 *    This often ensures that there is access control to resources, for example, socket or database connection.
 * 2. Memory space wastage does not occur with the use of the singleton class because it restricts instance creation.
 *
 *
 */
public class Singleton {

    private static Singleton instance = null;

    private Singleton() {
    }

    /**
     * Multi-threaded programs may often come to a situation where multiple threads try to access the same resources and
     * finally produce erroneous and unforeseen results.
     *
     * Why use Java Synchronization?
     * Java Synchronization is used to make sure by some synchronization method that only one thread can access the
     * resource at a given point in time. It is mainly used to prevent thread interference and thread deadlock.
     */
    public static synchronized Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    public static void main(String[] args) {
        Singleton instance1 = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        Singleton instance3 = Singleton.getInstance();

        System.out.println(instance1.hashCode());
        System.out.println(instance2.hashCode());
        System.out.println(instance3.hashCode());

        if (instance1 == instance2 && instance2 == instance3) {
            System.out.println("Same instance");
        } else {
            System.out.println("Different instances");
        }
    }
}
