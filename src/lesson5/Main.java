package lesson5;

import java.util.ArrayList;

public class Main {

    static final int size = 10000000;

    static float[] arr = new float[size];

    public static void main(String[] args) {
        method1();
        method2();
        method3(3);
    }

    private static void fillArray() {
        for (int i = 0; i < size; i++) {
            arr[i] = 1;
        }
    }

    private static void checkSum() {
        float sum = 0;
        for (int i = 0; i < size; i++) {
            sum+=arr[i];
        }
        System.out.println(sum);
    }

    private static void method1() {
        fillArray();
        long a = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println(System.currentTimeMillis() - a);
        checkSum();
    }

    private static void method2() {
        fillArray();
        int h = size / 2;
        long a = System.currentTimeMillis();
        Thread th1 = new Thread(()->{
            float[] ac = new float[h];
            System.arraycopy(arr, 0, ac, 0, h);
            for (int i = 0; i < h; i++) {
                ac[i] = (float)(ac[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
            System.arraycopy(ac, 0, arr, 0, h);
        });
        th1.start();
        Thread th2 = new Thread(()->{
            float[] ac = new float[h];
            System.arraycopy(arr, h, ac, 0, h);
            for (int i = h; i < size; i++) {
                int c = i - h;
                ac[c] = (float)(ac[c] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
            System.arraycopy(ac, 0, arr, h, h);
        });
        th2.start();
        try {
            th1.join();
            th2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(System.currentTimeMillis() - a);
        checkSum();
    }

    private static void method3(int threadCount) {
        fillArray();
        long a = System.currentTimeMillis();
        int partSize = size / threadCount;
        ArrayList<Thread> threads = new ArrayList<>();
        int srcPos = 0;
        for (int i = 0; i < threadCount; i++) {
            int finalSrcPos = srcPos;
            Thread thread = new Thread(()->{
                float[] ac = new float[partSize];
                System.arraycopy(arr, finalSrcPos, ac, 0, partSize);
                for (int j = 0; j < partSize; j++) {
                    int c = j + finalSrcPos;
                    ac[j] = (float)(ac[j] * Math.sin(0.2f + c / 5) * Math.cos(0.2f + c / 5) * Math.cos(0.4f + c / 2));
                }
                System.arraycopy(ac, 0, arr, finalSrcPos, partSize);
            });
            thread.start();
            threads.add(thread);
            srcPos+=partSize;
        }
        if (srcPos < size) {
            int finalSrcPos1 = srcPos;
            Thread thread = new Thread(()->{
                float[] ac = new float[partSize];
                int p = size - finalSrcPos1;
                System.arraycopy(arr, finalSrcPos1, ac, 0, p);
                for (int j = 0; j < p; j++) {
                    int c = j + finalSrcPos1;
                    ac[j] = (float)(ac[j] * Math.sin(0.2f + c / 5) * Math.cos(0.2f + c / 5) * Math.cos(0.4f + c / 2));
                }
                System.arraycopy(ac, 0, arr, finalSrcPos1, p);
            });
            thread.start();
            threads.add(thread);
        }
        for (Thread thread: threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(System.currentTimeMillis() - a);
        checkSum();
    }

}
