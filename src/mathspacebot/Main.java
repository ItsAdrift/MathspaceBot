package mathspacebot;

import mathspacebot.schedulling.Scheduler;

public class Main {

    public static MathspaceBot mathspaceBot;
    public static MathspaceBotUI ui;
    public static Scheduler scheduler;



    public static void main(String[] args) {

        scheduler = new Scheduler();
        ui = new MathspaceBotUI();
        mathspaceBot = new MathspaceBot(ui);


        System.out.print("Mathspace Bot Initialized");
    }

    public Main() {
        
    }

    public static Scheduler getScheduler() {
        return scheduler;
    }
    public static MathspaceBot getMathspaceBot() {
        return mathspaceBot;
    }
}
