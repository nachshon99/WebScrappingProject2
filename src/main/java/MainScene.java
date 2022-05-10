import javax.swing.*;
import java.awt.*;

public class MainScene extends JPanel {

    public static final  int OFFSET = 100;

    private JButton eurUsdButton;
    private JButton usdGbpButton;
    private JButton usdIlsButton;
    private JButton rubAudButton;
    private JButton cadJPYButton;

    private JButton clearButton;

    private JTextField textFieldToEnterCurrencyValue;
    private JTextField textFieldToShowCurrencyValue;
    private JTextField textFieldToShowCalcCurrencyValue;

    //Example
    private String currencyValue = "3.14";


    public MainScene(int x, int y, int width, int height){
        //Settings of panel
        this.setBounds(x,y,width,height);
        this.setLayout(null);
        this.setBackground(Color.CYAN);
        this.setDoubleBuffered(true);

        ScrappingCurrencyValue scrappingCurrencyValue = new ScrappingCurrencyValue();


        //Title Of Page
        JLabel title = new JLabel("Foreign Currency");
        title.setFont(new Font("arial", Font.BOLD,50));
        title.setBounds(Window.WINDOW_WIDTH/3,Window.WINDOW_HEIGHT/5, 500,100);
        title.setVisible(true);
        this.add(title);

        //Currency exchange pairs buttons
        eurUsdButton = new JButton("EUR/USD");
        eurUsdButton.setBounds(Window.WINDOW_WIDTH/10, Window.WINDOW_HEIGHT/9 , 100,50);
        eurUsdButton.setVisible(true);
        this.add(eurUsdButton);
        //Click button
        eurUsdButton.addActionListener((event) -> {
            usdGbpButton.setVisible(false);
            usdIlsButton.setVisible(false);
            rubAudButton.setVisible(false);
            cadJPYButton.setVisible(false);
            textFieldToShowCurrencyValue.setText(scrappingCurrencyValue.CURRENCY_VALUES.get(0).toString());
            enterCurrencyValue(textFieldToShowCurrencyValue,textFieldToEnterCurrencyValue,textFieldToShowCalcCurrencyValue);
        });

        usdGbpButton = new JButton("USD/GBP");
        usdGbpButton.setBounds(eurUsdButton.getX(), eurUsdButton.getY() + OFFSET, 100,50);
        usdGbpButton.setVisible(true);
        this.add(usdGbpButton);
        //Click button
        usdGbpButton.addActionListener((event) -> {
            eurUsdButton.setVisible(false);
            usdIlsButton.setVisible(false);
            rubAudButton.setVisible(false);
            cadJPYButton.setVisible(false);
            textFieldToShowCurrencyValue.setText(scrappingCurrencyValue.CURRENCY_VALUES.get(0).toString());
            enterCurrencyValue(textFieldToShowCurrencyValue,textFieldToEnterCurrencyValue,textFieldToShowCalcCurrencyValue);
        });

        usdIlsButton = new JButton("USD/ILS");
        usdIlsButton.setBounds(usdGbpButton.getX(), usdGbpButton.getY() + OFFSET, 100,50);
        usdIlsButton.setVisible(true);
        this.add(usdIlsButton);
        //Click button
        usdIlsButton.addActionListener((event) -> {
            eurUsdButton.setVisible(false);
            usdGbpButton.setVisible(false);
            rubAudButton.setVisible(false);
            cadJPYButton.setVisible(false);
            textFieldToShowCurrencyValue.setText(currencyValue);
            if (canClickButton(textFieldToEnterCurrencyValue)) {
                try {
                    double sum = Double.parseDouble(textFieldToEnterCurrencyValue.getText()) * Double.parseDouble(textFieldToShowCurrencyValue.getText());
                    textFieldToShowCalcCurrencyValue.setText(sum + "");
                }catch (NumberFormatException e){
                    e.printStackTrace();
                }
            }
        });

        rubAudButton = new JButton("RUB/AUD");
        rubAudButton.setBounds(usdIlsButton.getX(), usdIlsButton.getY() + OFFSET, 100,50);
        rubAudButton.setVisible(true);
        this.add(rubAudButton);
        //Click button
        rubAudButton.addActionListener((event) -> {
            eurUsdButton.setVisible(false);
            usdGbpButton.setVisible(false);
            usdIlsButton.setVisible(false);
            cadJPYButton.setVisible(false);
            textFieldToShowCurrencyValue.setText(currencyValue);
            if (canClickButton(textFieldToEnterCurrencyValue)) {
                double sum = Double.parseDouble(textFieldToEnterCurrencyValue.getText()) * Double.parseDouble(textFieldToShowCurrencyValue.getText());
                textFieldToShowCalcCurrencyValue.setText(sum + "");
            }
        });

        cadJPYButton = new JButton("Cad/JPY");
        cadJPYButton.setBounds(rubAudButton.getX(), rubAudButton.getY() + OFFSET, 100,50);
        cadJPYButton.setVisible(true);
        this.add(cadJPYButton);
        cadJPYButton.addActionListener((event) -> {
            eurUsdButton.setVisible(false);
            usdGbpButton.setVisible(false);
            usdIlsButton.setVisible(false);
            rubAudButton.setVisible(false);
            textFieldToShowCurrencyValue.setText(scrappingCurrencyValue.CURRENCY_VALUES.get(2).toString());
            enterCurrencyValue(textFieldToShowCurrencyValue,textFieldToEnterCurrencyValue,textFieldToShowCalcCurrencyValue);

        });

        //Text Field to show value of calc
        textFieldToShowCalcCurrencyValue = new JTextField();
        textFieldToShowCalcCurrencyValue.setBounds(500,300,100,50);
        textFieldToShowCalcCurrencyValue.setFont(new Font("arial",Font.BOLD,24));
        textFieldToShowCalcCurrencyValue.setForeground(Color.BLUE);
        textFieldToShowCalcCurrencyValue.setBackground(Color.lightGray);
        textFieldToShowCalcCurrencyValue.setVisible(true);
        textFieldToShowCalcCurrencyValue.setEnabled(false);
        textFieldToShowCalcCurrencyValue.setDisabledTextColor(Color.BLACK);
        this.add(textFieldToShowCalcCurrencyValue);

        //Text Field to enter Currency value
        textFieldToEnterCurrencyValue = new JTextField();
        textFieldToEnterCurrencyValue.setBounds(300,300,100,50);
        textFieldToEnterCurrencyValue.setFont(new Font("arial",Font.BOLD,24));
        textFieldToEnterCurrencyValue.setForeground(Color.BLUE);
        textFieldToEnterCurrencyValue.setBackground(Color.lightGray);
        textFieldToEnterCurrencyValue.setToolTipText("Enter Currency Value");
        textFieldToEnterCurrencyValue.setVisible(true);
        this.add(textFieldToEnterCurrencyValue);
        //Text to text field
        JLabel enterCurrencyValueText = new JLabel("Enter Currency Value to calculate:");
        enterCurrencyValueText.setBounds(textFieldToEnterCurrencyValue.getX() - 50,
                textFieldToEnterCurrencyValue.getY() + textFieldToEnterCurrencyValue.getHeight() - 20,
                200,
                50);
        this.add(enterCurrencyValueText);


        //Button to clear
        clearButton = new JButton("Clear");
        clearButton.setBounds(Window.WINDOW_WIDTH/2, textFieldToEnterCurrencyValue.getY() + (textFieldToEnterCurrencyValue.getHeight()*2), 100,50);
        clearButton.setVisible(true);
        this.add(clearButton);
        //Click button
        clearButton.addActionListener((event) -> {
            eurUsdButton.setVisible(true);
            usdGbpButton.setVisible(true);
            usdIlsButton.setVisible(true);
            rubAudButton.setVisible(true);
            cadJPYButton.setVisible(true);
            textFieldToShowCurrencyValue.setText("");
            textFieldToEnterCurrencyValue.setText("");
            textFieldToShowCalcCurrencyValue.setText("");
        });

        //Text Field to show Currency value
        textFieldToShowCurrencyValue = new JTextField();
        textFieldToShowCurrencyValue.setBounds(clearButton.getX(), title.getY() + OFFSET,100,50);
        textFieldToShowCurrencyValue.setFont(new Font("arial",Font.BOLD,24));
        textFieldToShowCurrencyValue.setForeground(Color.BLUE);
        textFieldToShowCurrencyValue.setBackground(Color.lightGray);
        textFieldToShowCurrencyValue.setVisible(true);
        textFieldToShowCurrencyValue.setEnabled(false);
        textFieldToShowCurrencyValue.setDisabledTextColor(Color.BLACK);
        this.add(textFieldToShowCurrencyValue);




        this.setVisible(true);
    }

