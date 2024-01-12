import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class GUI extends JFrame{

    private JButton generate;
    private JButton dropLow;
    private JButton consumeConsumable;
    private JButton showBackend;
    private JButton equipItem;
    private  JButton unequipItem;


    private JLabel[] counters;

    private  JLabel[] equipped;
    private int counter = 0;
    private Inventory inven;

    private JLabel inventory;
    private JLabel Equipped;
    private JLabel stats;

// 1 = weapon, 2 = Helmet, 3 = Robe, 4 = Boots, 5 = Consumable

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

        // Shows the backend
        showBackend = new JButton("Show Backend");
        showBackend.addActionListener(new ButtonClickListener3());
        add(showBackend);

        // Consumes a potion
        consumeConsumable = new JButton("Consume a potion");
        consumeConsumable.addActionListener(new ButtonClickListener4());
        add(consumeConsumable);

        //Equips an item
        equipItem = new JButton("Equip an item");
        equipItem.addActionListener(new ButtonClickListener5());
        add(equipItem);

        //Unequips an item
        unequipItem = new JButton("Unequip an item");
        unequipItem.addActionListener(new ButtonClickListener6());
        add(unequipItem);

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

        equipped = new JLabel[4];
        for (int i = 0; i < 4; i++) {
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
            String userInput = JOptionPane.showInputDialog(null, "Enter the index of the potion you want to consume:", "Consume a potion", JOptionPane.QUESTION_MESSAGE);
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
        }
    }

    private class ButtonClickListener5 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String userInput = JOptionPane.showInputDialog(null, "Enter the index of the Item you want to Equip:", "Equip an Item", JOptionPane.QUESTION_MESSAGE);
            int index = Integer.parseInt(userInput);
            if (index >= 0 && index < 20 && inven.getItems()[index] != null)
            {
                if (inven.getItems()[index].getItemType() == 1)
                {
                    if (inven.getEquipped()[0] == null)
                    {
                        equipped[0].setText(inven.getItems()[index].toString());
                        inven.equip(inven.getItems()[index], index);
                        counters[index].setText("0\n");
                        stats.setText("Total Attack: " + inven.getTotalAttack() + " Total Defense: " + inven.getTotalDefense()
                                + " Total Health: " + inven.getTotalHealth() + " Total Mana: " + inven.getTotalMana());
                        counter--;
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "You already have a weapon equipped!");
                    }
                }
                else if (inven.getItems()[index].getItemType() == 2)
                {
                    //write the same code i used before  here with modifications to work with the helmet
                    if (inven.getEquipped()[1] == null)
                    {
                        equipped[1].setText(inven.getItems()[index].toString());
                        inven.equip(inven.getItems()[index], index);
                        counters[index].setText("0\n");
                        stats.setText("Total Attack: " + inven.getTotalAttack() + " Total Defense: " + inven.getTotalDefense()
                                + " Total Health: " + inven.getTotalHealth() + " Total Mana: " + inven.getTotalMana());
                        counter--;
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "You already have a helmet equipped!");
                    }
                }
                else if (inven.getItems()[index].getItemType() == 3)
                {
                    //write the same code i used before  here with modifications to work with the robe
                    if (inven.getEquipped()[2] == null)
                    {
                        equipped[2].setText(inven.getItems()[index].toString());
                        inven.equip(inven.getItems()[index], index);
                        counters[index].setText("0\n");
                        stats.setText("Total Attack: " + inven.getTotalAttack() + " Total Defense: " + inven.getTotalDefense()
                                + " Total Health: " + inven.getTotalHealth() + " Total Mana: " + inven.getTotalMana());
                        counter--;
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "You already have a robe equipped!");
                    }
                }
                else if (inven.getItems()[index].getItemType() == 4)
                {
                    //write the same code i used before  here with modifications to work with the boots
                    if (inven.getEquipped()[3] == null)
                    {
                        equipped[3].setText(inven.getItems()[index].toString());
                        inven.equip(inven.getItems()[index], index);
                        counters[index].setText("0\n");
                        stats.setText("Total Attack: " + inven.getTotalAttack() + " Total Defense: " + inven.getTotalDefense()
                                + " Total Health: " + inven.getTotalHealth() + " Total Mana: " + inven.getTotalMana());
                        counter--;
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "You already have boots equipped!");
                    }
                }
                else if (inven.getItems()[index].getItemType() == 5)
                {
                    JOptionPane.showMessageDialog(null, "You cannot equip a potion!");
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Invalid item type!");
                }
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Invalid index! Please try again.");
            }

        }
    }
    private class ButtonClickListener6 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println(counter);
            String userInput = JOptionPane.showInputDialog(null, "Enter the index of the potion you want to consume:", "Consume a potion", JOptionPane.QUESTION_MESSAGE);
            int index = Integer.parseInt(userInput);
            if (index >= 0 && index < 4 ) {

                if (inven.getEquipped()[index] == null)
                {
                    JOptionPane.showMessageDialog(null, "You do not have an item equipped in that slot!");
                }
                else
                {
                   if (inven.getQuantityItems() == 20)
                   {
                          JOptionPane.showMessageDialog(null, "Your inventory is full! You must drop an item before unequipping!");
                     }
                     else
                     {
                         int ind = -1;
                        for (int i = 0; i < 20; i++)
                        {
                            if (inven.getItems()[i] == null)
                            {
                                ind = i;
                                break;
                            }
                        }
                        counters[ind].setText(inven.getEquipped()[index].toString());
                        inven.unequip(inven.getEquipped()[index], ind);
                        equipped[index].setText("0\n");
                        stats.setText("Total Attack: " + inven.getTotalAttack() + " Total Defense: " + inven.getTotalDefense()
                                + " Total Health: " + inven.getTotalHealth() + " Total Mana: " + inven.getTotalMana());
                          counter++;

                   }
                }

            }
            else
            {
                JOptionPane.showMessageDialog(null, "Invalid index! Please try again.");
            }
        }
    }




}
