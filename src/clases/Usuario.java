package clases;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class Usuario extends JFrame implements ActionListener{

JMenuBar menubar;
JMenu menu1,menu2,menu3;
JMenuItem variedades,promociones,condicionesv,volver,orden,creador,principal;
JLabel label1,label2,label3,label4,label5,label6,label7;
JTextArea area1;
JScrollPane scroll1;
String nombre="";
 
 public Usuario(){

  setLayout(null);

  setDefaultCloseOperation(EXIT_ON_CLOSE);

  getContentPane().setBackground(new Color(193,172,73));
 
  setIconImage(new ImageIcon(getClass().getResource("/Icono.png")).getImage());

  setTitle("Usuario");

  ImageIcon imagen= new ImageIcon("imagenes/logo-borth.png");
  Bienvenida nuevo= new Bienvenida();
  nombre= nuevo.texto;

  label1= new JLabel(imagen);
  label1.setBounds(5,5,300,150);
  add(label1);

  label2= new JLabel("Bienvenido/a");
  label2.setBounds(330,20,250,30);
  label2.setFont(new Font("Andale Mono",3,35));
  label2.setForeground(new Color(55,52,53));
  add(label2);

  label4= new JLabel(nombre);
  label4.setBounds(330,60,250,50);
  label4.setFont(new Font("Andale Mono",3,17));
  label4.setForeground(new Color(55,52,53));
  add(label4);
  
  label6= new JLabel("Esperamos que su experiencia con nosotros sea satisfactoría!!");
  label6.setBounds(40,150,560,35);
  label6.setFont(new Font("Andale Mono",3,18));
  label6.setForeground(new Color(55,52,53));
  add(label6);
  
  label7= new JLabel("<html>Podés ver nuestras condiciones de venta y<br> "
          + "  promociones vigentes en menu opciones<br>"
          + "también en variedades podés conocer más sobre<br>"
          + "nuestras cervezas, su precio y disponibilidad.<br><br><br>"
          + "El Equipo de Borth</html>");
  
  label7.setBounds(20,185,580,200);
  label7.setFont(new Font("Andale Mono",3,17));
  label7.setForeground(new Color(55,52,53));
  label7.setHorizontalAlignment(JLabel.CENTER);
  add(label7);


  label3= new JLabel("@Borth Cerveza Artesanal-Valle de Paravachasca");
  label3.setFont(new Font("Andale Mono",1,14));
  label3.setForeground(new Color(55,52,53));
  label3.setBounds(130,425,350,25);
  add(label3);
 
  label5= new JLabel("cel:xxxxxx");
  label5.setFont(new Font("Andale Mono",1,14));
  label5.setForeground(new Color(55,52,53));
  label5.setBounds(205,440,250,25);
  add(label5);


  area1= new JTextArea();
  area1.setFont(new Font("Andale Mono",1,14));
  area1.setForeground(new Color(55,52,53));
  area1.setBackground(new Color(255,255,255));
  area1.setEditable(false);
  scroll1=new JScrollPane(area1);
  scroll1.setBounds(20,150,580,260);
  scroll1.setVisible(false);
  add(scroll1);


  menubar = new JMenuBar();
  setJMenuBar(menubar);
  menubar.setBackground(new Color(193,172,73));

  menu1= new JMenu("Opciones");
  menu1.setFont(new Font("Andale Mono",1,14));
  menu1.setForeground(new Color(55,52,53));
  menubar.add(menu1);

  variedades= new JMenuItem("Variedades");
  variedades.setFont(new Font("Andale Mono",1,14));
  variedades.setForeground(new Color(55,52,53));
  variedades.addActionListener(this);
  menu1.add(variedades);  

  promociones= new JMenuItem("Promociones");
  promociones.setFont(new Font("Andale Mono",1,14));
  promociones.setForeground(new Color(55,52,53));
  promociones.addActionListener(this);
  menu1.add(promociones);


  condicionesv= new JMenuItem("Condiciones de venta");
  condicionesv.setFont(new Font("Andale Mono",1,14));
  condicionesv.setForeground(new Color(55,52,53));
  condicionesv.addActionListener(this);
  menu1.add(condicionesv);
  
  principal= new JMenuItem("Principal");
  principal.setFont(new Font("Andale Mono",1,14));
  principal.setForeground(new Color(55,52,53));
  principal.addActionListener(this);
  menu1.add(principal);

  volver= new JMenuItem("Volver");
  volver.setFont(new Font("Andale Mono",1,14));
  volver.setForeground(new Color(55,52,53));
  volver.addActionListener(this);
  menu1.add(volver);

  menu2= new JMenu("Pedidos");
  menu2.setFont(new Font("Andale Mono",1,14));
  menu2.setForeground(new Color(55,52,53));
  menubar.add(menu2);

  orden= new JMenuItem("Orden");
  orden.setFont(new Font("Andale Mono",1,14));
  orden.setForeground(new Color(55,52,53));
  orden.addActionListener(this);
  menu2.add(orden);
 
  menu3= new JMenu("Acerca de");
  menu3.setFont(new Font("Andale Mono",1,14));
  menu3.setForeground(new Color(55,52,53));
  menubar.add(menu3);

  creador= new JMenuItem("El Creador");
  creador.setFont(new Font("Andale Mono",1,14));
  creador.setForeground(new Color(55,52,53));
  creador.addActionListener(this);
  menu3.add(creador);

}

 
 public void actionPerformed(ActionEvent e){

 if(e.getSource() == variedades){
 scroll1.setVisible(true);
 label6.setVisible(false);
 label7.setVisible(false);
 try {
          Connection cn = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/onsMAuvdE5","onsMAuvdE5", "EWpgsJuVTJ");
          PreparedStatement pst = cn.prepareStatement("select * from opciones where ID = 1");

          ResultSet rs = pst.executeQuery();
                    

          if (rs.next()){
          area1.setText(rs.getString("variedades"));
          }
          
          
     } catch(SQLException evt) {
     }
 
 }

 if(e.getSource() == promociones){
 scroll1.setVisible(true);
 label6.setVisible(false);
 label7.setVisible(false);
     try {
          Connection cn = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/onsMAuvdE5","onsMAuvdE5", "EWpgsJuVTJ");
          PreparedStatement pst = cn.prepareStatement("select * from opciones where ID = 1");

          ResultSet rs = pst.executeQuery();
                    

          if (rs.next()){
          area1.setText(rs.getString("promouser"));
          }
          
          
     } catch(SQLException evt) {
     }
 
 }

 if(e.getSource() == condicionesv){
 scroll1.setVisible(true);
 label6.setVisible(false);
 label7.setVisible(false);
      try {
          Connection cn = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/onsMAuvdE5","onsMAuvdE5", "EWpgsJuVTJ");
          PreparedStatement pst = cn.prepareStatement("select * from opciones where ID = 1");

          ResultSet rs = pst.executeQuery();
                    

          if (rs.next()){
          area1.setText(rs.getString("condicionesv"));
          }
          
          
     } catch(SQLException evt) {
     }
 }

 if(e.getSource() == volver){

  Bienvenida bien= new Bienvenida();
  bien.setBounds(0, 0, 350, 460);
  bien.setVisible(true);
  bien.setLocationRelativeTo(null);
  bien.setResizable(false);
  this.setVisible(false);
 }

 if(e.getSource() == orden){
  Orden orden = new Orden();
  orden.setBounds(0, 0, 380, 475);
  orden.setVisible(true);
  orden.setLocationRelativeTo(null);
  orden.setResizable(false);
  this.setVisible(false);

 }
 
 if(e.getSource() == principal){
 scroll1.setVisible(false);
 label6.setVisible(true);
 label7.setVisible(true);
 }

 if(e.getSource() == creador){
 JOptionPane.showMessageDialog(null,"Creado por César Rosa.");
 }
}

 public static void main (String args[]){
  Usuario mayor = new Usuario();
  mayor.setBounds(0,0,640,530);
  mayor.setVisible(true);
  mayor.setLocationRelativeTo(null);
  mayor.setResizable(false); 

 }
}


