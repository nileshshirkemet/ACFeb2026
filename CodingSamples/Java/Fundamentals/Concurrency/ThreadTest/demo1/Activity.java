class Activity {

    private static ThreadLocal<String> id = new ThreadLocal<>();

    public static void client(String name) {
        id.set(name);
    }

    public static String client() {
        return id.get();
    }

    public static void perform(int count) {
        long target = System.currentTimeMillis() + 1000 * count;
        while(System.currentTimeMillis() < target);
    }
}
