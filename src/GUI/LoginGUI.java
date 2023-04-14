package Login;

import javax.swing.*;

public class LoginGUI extends JFrame{
    private JTextField textField1;
    private JTextField textField2;
    private JButton entrarButton;
    private JLabel Usuario;
    private JLabel Password;
    private JPanel Panel1;

    public LoginGUI(){
        setContentPane(Panel1);
        setTitle("Introduzca Credenciales");
        setSize(450,300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        entrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Meter la comprobacion de las credenciales
            }
        });
    }

    public static void main(String[] args){
        LoginGUI myLogin = new LoginGUI();
    }

}
