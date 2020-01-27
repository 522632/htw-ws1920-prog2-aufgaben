package de.htwberlin.prog2.ws1920.reisen.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import de.htwberlin.prog2.ws1920.reisen.entities.Adresse;
import de.htwberlin.prog2.ws1920.reisen.entities.Kunde;
import de.htwberlin.prog2.ws1920.reisen.entities.Reiseagentur;
import de.htwberlin.prog2.ws1920.reisen.entities.Reservierung;
import de.htwberlin.prog2.ws1920.reisen.util.Init;

/**
 * @author Mohammed AbuJarour (mohammed.abujarour@htw-berlin.de)
 *
 */
public class MainFrame extends JFrame {

    private static final long serialVersionUID = -7588691059811882213L;
    private Reiseagentur reiseagentur;
    private JPanel topPanel;
    private JPanel mainPanel;
    private JPanel leftPanel;
    private JPanel rightPanel;
    private JList<Kunde> kundenList;
    private JTextField txtSearchTerm;
    private JList<Reservierung> buchungen;
    private JLabel lblCount;
    private JLabel lblAdresse;
    private JLabel lblGeburtsDatum;
    private JLabel lblKundennummer;

    public MainFrame(Reiseagentur reiseagentur) {
        super();
        this.reiseagentur = reiseagentur;
        this.setTitle(this.reiseagentur.getName());
        setSize(800, 600);
        setLocation(300, 200);
        init();
        initMenu();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    /**
     * 
     */
    private void initMenu() {

        JMenuBar menubar = new JMenuBar();
        JMenu info = new JMenu("Info");
        JMenuItem about = new JMenuItem("About");
        about.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(mainPanel, "Mohammed AbuJarour" + "\n" + "S0123455");

            }
        });
        info.add(about);
        menubar.add(info);
        setJMenuBar(menubar);
    }

    private void init() {
        topPanel = new JPanel(new GridLayout(2, 1));
        JPanel namePanel = new JPanel();
        JLabel lblName = new JLabel("  " + this.reiseagentur.getName());

        Font font = new Font("SansSerif", Font.BOLD, 20);
        lblName.setFont(font);
        lblName.setForeground(Color.DARK_GRAY);
        namePanel.add(lblName);
        namePanel.setBorder(new EmptyBorder(10, 0, 10, 0));
        topPanel.add(namePanel);

        topPanel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        JPanel searchPanel = initSearchPanel();
        topPanel.add(searchPanel);
        mainPanel = new JPanel(new GridLayout(1, 2, 5, 5));
        leftPanel = initLeftPanel();
        rightPanel = initRightPanel();

        mainPanel.add(leftPanel);
        mainPanel.add(rightPanel);

        getContentPane().add(topPanel, BorderLayout.NORTH);
        getContentPane().add(mainPanel, BorderLayout.CENTER);

    }

    private JPanel initRightPanel() {

        JPanel panel = new JPanel(new BorderLayout(10, 10));

        JPanel kundenDetailsPanel = new JPanel(new BorderLayout(3, 0));

        JPanel kundenDetailsLabelsPanel = new JPanel(new GridLayout(3, 1));
        JPanel kundenDetailsValuesPanel = new JPanel(new GridLayout(3, 1));

        kundenDetailsLabelsPanel.add(new JLabel("Kundennummer:"));

        lblKundennummer = new JLabel();
        kundenDetailsValuesPanel.add(lblKundennummer);

        kundenDetailsLabelsPanel.add(new JLabel("Geburtsdatum:"));

        lblGeburtsDatum = new JLabel();
        kundenDetailsValuesPanel.add(lblGeburtsDatum);

        kundenDetailsLabelsPanel.add(new JLabel("Adresse:"));

        lblAdresse = new JLabel();
        kundenDetailsValuesPanel.add(lblAdresse);

        kundenDetailsPanel.add(kundenDetailsLabelsPanel, BorderLayout.WEST);
        kundenDetailsPanel.add(kundenDetailsValuesPanel, BorderLayout.CENTER);

        panel.add(kundenDetailsPanel, BorderLayout.NORTH);
        buchungen = new JList<>();
        panel.add(new JScrollPane(buchungen), BorderLayout.CENTER);
        JPanel buttonsPanel = new JPanel();

        buttonsPanel.add(new JButton("Deails anzeigen"));
        buttonsPanel.add(new JButton("Löschen"));

        panel.setBorder(new EmptyBorder(10, 5, 10, 5));
        return panel;
    }

    private JPanel initLeftPanel() {

        JPanel panel = new JPanel(new BorderLayout(5, 10));
        Border border = new EmptyBorder(5, 10, 10, 10);
        panel.setBorder(border);
        lblCount = new JLabel("Kunden gefunden ");
        panel.add(lblCount, BorderLayout.NORTH);
        kundenList = new JList<>();
        panel.add(new JScrollPane(kundenList), BorderLayout.CENTER);
        kundenList.addListSelectionListener(new ListSelectionListener() {

            public void valueChanged(ListSelectionEvent e) {

                Kunde selectedKunde = kundenList.getSelectedValue();
                updateKunenInfo(selectedKunde);
                updateReservierungsListe(selectedKunde);
            }

        });
        return panel;
    }

    private void updateKunenInfo(Kunde kunde) {
        if (kunde == null)
            return;
        lblKundennummer.setText(kunde.getKundennummer() + "");
        lblGeburtsDatum.setText(kunde.getGeburtsdatum());
        lblAdresse.setText(kunde.getAdresse() + "");
        lblAdresse.setToolTipText(kunde.getAdresse() + "");
    }

    private void updateReservierungsListe(Kunde kunde) {
        if (kunde == null)
            return;
        buchungen.setListData(kunde.getReservierungen());
    }

    private JPanel initSearchPanel() {
        JPanel panel = new JPanel();
        panel.add(new JLabel("Kundenname: "));
        txtSearchTerm = new JTextField(20);
        panel.add(txtSearchTerm);
        JButton btnSearch = new JButton("Suchen");

        btnSearch.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                Kunde[] suchErgbnis = reiseagentur.searchKunde(txtSearchTerm.getText());
                kundenList.removeAll();
                kundenList.setListData(suchErgbnis);
                lblCount.setText("Kunden gefunden (" + suchErgbnis.length + ")");

            }
        });
        panel.add(btnSearch);

        return panel;
    }

}
