import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;

public class MainScene extends JPanel {

    public static final  int INITIALIZE = 0;
    public static final  int COUNT_POINTS_VALID = 1;
    public static final  int DUPLICATE_2 = 2;
    public static final  int DUPLICATE_3 = 3;
    public static final  int OFFSET = 100;
    public static final int SIZE_FONT = 60;
    public static final int SIZE_TEXT_FIELD = 24;

    public static final int WIDTH_TITLE = 500;
    public static final int HEIGHT_TITLE = 100;
    public static final int X_TITLE = Window.WINDOW_WIDTH/4;
    public static final int Y_TITLE = Window.WINDOW_HEIGHT/5;
    public static final int X_BUTTON = Window.WINDOW_WIDTH/10;
    public static final int Y_BUTTON = Window.WINDOW_HEIGHT/9;
    public static final int X_CALC_BUTTON = Window.WINDOW_WIDTH/2;
    public static final int OFFSET_Y_TEXT = 20;
    public static final int OFFSET_X_TEXT_FIELD = 50;

    public static final int X_TEXT_FIELD = 500;
    public static final int Y_TEXT_FIELD = 300;
    public static final int WIDTH_TEXT_FIELD = 150;
    public static final int HEIGHT_TEXT_FIELD = 50;
    public static final int MAX_DIGITS = 6;
    public static final int WIDTH_CREATE_BUTTON = 100;
    public static final int HEIGHT_CREATE_BUTTON = 50;
    public static final int X_Y_TEXT_FIELD_ENTER = 300;

    public static final String EUR_USD = "EUR/USD";
    public static final String GBP_USD = "GBP/USD";
    public static final String USD_ILS = "USD/ILS";
    public static final String USD_CHF = "USD/CHF";
    public static final String USD_JPY = "USD/JPY";
    public static final String CLEAR_TEXT = "Clear";
    public static final String CALC_TEXT = "Calc";
    public static final String EMPTY_TEXT = "";
    public static final char DOT_CHAR = '.';
    public static final String DECIMAL_FORMAT = "#.####";
    public static final String MESSAGE_TEXT = "Invalid input!";
    public static final String TITLE_MESSAGE_TEXT = "Error";
    public final String TITLE = "Foreign Currency";
    public static final String TEXT_CALC_TEXT_FIELD = "Currency Value: ";
    public static final String TEXT_ENTER_TEXT_FIELD = "Enter Currency Value";
    public static final String TEXT_ENTER_TEXT = "Enter Currency Value to calculate:";
    public static final int WINDOW_WIDTH = 800;
    public static final int WINDOW_HEIGHT = 600;

    private ImageIcon background;
    private JLabel backgroundLabel;

    private JButton eurUsdButton;
    private JButton gbpUsdButton;
    private JButton usdIlsButton;
    private JButton usdChfButton;
    private JButton usdJpyButton;

    private JButton calcButton;
    private JButton clearButton;

    private JLabel enterCurrencyValueText;
    private JTextField textFieldToEnterCurrencyValue;

    private JLabel calcCurrencyValueText;
    private JTextField textFieldToShowCalcCurrencyValue;

    private JTextField textFieldToShowCurrencyValue;

    private boolean canUpdate = true;


