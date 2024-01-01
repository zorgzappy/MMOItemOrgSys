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
        setSize(3000, 2000);
        setLayout(new FlowLayout());

        // Create the generate item button
        generate = new JButton("Generate Item");
        generate.addActionListener(new ButtonClickListener());
        add(generate);

        //Create the drop lowest button
        dropLow = new JButton("Drop Lowest");
        dropLow.addActionListener(new ButtonClickListener2());
        add(dropLow);

        //Display text saying "Inventory" above the Counters
        JLabel inventory = new JLabel("Inventory\n");
        add(inventory);


        // Create counters
        counters = new JLabel[20];
        for (int i = 0; i < 20; i++) {
            counters[i] = new JLabel("0\n");
            counters[i].setBorder(BorderFactory.createLineBorder(Color.black));
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
                    for (int i = 0; i < 20; i++) {
                       if (counters[i].getText().equals("0\n"))
                       {
                           counters[i].setText(pick + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t");
                           break;
                       }
                    }

                    counter++;
                }
            }

        }
    }

    private class ButtonClickListener2 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (counter > 0) {
                Item pick = inven.dropLow();
              for (int i = 0; i < 20; i++)
              {
                if (counters[i].getText().equals(pick.toString() + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t"))
                {
                    counters[i].setText("0\n");
                    counter--;
                    break;
                }
              }
            }

        }

    }





}
