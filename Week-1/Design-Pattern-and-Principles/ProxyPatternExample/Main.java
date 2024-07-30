public class Main {
    public static void main(String[] args) {
        Image image1 = new ProxyImage("image 1");
        image1.display();
        System.out.println();
        Image image2 = new ProxyImage("image 2");
        image2.display();
    }
}
