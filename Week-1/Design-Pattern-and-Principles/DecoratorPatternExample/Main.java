public class Main {
    public static void main(String[] args) {
        Notifier obj1 = new EmailNotifier();
        obj1.send("Hello");
        System.out.println();

        Notifier obj2 = new EmailNotifier();
        obj2 = new SMSNotifierDecorator(obj2);
        obj2.send("Hi there");
        System.out.println();

        Notifier obj3 = new EmailNotifier();
        obj3 = new SlackNotifierDecorator(obj3);
        obj3.send("My name is Rishab");
        System.out.println();

        Notifier obj4 = new EmailNotifier();
        obj4 = new SMSNotifierDecorator(obj4);
        obj4 = new SlackNotifierDecorator(obj4);
        obj4.send("Bye");

    }
}
