import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class GUI extends JFrame{

    private JButton generate;
    private JButton dropLow;

    private JLabel[] counters;
    private int counter = 0;
    private Inventory inven;

    public GUI() {
        // Set up the frame
        setTitle("Counter GUI");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLayout(new FlowLayout());

        // Create the generate item button
        generate = new JButton("Generate Item");
        generate.addActionListener(new ButtonClickListener());
        add(generate);

        //Create the drop lowest button
        dropLow = new JButton("Drop Lowest");
        dropLow.addActionListener(new ButtonClickListener());
        add(dropLow);

        //Display text saying "Inventory" above the Counters
        JLabel inventory = new JLabel("Inventory\n");
        add(inventory);


        // Create counters
        counters = new JLabel[20];
        for (int i = 0; i < 20; i++) {
            counters[i] = new JLabel("0\n");
            add(counters[i]);
        }

        // Display the frame
        setVisible(true);

        // Create the inventory
        inven = new Inventory();
    }

    private class ButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (counter < 20) {
                Item pick = inven.pickUp();
                if (pick != null) {
                    counters[counter].setText(String.valueOf(pick + "\n" + counter));
                    counter++;
                }

            }

                }
            }





}
