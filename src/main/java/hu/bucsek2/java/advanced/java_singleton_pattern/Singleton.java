package hu.bucsek2.java.advanced.java_singleton_pattern;

class Singleton {
    public String str;
    private volatile static Singleton instance;

    private Singleton() {}

    static Singleton getSingleInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
