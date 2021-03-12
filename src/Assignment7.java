import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static java.lang.Integer.parseInt;


public class Assignment7 extends JFrame {
    public ArrayList<Integer> arraylist= new ArrayList<>();
    public JFrame window;
    public JLabel firstLabel;
    public int counter = 0;
    public JPanel firstPanel;
    JTextField value;
    public JButton enterButton;
    public JButton clearButton;
    public JPanel input;
    public JLabel entries;
    public JPanel entryCount;
    public JLabel sum;
    public JPanel sumPanel;
    public JLabel minimum;
    public JPanel minPanel;
    public JLabel maximum;
    public JPanel maxPanel;
    public JLabel average;
    public JPanel avgPanel;
    public JLabel dev;
    public JPanel devPanel;
    int total;

    public Assignment7() {
        window = new JFrame("Simple Calc GUI");
        window.setSize(500,439);
        window.setResizable(false);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setBackground(Color.BLACK);
        window.setLayout(new FlowLayout(FlowLayout.CENTER, 2, 0));

        //------------------Instruction Label---------------------------------------------------
        firstLabel = new JLabel("Enter a number, click enter: ");
        firstLabel.setForeground(Color.white); //font colour
        firstLabel.setFont(new Font(" ", Font.PLAIN, 18));
        firstPanel = new JPanel();
        firstPanel.setPreferredSize(new Dimension(600, 50));
        firstPanel.setBackground(Color.BLACK);
        firstPanel.setLayout(new FlowLayout());
        window.add(firstPanel);
        firstPanel.add(firstLabel);

        //-------------------------------------TextField and Buttons-------------------------------------
        //text field
        value = new JTextField(18); //text field
        value.setPreferredSize(new Dimension(40, 30));
        value.setFont(new Font("San-Serif", Font.BOLD, 14));
        window.add(value);

        //BUTTONS
        //ENTER BUTTON to execute calculation
        enterButton = new JButton("Enter");
        window.add(enterButton);
        enterButton.setPreferredSize(new Dimension(120, 30));
        clearButton = new JButton("Clear");
        clearButton.setPreferredSize(new Dimension(120, 30));
        //CLEAR BUTTON event handler
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                value.setText(null);
                entries.setText("Number of entries: ");
                sum.setText("Sum: ");
                minimum.setText("Minimum: ");
                maximum.setText("Maximum: ");
                average.setText("Average: ");
                dev.setText("Standard Deviation: ");
            }
        });
        input = new JPanel();
        input.setPreferredSize(new Dimension(500, 50));
        input.setBackground(Color.white);
        input.setLayout(new FlowLayout());
        window.add(input);
        input.add(value);
        input.add(enterButton);
        input.add(clearButton);
        input.setBorder(BorderFactory.createMatteBorder(0,5,3,5,Color.BLACK));

        //-------------------------------Panels and Labels--------------------------------------------
        entries = new JLabel( "Number of entries: ");
        entries.setFont(new Font(" ", Font.BOLD, 12));
        entryCount = new JPanel(); //container
        entryCount.setPreferredSize(new Dimension(600, 50));
        entryCount.setBackground(Color.white);
        entryCount.setLayout(new FlowLayout());
        window.add(entryCount);
        entryCount.add(entries);
        entryCount.setBorder(BorderFactory.createMatteBorder(0,5,3,5,Color.BLACK));

        //ADD text field input to arraylist
        enterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //for (int x = 0; x < arraylist.size(); x++) {
                // arraylist.add(Integer.valueOf(value.getText()));
                // }
                arraylist.add(Integer.parseInt(value.getText()));
                counter++;
                entries.setText("Number of entries: " + counter);

                findSum();
                findMin();
                findMax();
                findAVG();
                findDeviation();
            }
        });


        sum = new JLabel("Sum: "); //<------JLABEL to display output or result
        sumPanel = new JPanel();       //<------JPANEL to contain hold output
        sumPanel.setPreferredSize(new Dimension(600, 50));
        sumPanel.setBackground(Color.white);
        sumPanel.setLayout(new FlowLayout());
        window.add(sumPanel); //<-----------Set the JLABEL name to display on screen
        sumPanel.add(sum);    //<------------Assign JLABEL name to JPANEL to display it in the container
        sumPanel.setBorder(BorderFactory.createMatteBorder(0,5,3,5,Color.BLACK));
        //find sum
