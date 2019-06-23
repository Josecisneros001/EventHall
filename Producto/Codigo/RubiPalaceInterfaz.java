package proyecto1;

/*JOSE CISNEROS A01283070*/
//AREA DE IMPORTS
import javax.swing.JFrame;
import java.io.IOException;
import javax.swing.*;

public class RubiPalaceInterfaz{
  
  public static void main(String[] args) throws IOException {  
    //SE CREA LA VENTANA DE USUARIO
    JFrame frame = new UserFrame1("User");   
    frame.setSize(300,140);
    frame.setLocationRelativeTo(null); 
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
     ImageIcon icon = new ImageIcon("icono8.png");
    frame.setIconImage(icon.getImage());  
  }
}  