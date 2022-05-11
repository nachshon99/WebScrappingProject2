import javax.swing.*;

public class Window extends JFrame {
    public static final int WINDOW_WIDTH = 800;
    public static final int WINDOW_HEIGHT = 600;
    public static final int START_WINDOW = 0;

    public static void main(String[] args) {
        Window window = new Window();
    }

    public Window(){
        new Thread(() -> {
            MainScene mainScene = new MainScene(START_WINDOW,START_WINDOW,WINDOW_WIDTH,WINDOW_HEIGHT);
            this.add(mainScene);
            this.setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setLayout(null);
            this.setLocationRelativeTo(null);
            this.setResizable(false);
            this.setTitle(mainScene.TITLE);
            this.setVisible(true);
        }).start();

    }


}
