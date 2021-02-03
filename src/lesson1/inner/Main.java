package lesson1.inner;

public class Main {

    public static void main(String[] args) {
        Member[] members = new Member[]{
                new Man("Александр", 30, 2),
                new Cat("Пушок", 20, 3),
                new Robot("Вертер", 100, 10)
        };
        Obstacle[] obstacles = new Obstacle[]{
                new Treadmill(10),
                new Wall(1),
                new Treadmill(30),
                new Wall(2),
                new Treadmill(20),
                new Wall(3)
        };

        for (Member member :
                members) {
            for (Obstacle obstracle :
                    obstacles) {
                if (!obstracle.passing(member)) {
                    System.out.printf("Участник %s выбывает из соревнования%n", member.getName());
                    break;
                }
            }
        }
    }

}

