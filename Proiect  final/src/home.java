import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public  class home {
    private JPanel panel1;
    private JRadioButton radGermania;
    private JRadioButton radBulgaria;
    private JRadioButton radSpania;
    private JCheckBox chkBussinesClass;
    private JCheckBox chkBagajDeCala;
    private JCheckBox chkMancareLaBord;
    private JTextPane txtSub;
    private JTextPane txtTax;
    private JTextPane txtTotal;
    private JButton btnExit;
    private JButton btnClear;
    private JButton btnEnter;

   private double total;
   private double subTotal = 0;
   private final double TvaRate = 0.02;
   private double tva;

    public home() {
        radSpania.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (radSpania.isSelected())
                    radBulgaria.setSelected(false);
                radGermania.setSelected(false);
                System.out.println("Ati selectionat destinatia: 'Spania'");

            }
        });
        radBulgaria.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (radBulgaria.isSelected())
                    radSpania.setSelected(false);
                radGermania.setSelected(false);
                System.out.println("Ati selectionat destinatia: 'Bulgaria'");
            }
        });
        radGermania.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (radGermania.isSelected())
                    radBulgaria.setSelected(false);
                radSpania.setSelected(false);
                System.out.println("Ati selectionat destinatia: 'Germania'");
            }
        });
        btnEnter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DecimalFormat df = new DecimalFormat("0.00");



                if (radSpania.isSelected()) {
                    subTotal = subTotal + 150.0;
                } else if (radBulgaria.isSelected()) {
                    subTotal = subTotal + 50.0;
                } else if (radGermania.isSelected()) {
                    subTotal = subTotal + 100.0;
                }
                if (chkBussinesClass.isSelected()) {
                    subTotal = subTotal + 200.0;
                }
                if (chkBagajDeCala.isSelected()) {
                    subTotal = subTotal + 50.0;
                }
                if (chkMancareLaBord.isSelected()) {
                    subTotal = subTotal + 25.0;
                }

                txtSub.setText(Double.toHexString(subTotal));

                subTotal = Double.parseDouble(txtSub.getText());
                tva = subTotal * TvaRate;
                total = tva + subTotal;

                txtTax.setText(Double.toString(tva));
                txtTotal.setText(Double.toString(total));

                txtTax.setText(df.format(tva));
                txtSub.setText(df.format(subTotal));
                txtTotal.setText(df.format(total));
                System.out.println("Ati actionat butonul: 'Enter'");
            }
        });
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
                System.out.println("Ati actionat butonul: 'Exit'");
            }
        });
        btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                radSpania.setSelected(false);
                radGermania.setSelected(false);
                radBulgaria.setSelected(false);
                chkBussinesClass.setSelected(false);
                chkMancareLaBord.setSelected(false);
                chkBagajDeCala.setSelected(false);
                txtTotal.setText("");
                txtSub.setText("");
                txtTax.setText("");
                System.out.println("Ati actionat butonul: 'Clear'");

            }
        });
    }
    
    public double getTotal(){
        return total;
    }
    public double getSubTotal(){
        return  subTotal;
    }
    public final double getTvaRate(){
        return TvaRate;
    }
    public double getTva(){
        return tva;
    }

    public JPanel getPanel1() {
        return panel1;

    }

}