    public MainScene(int x, int y, int width, int height){
        //Settings of panel
        this.setBounds(x,y,width,height);
        this.setLayout(null);
        this.setBackground(null);
        this.setDoubleBuffered(true);

        ScrappingCurrencyValue scrappingCurrencyValue = new ScrappingCurrencyValue();

        //Title Of Page
        JLabel title = new JLabel(TITLE);
        title.setFont(new Font("arial", Font.TYPE1_FONT,SIZE_FONT));
        title.setForeground(Color.YELLOW);
        title.setBounds(X_TITLE,Y_TITLE, WIDTH_TITLE,HEIGHT_TITLE);
        title.setVisible(true);
        this.add(title);

        //Currency exchange pairs buttons
        eurUsdButton = createButton(EUR_USD,X_BUTTON, Y_BUTTON);
        eurUsdButton.setVisible(true);
        this.add(eurUsdButton);
        //Click button
        eurUsdButton.addActionListener((event) -> {
            gbpUsdButton.setVisible(false);
            usdIlsButton.setVisible(false);
            usdChfButton.setVisible(false);
            usdJpyButton.setVisible(false);
            eurUsdButton.setEnabled(false);
            calcButton.setVisible(true);
            calcCurrencyValueText.setVisible(true);
            enterCurrencyValueText.setVisible(true);
            textFieldToEnterCurrencyValue.setVisible(true);
            textFieldToShowCalcCurrencyValue.setVisible(true);
            updateScrapping(scrappingCurrencyValue,EUR_USD);
        });

        gbpUsdButton = createButton(GBP_USD,eurUsdButton.getX(), eurUsdButton.getY() + OFFSET);
        gbpUsdButton.setVisible(true);
        this.add(gbpUsdButton);
        //Click button
        gbpUsdButton.addActionListener((event) -> {
            eurUsdButton.setVisible(false);
            usdIlsButton.setVisible(false);
            usdChfButton.setVisible(false);
            usdJpyButton.setVisible(false);
            gbpUsdButton.setEnabled(false);
            calcButton.setVisible(true);
            calcCurrencyValueText.setVisible(true);
            enterCurrencyValueText.setVisible(true);
            textFieldToEnterCurrencyValue.setVisible(true);
            textFieldToShowCalcCurrencyValue.setVisible(true);
            updateScrapping(scrappingCurrencyValue,GBP_USD);
        });

        usdIlsButton = createButton(USD_ILS,gbpUsdButton.getX(), gbpUsdButton.getY() + OFFSET);
        usdIlsButton.setVisible(true);
        this.add(usdIlsButton);
        //Click button
        usdIlsButton.addActionListener((event) -> {
            eurUsdButton.setVisible(false);
            gbpUsdButton.setVisible(false);
            usdChfButton.setVisible(false);
            usdJpyButton.setVisible(false);
            usdIlsButton.setEnabled(false);
            calcButton.setVisible(true);
            calcCurrencyValueText.setVisible(true);
            enterCurrencyValueText.setVisible(true);
            textFieldToEnterCurrencyValue.setVisible(true);
            textFieldToShowCalcCurrencyValue.setVisible(true);
            updateScrapping(scrappingCurrencyValue,USD_ILS);
        });

        usdChfButton = createButton(USD_CHF,usdIlsButton.getX(), usdIlsButton.getY() + OFFSET);
        usdChfButton.setVisible(true);
        this.add(usdChfButton);
        //Click button
        usdChfButton.addActionListener((event) -> {
            eurUsdButton.setVisible(false);
            gbpUsdButton.setVisible(false);
            usdIlsButton.setVisible(false);
            usdJpyButton.setVisible(false);
            usdChfButton.setEnabled(false);
            calcButton.setVisible(true);
            calcCurrencyValueText.setVisible(true);
            enterCurrencyValueText.setVisible(true);
            textFieldToEnterCurrencyValue.setVisible(true);
            textFieldToShowCalcCurrencyValue.setVisible(true);
            updateScrapping(scrappingCurrencyValue,USD_CHF);
        });

        usdJpyButton = createButton(USD_JPY,usdChfButton.getX(), usdChfButton.getY() + OFFSET);
        usdJpyButton.setVisible(true);
        this.add(usdJpyButton);
        //Click button
        usdJpyButton.addActionListener((event) -> {
            eurUsdButton.setVisible(false);
            gbpUsdButton.setVisible(false);
            usdIlsButton.setVisible(false);
            usdChfButton.setVisible(false);
            usdJpyButton.setEnabled(false);
            calcButton.setVisible(true);
            calcCurrencyValueText.setVisible(true);
            enterCurrencyValueText.setVisible(true);
            textFieldToEnterCurrencyValue.setVisible(true);
            textFieldToShowCalcCurrencyValue.setVisible(true);
            updateScrapping(scrappingCurrencyValue,USD_JPY);
        });

        //Text Field to show value of calc
        textFieldToShowCalcCurrencyValue = createTextField(X_TEXT_FIELD,Y_TEXT_FIELD,WIDTH_TEXT_FIELD,HEIGHT_TEXT_FIELD);
        textFieldToShowCalcCurrencyValue.setEnabled(false);
        textFieldToShowCalcCurrencyValue.setVisible(false);
        this.add(textFieldToShowCalcCurrencyValue);

        //Text to calcTextField
        calcCurrencyValueText = new JLabel(TEXT_CALC_TEXT_FIELD);
        calcCurrencyValueText.setBounds(textFieldToShowCalcCurrencyValue.getX(),
                textFieldToShowCalcCurrencyValue.getY() + textFieldToShowCalcCurrencyValue.getHeight() - OFFSET_Y_TEXT, WIDTH_TEXT_FIELD+HEIGHT_TEXT_FIELD, HEIGHT_TEXT_FIELD);
        calcCurrencyValueText.setForeground(Color.YELLOW);
        calcCurrencyValueText.setVisible(false);
        this.add(calcCurrencyValueText);

        //Text Field to enter Currency value
        textFieldToEnterCurrencyValue = createTextField(X_Y_TEXT_FIELD_ENTER,X_Y_TEXT_FIELD_ENTER,WIDTH_CREATE_BUTTON,HEIGHT_TEXT_FIELD);
        textFieldToEnterCurrencyValue.setToolTipText(TEXT_ENTER_TEXT_FIELD);
        textFieldToEnterCurrencyValue.setVisible(false);
        textFieldToEnterCurrencyValue.setDocument(new LimitJTextField(MAX_DIGITS));
        this.add(textFieldToEnterCurrencyValue);

        //Text to text field
        enterCurrencyValueText = new JLabel(TEXT_ENTER_TEXT);
        enterCurrencyValueText.setBounds(textFieldToEnterCurrencyValue.getX() - OFFSET_X_TEXT_FIELD,
                textFieldToEnterCurrencyValue.getY() + textFieldToEnterCurrencyValue.getHeight() - OFFSET_Y_TEXT, WIDTH_TEXT_FIELD+HEIGHT_TEXT_FIELD, HEIGHT_TEXT_FIELD);
        enterCurrencyValueText.setForeground(Color.YELLOW);
        enterCurrencyValueText.setVisible(false);
        this.add(enterCurrencyValueText);

        //Button to calculate
        calcButton = createButton(CALC_TEXT,X_CALC_BUTTON,
                textFieldToEnterCurrencyValue.getY() + (textFieldToEnterCurrencyValue.getHeight()*DUPLICATE_2));
        calcButton.setVisible(false);
        this.add(calcButton);
        calcButton.addActionListener((event) -> {
            calculateEnterCurrencyValue(textFieldToShowCurrencyValue,textFieldToEnterCurrencyValue,textFieldToShowCalcCurrencyValue);
        });

        //Button to clear
        clearButton = createButton(CLEAR_TEXT,X_CALC_BUTTON,
                textFieldToEnterCurrencyValue.getY() + (textFieldToEnterCurrencyValue.getHeight()*DUPLICATE_3));
        this.add(clearButton);
        //Click button
        clearButton.addActionListener((event) -> {
            usdJpyButton.setEnabled(true);
            eurUsdButton.setVisible(true);
            eurUsdButton.setEnabled(true);
            gbpUsdButton.setVisible(true);
            gbpUsdButton.setEnabled(true);
            usdIlsButton.setVisible(true);
            usdIlsButton.setEnabled(true);
            usdChfButton.setVisible(true);
            usdChfButton.setEnabled(true);
            usdJpyButton.setVisible(true);
            enterCurrencyValueText.setVisible(false);
            calcCurrencyValueText.setVisible(false);

            textFieldToEnterCurrencyValue.setVisible(false);
            textFieldToShowCalcCurrencyValue.setVisible(false);
            calcButton.setVisible(false);
            textFieldToShowCurrencyValue.setText(EMPTY_TEXT);
            textFieldToEnterCurrencyValue.setText(EMPTY_TEXT);
            textFieldToShowCalcCurrencyValue.setText(EMPTY_TEXT);
            canUpdate = false;
        });

        //Text Field to show Currency value
        textFieldToShowCurrencyValue = createTextField(clearButton.getX(), title.getY() + OFFSET,WIDTH_TEXT_FIELD - HEIGHT_TEXT_FIELD,HEIGHT_TEXT_FIELD);
        textFieldToShowCurrencyValue.setVisible(true);
        textFieldToShowCurrencyValue.setEnabled(false);
        this.add(textFieldToShowCurrencyValue);

        background = new ImageIcon(this.getClass().getResource("/CurrencyBackground.jpg"));
        backgroundLabel = new JLabel(background);
        backgroundLabel.setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
        this.add(backgroundLabel);

        this.setVisible(true);
    }

