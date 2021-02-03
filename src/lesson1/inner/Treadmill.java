package lesson1.inner;

public class Treadmill implements Obstacle{

    private int length;

    public Treadmill(int length) {
        this.length = length;
    }

    @Override
    public boolean passing(Member member) {
        return member.run(this.length);
    }
}
