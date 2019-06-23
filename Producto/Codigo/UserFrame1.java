package proyecto1;
//AREA IMPORTS
import java.io.*;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.*;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.*;
import javax.swing.JPasswordField;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class  UserFrame1 extends JFrame {
    //DECLARACION COMPONENTES
  private JTextField usuario;
  private JPasswordField contraseña;
  private int cantidadcuentas=0;
  private Usuario[] usuarios;
  
  //ACTION LISTENER QUE LLAMA EL METODO REVISAR
  private class ButtonListener0 implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        revisar();
    }}
  //VERIFICA SI EXISTE UNA CUENTA CON EL NOMBRE Y CONTRASEÑA PROPORCIONADA
  public void revisar(){
   String name = usuario.getText();
    String contraseña1 = contraseña.getText();
    int count=0;
    try {
    for(int x=0;x<usuarios.length;x++){
     if(usuarios[x]!=null)
      if(name.equals(usuarios[x].getCuenta()) && contraseña1.equals(usuarios[x].getPassword())){
        count++;
        //EN CASO QUE SI, SALE DE LA PANTALLA DE USUARIO Y ENTRA AL RESTO DEL PROGRAMA
      JFrame frame = new MainFrame1("MENU",usuarios[x]);
         setVisible(false);
         frame.setSize(2300,1000);
         frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.setVisible(true);
        ImageIcon icon = new ImageIcon("icono8.png");
        frame.setIconImage(icon.getImage());
     }
    }
    if(count==0){
      usuario.setText("");
      contraseña.setText("");}}catch (IOException ex){System.out.println(ex);}
  }
    
  public  UserFrame1(String title)  {
   super(title);
   
     usuarios= new Usuario[100];
     try{
     RandomAccessFile arch = new RandomAccessFile ("CuentaLogIn.dat","rw");
     
     cantidadcuentas=arch.readInt();
     //LEE EL ARCHIVO DE CUENTAS Y LAS GUARDA EN UN ARREGLO
     for(int x=0;x<cantidadcuentas;x++){
       usuarios[x]= new Usuario(arch.readUTF(),arch.readUTF(),arch.readBoolean(),arch.readBoolean(),arch.readBoolean(),arch.readBoolean(),arch.readBoolean(),arch.readBoolean(),arch.readBoolean());
     }}
     catch(Exception e){}
   //Colors
     int[] colores=new int[9];
    String  fontletra="";
     try{
     RandomAccessFile arch1 = new RandomAccessFile("preferencias.dat", "rw");
      for(int count=0;count<colores.length;count++){
        colores[count] = arch1.readInt();}
    //LEER FONT
        fontletra= arch1.readUTF();}
     catch(Exception e){}
     
     Color     c= new Color(colores[0],colores[1],colores[2]);
     Color    c1= new Color(colores[3], colores[4], colores[5]);
     Color    c2= new Color(colores[6],colores[7],colores[8]);
     
   //SE DECLARAN LOS COMPONENTES Y SE AJUSTAN PROPIEDADES
   JLabel nameLabel1 = new JLabel(" RUBI PALACE ",SwingConstants.CENTER);
   nameLabel1.setFont(new java.awt.Font(fontletra, 0, 20)); 
   nameLabel1.setForeground(c2);
   
   JLabel label1=new JLabel("Usuario:");
   label1.setFont(new java.awt.Font(fontletra, 0, 20)); 
   label1.setForeground(c2);
   usuario=new JTextField(20);
   
   JLabel label2= new JLabel("Contraseña:");
   label2.setForeground(c2);
   label2.setFont(new java.awt.Font(fontletra, 0, 20)); 
   contraseña= new JPasswordField(20);
   
   
   JButton ingresar = new JButton("Ingresar");
   ingresar.setForeground(c2);
   ingresar.setFont(new java.awt.Font(fontletra, 0, 15)); 
   ingresar.setBackground(c1);
   
   GridLayout gl = new GridLayout(2,2);
   //SE CREA EL PANEL Y SE AÑADEN COMPONENTES
   JPanel adentro1 = new JPanel();
   adentro1.setBackground(c);
   adentro1.setLayout(gl); 
   adentro1.add(label1);
   adentro1.add(usuario);
   adentro1.add(label2);
   adentro1.add(contraseña);
   //SE CREA EL CONTENEDOR Y SE AÑADEN COMPONENTES
   Container cp = getContentPane();
   cp.setBackground(c);
   cp.add(adentro1, BorderLayout.CENTER);
   cp.add(nameLabel1, BorderLayout.NORTH);
   cp.add(ingresar,BorderLayout.SOUTH);
 
   //SE AGREGAN LOS ACTION LISTENERS QUE LLAMARAN EL METODO DE REVISAR
   ingresar.addActionListener(new ButtonListener0());
   contraseña.addKeyListener(new KeyAdapter() {
        
        public void keyPressed(KeyEvent e) {
            if(e.getKeyCode() == KeyEvent.VK_ENTER) {
                revisar();
            }
        }
   });
           }}
   