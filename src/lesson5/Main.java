package lesson5;

public class Main {

    static final int size = 10000000;

    public static void main(String[] args) {
        method1();
        method2();
    }

    private static void method1() {
        float[] arr = new float[size];
        for (int i = 0; i < size; i++) {
            arr[i] = 1;
        }

        long a = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println(System.currentTimeMillis() - a);
        float sum = 0;
        for (int i = 0; i < size; i++) {
            sum+=arr[i];
        }
        System.out.println(sum);
    }

    private static void method2() {
        float[] arr = new float[size];
        for (int i = 0; i < size; i++) {
            arr[i] = 1;
        }
        int h = size / 2;

        long a = System.currentTimeMillis();

        float[] a1 = new float[h];
        float[] a2 = new float[h];
        Thread th1 = new Thread(()->{
            System.arraycopy(arr, 0, a1, 0, h);
            for (int i = 0; i < h; i++) {
                a1[i] = (float)(a1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
            System.arraycopy(a1, 0, arr, 0, h);
        });
        th1.start();
        Thread th2 = new Thread(()->{
            System.arraycopy(arr, h, a2, 0, h);
            for (int i = h; i < size; i++) {
                int c = i - h;
                a2[c] = (float)(a2[c] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
            System.arraycopy(a2, 0, arr, h, h);
        });
        th2.start();
        try {
            th1.join();
            th2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(System.currentTimeMillis() - a);
        float sum = 0;
        for (int i = 0; i < size; i++) {
            sum+=arr[i];
        }
        System.out.println(sum);

    }

}
