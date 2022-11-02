import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class login {
    private JLabel Username;
    private JPanel panel;
    private JPasswordField password;
    private JTextField textField1;
    private JButton Login;

    public JPasswordField getPassword(){
        return password;
    }



    public login() {

        Login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               String pwd = new String(getPassword().getPassword());

               if(pwd.equals(ExSingleton.getInstance().modificaCamp1("parola")))
                {

                    JOptionPane.showMessageDialog(null, "Te ai logat cu succes");
                    panel.setVisible(false);
                    JFrame avion = new JFrame();
                    avion.setContentPane(new home().getPanel1());
                    avion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    avion.pack();
                    avion.setVisible(true);

                }
                else {
                    JOptionPane.showMessageDialog(null,"Parola a fost introdusa gresit sau username-ul este incorect");
                }
            }
        });
    }


    public static void main(String[] args){
            JFrame frame = new JFrame("App");
            frame.setContentPane(new login().panel);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);


    }
}
