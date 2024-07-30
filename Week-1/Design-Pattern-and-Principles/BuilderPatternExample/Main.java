public class Main {
    public static void main(String[] args) {
        Computer computer = new Computer.Builder().setCpu("Ryzen 9").setRam(16).setStorage(512).build();
        System.out.println(computer.toString());
        computer.addAdditionalRam(16);
        computer.addAdditionalStorage(512);
        System.out.println(computer.toString());
    }
}
