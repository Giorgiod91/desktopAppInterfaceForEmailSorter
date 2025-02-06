import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

public class auswahlGUI extends JFrame{
    private String important, notImportant;



    private JCheckBox notImportant1, notImportant2;
    private ButtonGroup gruppe;

    private JRadioButton important1, important2;
    
    private JButton schaltflaecheAnnehmen, schaltfleacheBeenden;


    private String[] mehrAuswahl = {"ils", "LinkedIn", "Insta", "Facebook"}; 
    private JComboBox <String> auswahl;

    
    class MeinListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e){
            if (e.getActionCommand().equals("Annehmen")){
                important = important + auswahl.getSelectedItem().toString();
                if(important1.isSelected())
                    important = important1.getText() + "Jobs";
                if(important2.isSelected())
                    important = important2.getText() + "Rabatt";
                if(notImportant1.isSelected())
                    notImportant = notImportant1.getText() + "Werbung";
                if(notImportant2.isSelected())
                    notImportant = notImportant2.getText() + "Social Media";    
                if(notImportant1.isSelected() == false && notImportant2.isSelected()  == false)
                    notImportant = notImportant + "None";
                JOptionPane.showMessageDialog(null, "Bitte sehr!\n" + important + notImportant);
                important = "als important ausgewaehlt:";
                notImportant = "als notImportant ausgewaehlt";

            }
            if (e.getActionCommand().equals("Beenden"))
                System.exit(0);
        }
    }


    public auswahlGUI(String titel){
        //Konstruktor
        super(titel);
        // text 
        important = "Ausgewaehlt als important:";
        notImportant = "Ausgewaehlt als nicht important:";
        //checkbox
        notImportant1 = new JCheckBox("Werbung");
        notImportant2 = new JCheckBox("Social Media");


        //buttonGroup
        gruppe = new ButtonGroup();
        //die buttons
        important1 = new JRadioButton("Jobs");
        important2 = new JRadioButton("Rabatt");
        // default value
        important1.setSelected(true);
        // add to group
        gruppe.add(important1);
        gruppe.add(important2);
        //schaltflaechen
        
        schaltflaecheAnnehmen = new JButton("Annehmen");
        schaltfleacheBeenden = new JButton("Beenden");

        //gridlayout
        setLayout(new GridLayout(0,2,10,10));
        //components
        
        //labels
        add(new JLabel("Important "));
        add(new JLabel("not Important "));

        //buttons
        add(important1);
        add(notImportant1);
        add(important2);
        add(notImportant2);
        add(schaltflaecheAnnehmen);
        add(schaltfleacheBeenden);

        //connect listener
        MeinListener listener = new MeinListener();
        schaltflaecheAnnehmen.addActionListener(listener);
        schaltfleacheBeenden.addActionListener(listener);

        // action for closing
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //combobox
        auswahl = new JComboBox<>(mehrAuswahl);
        add(auswahl);
        add(new JLabel());

        pack();
        setVisible(true);


    
    }

    public static void main(String[] args) {
        new auswahlGUI("Auswahl GUI");
    }
}

