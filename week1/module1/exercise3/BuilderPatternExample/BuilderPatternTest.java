package week1.module1.exercise3.BuilderPatternExample;

public class BuilderPatternTest {
    public static void main(String[] args) {
        Computer basicComputer = new Computer.Builder("Intel i5", 8, 256)
                .build();
        System.out.println(basicComputer);

        Computer gamingComputer = new Computer.Builder("AMD Ryzen 7", 16, 512)
                .setSSD(true)
                .setGPU("NVIDIA GTX 3080")
                .build();
        System.out.println(gamingComputer);
    }
}
