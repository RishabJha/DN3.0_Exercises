public class SlackNotifierDecorator extends NotifierDecorator {
    public SlackNotifierDecorator(Notifier notifier) {
        super(notifier);
    }

    public void send(String msg) {
        super.send(msg);
        sendSlack(msg);
    }

    private void sendSlack(String message) {
        System.out.println("Sending Slack message: " + message);
    }
}
