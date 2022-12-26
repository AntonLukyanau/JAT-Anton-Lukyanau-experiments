package org.example.multithreading;

public class LiveLockExample {
    static class Spoon {
        private Diner owner;

        public Spoon(Diner owner) {
            this.owner = owner;
        }

        public Diner getOwner() {
            return owner;
        }

        public synchronized void setOwner(Diner owner) {
            this.owner = owner;
        }

        public synchronized void use() {
            System.out.printf("%s использует ложку%n", owner.name);
        }
    }

    static class Diner {
        private String name;
        private boolean isHungry;

        public Diner(String name) {
            this.name = name;
            isHungry = true;
        }

        public void eatWith(Spoon spoon, Diner spouse) {
            while (isHungry) {
                // Проверяем, не использует ли супруг(а) ложку
                if (spoon.owner != this) {
                    for (int i = 0; i < 10000000; i++){}
                    continue;
                }

                // Проверяем, не голоден ли супруг(а)
                if (spouse.isHungry) {
                    System.out.printf("%s: Я вижу ты хочешь есть. Давай уступим ложку тебе\n", name);
                    spoon.setOwner(spouse);
                    continue;
                }

                // Если супруг(а) не голоден(а) и использует ложку, начинаем есть
                spoon.use();
                isHungry = false;
                System.out.printf("%s: Я сыт(а)%n", name);
                spoon.setOwner(spouse);
            }
        }
    }

    public static void main(String[] args) {
        Diner husband = new Diner("Муж");
        Diner wife = new Diner("Жена");

        Spoon spoon = new Spoon(husband);

        Thread husbandThread = new Thread(() -> husband.eatWith(spoon, wife));
        Thread wifeThread = new Thread(() -> wife.eatWith(spoon, husband));
        husbandThread.start();
        wifeThread.start();
        while (true) {
            System.out.println("Муж:  " + husbandThread.getState());
            System.out.println("Жена: " + wifeThread.getState());
        }
    }
}