    public JTextField createJTextField(){
        JTextField textField = new JTextField();
        textField.setBounds(290,300,100,50);
        textField.setFont(new Font("arial",Font.BOLD,24));
        textField.setForeground(Color.BLUE);
        textField.setBackground(Color.lightGray);
        textField.setToolTipText("Enter Currency Value");
        textField.setVisible(true);
        return textField;
    }

    public boolean canClickButton(JTextField textEnter){
        boolean canClick = true;
        if(textEnter.getText() == null){
            canClick = false;
        }
        return canClick;
    }

    public boolean isValidInput(JTextField textField){
        boolean isValid = true;
        try {
            for (int i = 0; i < textField.getText().length(); i++){
                if(!Character.isDigit(textField.getText().charAt(i))){
                    isValid = false;
                    break;
                }
            }
        }catch (NumberFormatException e){
        }
        return isValid;
    }

    public void enterCurrencyValue(JTextField showTextField, JTextField enterTextField, JTextField calcTextField){
        if (canClickButton(enterTextField) && isValidInput(enterTextField)) {
            try {
                double sum = (Double.parseDouble(enterTextField.getText())) * (Double.parseDouble(showTextField.getText()));
                calcTextField.setText(sum + "");
            }catch (NumberFormatException e){
            }
        }
    }

