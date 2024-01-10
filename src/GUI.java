import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class GUI extends JFrame{

    private JButton generate;
    private JButton dropLow;
    private JButton consumeConsumable;
    private JButton showBackend;

    private JLabel[] counters;

    private  JLabel[] equipped;
    private int counter = 0;
    private Inventory inven;

    private JLabel inventory;
    private JLabel Equipped;
    private JLabel stats;



    public GUI() {
        // Set up the frame
        setTitle("Counter GUI");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(3000, 2000);
        setLayout(new FlowLayout());
        inven = new Inventory();

        stats = new JLabel("Total Attack: " + inven.getTotalAttack() + " Total Defense: " + inven.getTotalDefense()
                + " Total Health: " + inven.getTotalHealth() + " Total Mana: " + inven.getTotalMana());
        add(stats);

        // Create the generate item button
        generate = new JButton("Generate Item");
        generate.addActionListener(new ButtonClickListener());
        add(generate);

        //Create the drop lowest button
        dropLow = new JButton("Drop Lowest");
        dropLow.addActionListener(new ButtonClickListener2());
        add(dropLow);

        // Hides the counters and instead displays the equipped items.
        showBackend = new JButton("Show Backend");
        showBackend.addActionListener(new ButtonClickListener3());
        add(showBackend);

        consumeConsumable = new JButton("Consume a potion");
        consumeConsumable.addActionListener(new ButtonClickListener4());
        add(consumeConsumable);

        //Display text saying "Inventory" above the Counters
         inventory = new JLabel("Inventory\n\n\n");
        add(inventory);


        // Create counters
        counters = new JLabel[20];
        for (int i = 0; i < 20; i++) {
            counters[i] = new JLabel("0\n");
            counters[i].setBorder(BorderFactory.createLineBorder(Color.black));
            add(counters[i]);
        }

         Equipped = new JLabel("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\nEquipped\n\n\n");
        add(Equipped);

        equipped = new JLabel[6];
        for (int i = 0; i < 6; i++) {
            equipped[i] = new JLabel("0\n");
            equipped[i].setBorder(BorderFactory.createLineBorder(Color.black));
            add(equipped[i]);

        }

        // Display the frame
        setVisible(true);

        // Create the inventory
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
            else {
                JOptionPane.showMessageDialog(null, "Inventory is full!");
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

    private class ButtonClickListener3 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JTextArea textArea = new JTextArea(inven.getItemCategoryList().toString());
            textArea.setEditable(false); // Make it non-editable
            textArea.setLineWrap(true);  // Enable line wrapping
            textArea.setWrapStyleWord(true);  // Wrap at word boundaries
            // Create a JScrollPane to add a scrollbar
            JScrollPane scrollPane = new JScrollPane(textArea);

            scrollPane.setPreferredSize(new Dimension(650, 450));

            // Show a pop-up with the JScrollPane as the message
            JOptionPane.showMessageDialog(null, scrollPane, "Backend", JOptionPane.INFORMATION_MESSAGE);

        }
    }

    private class ButtonClickListener4 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String userInput = JOptionPane.showInputDialog(this, "Enter the index of the potion you want to consume:");
            int index = Integer.parseInt(userInput);
            if (index >= 0 && index < 20 && inven.getItems()[index] != null) {

               if (inven.getItems()[index].getItemType() == 5) {
                   inven.consume(inven.getItems()[index]);
                   counters[index].setText("0\n");
                   counter--;
                   stats.setText("Total Attack: " + inven.getTotalAttack() + " Total Defense: " + inven.getTotalDefense()
                           + " Total Health: " + inven.getTotalHealth() + " Total Mana: " + inven.getTotalMana());
               }
               else {
                   JOptionPane.showMessageDialog(null, "That item is not a potion!");
               }

            }
            else
            {
                JOptionPane.showMessageDialog(null, "Invalid index! Please try again.");
            }


            // Check if the user clicked "Cancel" or entered a non-integer value


        }
    }




}
