package mathspacebot;

import mathspacebot.mouse.MouseController;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.util.TimerTask;

public class MathspaceBotUI extends Main {

    public static JFrame jFrame;
    public static JPanel jPanel;
    public static JLabel enabledLabel;
    public static JLabel mousePositionLabel;

    public static JLabel totalRuns;
    public static JLabel question;
    public static JLabel lastQuestion;

    public static JLabel equation;
    public static JLabel answer;

    public MathspaceBotUI(){
        jFrame = new JFrame("Mathspace Bot");
        jPanel = new JPanel();
        enabledLabel = new JLabel("Enabled");
        mousePositionLabel = new JLabel("Mouse Position");
        totalRuns = new JLabel("Total Runs");
        question = new JLabel("Question");
        lastQuestion = new JLabel("Last Question");

        equation = new JLabel("Equation");
        answer = new JLabel("Answer");

        ImageIcon img = new ImageIcon("src/mathspacebot/assets/mathspace.png");

        jFrame.setIconImage(img.getImage());

        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        enabledLabel.setText("Enabled: " + MathspaceBot.enabled);
        enabledLabel.setBorder(new EmptyBorder(10, 10, 10, 10));
        enabledLabel.setHorizontalAlignment(JLabel.LEFT);
        enabledLabel.setVerticalAlignment(JLabel.TOP);

        mousePositionLabel.setText("Mouse Position: 0, 0");
        mousePositionLabel.setBorder(new EmptyBorder(10, 10, 10, 10));
        mousePositionLabel.setHorizontalAlignment(JLabel.RIGHT);
        mousePositionLabel.setVerticalAlignment(JLabel.TOP);

        totalRuns.setText("Total Runs: --");
        totalRuns.setBorder(new EmptyBorder(10, 10, 10, 75));
        totalRuns.setHorizontalAlignment(JLabel.CENTER);
        totalRuns.setVerticalAlignment(JLabel.TOP);

        question.setText("Question: --");
        question.setBorder(new EmptyBorder(10, 10, 10, 75));
        question.setHorizontalAlignment(JLabel.LEFT);
        question.setVerticalAlignment(JLabel.TOP);

        lastQuestion.setText("Last Question: --");
        lastQuestion.setBorder(new EmptyBorder(10, 10, 10, 10));
        lastQuestion.setHorizontalAlignment(JLabel.RIGHT);
        lastQuestion.setVerticalAlignment(JLabel.TOP);

        equation.setText("Equation: --");
        equation.setBorder(new EmptyBorder(10, 10, 10, 75));
        equation.setHorizontalAlignment(JLabel.CENTER);
        equation.setVerticalAlignment(JLabel.CENTER);

        answer.setText("Answer: --");
        answer.setBorder(new EmptyBorder(10, 10, 10, 75));
        answer.setHorizontalAlignment(JLabel.CENTER);
        answer.setVerticalAlignment(JLabel.CENTER);

        jPanel.add(enabledLabel);
        jPanel.add(mousePositionLabel);

        jPanel.add(totalRuns);
        jPanel.add(question);
        jPanel.add(lastQuestion);

        jPanel.add(equation);
        jPanel.add(answer);

        jPanel.setSize(400, 350);

        jFrame.add(jPanel);

        jFrame.setSize(700, 350);

        jFrame.setVisible(true);


        jFrame.addKeyListener(new KeyList());

        //MouseController mc = new MouseController();
        //mc.setPosition(0, 0);


        /*Box box = Box.createVerticalBox();

        JPanel panel = new JPanel(new GridLayout(1, 2));
        panel.setBorder(new LineBorder(Color.black));

        JLabel label1 = new JLabel("Hello");
        JLabel label2 = new JLabel("World");
        label1.setHorizontalAlignment(JLabel.LEADING);
        label2.setHorizontalAlignment(JLabel.TRAILING);
        panel.add(label1);
        panel.add(label2);

        box.add(new JPanel(){
            public Dimension getPreferredSize(){
                return new Dimension(300, 300);
            }
        });
        box.add(panel);

        add(box);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setVisible(true);*/

        Main.getScheduler().runRepeatingTask(new TimerTask() {
            @Override
            public void run() {
                update();
            }
        }, 1000, 10);
    }

    public void update() {
        if (Main.getMathspaceBot().question != 0) {
            question.setText("Question: " + Main.getMathspaceBot().question);
        } else {
            question.setText("Question: --");
        }

        if (Main.getMathspaceBot().lastQuestion != 0) {
            lastQuestion.setText("Last Question: " + Main.getMathspaceBot().lastQuestion);
        } else {
            lastQuestion.setText("Last Question: --");
        }

    }

}