    /*public boolean isValidIP(String str){
        boolean isValid = false;
        int countDots = 0;
        int countNumbers = 0;
        String saveNumber = "";
        Queue<Character> numbers = new LinkedList<>();
        String ip;
        if(str.length() >= 4 && str.length() <= 15){
            ip = str;
            for (int i = 0; i < ip.length();i++){
                numbers.add(ip.charAt(i));
                if(ip.charAt(i) == '.'){
                    countDots++;
                }
            }
            numbers.add('.');
            if(countDots == 3){
                do {
                    if(Character.isDigit(numbers.peek())){
                        countNumbers++;
                        saveNumber += numbers.peek();
                    }else if(numbers.peek() == '.') {
                        if(countNumbers >= 1 && countNumbers <= 3){
                            if(isValidNumber(saveNumber) && (Integer.parseInt(saveNumber) >= 0 && Integer.parseInt(saveNumber) <= 255)){
                                isValid = true;
                                saveNumber = "";
                                countNumbers = 0;
                            }else {
                                isValid = false;
                                break;
                            }
                        }else {
                            isValid = false;
                            break;
                        }
                    }
                    else {
                        isValid = false;
                        break;
                    }
                    numbers.poll();
                }while (!numbers.isEmpty());
            }
        }
        return isValid;
    }

    public boolean isValidNumber(String number){
        boolean isValid = false;
        int countZero = 0;
        for (int i = 0; i < number.length();i++){
            char currentChar = number.charAt(i);
            if (Character.isDigit(currentChar)){
                if(currentChar == '0'){
                    countZero++;
                    if(countZero > 1){
                        isValid = false;
                        break;
                    }
                }
                isValid = true;
            }else {
                isValid = false;
            }
        }
        return isValid;
    }*/
}