    public void updateScrapping(ScrappingCurrencyValue scrappingCurrencyValue,String typeCurrency){
        canUpdate = true;
        new Thread(() -> {
            while (canUpdate){
                textFieldToShowCurrencyValue.setText(scrappingCurrencyValue.CURRENCY_VALUES.get(typeCurrency));
                try {
                    Thread.sleep(scrappingCurrencyValue.SLEEP_TIME);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }).start();
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
        int countPoint = INITIALIZE;
        JFrame frame = new JFrame();
        try {
            for (int i = 0; i < textField.getText().length(); i++){
                if(textField.getText().charAt(i) == DOT_CHAR){
                    countPoint++;
                    if(countPoint > COUNT_POINTS_VALID){
                        isValid = false;
                        break;
                    }
                }else if((!Character.isDigit(textField.getText().charAt(i)) && textField.getText().charAt(i) != DOT_CHAR) || countPoint > COUNT_POINTS_VALID){
                    isValid = false;
                    break;
                }
            }
            if(!isValid){
                JOptionPane.showConfirmDialog(frame,MESSAGE_TEXT,TITLE_MESSAGE_TEXT, JOptionPane.CLOSED_OPTION);
            }
        }catch (NumberFormatException e){
        }
        return isValid;
    }

    public void calculateEnterCurrencyValue(JTextField showTextField, JTextField enterTextField, JTextField calcTextField){
        if (isValidInput(enterTextField) && canClickButton(enterTextField)) {
            try {
                double sum = (Double.parseDouble(enterTextField.getText())) * (Double.parseDouble(showTextField.getText()));
                sum = Double.parseDouble(new DecimalFormat(DECIMAL_FORMAT).format(sum));
                calcTextField.setText(sum + EMPTY_TEXT);
            }catch (NumberFormatException e){
            }
        }
    }
    public static JTextField createTextField( int x, int y, int width, int height){
        JTextField textField = new JTextField();
        textField.setBounds(x,y,width,height);
        textField.setFont(new Font("arial",Font.BOLD, SIZE_TEXT_FIELD));
        textField.setForeground(Color.BLUE);
        textField.setBackground(Color.lightGray);
        textField.setDisabledTextColor(Color.BLACK);

        return textField;
    }
    public static JButton createButton(String textButton,int x, int y){
        JButton button = new JButton(textButton);
        button.setBounds(x, y, WIDTH_CREATE_BUTTON,HEIGHT_CREATE_BUTTON);
        return button;
    }
}