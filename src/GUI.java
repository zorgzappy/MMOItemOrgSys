import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class GUI extends JFrame{

    private JButton button;
    private JLabel[] counters;
    private int counter = 0;

    public GUI() {
        // Set up the frame
        setTitle("Counter GUI");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLayout(new FlowLayout());

        // Create the button
        button = new JButton("Generate Item");
        button.addActionListener(new ButtonClickListener());
        add(button);

        // Create counters
        counters = new JLabel[20];
        for (int i = 0; i < 20; i++) {
            counters[i] = new JLabel("0");
            add(counters[i]);
        }

        // Display the frame
        setVisible(true);
    }

    private class ButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (counter < 20) {
                int currentValue = Integer.parseInt(counters[counter].getText());
                counters[counter].setText(String.valueOf(currentValue + 1));
                counter++;
            }

                }
            }





}
