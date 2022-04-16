package clases;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Orden extends JFrame implements ActionListener {

    JMenuBar menubar;
    JMenu menu1, menu2;
    JMenuItem nueva, volver, creador;
    private JButton boton1, boton2;
    private JLabel label1, label2, label3, label4, label5, label6, label7, label8, label9, label10, label11, label12, label13, label14;
    private JTextField campo1, campo2, campo3, campo4, campo5, campo6, campo7;
    String usuario = "", direccion = "", nombre = "", telefono = "", correo = "";
    int TotalRu, TotalRo, TotalNe, totalunidades;
    float total;

    public Orden() {
        setLayout(null);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        getContentPane().setBackground(new Color(193, 172, 73));

        setIconImage(new ImageIcon(getClass().getResource("/Icono.png")).getImage());
        setTitle("Orden");

        ImageIcon imagen = new ImageIcon("imagenes/logo-borthMm.png");
        Bienvenida nuevo = new Bienvenida();
        usuario = nuevo.texto;

        label1 = new JLabel(imagen);
        label1.setBounds(60, 15, 200, 80);
        add(label1);

        menubar = new JMenuBar();
        setJMenuBar(menubar);
        menubar.setBackground(new Color(193, 172, 73));

        menu1 = new JMenu("Opciones");
        menu1.setFont(new Font("Andale Mono", 1, 14));
        menu1.setForeground(new Color(55, 52, 53));
        menubar.add(menu1);

        nueva = new JMenuItem("Nueva Orden");
        nueva.setFont(new Font("Andale Mono", 1, 14));
        nueva.setForeground(new Color(55, 52, 53));
        nueva.addActionListener(this);
        menu1.add(nueva);

        volver = new JMenuItem("Volver");
        volver.setFont(new Font("Andale Mono", 1, 14));
        volver.setForeground(new Color(55, 52, 53));
        volver.addActionListener(this);
        menu1.add(volver);

        menu2 = new JMenu("Acerca de");
        menu2.setFont(new Font("Andale Mono", 1, 14));
        menu2.setForeground(new Color(55, 52, 53));
        menubar.add(menu2);

        creador = new JMenuItem("El creador");
        creador.setFont(new Font("Andale Mono", 1, 14));
        creador.setForeground(new Color(55, 52, 53));
        creador.addActionListener(this);
        menu2.add(creador);

        label2 = new JLabel("Cajones");
        label2.setBounds(15, 100, 80, 30);
        label2.setFont(new Font("Andale Mono", 3, 18));
        label2.setForeground(new Color(55, 52, 53));
        add(label2);

        label4 = new JLabel("Cerveza Rubia:");
        label4.setFont(new Font("Andale Mono", 1, 12));
        label4.setForeground(new Color(55, 52, 53));
        label4.setBounds(15, 140, 100, 25);
        add(label4);

        campo1 = new JTextField();
        campo1.setFont(new Font("Andale Mono", 1, 14));
        campo1.setForeground(new Color(55, 52, 53));
        campo1.setBackground(new Color(255, 255, 255));
        campo1.setBounds(115, 140, 50, 25);
        add(campo1);

        label5 = new JLabel("Cerveza Roja:");
        label5.setFont(new Font("Andale Mono", 1, 12));
        label5.setForeground(new Color(55, 52, 53));
        label5.setBounds(15, 175, 100, 25);
        add(label5);

        campo2 = new JTextField();
        campo2.setFont(new Font("Andale Mono", 1, 14));
        campo2.setForeground(new Color(55, 52, 53));
        campo2.setBackground(new Color(255, 255, 255));
        campo2.setBounds(115, 175, 50, 25);
        add(campo2);

        label6 = new JLabel("Cerveza Negra:");
        label6.setFont(new Font("Andale Mono", 1, 12));
        label6.setForeground(new Color(55, 52, 53));
        label6.setBounds(15, 210, 100, 25);
        add(label6);

        campo3 = new JTextField();
        campo3.setFont(new Font("Andale Mono", 1, 14));
        campo3.setForeground(new Color(55, 52, 53));
        campo3.setBackground(new Color(255, 255, 255));
        campo3.setBounds(115, 210, 50, 25);
        add(campo3);

        label9 = new JLabel("Unidades");
        label9.setBounds(195, 100, 100, 30);
        label9.setFont(new Font("Andale Mono", 3, 18));
        label9.setForeground(new Color(55, 52, 53));
        add(label9);

        label10 = new JLabel("Cerveza Rubia:");
        label10.setFont(new Font("Andale Mono", 1, 12));
        label10.setForeground(new Color(55, 52, 53));
        label10.setBounds(195, 140, 100, 25);
        add(label10);

        campo5 = new JTextField();
        campo5.setFont(new Font("Andale Mono", 1, 14));
        campo5.setForeground(new Color(55, 52, 53));
        campo5.setBackground(new Color(255, 255, 255));
        campo5.setBounds(295, 140, 50, 25);
        add(campo5);

        label11 = new JLabel("Cerveza Roja:");
        label11.setFont(new Font("Andale Mono", 1, 12));
        label11.setForeground(new Color(55, 52, 53));
        label11.setBounds(195, 175, 100, 25);
        add(label11);

        campo6 = new JTextField();
        campo6.setFont(new Font("Andale Mono", 1, 14));
        campo6.setForeground(new Color(55, 52, 53));
        campo6.setBackground(new Color(255, 255, 255));
        campo6.setBounds(295, 175, 50, 25);
        add(campo6);

        label12 = new JLabel("Cerveza Negra:");
        label12.setFont(new Font("Andale Mono", 1, 12));
        label12.setForeground(new Color(55, 52, 53));
        label12.setBounds(195, 210, 100, 25);
        add(label12);

        campo7 = new JTextField();
        campo7.setFont(new Font("Andale Mono", 1, 14));
        campo7.setForeground(new Color(55, 52, 53));
        campo7.setBackground(new Color(255, 255, 255));
        campo7.setBounds(295, 210, 50, 25);
        add(campo7);

        label7 = new JLabel("Total en pesos con promociones:");
        label7.setFont(new Font("Andale Mono", 1, 12));
        label7.setForeground(new Color(55, 52, 53));
        label7.setBounds(15, 255, 200, 25);
        add(label7);

        campo4 = new JTextField();
        campo4.setFont(new Font("Andale Mono", 1, 14));
        campo4.setForeground(new Color(55, 52, 53));
        campo4.setBackground(new Color(255, 255, 255));
        campo4.setBounds(225, 255, 120, 25);
        add(campo4);

        boton1 = new JButton("Pedir");
        boton1.setFont(new Font("Andale Mono", 1, 12));
        boton1.setForeground(new Color(193, 172, 73));
        boton1.setBackground(new Color(55, 52, 53));
        boton1.setBounds(205, 300, 100, 20);
        boton1.addActionListener(this);
        boton1.setEnabled(false);
        add(boton1);

        boton2 = new JButton("Calcular");
        boton2.setFont(new Font("Andale Mono", 1, 12));
        boton2.setForeground(new Color(193, 172, 73));
        boton2.setBackground(new Color(55, 52, 53));
        boton2.setBounds(65, 300, 100, 20);
        boton2.addActionListener(this);
        boton2.setEnabled(true);
        add(boton2);
        
        label14 = new JLabel("Por pedidos mayores a 6 cajones consulte disponibilidad.");
        label14.setFont(new Font("Andale Mono", 1, 10));
        label14.setForeground(new Color(55, 52, 53));
        label14.setBounds(40, 330, 290, 15);
        add(label14);
        
        label13 = new JLabel("*Pedido sujeto a Stock.");
        label13.setFont(new Font("Andale Mono", 1, 10));
        label13.setForeground(new Color(55, 52, 53));
        label13.setBounds(120, 340, 200, 15);
        add(label13);
        

        label3 = new JLabel("@Borth Cerveza Artesanal-Valle de Paravachasca");
        label3.setFont(new Font("Andale Mono", 1, 12));
        label3.setForeground(new Color(55, 52, 53));
        label3.setBounds(40, 360, 300, 30);
        add(label3);

        label8 = new JLabel("cel:xxxxxx");
        label8.setFont(new Font("Andale Mono", 1, 12));
        label8.setForeground(new Color(55, 52, 53));
        label8.setBounds(100, 375, 300, 30);
        add(label8);

    }

    public void actionPerformed(ActionEvent e) {
        int Crubia = 0, Croja = 0, Cnegra = 0, Urubia = 0, Uroja = 0, Unegra = 0;
        float prubiaM = 0, projaM = 0, pnegraM = 0;
        float porcentdesc = 0, precio = 0, cajones = 0, prubiamin = 0, projamin = 0, pnegramin = 0;
        if (e.getSource() == boton2) {
            int porcentaje = 0, cantidadcajones = 0;
            if (campo1.getText().equals("") && campo2.getText().equals("") && campo3.getText().equals("") && campo5.getText().equals("")
                    && campo6.getText().equals("") && campo7.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Debe llenar algún campo");
            } else {
                if (campo1.getText().equals("")) {
                    Crubia = 0;
                } else {
                    Crubia = Integer.parseInt(campo1.getText());
                }
                if (campo2.getText().equals("")) {
                    Croja = 0;
                } else {
                    Croja = Integer.parseInt(campo2.getText());
                }
                if (campo3.getText().equals("")) {
                    Cnegra = 0;
                } else {
                    Cnegra = Integer.parseInt(campo3.getText());
                }
                if (campo5.getText().equals("")) {
                    Urubia = 0;
                } else {
                    Urubia = Integer.parseInt(campo5.getText());
                }
                if (campo6.getText().equals("")) {
                    Uroja = 0;
                } else {
                    Uroja = Integer.parseInt(campo6.getText());
                }
                if (campo7.getText().equals("")) {
                    Unegra = 0;
                } else {
                    Unegra = Integer.parseInt(campo7.getText());
                }
                TotalRu = (Crubia * 12) + Urubia;
                TotalRo = (Croja * 12) + Uroja;
                TotalNe = (Cnegra * 12) + Unegra;
                totalunidades = TotalRu + TotalRo + TotalNe;
                cajones = totalunidades / 12;
                try {
                    Connection cn = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/onsMAuvdE5", "onsMAuvdE5", "EWpgsJuVTJ");
                    PreparedStatement pst = cn.prepareStatement("select * from usuarios where user='" + usuario + "'");

                    ResultSet rs = pst.executeQuery();

                    if (rs.next()) {
                        nombre = rs.getString("nombre");
                        direccion = rs.getString("direccion");
                        telefono = rs.getString("telefono");
                        correo = rs.getString("mail");
                    } else {
                        JOptionPane.showMessageDialog(null, "Usuario no registrado");
                    }

                } catch (SQLException evt) {
                }
                try {
                    Connection cn = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/onsMAuvdE5", "onsMAuvdE5", "EWpgsJuVTJ");
                    PreparedStatement pst = cn.prepareStatement("select * from opciones where ID = 1");

                    ResultSet rs = pst.executeQuery();

                    if (rs.next()) {
                        porcentaje = rs.getInt(5);
                        cantidadcajones = rs.getInt(2);
                    }

                } catch (SQLException evt) {
                }
                try {
                    Connection cn = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/onsMAuvdE5", "onsMAuvdE5", "EWpgsJuVTJ");
                    PreparedStatement pst = cn.prepareStatement("select * from estilos where ID = 1");

                    ResultSet rs = pst.executeQuery();

                    if (rs.next()) {
                        prubiaM = rs.getFloat(1);
                        projaM = rs.getFloat(2);
                        pnegraM = rs.getFloat(3);
                        prubiamin = rs.getFloat(4);
                        projamin = rs.getFloat(5);
                        pnegramin = rs.getFloat(6);
                    }

                    if (totalunidades >= 12) {
                        precio = (TotalRu * prubiaM) + (TotalRo * projaM) + (TotalNe * pnegraM);
                    } else {
                        precio = (TotalRu * prubiamin) + (TotalRo * projamin) + (TotalNe * pnegramin);
                    }

                    if (porcentaje != 0 && cajones >= cantidadcajones) {
                        porcentdesc = (porcentaje * precio) / 100;
                        total = precio - porcentdesc;
                        campo4.setText(String.valueOf(total));
                        boton1.setEnabled(true);
                        campo1.setEditable(false);
                        campo2.setEditable(false);
                        campo3.setEditable(false);
                        campo4.setEditable(false);
                        campo5.setEditable(false);
                        campo6.setEditable(false);
                        campo7.setEditable(false);

                    } else {
                        total = precio;
                        campo4.setText(String.valueOf(total));
                        boton1.setEnabled(true);
                        campo1.setEditable(false);
                        campo2.setEditable(false);
                        campo3.setEditable(false);
                        campo4.setEditable(false);
                        campo5.setEditable(false);
                        campo6.setEditable(false);
                        campo7.setEditable(false);

                    }

                } catch (SQLException evt) {
                }
            }
        }

        if (e.getSource() == boton1) {
            SendMail mail = new SendMail();
            String Mensage = "El usuario: " + nombre + " ,de telefono: " + telefono + " ,que vive en: " + direccion
                    + " necesita un total de: " + String.valueOf(totalunidades) + " litros de cerveza, " + String.valueOf(TotalRu)
                    + " de rubia, " + String.valueOf(TotalRo) + " litros de roja, y " + String.valueOf(TotalNe)
                    + " litros de negra, por un total de pesos de: " + String.valueOf(total);
            String To = "maildelafabrica@xxxx.com";
            String Subject = "Pedido de: " + nombre;
            mail.SendMail(Mensage, To, Subject);

            SendMail segmail = new SendMail();
            String Men = "Gracias por confiar en nosotros!!"
                    + "Estamos procesando su pedido!"
                    + "A la Brevedad nos comunicaremos con usted"
                    + "El equipo de Borth";
            String para = correo;
            String sujeto = "Pedido Borth Cerveza Artesanal";
            segmail.SendMail(Men, para, sujeto);
        }

        if (e.getSource() == nueva) {
            campo1.setText("");
            campo2.setText("");
            campo3.setText("");
            campo4.setText("");
            campo5.setText("");
            campo6.setText("");
            campo7.setText("");
            campo1.setEditable(true);
            campo2.setEditable(true);
            campo3.setEditable(true);
            campo4.setEditable(true);
            campo5.setEditable(true);
            campo6.setEditable(true);
            campo7.setEditable(true);
        }

        if (e.getSource() == volver) {
            Usuario mayor = new Usuario();
            mayor.setBounds(0, 0, 640, 530);
            mayor.setVisible(true);
            mayor.setLocationRelativeTo(null);
            mayor.setResizable(false);
            this.setVisible(false);

        }

        if (e.getSource() == creador) {

            JOptionPane.showMessageDialog(null, "Creado por César Rosa.");
        }

    }

    public static void main(String args[]) {

        Orden orden = new Orden();
        orden.setBounds(0, 0, 380, 475);
        orden.setVisible(true);
        orden.setLocationRelativeTo(null);
        orden.setResizable(false);
    }
}
