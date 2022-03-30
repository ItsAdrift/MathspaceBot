package mathspacebot;

import javafx.scene.input.KeyCode;
import mathspacebot.mouse.MouseButton;
import mathspacebot.mouse.MouseController;
import mathspacebot.mouse.MousePosition;

import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;

public class MathspaceBot {

    TextReader textReader = new TextReader();
    MouseController mouseController = new MouseController();
    KeyController keyController = new KeyController();
    public static boolean enabled;

    public int totalRuns = 0;
    public int lastQuestion = 0;
    public int question = 0;

    private MathspaceBotUI ui;
    public MathspaceBot(MathspaceBotUI ui) {
        this.ui = ui;
    }

    public void start() {
        enabled = true;

        runTask(true);

    }

    public void stop() {
        enabled = false;
    }

    public void runTask(boolean obtainQuestion) {
        if (obtainQuestion) {
            obtainQuestionNumber();
        }

        Main.getScheduler().runTaskLater(new TimerTask() {
            @Override
            public void run() {
                textReader.read(new MousePosition(100, 180), new MousePosition(180, 180));
                Main.getScheduler().runTaskLater(new TimerTask() {
                    @Override
                    public void run() {
                        System.out.println("\n");
                        // Equation
                        String equation = textReader.getText().replace('\\' + "times", "");
                        String[] numbers = equation.split(" ");
                        if (numbers.length != 2) {
                            runTask(false);
                            return;
                        }
                        MathspaceBotUI.equation.setText("Equation: " + equation.replace(" ", "*"));
                        if (isInt(numbers[0]) && isInt(numbers[1])) {
                            int answer = Integer.parseInt(numbers[0]) * Integer.parseInt(numbers[1]);
                            MathspaceBotUI.answer.setText("Answer: " + String.valueOf(answer));
                            String[] chars = String.valueOf(answer).split("");
                            //System.out.println(Arrays.toString(chars));
                            mouseController.setPosition(190, 237);
                            mouseController.clickMouse(MouseButton.LEFT_CLICK);
                            Main.getScheduler().runTaskLater(new TimerTask() {
                                int delay = 20;
                                @Override
                                public void run() {
                                    for (String s : chars) {
                                        KeyCode keyCode = KeyCode.valueOf("DIGIT" + s);
                                        Main.getScheduler().runTaskLater(new TimerTask() {
                                            @Override
                                            public void run() {
                                                keyController.typeKey(keyCode.impl_getCode());
                                            }
                                        }, delay);
                                        //System.out.println(keyCode.getName());
                                        delay += 20;
                                    }
                                    Main.getScheduler().runTaskLater(new TimerTask() {
                                        @Override
                                        public void run() {
                                            keyController.typeKey(KeyCode.ENTER.impl_getCode());
                                        }
                                    }, 100);

                                    Main.getScheduler().runTaskLater(new TimerTask() {
                                        @Override
                                        public void run() {
                                            attemptNewTask(0);
                                        }
                                    }, 3 * 1000);
                                }
                            }, 500);


                        }
                    }
                }, 50);


            }
        }, (obtainQuestion ? 50 : 90));


    }

    public void attemptNewTask(int attempts) {
        if (!enabled) {
            return;
        }

        mouseController.setPosition(1750, 980);
        mouseController.clickMouse(MouseButton.LEFT_CLICK);
        Main.getScheduler().runTaskLater(new TimerTask() {
            @Override
            public void run() {
                lastQuestion = question;
                obtainQuestionNumber();
                Main.getScheduler().runTaskLater(new TimerTask() {
                    @Override
                    public void run() {
                        if (question != lastQuestion || attempts >= 2) {
                            runTask(true);
                            totalRuns++;
                            MathspaceBotUI.totalRuns.setText("Total Runs: " + totalRuns);
                        } else {
                            Main.getScheduler().runTaskLater(new TimerTask() {
                                @Override
                                public void run() {
                                    attemptNewTask(attempts+1);
                                }
                            }, 1000);
                        }
                    }
                }, 80);
            }
        }, 1000);
    }

    public void obtainQuestionNumber() {
        // Get The question
        textReader.read(new MousePosition(40, 165), new MousePosition(70, 165));
        Main.getScheduler().runTaskLater(new TimerTask() {
            @Override
            public void run() {
                question = Integer.parseInt(textReader.getText().replace(".", ""));
            }
        }, 50);
    }

    public boolean isInt(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
