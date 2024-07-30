package week1.module1.exercise3.BuilderPatternExample;

public class Computer {
    private final String CPU;
    private final int RAM;
    private final int storage;

    private final boolean isSSD;
    private final String GPU;

    private Computer(Builder builder) {
        this.CPU = builder.CPU;
        this.RAM = builder.RAM;
        this.storage = builder.storage;
        this.isSSD = builder.isSSD;
        this.GPU = builder.GPU;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "CPU='" + CPU + '\'' +
                ", RAM=" + RAM +
                ", storage=" + storage +
                ", isSSD=" + isSSD +
                ", GPU='" + GPU + '\'' +
                '}';
    }

    public static class Builder {
        private final String CPU;
        private final int RAM;
        private final int storage;

        private boolean isSSD = false;
        private String GPU = "None";

        public Builder(String CPU, int RAM, int storage) {
            this.CPU = CPU;
            this.RAM = RAM;
            this.storage = storage;
        }

        public Builder setSSD(boolean isSSD) {
            this.isSSD = isSSD;
            return this;
        }

        public Builder setGPU(String GPU) {
            this.GPU = GPU;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }
}
