import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    public static final int WINDOW_WIDTH = 800;
    public static final int WINDOW_HEIGHT = 600;

    public static void main(String[] args) {
        Window window = new Window();
    }

    public Window(){
        this.setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setResizable(true);
        this.setTitle("IP Of Countries");
        this.setVisible(true);

        MainScene mainScene = new MainScene(0,0,WINDOW_WIDTH,WINDOW_HEIGHT);
        this.add(mainScene);
    }
}
