package clases;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Bienvenida extends JFrame implements ActionListener {

    private JButton boton1, boton2;
    private JLabel label1, label2, label3, label4, label5, label6;
    private JTextField campo1, campo2;
    private String texto1, texto2;
    public static String texto = "";

    public Bienvenida() {
        setLayout(null);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        getContentPane().setBackground(new Color(193, 172, 73));

        setIconImage(new ImageIcon(getClass().getResource("/Icono.png")).getImage());
        setTitle("Bienvenida");

        ImageIcon imagen = new ImageIcon("imagenes/logo-borth.png");

        label1 = new JLabel(imagen);
        label1.setBounds(25, 15, 300, 150);
        add(label1);

        label2 = new JLabel("Sistema Cervecería Borth");
        label2.setBounds(57, 150, 300, 30);
        label2.setFont(new Font("Andale Mono", 3, 18));
        label2.setForeground(new Color(55, 52, 53));
        add(label2);

        label4 = new JLabel("Nombre de Usuario:");
        label4.setFont(new Font("Andale Mono", 1, 12));
        label4.setForeground(new Color(55, 52, 53));
        label4.setBounds(45, 190, 200, 30);
        add(label4);

        campo1 = new JTextField();
        campo1.setFont(new Font("Andale Mono", 1, 14));
        campo1.setForeground(new Color(55, 52, 53));
        campo1.setBackground(new Color(255, 255, 255));
        campo1.setBounds(45, 220, 255, 25);
        add(campo1);

        label5 = new JLabel("Contraseña:");
        label5.setFont(new Font("Andale Mono", 1, 12));
        label5.setForeground(new Color(55, 52, 53));
        label5.setBounds(45, 245, 200, 30);
        add(label5);

        campo2 = new JTextField();
        campo2.setFont(new Font("Andale Mono", 1, 14));
        campo2.setForeground(new Color(55, 52, 53));
        campo2.setBackground(new Color(255, 255, 255));
        campo2.setBounds(45, 275, 255, 25);
        add(campo2);

        boton2 = new JButton("Olvide mi usuario y contraseña");
        boton2.setBackground(new Color(193, 172, 73));
        boton2.setFont(new Font("Andale Mono", 1, 11));
        boton2.setForeground(new Color(55, 52, 53));
        boton2.setBounds(50, 310, 220, 15);
        boton2.addActionListener(this);
        add(boton2);

        boton1 = new JButton("Continuar");
        boton1.setFont(new Font("Andale Mono", 1, 12));
        boton1.setForeground(new Color(193, 172, 73));
        boton1.setBackground(new Color(55, 52, 53));
        boton1.setBounds(115, 350, 100, 20);
        boton1.addActionListener(this);
        boton1.setEnabled(true);
        add(boton1);

        label3 = new JLabel("@Borth Cerveza Artesanal-Valle de Paravachasca");
        label3.setFont(new Font("Andale Mono", 1, 12));
        label3.setForeground(new Color(55, 52, 53));
        label3.setBounds(20, 380, 300, 15);
        add(label3);

        label6 = new JLabel("cel:xxxxxx");
        label6.setFont(new Font("Andale Mono", 1, 12));
        label6.setForeground(new Color(55, 52, 53));
        label6.setBounds(80, 395, 300, 15);
        add(label6);

    }

    public void actionPerformed(ActionEvent e) {

        texto = campo1.getText().trim();
        texto1 = campo2.getText().trim();
        int num = texto.length(), num1 = texto1.length();

        if (e.getSource() == boton1) {

            if (texto.equals("") || texto1.equals("")) {
                JOptionPane.showMessageDialog(null, "Falta su nombre o Contraseña");
            } else if (num > 10 || num1 != 8) {
                JOptionPane.showMessageDialog(null, "El nombre debe tener menos de 11 caracteres \n y la contraseña debe tener 8");
            } else {
                try {
                    Connection cn = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/onsMAuvdE5", "onsMAuvdE5", "EWpgsJuVTJ");
                    PreparedStatement pst = cn.prepareStatement("select * from usuarios" + " where user = '" + texto + "'");

                    ResultSet rs = pst.executeQuery();

                    if (rs.next()) {
                        texto2 = rs.getString("grupo");
                        if (texto1.equals(rs.getString("pass"))) {
                            if (texto2.equals("Usuarios")) {
                                Usuario user = new Usuario();
                                user.setBounds(0, 0, 640, 530);
                                user.setVisible(true);
                                user.setLocationRelativeTo(null);
                                user.setResizable(false);
                                this.setVisible(false);
                            }else {
                            JOptionPane.showMessageDialog(null, "No es Usuario");
                        }
                        } else {
                            JOptionPane.showMessageDialog(null, "Contraseña incorrecta");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Usuario incorrecto");
                    }
                } catch (Exception evt) {
                }
            }
        }
        if (e.getSource() == boton2) {
            PedirPass pass = new PedirPass();
            pass.setBounds(0, 0, 330, 150);
            pass.setLocationRelativeTo(null);
            pass.setVisible(true);
            pass.setResizable(false);
        }

    }

    public static void main(String args[]) {

        Bienvenida bien = new Bienvenida();
        bien.setBounds(0, 0, 350, 460);
        bien.setVisible(true);
        bien.setLocationRelativeTo(null);
        bien.setResizable(false);
    }
}