//        enterButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//
//            }
//        });


        minimum = new JLabel("Minimum: ");
        minPanel = new JPanel();
        minPanel.setPreferredSize(new Dimension(600, 50));
        minPanel.setLayout(new FlowLayout());
        minPanel.setBackground(Color.white);
        window.add(minPanel);
        minPanel.add(minimum);
        minPanel.setBorder(BorderFactory.createMatteBorder(0,5,3,5,Color.BLACK));
//        enterButton.addActionListener(new ActionListener() {
////            @Override
////            public void actionPerformed(ActionEvent e) {
////
////            }
////        });

        maximum = new JLabel("Maximum: ");
        maxPanel = new JPanel();
        maxPanel.setPreferredSize(new Dimension(600, 50));
        maxPanel.setLayout(new FlowLayout());
        maxPanel.setBackground(Color.white);
        window.add(maxPanel);
        maxPanel.add(maximum);
        maxPanel.setBorder(BorderFactory.createMatteBorder(0,5,3,5,Color.BLACK));
//        enterButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//
//        });

        average = new JLabel("Average: ");
        avgPanel = new JPanel();
        avgPanel.setPreferredSize(new Dimension(600, 50));
        avgPanel.setLayout(new FlowLayout());
        avgPanel.setBackground(Color.white);
        window.add(avgPanel);
        avgPanel.add(average);
        avgPanel.setBorder(BorderFactory.createMatteBorder(0,5,3,5,Color.BLACK));
//        enterButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//
//        });

        dev = new JLabel("Standard Deviation: ");
        devPanel = new JPanel();
        devPanel.setPreferredSize(new Dimension(600, 50));
        devPanel.setLayout(new FlowLayout());
        devPanel.setBackground(Color.white);
        window.add(devPanel);
        devPanel.add(dev);
        devPanel.setBorder(BorderFactory.createMatteBorder(0,5,5,5,Color.BLACK));
//        enterButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//
//            }
//        });

        window.setVisible(true);
    }
    //--------------------------------------Calculations--------------------------------------
    public void findSum() {
        total=0;
        for (int i : arraylist) {
            total += i;
        }
        sum.setText("Sum: " + total);
    }

    public void findMin(){
        double min = arraylist.get(0);
        for (int i = 0; i < arraylist.size(); i++) {
            if(arraylist.get(i) < min) {
                min = arraylist.get(i);
            }
        }
        minimum.setText("Minimum: " + min);
    }

    public void findMax() {
        double max = arraylist.get(0);
        for (int j = 0; j < arraylist.size(); j++) {
            if (arraylist.get(j) > max) {
                max = arraylist.get(j);
            }
        }
        maximum.setText("Maximum: " + max);
    }

    public void findAVG(){
        double avg=0;
        double total = 0;
        for (int s = 0; s < arraylist.size(); s++) {
            total += arraylist.get(s);
        }
        avg = total / arraylist.size();
        average.setText("Average: " + avg);
    }

    public void findDeviation() {
        double deviation;
        double sum = 0;
        double average;
        for (int z = 0; z < arraylist.size(); z++) {
            sum = sum + arraylist.get(z);
        }
        average = sum / arraylist.size();
        double calc = 0;
        for (int a = 0; a < arraylist.size(); a++) {
            calc += Math.pow((arraylist.get(a) - average), 2 ); //(array value - average) to the 2nd power.
        }
        average = calc / (arraylist.size() - 1);
        deviation = Math.sqrt(average);
        dev.setText("Standard Deviation: " + deviation);
    }

    public static void main(String[] args) {

        new Assignment7();
    }
}
