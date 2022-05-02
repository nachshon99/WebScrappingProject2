import javax.swing.*;
import java.awt.*;

public class MainScene extends JPanel {

    private JTextField textFieldToSearchIP;

    public MainScene(int x, int y, int width, int height){
        //Settings of panel
        this.setBounds(x,y,width,height);
        this.setLayout(null);
        this.setBackground(Color.CYAN);
        this.setDoubleBuffered(true);


        new Thread(() -> {

            //Title Of Page
            JLabel title = new JLabel("IP Countries");
            title.setFont(new Font("arial", Font.BOLD,50));
            title.setBounds(Window.WINDOW_WIDTH/3,Window.WINDOW_HEIGHT/4, 400,50);
            title.setVisible(true);
            this.add(title);

            //Text Field to enter IP
            textFieldToSearchIP = createJTextField();
            this.add(textFieldToSearchIP);

            //Button to Search
            JButton searchButton = new JButton("Search");
            searchButton.setBounds(Window.WINDOW_WIDTH/2 - 35, textFieldToSearchIP.getY() + (textFieldToSearchIP.getHeight()*2), 100,50);
            this.add(searchButton);

        }).start();


        /*this.add(textToSearchIP);*/
        /*textToSearchIP.setPreferredSize(new Dimension(250,40));
        this.add(textToSearchIP);*/

        /*Thread thread = new Thread(() -> {
            try {
                ScrappingIP scrappingIP = new ScrappingIP();
                Thread.sleep(5);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        });
        thread.start();*/

        this.setVisible(true);
    }

    public JTextField createJTextField(){
        JTextField textField = new JTextField();
        textField.setBounds(290,300,250,50);
        textField.setFont(new Font("arial",Font.BOLD,24));
        textField.setForeground(Color.BLUE);
        textField.setBackground(Color.lightGray);
        textField.setToolTipText("Enter IP");
        return textField;

    }
}
