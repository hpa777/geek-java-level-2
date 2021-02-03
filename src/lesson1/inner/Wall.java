package lesson1.inner;

public class Wall implements Obstacle{

    private int height;

    public Wall(int height) {
        this.height = height;
    }

    @Override
    public boolean passing(Member member) {
        return member.jump(this.height);
    }
}
