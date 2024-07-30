public class Computer {
    private String cpu;
    private int ram;
    private int storage;

    private Computer(Builder builder) {
        this.cpu = builder.cpu;
        this.ram = builder.ram;
        this.storage = builder.storage;
    }

    public String getCpu() {
        return this.cpu;
    }

    public int getRam() {
        return this.ram;
    }

    public int getStorage() {
        return this.storage;
    }

    public void addAdditionalRam(int additionalRam) {
        this.ram += additionalRam;
        System.out.println("Additional ram has been added");
    }

    public void addAdditionalStorage(int additionalStorage) {
        this.storage += additionalStorage;
        System.out.println("Additional storage has been added");
    }

    public String toString() {
        return "CPU is " + this.getCpu() + "\nRam is " + this.getRam() + "\nStorage is " + this.getStorage();
    }

    public static class Builder {
        private String cpu;
        private int ram;
        private int storage;

        public Builder setCpu(String cpu) {
            this.cpu = cpu;
            return this;
        }

        public Builder setRam(int ram) {
            this.ram = ram;
            return this;
        }

        public Builder setStorage(int storage) {
            this.storage = storage;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }
}