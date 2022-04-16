package clases;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PedirPass extends JFrame implements ActionListener {

    JTextField campo1;
    JButton boton1, boton2;
    JLabel texto;
    String Pass,Mail,User;

    public PedirPass() {
        setLayout(null);
        getContentPane().setBackground(new Color(193, 172, 73));
        setIconImage(new ImageIcon(getClass().getResource("/Icono.png")).getImage());
        setTitle("Pedido Contraseña");

        texto = new JLabel("Colocar DNI:");
        texto.setBounds(10, 15, 90, 25);
        texto.setForeground(new Color(55, 52, 53));
        texto.setFont(new Font("Andale Mono", 1, 13));
        add(texto);

        campo1 = new JTextField("");
        campo1.setBounds(100, 15, 140, 25);
        campo1.setBackground(new Color(255, 255, 255));
        campo1.setForeground(new Color(55, 52, 53));
        campo1.setFont(new Font("Andale Mono", 1, 13));
        add(campo1);

        boton1 = new JButton("Enviar user y pass por mail");
        boton1.setBounds(10, 60, 250, 25);
        boton1.setBackground(new Color(55, 52, 53));
        boton1.setForeground(new Color(193, 172, 73));
        boton1.setFont(new Font("Andale Mono", 1, 14));
        boton1.addActionListener(this);
        add(boton1);

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == boton1) {
            if (campo1.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Debe ingresar su DNI");
            } else {                
                try {
                    Connection cn= DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/onsMAuvdE5", "onsMAuvdE5", "EWpgsJuVTJ");
                    PreparedStatement pst= cn.prepareStatement("select * from usuarios where dni="+campo1.getText()); 
                    
                    ResultSet rs = pst.executeQuery();
                    if(rs.next()){
                    Pass = rs.getString("pass");
                    User= rs.getString("user");
                    Mail = rs.getString("mail");
                    }else{
                    JOptionPane.showMessageDialog(null, "Usuario no registrado");
                    }
                    
                } catch (SQLException ex) {                    
                }
            SendMail mail = new SendMail();
            String Mensage = "Su Usuario es: "+User+" y su contraseña es: "+Pass;
            String To = Mail;
            String Subject = "Contraseña de: "+campo1.getText();
            mail.SendMail(Mensage, To, Subject);
            }
        }
    }

    public static void main(String[] args) {
        PedirPass pass = new PedirPass();
        pass.setBounds(0, 0, 330, 150);
        pass.setLocationRelativeTo(null);
        pass.setVisible(true);
        pass.setResizable(false);
    }
}
