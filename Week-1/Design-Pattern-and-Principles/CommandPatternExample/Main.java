public class Main {
    public static void main(String[] args) {
        Light light = new Light();
        Command lightOnCommand = new LightOnCommand(light);
        RemoteControl remoteControl = new RemoteControl(lightOnCommand);
        remoteControl.executeCommand();

        Command lightOffCommand = new LightOffCommand(light);
        remoteControl.setCommand(lightOffCommand);
        remoteControl.executeCommand();
    }
}
