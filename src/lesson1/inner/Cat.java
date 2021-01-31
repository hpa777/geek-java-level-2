package lesson1.inner;

public class Cat implements Member{

    private String name;

    public String getName() {
        return name;
    }

    private int maxLength;

    private int maxHeight;

    public Cat(String name, int maxLength, int maxHeight) {
        this.name = name;
        this.maxLength = maxLength;
        this.maxHeight = maxHeight;
    }

    @Override
    public boolean run(int length) {
        boolean result = length <= maxLength;
        String m = result ? "пробежал" : "не пробежал";
        System.out.printf("Кот %s %s беговую дорожку длинной %d%n", this.name, m, length);
        return result;
    }

    @Override
    public boolean jump(int height) {
        boolean result = height <= maxHeight;
        String m = result ? "перепрыгнул" : "не перепрыгнул";
        System.out.printf("Кот %s %s стену высотой %d%n", this.name, m, height);
        return result;
    }

}
