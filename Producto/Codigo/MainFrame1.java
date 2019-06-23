package proyecto1;
//AREA DE IMPORTS
import java.io.IOException;
import java.io.*;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.*;
import javax.swing.table.TableColumnModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel; 
import java.awt.event.ActionListener;
import javax.swing.table.TableCellRenderer;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.*;
import javax.swing.JPasswordField;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.util.Calendar;
import org.jdatepicker.impl.*;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import java.util.List;
import java.util.Properties;
import javax.swing.JFormattedTextField.AbstractFormatter;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JColorChooser;
import javax.swing.table.TableRowSorter;



public class MainFrame1 extends JFrame {
//DECLARACION DE ARCHIVOS 
  private RandomAccessFile arch1;
  private RandomAccessFile arch;
  private RandomAccessFile arch2;
  private RandomAccessFile arch3;
  private RandomAccessFile arch4;
  //DECLARACION DE ICONO DE JFRAMES
  private ImageIcon icon = new ImageIcon("icono8.png");
//METODOS/ACTIONLISTENERS  PARA CAMBIAR COLORES
        //DECLARACION DE VARIABLES QUE SE USARAN EN LOS METODOS DE CAMBIAR COLORES
  private JComboBox fontsss= new JComboBox();
  private Color c;
  private Color c1;
  private Color c2;
  private int[] colores;
  //METODO/ACTIONLISTENER  PARA COLOR PRINCIPAL
  private class ButtonListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      try{
        Color c4 = JColorChooser.showDialog(null, "Choose a Color", c) ;
        if (c4 != null){
          c=c4;
          guardarPref();
          setVisible(false);
          actualizarframe();
        }
      } catch(HeadlessException ex){alerta1("Error,vuelva a intentarlo");}
    }
    
  }
  //METODO/ACTIONLISTENER  PARA COLORES SECUNDARIOS
  
  private class ButtonListener3 implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      try{
        Color c4 = JColorChooser.showDialog(null, "Choose a Color", c) ;
        if (c4 != null){
          c1=c4;    
          guardarPref();
          actualizarframe();
        }
      }catch(HeadlessException ex){alerta1("Error,vuelva a intentarlo");}}
  }
 
//METODO/ACTIONLISTENER  PARA COLOR DE LETRA
  private class ButtonListener4 implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      try{
        Color c4 = JColorChooser.showDialog(null, "Choose a Color", c) ;
        if (c != null){
          c2=c4;
          guardarPref();
          actualizarframe();
        }}catch(Exception ex){alerta1("Error,vuelva a intentarlo");}
    }}
  //METODO PARA ACTUALIZAR LA PANTALLA Y REFLEJAR EL CAMBIO DE COLORES
  private void actualizarframe(){
    try{
      JFrame frame = new MainFrame1("MENU",usuarioactual);
      setVisible(false);
      frame.setSize(2300,1000);
      frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
      frame.setVisible(true);frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setIconImage(icon.getImage());
    }catch(Exception c){}
  }  
   //METODO/ACTIONLISTENER PARA CAMBIAR EL FONT
        // DECLARACION DE VARIABLES QUE TAMBIEN SE UTILIZAN FUERA DEL METODO
  public JComboBox comboBox= new JComboBox();
  public String fontletra;
  
  private class ButtonListener2 implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      final  JComboBox<String> comboBox = new JComboBox<String>(); 
      comboBox.setFont(new java.awt.Font(fontletra, 0, 40));
      final  String fonts[] = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
      
      for ( int i = 0; i < fonts.length; i++ ){
        comboBox.addItem(fonts[i]);
      }
      comboBox.setSelectedItem(fonts[0]);
      JButton mainPanelbutton = new JButton("Guardar");
      
      JPanel mainPanel = new JPanel();
      mainPanelbutton.setFont(new java.awt.Font(fontletra, 0, 40));
      mainPanelbutton.setForeground(c2);
      mainPanelbutton.setBackground(c1);
      mainPanel.setBackground(c);
      mainPanel.add(comboBox);  
      mainPanel.add(mainPanelbutton);
      
      final JFrame frame = new JFrame("Elija un font:");
      
      frame.setContentPane(mainPanel);
      frame.pack();
      frame.setLocationByPlatform(true);
      frame.setVisible(true);frame.setIconImage(icon.getImage());
      
      mainPanelbutton.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
          fontletra=(String)comboBox.getSelectedItem();
          frame.setVisible(false);
          guardarPref();
          actualizarframe();
        }});
    }
  }
//TERMINAN METODOS PARA CAMBIAR COLORES Y FONT

  //METODO PARA MOSTRAR EL RELOJ Y LA FECHA ACTUAL
        //DECALARACION DE VARIABLES QUE SE USARAN EN ESTE METODO Y O FUERA TAMBIEN 
  private JLabel relojyfecha2;
  private java.util.Calendar calendario; 
  private int dia, mes, año, hora, minutos, segundos; 
  private void reloj() { 
    calendario = new java.util.GregorianCalendar(); 
    segundos = calendario.get(Calendar.SECOND); 
    javax.swing.Timer timer = new javax.swing.Timer(1000, new java.awt.event.ActionListener() { 
      @ Override 
      public void actionPerformed(java.awt.event.ActionEvent ae) { 
        java.util.Date actual = new java.util.Date(); 
        calendario.setTime(actual); 
        dia = calendario.get(Calendar.DAY_OF_MONTH); 
        mes = (calendario.get(Calendar.MONTH) + 1); 
        año = calendario.get(Calendar.YEAR); 
        hora = calendario.get(Calendar.HOUR_OF_DAY); 
        minutos = calendario.get(Calendar.MINUTE); 
        segundos = calendario.get(Calendar.SECOND); 
        String hour = String.format("%02d : %02d : %02d", hora, minutos, segundos); 
        String date = String.format("%02d / %02d / %02d", dia, mes, año); 
        relojyfecha2.setText("<html><center>" + hour +"<br>"+ date );
        revisarlabel(); //LLAMAR METODO REVISARLABEL, EL CUAL CAMBIA EL MENSAJE DE "BUENOS DIAS/NOCHES/TARDES" DEPENDIENDO LA HORA 
      }}); 
    timer.start(); 
  } 
  //METODO QUE REVISA LA HORA PARA MONSTRAR EL MENSAJE ADECUADO
    JLabel bienvenido;
  private void revisarlabel(){
  if(hora<6 || hora >19){
  bienvenido.setText("Buenas Noches, "+usuarioactual.getCuenta());
  }else{
  if(hora>=6 && hora<12){
  bienvenido.setText("Buenos Días, "+usuarioactual.getCuenta());
  }else{
  bienvenido.setText(("Buenas Tardes, "+usuarioactual.getCuenta()));
  }
  }
  
  }
  
//METODO PARA GUARDAR ARCHIVO PREFERENCIAS
  public void guardarPref() {
    try{
      arch1 = new RandomAccessFile("preferencias.dat", "rws");      
      colores[0] = c.getRed(); 
      colores[1] = c.getGreen(); 
      colores[2] = c.getBlue(); 
      colores[3] = c1.getRed();
      colores[4] = c1.getGreen();
      colores[5] = c1.getBlue();
      colores[6] = c2.getRed();
      colores[7] = c2.getGreen();
      colores[8] = c2.getBlue();
      
      for(int count=0;count<colores.length;count++){arch1.writeInt(colores[count]);}   
      arch1.writeUTF(fontletra);
      arch1.close();
    }catch(IOException ex){}
  }
  //TERMINA METODO PARA GUARDAR PREFERENCIAS
  //METODO GUARDAR CUENTAS
            //DECALARACION DE VARIABLES QUE SE USARAN EN ESTE METODO Y O FUERA TAMBIEN 
  Usuario[] usuarios;
    public void guardarCuentas(){
    
    try{arch4= new RandomAccessFile ("CuentaLogIn.dat","rws");}catch(IOException ex){}
    int count=0;
    for(int x=0;x<usuarios.length;x++){if(usuarios[x]!=null){count++;}}
    try{
      arch4.writeInt(count);
      for(int x=0;x<usuarios.length;x++){if(usuarios[x]!=null){
        arch4.writeUTF(usuarios[x].getCuenta());
        arch4.writeUTF(usuarios[x].getPassword());
        arch4.writeBoolean(usuarios[x].getRes1());
        arch4.writeBoolean(usuarios[x].getRes2());
        arch4.writeBoolean(usuarios[x].getRes3());
        arch4.writeBoolean(usuarios[x].getRes4());
        arch4.writeBoolean(usuarios[x].getRes5());
        arch4.writeBoolean(usuarios[x].getRes6());
        arch4.writeBoolean(usuarios[x].getRes7());}}}catch(IOException ex){}
  }
  //TERMINA METODO GUARDAR CUENTAS
  //METODO GUARDAR EMPLEADOS
        //DECALARACION DE VARIABLES QUE SE USARAN EN ESTE METODO Y O FUERA TAMBIEN 
  public Empleado[] empleados;
    public void guardarEmpleados(){
        try{
            arch3 = new RandomAccessFile ("Empleados.dat","rws");
            int utilizados=0;
            for(int i=0;i<empleados.length;i++){
                if(empleados[i]!=null){utilizados++;}
            }
            arch3.writeInt(utilizados);
            for(int x=0;x<empleados.length;x++){
                if(empleados[x]!=null){
                    arch3.writeUTF(empleados[x].getNombre());
                    arch3.writeUTF(empleados[x].getApellido());
                    arch3.writeChar(empleados[x].getGenero());   
                    arch3.writeUTF(empleados[x].getTelefono());
                    arch3.writeUTF(empleados[x].getDomicilio());
                    arch3.writeUTF(empleados[x].getCorreo());
                    arch3.writeUTF(empleados[x].getNomina());
                    arch3.writeUTF(empleados[x].getPuesto());
                    arch3.writeDouble(empleados[x].getSueldo());    
                }
            }   
        }catch(Exception ex){}
    }
  //TERMINA METODO GUARDAR EMPLEADO
  //METODO PARA ESCRIBIR EN WORD 
        //DECALARACION DE VARIABLES QUE SE USARAN EN ESTE METODO Y O FUERA TAMBIEN 
    public static XWPFDocument doc;
    public void escribir2(String[][] x,String w) throws IOException{
    String filepath= ".\\CONTRATOS\\CONTRATOBASE.docx";;   
    String outpath = ".\\CONTRATOS\\CONTRATOBASE"+w+".docx";
    doc = new XWPFDocument(new FileInputStream(filepath));
    for (XWPFParagraph p : doc.getParagraphs()){
      StringBuilder sb = new StringBuilder();
      for (XWPFRun r : p.getRuns()){
        int pos = r.getTextPosition();
        if(r.getText(pos) != null) {
          sb.append(r.getText(pos));
        }
      }
      List<XWPFRun> runs = p.getRuns();
      if (runs != null) {
        for (XWPFRun r : runs) {
          String text = r.getText(0);
          for(int i=0;i<22;i++){
             int j=0;
                if (text != null && text.contains(x[i][j])) {
            text = text.replace(x[i][j], x[i][j+1]);
            r.setText(text, 0);
          }}
        }
      }
    }
    doc.write(new FileOutputStream(outpath));
    }
  //TERMINA METODO PARA ESCRIBIR EN WORD
  //METODO PARA GUARDAR EVENTOS
    //DECALARACION DE VARIABLES QUE SE USARAN EN ESTE METODO Y O FUERA TAMBIEN 
  public Evento[] eventos; 
  public void guardarEventos(){
    try{arch=new RandomAccessFile("InfoEvento.dat","rws");}
    catch(IOException ex){}
    int utilizados=0;
    for(int i=0;i<eventos.length;i++){
      if(eventos[i]!=null){utilizados++;}
    }
    //SE GUARDA EL NUMERO DE EVENTOS ACTUAL
    try{arch.writeInt(utilizados);}catch(IOException ex){}
    for(int i=0;i<eventos.length;i++){
      if(eventos[i]!=null){ 
        try{
            //SE GUARDA TODA LA INFORMACION DE LOS EVENTOS
          arch.writeUTF(eventos[i].clientes.getNombre());
          arch.writeUTF(eventos[i].clientes.getApellido());
          arch.writeUTF(eventos[i].clientes.getRfc());   
          arch.writeUTF(eventos[i].clientes.getTelefono());
          arch.writeUTF(eventos[i].clientes.getDomicilio());
          arch.writeUTF(eventos[i].clientes.getCorreo());
          arch.writeUTF(eventos[i].clientes.getNreferente());
          arch.writeUTF(eventos[i].clientes.getTreferente());
          arch.writeUTF(eventos[i].getNombre());
          arch.writeUTF(eventos[i].getFecha());
          arch.writeUTF(eventos[i].getPrimerT());
          arch.writeUTF(eventos[i].getSegundoT1());
          arch.writeUTF(eventos[i].getSegundoT2());
          arch.writeUTF(eventos[i].getSegundoT3());
          arch.writeUTF(eventos[i].getTercerT());
          arch.writeInt(eventos[i].getCantidadAdt());
          arch.writeUTF(eventos[i].getComidaNiño());
          arch.writeInt(eventos[i].getCantidadNiño());
          arch.writeUTF(eventos[i].getHoraInicial());
          arch.writeUTF(eventos[i].getHoraFinal());
          arch.writeUTF(eventos[i].getSalon());
          arch.writeBoolean(eventos[i].getMusica());
          arch.writeBoolean(eventos[i].getArreglo());
          arch.writeInt(eventos[i].getTotal());
          arch.writeUTF(eventos[i].getPath());
          arch.writeUTF(eventos[i].getDescuento());
        }
        catch(Exception ex){}
        
      }}
    try{arch.close();
    } catch(IOException ex){}
  }
  
//METODO PARA GUARDAR NUMERO EVENTO
  //DECALARACION DE VARIABLES QUE SE USARAN EN ESTE METODO Y O FUERA TAMBIEN 
  public int Nevento=0;
  RandomAccessFile archivo5;
  public void guardarNumero(){
    try{
      archivo5 = new RandomAccessFile ("Nevento.dat","rws");
      archivo5.writeInt(Nevento);
    }catch(Exception e){}
  }
  //TERMINA METODO QUE GUARDA EL NUMERO
  //METODOS QUE HACEN REFERENCIA A LA TABLA
  private JTable table;
  //METODO PARA APLICAR FILTRO EN LA TABLA DE EVENTOS
    private void filter(String text){
        DefaultTableModel modelo = (DefaultTableModel)table.getModel();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(modelo);
        table.setRowSorter(tr);
        
        tr.setRowFilter(RowFilter.regexFilter(text.toUpperCase()));
    }
  //TERMINA METODO PARA APLICAR FILTRO EN LA TABLA
  //METODO/ACTIONLISTENER QUE LLAMA EL METODO QUE ACTUALIZA
  private class ButtonListener6 implements ActionListener {
    public void actionPerformed(ActionEvent e) {actualizartabla();}}
  //TERMINA EL METODO QUE LLAMA EL METODO QUE ACTUALIZA
  //METODO QUE ACTUALIZA EL CONTENIDO DE LA TABLA
  public void actualizartabla(){
    //reloadData();
    int count3=0;
    for(int i=0;i<eventos.length;i++){
      if(eventos[i]!=null){count3++;}}
    Object[][] data = new Object[count3][14];
    int count4=0;
    for(int i=0;i<eventos.length;i++){
      if(eventos[i]!=null){
        data[count4][0] = (eventos[i].clientes.getNombre() + "  "+eventos[i].clientes.getApellido()).toUpperCase(); 
        //System.out.println(i);
        data[count4][1] = eventos[i].getNombre().toUpperCase();
        data[count4][2] = eventos[i].getFecha().toUpperCase();
        data[count4][3] = eventos[i].getPrimerT().toUpperCase();
        data[count4][4] = eventos[i].getSegundoT1().toUpperCase(); 
        data[count4][5] = eventos[i].getSegundoT2().toUpperCase();
        data[count4][6] = eventos[i].getSegundoT3().toUpperCase();
        data[count4][7] = eventos[i].getTercerT().toUpperCase();
        data[count4][8] = eventos[i].getCantidadAdt();
        data[count4][9] = eventos[i].getComidaNiño().toUpperCase();
        data[count4][10] = eventos[i].getCantidadNiño();
        data[count4][11] = eventos[i].getSalon().toUpperCase();
        data[count4][12] = eventos[i].getHoraInicial().toUpperCase();
        data[count4][13] = eventos[i].getHoraFinal().toUpperCase();
        count4++;
      }
    }    
//Array de �String� con los titulos de las columnas 
    String[] columnNames = {"Nombre", "Evento", "Fecha", "Primer T.", "Guarnicion 1", "Guarnicion 2", "Plato Fuerte", "Tercer T.", "Cantidad", "Comida Niños", "Cantidad","Salón","Inicio","Fin"};
    DefaultTableModel dtm = new DefaultTableModel(data, columnNames); 
    int[] anchos={80,200,80,50};
    table.setModel(dtm);
    final TableColumnModel columnModel = table.getColumnModel();
    for (int column = 0; column < table.getColumnCount(); column++) {
      int width = 15; // Min width
      for (int row = 0; row < table.getRowCount(); row++) {
        TableCellRenderer renderer = table.getCellRenderer(row, column);
        Component comp = table.prepareRenderer(renderer, row, column);
        width = Math.max(comp.getPreferredSize().width +1 , width);
      }
      if(width > 300)
        width=300;
      columnModel.getColumn(column).setPreferredWidth(width);
    }
    int count=0;
    for(int i = 8; i < 12; i++) {
      table.getColumnModel().getColumn(i).setPreferredWidth(anchos[count]);
      count++;
      
    }
  } 
  //TERMINA METODO QUE ACTUALIZA EL CONTENIDO DE LA TABLA
  //METODO PARA MOSTRAR ALERTAS
  public void alerta1(String alerta){       
    JPanel mainPanel = new JPanel();
    mainPanel.setBackground(c);
    JLabel alerta1= new JLabel(alerta);
    alerta1.setFont(new java.awt.Font(fontletra, 0, 20));
    alerta1.setForeground(c2);
    mainPanel.add(alerta1);
    JButton mainPanelbutton = new JButton("Aceptar");
    mainPanelbutton.setFont(new java.awt.Font(fontletra, 0, 20));
    mainPanelbutton.setForeground(c2);
    mainPanelbutton.setBackground(c1);
    mainPanel.add(mainPanelbutton);
    
    final JFrame frame = new JFrame("Alerta:");
    frame.setBackground(c);
    frame.setContentPane(mainPanel);
    frame.pack();
    frame.setLocationByPlatform(true);
    frame.setVisible(true);frame.setIconImage(icon.getImage());
            
        frame.setIconImage(icon.getImage());
    
    mainPanelbutton.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        frame.setVisible(false);}});
  }
  //TERMINA METODO DE ALERTAS
  //METODO GUARDAR COMIDAS 
  //DECALARACION DE VARIABLES QUE SE USARAN EN ESTE METODO Y O FUERA TAMBIEN 
  private String[] comidas= new String[100];
  private String[] comidas1= new String[100];
  private String[] comidas2= new String[100];
  private String[] comidas3= new String[100];
  private String[] comidas4= new String[100];
  
  public void guardarComidas(){
    int count1=0,count2=0,count3=0,count4=0,count5=0;
    try{arch2 = new RandomAccessFile("InfoComidas.dat","rws");
      for(int x=0;x<comidas.length;x++){
        if(comidas[x]!=null){count1++;}}
      
      for(int x=0;x<comidas1.length;x++){
        if(comidas1[x]!=null){count2++;}}
      
      for(int x=0;x<comidas2.length;x++){
        if(comidas2[x]!=null){count3++;}}
      
      for(int x=0;x<comidas3.length;x++){
        if(comidas3[x]!=null){count4++;}}
      
      for(int x=0;x<comidas4.length;x++){
        if(comidas4[x]!=null){count5++;}}
      
      arch2.writeInt(count1);arch2.writeInt(count2);arch2.writeInt(count3);arch2.writeInt(count4);arch2.writeInt(count5);
      for(int x=0;x<comidas.length;x++){if(comidas[x]!=null){arch2.writeUTF(comidas[x]);}}
      for(int x=0;x<comidas1.length;x++){if(comidas1[x]!=null){arch2.writeUTF(comidas1[x]);}}
      for(int x=0;x<comidas2.length;x++){if(comidas2[x]!=null){arch2.writeUTF(comidas2[x]);}}
      for(int x=0;x<comidas3.length;x++){if(comidas3[x]!=null){arch2.writeUTF(comidas3[x]);}}
      for(int x=0;x<comidas4.length;x++){if(comidas4[x]!=null){arch2.writeUTF(comidas4[x]);}}}
    catch(IOException ex){}
  }
  //TERMINA METODO PARA GUARDAR COMIDAS
 
 //DECALARACION DE VARIABLES QUE SE USARAN EN EL CONSTRUCTOR
  private JMenuBar barraMenu;
  private JMenu menuPreferencias;
  private JMenuItem[] itemsbarra;
    //DECLARO EL USUARIO ACTUAL
  private Usuario usuarioactual;


//CONSTRUCTOR DEL OBJETO QUE RECIBE EL USUARIO ACTUAL Y EL TITULO
  public MainFrame1(String title, Usuario usuarioactual1) throws IOException {
    super(title);
    //SE GUARDA EL USUARIO ACTUAL
    usuarioactual=usuarioactual1;
    relojyfecha2=new JLabel("");
    
    //LEER COLORES DEL ARCHIVO
    arch1 = new RandomAccessFile("preferencias.dat", "rws");
    colores = new int[9];
    for(int count=0;count<colores.length;count++){
      colores[count] = arch1.readInt();}
    c= new Color(colores[0],colores[1],colores[2]);
    c1= new Color(colores[3], colores[4], colores[5]);
    c2= new Color(colores[6],colores[7],colores[8]);
    //LEER FONT
    fontletra= arch1.readUTF();
    //LEER COMIDAS
    arch2 = new RandomAccessFile("InfoComidas.dat","rws");         
    int[] largocomidas = {  arch2.readInt(),  arch2.readInt(),  arch2.readInt(),  arch2.readInt(),  arch2.readInt()};
    for(int x=0;x<largocomidas[0];x++){comidas[x]=arch2.readUTF();}
    for(int x=0;x<largocomidas[1];x++){comidas1[x]=arch2.readUTF();}
    for(int x=0;x<largocomidas[2];x++){comidas2[x]=arch2.readUTF();}
    for(int x=0;x<largocomidas[3];x++){comidas3[x]=arch2.readUTF();}
    for(int x=0;x<largocomidas[4];x++){comidas4[x]=arch2.readUTF();}
    
    //LEER CUENTAS  
    usuarios= new Usuario[100];
    try{
      RandomAccessFile arch = new RandomAccessFile ("CuentaLogIn.dat","rw");
      int cantidadcuentas=arch.readInt();
      for(int x=0;x<cantidadcuentas;x++){
        usuarios[x]= new Usuario(arch.readUTF(),arch.readUTF(),arch.readBoolean(),arch.readBoolean(),arch.readBoolean(),arch.readBoolean(),arch.readBoolean(),arch.readBoolean(),arch.readBoolean());
      }
    }catch(Exception e){}
    //LEER EVENTOS  
    arch = new RandomAccessFile("InfoEvento.dat","rws");
    eventos= new Evento[100];
    final long numeventos=arch.readInt();
    int x=0;
    long numeventos2=numeventos;
    
    while(numeventos2>0){
      eventos[x]=new Evento(arch.readUTF(),arch.readUTF(),arch.readUTF(),arch.readUTF(),arch.readUTF(),arch.readUTF(),arch.readUTF(),arch.readUTF(),arch.readUTF(),arch.readUTF(),arch.readUTF(),arch.readUTF(),arch.readUTF(),arch.readUTF(),arch.readUTF(),arch.readInt(),arch.readUTF(),arch.readInt(),arch.readUTF(),arch.readUTF(),arch.readUTF(),!arch.readBoolean(),arch.readBoolean(),arch.readInt(),arch.readUTF(),arch.readUTF());
      x++;
      numeventos2--;
    }
    //LEER EMPLEADOS
    arch3 = new RandomAccessFile ("Empleados.dat","rws");
    empleados= new Empleado[100];
    int numempleados= arch3.readInt();
    x=0;
    
    while(numempleados>0){
      empleados[x]= new Empleado(arch3.readUTF(),arch3.readUTF(),arch3.readChar(),arch3.readUTF(),arch3.readUTF(),arch3.readUTF(),arch3.readUTF(),arch3.readUTF(),arch3.readDouble());
      x++;
      numempleados--;
    }
    //LEER NUMERO EVENTOS
    archivo5 = new RandomAccessFile ("Nevento.dat","rws");
    Nevento=archivo5.readInt();
    //DECLARACION DE ICONOS
    String[] nombreiconos={"icono.png","icono2.png","icono5.png","icono4.png","icono3.png","icono6.png","icono7.png"};
    ImageIcon[] iconos= new ImageIcon[nombreiconos.length];
    for(int i=0;i<nombreiconos.length;i++){
      if(i>4){
        iconos[i]=new ImageIcon(new ImageIcon(nombreiconos[i]).getImage().getScaledInstance(75, 75, Image.SCALE_DEFAULT));}
      else{iconos[i]=new ImageIcon(new ImageIcon(nombreiconos[i]).getImage().getScaledInstance(125, 125, Image.SCALE_DEFAULT));}
    }
    // SE DECLARA LA BARRA MENU Y SUS COMPONENTES
    
    barraMenu = new JMenuBar();
    barraMenu.setBackground(c);
    barraMenu.setForeground(c2);
    barraMenu.setFont(new java.awt.Font(fontletra, 0, 3)); 
    barraMenu.setLayout(new GridLayout(1,3));
    
    menuPreferencias = new JMenu();
    menuPreferencias.setIcon(iconos[5]);
    menuPreferencias.setForeground(c2);
    menuPreferencias.setFont(new java.awt.Font(fontletra, 0, 25));
    //AGREGAR ITEMS
    try{
      String[] nombresitemsmenu={"Color","Letra","Color Primario","Color Letra","Color Secundario"};
      itemsbarra=new JMenuItem[5];
      for(int i=0;i<nombresitemsmenu.length;i++){
        if(i>0){
          itemsbarra[i] = new JMenuItem(nombresitemsmenu[i]);
          if(i>1){
            itemsbarra[0].add(itemsbarra[i]);
          }else{menuPreferencias.add( itemsbarra[i]);}
        }
        else{
          itemsbarra[i] = new JMenu(nombresitemsmenu[i]);
          menuPreferencias.add( itemsbarra[i]);
        }
        itemsbarra[i].setFont(new java.awt.Font(fontletra, 0, 25)); 
      }
      itemsbarra[2].addActionListener(new ButtonListener());
      itemsbarra[3].addActionListener(new ButtonListener4());
      itemsbarra[4].addActionListener(new ButtonListener3());
      itemsbarra[1].addActionListener(new ButtonListener2());
      setJMenuBar( barraMenu);
    }catch(Exception ex){}
    
    bienvenido= new JLabel((""+usuarioactual.getCuenta()));
    bienvenido.setForeground(c2);
    bienvenido.setFont(new java.awt.Font(fontletra, 0, 50)); 
    barraMenu.add(bienvenido);
    
    JLabel bienvenido1= new JLabel("Rubi Palace");
    bienvenido1.setForeground(c2);
    bienvenido1.setFont(new java.awt.Font(fontletra, 0, 70)); 
    barraMenu.add(bienvenido1);
    
    JButton bienvenido2 = new JButton();
    bienvenido2.setBackground(c);
    bienvenido2.setIcon(iconos[6]);
    bienvenido2.setBorder(null);
   
    //ACTION LISTENER DE BOTON PARA CERRAR SESIÓN
    bienvenido2.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        setVisible(false);
        JFrame frame = new UserFrame1("User");
        frame.setSize(300,140);
        frame.setBackground(c);
        frame.setLocationRelativeTo(null); 
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setIconImage(icon.getImage());
      }});
    
    JMenuBar panelmenu = new JMenuBar();
    panelmenu.setBorder(null);
    panelmenu.setBackground(c);
    panelmenu.add(new JLabel("                                "));
    relojyfecha2.setForeground(c2);
    relojyfecha2.setFont(new java.awt.Font(fontletra, 0, 30));
    panelmenu.add(relojyfecha2);
    panelmenu.add(menuPreferencias);
    panelmenu.add(bienvenido2);   
    barraMenu.add(panelmenu);
    
    //BOTONES PRINCIPALES LADO IZQUIERDO      
    final   JPanel adentro1 = new JPanel();
    adentro1.setBackground(c);
    GridLayout gl = new GridLayout(5,1);
    adentro1.setLayout(gl); 
    
    JButton[] botonesprincipales= new JButton[5];
    for(int i=0;i<botonesprincipales.length;i++){
      botonesprincipales[i]=new JButton();
      botonesprincipales[i].setIcon(iconos[i]);
      botonesprincipales[i].setBackground(c1);
      botonesprincipales[i].setSize(3,3);
      adentro1.add(botonesprincipales[i]);
      if(i==4){
        botonesprincipales[i].setEnabled(usuarioactual.getRes7());
      }
    }
    
    //CALENDARIO
    UtilDateModel model = new UtilDateModel();
    
    Properties p = new Properties();
    p.put("text.today", "Today");
    p.put("text.month", "Month");
    p.put("text.year", "Year");
    JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
    
    AbstractFormatter formatter = new AbstractFormatter() {
      private static final long serialVersionUID = -8683300026142745158L;
      
      private String datePattern = "dd.MM.yyyy";
      private SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern);
      
      @Override
      public Object stringToValue(String text) throws ParseException {
        return dateFormatter.parseObject(text);
      }
      @Override
      public String valueToString(Object value) throws ParseException {
        try{ 
          if (value != null) {
            Calendar cal = (Calendar) value;
            return dateFormatter.format(cal.getTime());
          }} catch(Exception c){alerta1("Error revise los datos ingresados");}
          return "";
      }
    };
    
    JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, formatter); 
    datePicker.setFont(new java.awt.Font(fontletra, 0, 60)); 
    //SE INICIALIZAN LAS HORAS DISPONIBLES
    String[] horas={"8:00","9:00","10:00","11:00","12:00","13:00","14:00","15:00","16:00","17:00","18:00","19:00","20:00","21:00","22:00","23:00","00:00","1:00","2:00","3:00"};
    // VER COMIDAS 
    //DECLARACION DE COMPONENTES 
    String[] tiposcomida= {"Primer T.","Plato F.","Guarnicion","Tercer T.","Niños"};
    JLabel[] labelscomidas= new JLabel[16];
    JComboBox[] boxscomidas = new JComboBox[10];
    JTextField[] fieldscomidas = new JTextField[7];
    JButton[] buttonscomidas = new JButton[11];
    String[] stringcomidas={"Tipo Comida","Comida","Evento","Fecha","Salon","Hora","Cantidad","Evento","Fecha","Tipo","Comida","Cantidad","Comida","Tipo","Tipo","Comida"};
    //CAMBIO DE PROPIEDADES A LOS COMPONENTES
    for(int i=0;i<labelscomidas.length;i++){
      labelscomidas[i]= new JLabel(stringcomidas[i]);
      labelscomidas[i].setFont(new java.awt.Font(fontletra, 0, 60));
      labelscomidas[i].setForeground(c2);
    }
    for(int i=0;i<boxscomidas.length;i++){
      if(i==0 || i==7 || i==8){ boxscomidas[i]= new JComboBox(tiposcomida);}
      else{boxscomidas[i]= new JComboBox();}
      boxscomidas[i].setFont(new java.awt.Font(fontletra, 0, 25));
    }
    boxscomidas[4].setEditable(true);
    boxscomidas[5].setEditable(true);
    boxscomidas[5].setVisible(false);
    for(int i=0;i<fieldscomidas.length;i++){
      fieldscomidas[i]= new JTextField();
      fieldscomidas[i].setText("");
      fieldscomidas[i].setFont(new java.awt.Font(fontletra, 0, 25)); 
      fieldscomidas[i].setEnabled(false);
    }
    fieldscomidas[5].setEnabled(true);
    fieldscomidas[6].setEnabled(true);
    String[] stringcomidas1={"Guardar","Agregar","Borrar","Volver Menu","Volver Menu","Volver Menu","Volver Menu","Ver","Modificar","Agregar","Quitar"};   
    for(int i=0;i<buttonscomidas.length;i++){
      buttonscomidas[i]= new JButton(stringcomidas1[i]);
      buttonscomidas[i].setFont(new java.awt.Font(fontletra, 0, 60));
      buttonscomidas[i].setForeground(c2);
      buttonscomidas[i].setBackground(c1);
    } 
    String[] tituloscomidas={"VER", "MODIFICAR","AGREGAR","QUITAR","COMIDAS"};
    JLabel[] titulocomidas= new JLabel[5];
    for(int i =0;i<titulocomidas.length;i++){
      titulocomidas[i]= new JLabel(tituloscomidas[i],SwingConstants.CENTER);
      titulocomidas[i].setFont(new java.awt.Font(fontletra, 0, 120));
      titulocomidas[i].setForeground(c2);
    }
    buttonscomidas[7].setEnabled(usuarioactual.getRes3());
    buttonscomidas[8].setEnabled(usuarioactual.getRes4());
    buttonscomidas[9].setEnabled(usuarioactual.getRes4());
    buttonscomidas[10].setEnabled(usuarioactual.getRes4());
    
    //PANEL VER COMIDAS
    JPanel menucomidaver= new JPanel();
    menucomidaver.setBackground(c);
    GridLayout menucomidaver0 = new GridLayout(9,4);
    menucomidaver.setLayout(menucomidaver0);
    
    menucomidaver.add(new JLabel(""));menucomidaver.add(new JLabel(""));menucomidaver.add(new JLabel(""));menucomidaver.add(new JLabel(""));
    menucomidaver.add(new JLabel("")); menucomidaver.add(labelscomidas[0]); menucomidaver.add(boxscomidas[0]);menucomidaver.add(new JLabel(""));
    menucomidaver.add(new JLabel("")); menucomidaver.add(labelscomidas[1]); menucomidaver.add(boxscomidas[1]);menucomidaver.add(new JLabel(""));
    menucomidaver.add(new JLabel(""));menucomidaver.add(labelscomidas[2]);menucomidaver.add(boxscomidas[2]);menucomidaver.add(new JLabel(""));
    menucomidaver.add(new JLabel(""));menucomidaver.add(labelscomidas[3]);menucomidaver.add(fieldscomidas[0]);menucomidaver.add(new JLabel(""));
    menucomidaver.add(new JLabel(""));menucomidaver.add(labelscomidas[4]);menucomidaver.add(fieldscomidas[1]);menucomidaver.add(new JLabel(""));
    menucomidaver.add(new JLabel("")); menucomidaver.add(labelscomidas[5]);menucomidaver.add(fieldscomidas[2]);menucomidaver.add(new JLabel(""));
    menucomidaver.add(new JLabel(""));menucomidaver.add(labelscomidas[6]);menucomidaver.add(fieldscomidas[3]);menucomidaver.add(new JLabel(""));
    menucomidaver.add(new JLabel("")); menucomidaver.add(new JLabel("")); menucomidaver.add(new JLabel("")); menucomidaver.add(new JLabel(""));
    
    //PANEL MODIFICAR COMIDA
    JPanel menucomidamodificar= new JPanel();
    menucomidamodificar.setBackground(c);
    GridLayout menucomidamodificar0 = new GridLayout(8,4);
    menucomidamodificar.setLayout(menucomidamodificar0);
    
    menucomidamodificar.add(new JLabel(""));menucomidamodificar.add(new JLabel(""));menucomidamodificar.add(new JLabel(""));menucomidamodificar.add(new JLabel(""));
    menucomidamodificar.add(new JLabel(""));menucomidamodificar.add(labelscomidas[7]);menucomidamodificar.add(boxscomidas[3]);menucomidamodificar.add(new JLabel(""));
    menucomidamodificar.add(new JLabel(""));menucomidamodificar.add(labelscomidas[8]);menucomidamodificar.add(fieldscomidas[4]);menucomidamodificar.add(new JLabel(""));
    menucomidamodificar.add(new JLabel(""));menucomidamodificar.add(labelscomidas[9]);menucomidamodificar.add(boxscomidas[6]);menucomidamodificar.add(new JLabel(""));
    menucomidamodificar.add(new JLabel(""));menucomidamodificar.add(labelscomidas[10]);menucomidamodificar.add(boxscomidas[4]);menucomidamodificar.add(boxscomidas[5]);
    menucomidamodificar.add(new JLabel(""));menucomidamodificar.add(labelscomidas[11]);menucomidamodificar.add(fieldscomidas[5]);menucomidamodificar.add(new JLabel(""));
    menucomidamodificar.add(new JLabel(""));menucomidamodificar.add(new JLabel(""));menucomidamodificar.add(buttonscomidas[0]);menucomidamodificar.add(new JLabel(""));
    menucomidamodificar.add(new JLabel(""));menucomidamodificar.add(new JLabel(""));menucomidamodificar.add(new JLabel(""));menucomidamodificar.add(new JLabel(""));
    
    //COMIDA AGREGAR PANEL
    JPanel menucomidaagregar= new JPanel();
    menucomidaagregar.setBackground(c);
    GridLayout menucomidaagregar0 = new GridLayout(5,4);
    menucomidaagregar.setLayout(menucomidaagregar0);
    menucomidaagregar.add(new JLabel(""));menucomidaagregar.add(new JLabel(""));menucomidaagregar.add(new JLabel(""));menucomidaagregar.add(new JLabel(""));
    menucomidaagregar.add(new JLabel("")); menucomidaagregar.add(labelscomidas[13]); menucomidaagregar.add(boxscomidas[7]);menucomidaagregar.add(new JLabel(""));
    menucomidaagregar.add(new JLabel(""));menucomidaagregar.add(labelscomidas[12]);menucomidaagregar.add(fieldscomidas[6]);menucomidaagregar.add(new JLabel(""));
    menucomidaagregar.add(new JLabel(""));menucomidaagregar.add(new JLabel(""));menucomidaagregar.add(buttonscomidas[1]);menucomidaagregar.add(new JLabel(""));
    menucomidaagregar.add(new JLabel(""));menucomidaagregar.add(new JLabel(""));menucomidaagregar.add(new JLabel(""));menucomidaagregar.add(new JLabel(""));
    
    //COMIDA BORRAR PANEL
    JPanel menucomidaquitar= new JPanel();
    menucomidaquitar.setBackground(c);
    GridLayout menucomidaquitar0 = new GridLayout(5,4);
    menucomidaquitar.setLayout(menucomidaquitar0);
    menucomidaquitar.add(new JLabel("")); menucomidaquitar.add(new JLabel("")); menucomidaquitar.add(new JLabel("")); menucomidaquitar.add(new JLabel(""));
    menucomidaquitar.add(new JLabel(""));menucomidaquitar.add(labelscomidas[14]); menucomidaquitar.add(boxscomidas[8]); menucomidaquitar.add(new JLabel(""));
    menucomidaquitar.add(new JLabel("")); menucomidaquitar.add(labelscomidas[15]); menucomidaquitar.add(boxscomidas[9]); menucomidaquitar.add(new JLabel(""));
    menucomidaquitar.add(new JLabel("")); menucomidaquitar.add(new JLabel(""));menucomidaquitar.add(buttonscomidas[2]); menucomidaquitar.add(new JLabel(""));
    menucomidaquitar.add(new JLabel("")); menucomidaquitar.add(new JLabel("")); menucomidaquitar.add(new JLabel("")); menucomidaquitar.add(new JLabel(""));  
    //ACTION LISTENERS VER COMIDAS
                //PONE LOS ITEMS EN EUN JCOMOBOX DEPENDIENDO EL OTRO JCOMBOBOX
    boxscomidas[0].addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        boxscomidas[1].removeAllItems();
        if(boxscomidas[0].getSelectedItem()!= null && boxscomidas[0].getSelectedItem().equals("Primer T.")){
          for(int x=0;x<comidas.length;x++){
            if(comidas[x]!=null){
              boxscomidas[1].addItem(comidas[x]);}}
        }
        
        
        if(boxscomidas[0].getSelectedItem()!= null && boxscomidas[0].getSelectedItem().equals("Plato F.")){
          for(int x=0;x<comidas1.length;x++){
            if(comidas1[x]!=null){
              boxscomidas[1].addItem(comidas1[x]);}}
        }
        if(boxscomidas[0].getSelectedItem()!= null && boxscomidas[0].getSelectedItem().equals("Guarnicion")){
          for(int x=0;x<comidas2.length;x++){
            if(comidas2[x]!=null){
              boxscomidas[1].addItem(comidas2[x]);}}
        }
        if(boxscomidas[0].getSelectedItem()!= null && boxscomidas[0].getSelectedItem().equals("Tercer T.")){
          for(int x=0;x<comidas3.length;x++){
            if(comidas3[x]!=null){
              boxscomidas[1].addItem(comidas3[x]);}}
        }
        if(boxscomidas[0].getSelectedItem()!= null && boxscomidas[0].getSelectedItem().equals("Niños")){
          for(int x=0;x<comidas4.length;x++){
            if(comidas4[x]!=null){
              boxscomidas[1].addItem(comidas4[x]);}}
        }
        
      }});
    //PONER LOS ITEMS CORRESPONDIENTES EN UN JCOMBOBOX DEPENDIENDO UN JCOMBOBOX
    boxscomidas[1].addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        boxscomidas[2].removeAllItems();
        fieldscomidas[3].setText("");
        fieldscomidas[2].setText("");
        fieldscomidas[1].setText("");
        fieldscomidas[0].setText("");
        for(int x=0; x<eventos.length;x++){
          if(eventos[x]!=null && boxscomidas[1].getSelectedItem()!=null)
            if((eventos[x].getPrimerT()).equals(boxscomidas[1].getSelectedItem())||(eventos[x].getSegundoT1()).equals(boxscomidas[1].getSelectedItem())||(eventos[x].getComidaNiño()).equals(boxscomidas[1].getSelectedItem())||(eventos[x].getSegundoT2()).equals(boxscomidas[1].getSelectedItem())||(eventos[x].getSegundoT3()).equals(boxscomidas[1].getSelectedItem())||(eventos[x].getTercerT()).equals(boxscomidas[1].getSelectedItem())){
            boxscomidas[2].addItem(eventos[x].getNombre());
          }
        }
      }});
    //PONER LOS DATOS CORRESPONDIENTES EN LOS JTEXTFIELDS DEPENDEINDO EL JCOMBOBOX
    boxscomidas[2].addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        for(int x=0; x<eventos.length;x++){
          if(eventos[x]!=null && boxscomidas[2].getSelectedItem()!=null)
            if((eventos[x].getNombre()).equals(boxscomidas[2].getSelectedItem())){
            
            fieldscomidas[3].setText(String.valueOf(eventos[x].getCantidadAdt()));
            fieldscomidas[2].setText(eventos[x].getHoraInicial());
            fieldscomidas[1].setText(eventos[x].getSalon());
            fieldscomidas[0].setText(eventos[x].getFecha());
          }}
      }});
    
    //ACTION LISTENERS COMIDA MODIFICAR 
        //SE LLENA UN JCOMOBOX DEPENDIENDO OTRO
    boxscomidas[6].addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        boxscomidas[4].removeAllItems();
        boxscomidas[5].setVisible(false);
        if(boxscomidas[6].getSelectedItem()!= null && boxscomidas[6].getSelectedItem().equals("Primer T.")){
          for(int x=0;x<comidas.length;x++){
            if(comidas[x]!=null){
              boxscomidas[4].addItem(comidas[x]);}}
        }
        
        
        if(boxscomidas[6].getSelectedItem()!= null && boxscomidas[6].getSelectedItem().equals("Plato F.")){
          for(int x=0;x<comidas1.length;x++){
            if(comidas1[x]!=null){
              boxscomidas[4].addItem(comidas1[x]);}}
        }
        if(boxscomidas[6].getSelectedItem()!= null && boxscomidas[6].getSelectedItem().equals("Guarnicion")){
          for(int x=0;x<comidas2.length;x++){
            if(comidas2[x]!=null){
              boxscomidas[4].addItem(comidas2[x]);
              boxscomidas[5].addItem(comidas2[x]);
              boxscomidas[5].setVisible(true);
            }}
        }
        if(boxscomidas[6].getSelectedItem()!= null && boxscomidas[6].getSelectedItem().equals("Tercer T.")){
          for(int x=0;x<comidas3.length;x++){
            if(comidas3[x]!=null){
              boxscomidas[4].addItem(comidas3[x]);}}
        }
        if(boxscomidas[6].getSelectedItem()!= null && boxscomidas[6].getSelectedItem().equals("Niños")){
          for(int x=0;x<comidas4.length;x++){
            if(comidas4[x]!=null){
              boxscomidas[4].addItem(comidas4[x]);}}
        }
        
        if(boxscomidas[6].getSelectedItem()!= null && boxscomidas[6].getSelectedItem().equals("Primer T.")){
          for(int x=0;x<eventos.length;x++){
            if(eventos[x]!=null){
              if(((String)boxscomidas[3].getSelectedItem()).equals(eventos[x].getNombre()))
                boxscomidas[4].setSelectedItem(eventos[x].getPrimerT());}}
        }
        
        
        if(boxscomidas[6].getSelectedItem()!= null && boxscomidas[6].getSelectedItem().equals("Plato F.")){
          for(int x=0;x<eventos.length;x++){
            if(eventos[x]!=null){
              if(((String)boxscomidas[3].getSelectedItem()).equals(eventos[x].getNombre()))
                boxscomidas[4].setSelectedItem(eventos[x].getSegundoT1());}}
        }
        if(boxscomidas[6].getSelectedItem()!= null && boxscomidas[6].getSelectedItem().equals("Guarnicion")){
          
          for(int x=0;x<eventos.length;x++){
            if(eventos[x]!=null){
              if(((String)boxscomidas[3].getSelectedItem()).equals(eventos[x].getNombre())){
                boxscomidas[4].setSelectedItem(eventos[x].getSegundoT2());
                boxscomidas[5].setSelectedItem(eventos[x].getSegundoT3());}
            }}
        }
        
        if(boxscomidas[6].getSelectedItem()!= null && boxscomidas[6].getSelectedItem().equals("Tercer T.")){
          for(int x=0;x<eventos.length;x++){
            if(eventos[x]!=null){
              if(((String)boxscomidas[3].getSelectedItem()).equals(eventos[x].getNombre()))
                boxscomidas[4].setSelectedItem(eventos[x].getTercerT());}}
        }
        if(boxscomidas[6].getSelectedItem()!= null && boxscomidas[6].getSelectedItem().equals("Niños")){
          for(int x=0;x<eventos.length;x++){
            if(eventos[x]!=null){
              if(((String)boxscomidas[3].getSelectedItem()).equals(eventos[x].getNombre()))
                boxscomidas[4].setSelectedItem(eventos[x].getComidaNiño());}}
        }
      }});
    
    //SE AJUSTA LA INFORMACION EN UN JCOMBOX Y EN UN JTEXTFIELD DEPENDIENDO UN JCOMBOBOX
    boxscomidas[4].addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        boxscomidas[2].removeAllItems();
        
        for(int x=0; x<eventos.length;x++){
          if(eventos[x]!=null && boxscomidas[4].getSelectedItem()!=null)
            if(!boxscomidas[4].getSelectedItem().equals(""))
            if((eventos[x].getPrimerT()).equals(boxscomidas[4].getSelectedItem())||(eventos[x].getSegundoT1()).equals(boxscomidas[4].getSelectedItem())||(eventos[x].getComidaNiño()).equals(boxscomidas[4].getSelectedItem())||(eventos[x].getSegundoT2()).equals(boxscomidas[4].getSelectedItem())||(eventos[x].getSegundoT3()).equals(boxscomidas[4].getSelectedItem())||(eventos[x].getTercerT()).equals(boxscomidas[4].getSelectedItem())){
            boxscomidas[2].addItem(eventos[x].getNombre());
          }
        }
        if(boxscomidas[4].getSelectedItem()==null){fieldscomidas[5].setText("0");}
        else{
          for(int x=0;x<eventos.length;x++){
            if(eventos[x]!=null && boxscomidas[4].getSelectedItem()!=null && boxscomidas[6].getSelectedItem()!=null){
              if(eventos[x].getNombre().equals(boxscomidas[3].getSelectedItem())){
                if(boxscomidas[6].getSelectedItem().equals("Niños")){ fieldscomidas[5].setText((String.valueOf(eventos[x].getCantidadNiño())));}
                else{fieldscomidas[5].setText(String.valueOf(eventos[x].getCantidadAdt()));}
              }}}}
      }});
    //SE AJUSTAN LOS DATOS DE FECHA EN UN JTEXTFIELD DEPENDIENDO EL JCOMBOBOX DEL EVENTOS Y SE AJUSTAN LOS TIPOS DE COMIDAS EN UN JCOMBOX
    boxscomidas[3].addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        fieldscomidas[4].setText("");
        boxscomidas[6].removeAllItems();
        boxscomidas[5].setVisible(false);
        boxscomidas[4].setSelectedItem("");
        for(int x=0;x<eventos.length;x++){
          if(eventos[x]!=null && boxscomidas[3].getSelectedItem()!=null){   
            if(boxscomidas[3].getSelectedItem().equals(eventos[x].getNombre())){
              fieldscomidas[4].setText(eventos[x].getFecha());   
            }}}
        if(boxscomidas[3].getSelectedItem()!=null){
          for(int x=0;x<tiposcomida.length;x++){
            boxscomidas[6].addItem(tiposcomida[x]);
          }
        }
        
      }});
    //METODO QUE GUARDA TODOS LOS DATOS
    buttonscomidas[0].addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        try{      
          
          if(boxscomidas[3].getSelectedItem()!=null && !fieldscomidas[4].getText().equals("") && boxscomidas[6].getSelectedItem()!=null && boxscomidas[4].getSelectedItem()!=null  && !fieldscomidas[5].getText().equals("")){
            for(int x=0;x<eventos.length;x++){
              if(eventos[x]!=null){
                if(eventos[x].getNombre().equals(boxscomidas[3].getSelectedItem()) && eventos[x].getFecha().equals(fieldscomidas[4].getText())){
                  if(boxscomidas[6].getSelectedItem().equals("Niños")){
                    eventos[x].setComidaNiño((String)boxscomidas[4].getSelectedItem());
                    eventos[x].setCantidadNiño(Integer.parseInt(fieldscomidas[5].getText()));
                    boxscomidas[3].setSelectedItem("");
                  }
                  if(boxscomidas[6].getSelectedItem().equals("Tercer T.")){
                    eventos[x].setTercerT((String)boxscomidas[4].getSelectedItem());
                    eventos[x].setCantidadAdt(Integer.parseInt(fieldscomidas[5].getText()));
                    boxscomidas[3].setSelectedItem("");}
                  if(boxscomidas[6].getSelectedItem().equals("Guarnicion")){
                    if (boxscomidas[5].getSelectedItem()==null){alerta1("Error,revise las casillas");}
                    else{eventos[x].setSegundoT3((String)boxscomidas[5].getSelectedItem());
                      eventos[x].setSegundoT2((String)boxscomidas[4].getSelectedItem());
                      eventos[x].setCantidadAdt(Integer.parseInt(fieldscomidas[5].getText()));
                      boxscomidas[3].setSelectedItem("");}}
                  if(((String)boxscomidas[6].getSelectedItem()).equals("Plato F.")){
                    eventos[x].setSegundoT1((String)boxscomidas[4].getSelectedItem());
                    eventos[x].setCantidadAdt(Integer.parseInt(fieldscomidas[5].getText()));
                    boxscomidas[3].setSelectedItem("");}
                  if(((String)boxscomidas[6].getSelectedItem()).equals("Primer T.")){
                    eventos[x].setPrimerT((String)boxscomidas[4].getSelectedItem());
                    eventos[x].setCantidadAdt(Integer.parseInt(fieldscomidas[5].getText()));
                    boxscomidas[3].setSelectedItem("");}
                }
              }
              
            }
          }else{alerta1("Error,revise las casillas");} guardarEventos(); //SE LLAMA AL METODO QUE GUARDA
        }catch(Exception c){alerta1("Error,revise las casillas");}
      }});
    
//ACTION LISTENERS COMIDA AGREGAR
    //AGREGA UNA COMIDA AL ARREGLO
    buttonscomidas[1].addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        if(!fieldscomidas[6].getText().equals("")){
          if(boxscomidas[7].getSelectedItem().equals("Niños")){
            for(int x=0;x<comidas4.length;x++){
              if(comidas4[x]==null){
                comidas4[x]=fieldscomidas[6].getText();
                x=comidas4.length;
              }
            }
          }
          if(boxscomidas[7].getSelectedItem().equals("Tercer T.")){
            for(int x=0;x<comidas3.length;x++){
              if(comidas3[x]==null){
                comidas3[x]=fieldscomidas[6].getText();
                x=comidas3.length;
              }
            }
          }                     
          
          if(boxscomidas[7].getSelectedItem().equals("Guarnicion")){
            for(int x=0;x<comidas2.length;x++){
              if(comidas2[x]==null){
                comidas2[x]=fieldscomidas[6].getText();
                x=comidas2.length;
              }
            }
          }                        
          
          if(((String)boxscomidas[7].getSelectedItem()).equals("Plato F.")){
            for(int x=0;x<comidas1.length;x++){
              if(comidas1[x]==null){
                comidas1[x]=fieldscomidas[6].getText();
                x=comidas1.length;
              }
            }
          }
          if(((String)boxscomidas[7].getSelectedItem()).equals("Primer T.")){
            for(int x=0;x<comidas1.length;x++){
              if(comidas[x]==null){
                comidas[x]=fieldscomidas[6].getText();
                x=comidas.length;
              }
            }
          }
          fieldscomidas[6].setText("");
        }
        
        else{alerta1("Error,revise las casillas");}  guardarComidas(); //SE LLAMA EL METODO DE GUARDAR COMIDAS
      }});
    
    //ACTION LISTENERS MENU COMIDA QUITAR
    //AJUSTA LOS ITEMS EN UN JCOMBOBOX DEPENDIENDO DE UN JCOMBOBOX
    boxscomidas[8].addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        boxscomidas[9].removeAllItems();
        if(boxscomidas[8].getSelectedItem().equals("Niños")){
          for(int x=0;x<comidas4.length;x++){
            if(comidas4[x]!=null){
              boxscomidas[9].addItem(comidas4[x]);
            }
          }
        }
        if(boxscomidas[8].getSelectedItem().equals("Tercer T.")){
          for(int x=0;x<comidas3.length;x++){
            if(comidas3[x]!=null){
              boxscomidas[9].addItem(comidas3[x]);
            }
          }
        }                     
        
        if(boxscomidas[8].getSelectedItem().equals("Guarnicion")){
          for(int x=0;x<comidas2.length;x++){
            if(comidas2[x]!=null){
              boxscomidas[9].addItem(comidas2[x]);
            }
          }
        }                        
        
        if(((String)boxscomidas[8].getSelectedItem()).equals("Plato F.")){
          for(int x=0;x<comidas1.length;x++){
            if(comidas1[x]!=null){
              boxscomidas[9].addItem(comidas1[x]);
            }
          }
        }
        if(((String)boxscomidas[8].getSelectedItem()).equals("Primer T.")){
          for(int x=0;x<comidas1.length;x++){
            if(comidas[x]!=null){
              boxscomidas[9].addItem(comidas[x]);
            }
          }
        }                                   
      }});
    //BORRA LA COMIDA Y GUARDA LOS CAMBIOS
    buttonscomidas[2].addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        if(boxscomidas[9].getSelectedItem()!=null){
          if(boxscomidas[8].getSelectedItem().equals("Niños")){
            for(int x=0;x<comidas4.length;x++){
              if(comidas4[x]!=null){
                if(comidas4[x].equals(boxscomidas[9].getSelectedItem())){
                  comidas4[x]=null;
                }
              }
            }
          }
          if(boxscomidas[8].getSelectedItem().equals("Tercer T.")){
            for(int x=0;x<comidas3.length;x++){
              if(comidas3[x]!=null){
                if(comidas3[x].equals(boxscomidas[9].getSelectedItem())){
                  comidas3[x]=null;
                }
              }
            }
          }                  
          
          if(boxscomidas[8].getSelectedItem().equals("Guarnicion")){
            for(int x=0;x<comidas2.length;x++){
              if(comidas2[x]!=null){
                if(comidas2[x].equals(boxscomidas[9].getSelectedItem())){
                  comidas2[x]=null;
                }
              }
            }
          }                        
          
          if(((String)boxscomidas[8].getSelectedItem()).equals("Plato F.")){
            for(int x=0;x<comidas1.length;x++){
              if(comidas1[x]!=null){
                if(comidas1[x].equals(boxscomidas[9].getSelectedItem())){
                  comidas1[x]=null;
                }
              }
            }
          }
          if(((String)boxscomidas[8].getSelectedItem()).equals("Primer T.")){
            for(int x=0;x<comidas.length;x++){
              if(comidas[x]!=null){
                if(comidas[x].equals(boxscomidas[9].getSelectedItem())){
                  comidas[x]=null;
                }
              }
            }
          }
        }    
        
        else{alerta1("Error,revise las casillas");} 
        boxscomidas[8].setSelectedIndex(0);
        guardarComidas(); //SE LLAMA EL METODO QUE GUARDA LAS COMIDAS
      }});
    //SE DECLARAN LOS PANELES
    JPanel main2= new JPanel();
    main2.setBackground(c);
    main2.setLayout(new BorderLayout()); 
    main2.add(menucomidaver);   
    main2.add(titulocomidas[0], BorderLayout.NORTH);   
    main2.add(buttonscomidas[3], BorderLayout.SOUTH);
    
    JPanel main4= new JPanel(new BorderLayout());
    main4.setBackground(c);
    main4.add(titulocomidas[1], BorderLayout.NORTH);
    main4.add(menucomidamodificar);
    main4.add(buttonscomidas[4], BorderLayout.SOUTH);
    
    JPanel main5= new JPanel(new BorderLayout());
    main5.setBackground(c);
    main5.add(titulocomidas[2], BorderLayout.NORTH);
    main5.add(menucomidaagregar);
    main5.add(buttonscomidas[5], BorderLayout.SOUTH);
    
    JPanel main6= new JPanel(new BorderLayout());
    main6.setBackground(c);
    main6.add(titulocomidas[3], BorderLayout.NORTH);
    main6.add(menucomidaquitar);
    main6.add(buttonscomidas[6], BorderLayout.SOUTH);
    
    JPanel comidamenu= new JPanel(new GridLayout(6,3));
    comidamenu.setBackground(c);
    comidamenu.add(new JLabel("")); comidamenu.add(new JLabel("")); comidamenu.add(new JLabel(""));
    comidamenu.add(new JLabel(""));comidamenu.add(buttonscomidas[7]); comidamenu.add(new JLabel(""));
    comidamenu.add(new JLabel(""));comidamenu.add(buttonscomidas[8]); comidamenu.add(new JLabel(""));
    comidamenu.add(new JLabel(""));comidamenu.add(buttonscomidas[9]); comidamenu.add(new JLabel(""));
    comidamenu.add(new JLabel(""));comidamenu.add(buttonscomidas[10]); comidamenu.add(new JLabel(""));
    comidamenu.add(new JLabel("")); comidamenu.add(new JLabel("")); comidamenu.add(new JLabel(""));
    
    JPanel main3= new JPanel(new BorderLayout());
    main3.setBackground(c);
    main3.add(titulocomidas[4], BorderLayout.NORTH);
    main3.add(comidamenu);
    
    
//CONTRATOS     
    //PANEL CONTRATOS PRINCIPAL
    
    
    JPanel contratosmenu= new JPanel();
    contratosmenu.setBackground(c);
    JLabel contratostitulo = new JLabel("CONTRATOS",SwingConstants.CENTER);
    contratostitulo.setFont(new java.awt.Font(fontletra, 0, 120));
    contratostitulo.setForeground(c2);
    GridLayout contratosmenu0 = new GridLayout(5,3);
    contratosmenu.setLayout(contratosmenu0); 
    JButton contratosmenu1= new JButton("Buscar");
    contratosmenu1.setFont(new java.awt.Font(fontletra, 0, 60));
    contratosmenu1.setForeground(c2);
    contratosmenu1.setBackground(c1);
    contratosmenu1.setEnabled(usuarioactual.getRes1());
    
    JButton contratosmenu3= new JButton("Agregar");
    contratosmenu3.setFont(new java.awt.Font(fontletra, 0, 60));
    contratosmenu3.setForeground(c2);
    contratosmenu3.setBackground(c1);
    contratosmenu3.setEnabled(usuarioactual.getRes2());
    
    JButton contratosmenu4= new JButton("Tabla");
    contratosmenu4.setFont(new java.awt.Font(fontletra, 0, 60));
    contratosmenu4.setForeground(c2);
    contratosmenu4.setBackground(c1);
    contratosmenu4.setEnabled(usuarioactual.getRes1());
    
    contratosmenu.add(new JLabel("")); contratosmenu.add(new JLabel("")); contratosmenu.add(new JLabel(""));
    contratosmenu.add(new JLabel(""));contratosmenu.add(contratosmenu1); contratosmenu.add(new JLabel(""));
    contratosmenu.add(new JLabel(""));contratosmenu.add(contratosmenu3); contratosmenu.add(new JLabel(""));
    contratosmenu.add(new JLabel(""));contratosmenu.add(contratosmenu4); contratosmenu.add(new JLabel(""));
    contratosmenu.add(new JLabel("")); contratosmenu.add(new JLabel("")); contratosmenu.add(new JLabel(""));
    JPanel main7= new JPanel();
    main7.setBackground(c);
    main7.setLayout(new BorderLayout());
    main7.add(contratostitulo, BorderLayout.NORTH);
    main7.add(contratosmenu);
    
    //PANEL CONTRATOS AGREGAR
    //INICIALIZACION DE COMPONENTES 
    JLabel[] labelscontratos= new JLabel[23];
    JComboBox[] boxscontratos = new JComboBox[10];
    JTextField[] fieldscontratos = new JTextField[12];
    JButton[] buttonscontratos = new JButton[2];
    String[] titulocontratos0={"Cliente:","Apellido:","Correo:","RFC:","Direccion:","Telefono:","Referente:","Telefono:","Evento:","Fecha:","Primer T.:","Plato F.:","Guarnicion:","Guarnicion 2:","Tercer T.:","Cantidad:","Comida Niños:","Cantidad:","Hora Inicio:","Hora final:","Salón:","Descuento:","Total:"};
    for(int i=0;i<labelscontratos.length;i++){
      labelscontratos[i]= new JLabel(titulocontratos0[i]);
      labelscontratos[i].setFont(new java.awt.Font(fontletra, 0, 30));
      labelscontratos[i].setForeground(c2);
    }
    for(int i=0;i<fieldscontratos.length;i++){
      fieldscontratos[i]= new JTextField();
      fieldscontratos[i].setFont(new java.awt.Font(fontletra, 0, 25)); 
    }
    fieldscontratos[9].setText("0");    
    fieldscontratos[10].setText("0");
    for(int i=0;i<boxscontratos.length;i++){
      if(i==6||i==7){boxscontratos[i]= new JComboBox(horas);}
      else{boxscontratos[i]= new JComboBox();}
      boxscontratos[i].setFont(new java.awt.Font(fontletra, 0, 25)); 
    }
    String[] descuentos={"0",".10",".20",".30",".40",".50",".60",".70",".80",".90","1"};
    boxscontratos[9].setModel(new DefaultComboBoxModel(descuentos));
    String[] titulocontratos1={"Calcular","Guardar"};   
    for(int i=0;i<buttonscontratos.length;i++){
      buttonscontratos[i]= new JButton(titulocontratos1[i]);
      buttonscontratos[i].setFont(new java.awt.Font(fontletra, 0, 40));
      buttonscontratos[i].setForeground(c2);
      buttonscontratos[i].setBackground(c1);
    } 
    JDatePickerImpl contratos13 = new JDatePickerImpl(datePanel, formatter); 
    contratos13.setFont(new java.awt.Font(fontletra, 0, 40));   
    JCheckBox contratos26 = new JCheckBox("Musica");
    contratos26.setFont(new java.awt.Font(fontletra, 0, 40));
    contratos26.setForeground(c2);
    contratos26.setBackground(c);
    JCheckBox contratos43 = new JCheckBox("Arreglos");
    contratos43.setFont(new java.awt.Font(fontletra, 0, 40));
    contratos43.setForeground(c2);
    contratos43.setBackground(c);
    boxscontratos[8].addItem("1");
    boxscontratos[8].addItem("2");
    
    //ACTION LISTENERS AGREGAR CONTRATOS 
    //CALCULA EL PRECIO-TOTAL DEL EVENTO 
    buttonscontratos[0].addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        try{
          int subtotal=0;
          if(contratos26.isSelected()){
            subtotal+=2000;
          }
          if(contratos43.isSelected()){
            subtotal+=1000;
          }
          fieldscontratos[11].setText(String.valueOf(subtotal+(Integer.parseInt(fieldscontratos[9].getText())*250+Integer.parseInt(fieldscontratos[10].getText())*200+10000)*(1-Double.parseDouble((String)boxscontratos[9].getSelectedItem()))));
        }
        catch(Exception c){alerta1("Error,revise las casillas de cantidad y descuento");System.out.println(c);}
      }});
    //SE CREA EL EVENTO Y SE GUARDA
    buttonscontratos[1].addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        int casilla=-1;
        for(int x=0;x<eventos.length;x++){if(eventos[x]==null){casilla=x; x=eventos.length;}}
        try{
          eventos[casilla]=new Evento((fieldscontratos[0].getText()),(fieldscontratos[1].getText()),fieldscontratos[3].getText(),(fieldscontratos[5].getText()),(fieldscontratos[4].getText()),(fieldscontratos[2].getText()),(fieldscontratos[6].getText()),(fieldscontratos[7].getText()), (fieldscontratos[8].getText()),(contratos13.getJFormattedTextField().getText()),((String)boxscontratos[0].getSelectedItem()),((String)boxscontratos[1].getSelectedItem()),((String)boxscontratos[2].getSelectedItem()),((String)boxscontratos[3].getSelectedItem()),((String)boxscontratos[4].getSelectedItem()),( Integer.parseInt(fieldscontratos[9].getText())),((String)boxscontratos[5].getSelectedItem()),(Integer.parseInt(fieldscontratos[10].getText())),((String)boxscontratos[6].getSelectedItem()),((String)boxscontratos[7].getSelectedItem()),((String)boxscontratos[8].getSelectedItem()),contratos26.isSelected(),contratos43.isSelected(),(int)(Double.parseDouble(fieldscontratos[11].getText())),"nada",(String)boxscontratos[9].getSelectedItem());
          fieldscontratos[0].setText("");fieldscontratos[1].setText("");fieldscontratos[3].setText("");fieldscontratos[5].setText("");fieldscontratos[4].setText("");fieldscontratos[2].setText("");fieldscontratos[6].setText("");fieldscontratos[7].setText(""); fieldscontratos[8].setText("");boxscontratos[0].setSelectedIndex(0);boxscontratos[1].setSelectedIndex(0);boxscontratos[2].setSelectedIndex(0);boxscontratos[3].setSelectedIndex(0);boxscontratos[4].setSelectedIndex(0);fieldscontratos[9].setText("");boxscontratos[5].setSelectedIndex(0);fieldscontratos[10].setText("");boxscontratos[6].setSelectedIndex(0);boxscontratos[7].setSelectedIndex(0);boxscontratos[8].setSelectedIndex(0);fieldscontratos[11].setText("");
          guardarEventos();     
        }
        catch(Exception c){alerta1("Error,revise las casillas");}
      }});
    //SE CREA E INICIALIZA EL PANEL
    JPanel contratos1 = new JPanel();
    contratos1.setBackground(c);
    GridLayout contratos = new GridLayout(15,6);
    contratos1.setLayout(contratos); 
    contratos1.add(new JLabel(""));contratos1.add(new JLabel(""));contratos1.add(new JLabel(""));contratos1.add(new JLabel(""));contratos1.add(new JLabel(""));contratos1.add(new JLabel(""));
    contratos1.add(new JLabel(""));contratos1.add(labelscontratos[0]);contratos1.add(fieldscontratos[0]);contratos1.add(labelscontratos[1]);contratos1.add(fieldscontratos[1]);contratos1.add(new JLabel(""));
    contratos1.add(new JLabel(""));contratos1.add(labelscontratos[2]);contratos1.add(fieldscontratos[2]);contratos1.add(labelscontratos[5]);contratos1.add(fieldscontratos[5]);contratos1.add(new JLabel(""));
    contratos1.add(new JLabel(""));contratos1.add(labelscontratos[3]);contratos1.add(fieldscontratos[3]);contratos1.add(labelscontratos[4]);contratos1.add(fieldscontratos[4]);contratos1.add(new JLabel(""));
    contratos1.add(new JLabel(""));contratos1.add(labelscontratos[6]);contratos1.add(fieldscontratos[6]); contratos1.add(labelscontratos[7]);contratos1.add(fieldscontratos[7]);contratos1.add(new JLabel(""));
    contratos1.add(new JLabel(""));contratos1.add(labelscontratos[8]);contratos1.add(fieldscontratos[8]);contratos1.add(labelscontratos[9]);contratos1.add(contratos13);contratos1.add(new JLabel(""));
    contratos1.add(new JLabel(""));contratos1.add(labelscontratos[10]);contratos1.add(boxscontratos[0]); contratos1.add(labelscontratos[11]);contratos1.add(boxscontratos[1]);contratos1.add(new JLabel(""));
    contratos1.add(new JLabel(""));contratos1.add(labelscontratos[12]);contratos1.add(boxscontratos[2]); contratos1.add(labelscontratos[13]);contratos1.add(boxscontratos[3]);contratos1.add(new JLabel(""));
    contratos1.add(new JLabel(""));contratos1.add(labelscontratos[14]);contratos1.add(boxscontratos[4]); contratos1.add(labelscontratos[15]);contratos1.add(fieldscontratos[9]);contratos1.add(new JLabel(""));
    contratos1.add(new JLabel(""));contratos1.add(labelscontratos[16]);contratos1.add(boxscontratos[5]);contratos1.add(labelscontratos[17]); contratos1.add(fieldscontratos[10]);contratos1.add(new JLabel(""));
    contratos1.add(new JLabel(""));contratos1.add(labelscontratos[18]);contratos1.add(boxscontratos[6]); contratos1.add(labelscontratos[19]);contratos1.add(boxscontratos[7]);contratos1.add(new JLabel(""));
    contratos1.add(new JLabel(""));contratos1.add(labelscontratos[20]);contratos1.add(boxscontratos[8]);contratos1.add(contratos26);contratos1.add(contratos43);contratos1.add(new JLabel(""));
    contratos1.add(new JLabel(""));contratos1.add(labelscontratos[21]);contratos1.add(boxscontratos[9]);contratos1.add(labelscontratos[22]);contratos1.add(fieldscontratos[11]);contratos1.add(new JLabel(""));
    contratos1.add(new JLabel(""));contratos1.add(buttonscontratos[0]);contratos1.add(new JLabel(""));contratos1.add(new JLabel(""));contratos1.add(buttonscontratos[1]);contratos1.add(new JLabel(""));
    contratos1.add(new JLabel(""));contratos1.add(new JLabel(""));contratos1.add(new JLabel(""));contratos1.add(new JLabel(""));contratos1.add(new JLabel(""));contratos1.add(new JLabel(""));
    
    JLabel contratos0 = new JLabel("CONTRATOS",SwingConstants.CENTER);
    contratos0.setFont(new java.awt.Font(fontletra, 0, 60));
    contratos0.setForeground(c2);
    JButton volvermenucontratos0 = new JButton("Volver Menu");
    volvermenucontratos0.setFont(new java.awt.Font(fontletra, 0, 60));
    volvermenucontratos0.setForeground(c2);
    volvermenucontratos0.setBackground(c1);
    JPanel main= new JPanel();
    main.setBackground(c);
    main.setLayout(new BorderLayout());
    main.add(contratos0, BorderLayout.NORTH);
    main.add(contratos1);
    main.add(volvermenucontratos0, BorderLayout.SOUTH);
    
//PANEL BUSCAR POR
   //SE CREA E INCIALIZAN COMPONENTES Y PANEL 
    JPanel contratosmenu5= new JPanel();
    contratosmenu5.setBackground(c);
    JLabel contratostitulo0 = new JLabel("BUSCAR CONTRATOS POR:",SwingConstants.CENTER);
    contratostitulo0.setFont(new java.awt.Font(fontletra, 0, 70));
    contratostitulo0.setForeground(c2);
    GridLayout contratosmenu6 = new GridLayout(5,5);
    contratosmenu5.setLayout(contratosmenu6); 
    JLabel contratosmenu7= new JLabel("Fecha");
    contratosmenu7.setFont(new java.awt.Font(fontletra, 0, 60));
    contratosmenu7.setForeground(c2); 
    JComboBox contratosmenu10 = new JComboBox();
    contratosmenu10.setFont(new java.awt.Font(fontletra, 0, 30));
    
    JButton contratosmenu13 = new JButton("Buscar");
    contratosmenu13.setFont(new java.awt.Font(fontletra, 0, 60));
    contratosmenu13.setForeground(c2);
    contratosmenu13.setBackground(c1);
    
    JLabel contratosmenu8 =new JLabel("Nombre");
    contratosmenu8.setFont(new java.awt.Font(fontletra, 0, 60));
    contratosmenu8.setForeground(c2);
    
    JButton contratosmenu14 = new JButton("Buscar");
    contratosmenu14.setFont(new java.awt.Font(fontletra, 0, 60));
    contratosmenu14.setForeground(c2);
    contratosmenu14.setBackground(c1);
    JComboBox contratosmenu11 = new JComboBox();
    contratosmenu11.setFont(new java.awt.Font(fontletra, 0, 30));
    
    
    JLabel contratosmenu9= new JLabel("Cliente");
    contratosmenu9.setFont(new java.awt.Font(fontletra, 0, 60));
    contratosmenu9.setForeground(c2); 
    JComboBox contratosmenu12 = new JComboBox();
    contratosmenu12.setFont(new java.awt.Font(fontletra, 0, 30));
    JButton contratosmenu15 = new JButton("Buscar");
    contratosmenu15.setFont(new java.awt.Font(fontletra, 0, 60));
    contratosmenu15.setForeground(c2);
    contratosmenu15.setBackground(c1);
    
    contratosmenu5.add(new JLabel("")); contratosmenu5.add(new JLabel("")); contratosmenu5.add(new JLabel("")); contratosmenu5.add(new JLabel(""));contratosmenu5.add(new JLabel(""));
    contratosmenu5.add(new JLabel(""));contratosmenu5.add(contratosmenu7);contratosmenu5.add(contratosmenu10); contratosmenu5.add(contratosmenu13); contratosmenu5.add(new JLabel(""));
    contratosmenu5.add(new JLabel(""));contratosmenu5.add(contratosmenu8);contratosmenu5.add(contratosmenu11);contratosmenu5.add(contratosmenu14); contratosmenu5.add(new JLabel(""));
    contratosmenu5.add(new JLabel(""));contratosmenu5.add(contratosmenu9);contratosmenu5.add(contratosmenu12); contratosmenu5.add(contratosmenu15);contratosmenu5.add(new JLabel(""));
    contratosmenu5.add(new JLabel("")); contratosmenu5.add(new JLabel("")); contratosmenu5.add(new JLabel("")); contratosmenu5.add(new JLabel(""));contratosmenu5.add(new JLabel(""));
    JPanel main8= new JPanel();
    main8.setBackground(c);
    main8.setLayout(new BorderLayout());
    main8.add(contratostitulo0, BorderLayout.NORTH);
    main8.add(contratosmenu5);
    JButton volvermenucontratos1 = new JButton("Volver Menu");
    volvermenucontratos1.setFont(new java.awt.Font(fontletra, 0, 60));
    volvermenucontratos1.setForeground(c2);
    volvermenucontratos1.setBackground(c1);
    main8.add(volvermenucontratos1, BorderLayout.SOUTH);
    //PANEL TABLA
    int count3=0;
    for(int i=0;i<eventos.length;i++){
      if(eventos[i]!=null){count3++;}}
    Object[][] data = new Object[count3][14];
    
    //SE OBTIENEN LOS DATOS QUE VAN EN LA TABLA
    for(int i=0;i<eventos.length;i++){
      if(eventos[i]!=null){
        data[i][0] = (eventos[i].clientes.getNombre() + "  "+eventos[i].clientes.getApellido()).toUpperCase(); 
        data[i][1] = eventos[i].getNombre().toUpperCase();
        data[i][2] = eventos[i].getFecha().toUpperCase();
        data[i][3] = eventos[i].getPrimerT().toUpperCase();
        data[i][4] = eventos[i].getSegundoT1().toUpperCase(); 
        data[i][5] = eventos[i].getSegundoT2().toUpperCase();
        data[i][6] = eventos[i].getSegundoT3().toUpperCase();
        data[i][7] = eventos[i].getTercerT().toUpperCase();
        data[i][8] = eventos[i].getCantidadAdt();
        data[i][9] = eventos[i].getComidaNiño().toUpperCase();
        data[i][10] = eventos[i].getCantidadNiño();
        data[i][11] = eventos[i].getSalon().toUpperCase();
        data[i][12] = eventos[i].getHoraInicial().toUpperCase();
        data[i][13] = eventos[i].getHoraFinal().toUpperCase();
      }
    }
    //SE CREA LA TABLA Y SE AJUSTAN PROPIEDADES
    table = new JTable(); 
    table.setPreferredScrollableViewportSize(new Dimension(1000,300));
    table.setFont(new java.awt.Font(fontletra, 0, 20)); 
    table.setRowHeight(table.getRowHeight() + 3);
    table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
    //SE CREA EL JSCROLLPANE  Y SE AJUSTAN PROPIEDADES
    JScrollPane scrollpane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    scrollpane.getViewport().setBackground(c);
    //SE CREAN  LOS  JPANELS Y SE AJUSTAN LOS COMPONENTES
    JPanel tablapanel= new JPanel(new BorderLayout());
    tablapanel.setBackground(c);
    JPanel tablapanel2= new JPanel(new BorderLayout());
    tablapanel2.add( scrollpane);
    JPanel tablapanel3= new JPanel(new GridLayout());
    tablapanel3.setBackground(c);tablapanel2.setBackground(c);
    //SE CREAN LOS OTROS COMPONENTES QUE ESTARAN EN EL PANEL Y SE AJUSTAN PROPIEDADES
    
    JLabel componentetabla1 = new JLabel("Filtro");
    componentetabla1.setFont(new java.awt.Font(fontletra, 0, 37));
    componentetabla1.setForeground(c2);
    JTextField componentetabla2 = new JTextField(20);
    componentetabla2.setFont(new java.awt.Font(fontletra, 0, 25));
    
    JButton volvermenucontratos2 = new JButton("Volver Menu");
    volvermenucontratos2.setFont(new java.awt.Font(fontletra, 0, 60));
    volvermenucontratos2.setForeground(c2);
    volvermenucontratos2.setBackground(c1);
   
    //ACTION LISTENER PARA UN JTEXTFIELD QUE LLAMA EL METODO QUE REALIZA EL FILTRO EN LA TABLA
    componentetabla2.addKeyListener(new KeyAdapter() {
        
        public void keyTyped(KeyEvent e) {
            String text=componentetabla2.getText();
            filter(text);
        }
    });
    
    tablapanel3.add(componentetabla1);tablapanel3.add(componentetabla2);tablapanel3.add(new JLabel(""));tablapanel3.add(new JLabel(""));tablapanel3.add(new JLabel(""));
    tablapanel2.add(tablapanel3, BorderLayout.SOUTH);
    tablapanel.add(tablapanel2);
    tablapanel.add(volvermenucontratos2, BorderLayout.SOUTH);

//PANEL CALENDARIO
    //SE CREAN E INICIALIZAN LOS COMPONENTES Y SUS PROPIEDADES
    JLabel[] labelscalendario= new JLabel[23];
    JComboBox[] boxscalendarios = new JComboBox[10];
    JTextField[] fieldscalendarios = new JTextField[12];
    JButton[] buttonscalendarios = new JButton[4];
    String[] titulocalendarios0={"Cliente:","Telefono:","Apellido:","RFC:","Correo:","Direccion:","Referente:","Telefono:","Evento:","Fecha:","Primer T.:","Plato F.:","Guarnicion 1:","Guarnicion 2:","Tercer T.:","Cantidad:","Comida Niños:","Cantidad:","Hora Inicio:","Hora final:","Salón:","Descuento:","Total:"};
    for(int i=0;i<labelscalendario.length;i++){
      labelscalendario[i]= new JLabel(titulocalendarios0[i]);
      labelscalendario[i].setFont(new java.awt.Font(fontletra, 0, 37));
      labelscalendario[i].setForeground(c2);
    }
    for(int i=0;i<fieldscalendarios.length;i++){
      fieldscalendarios[i]= new JTextField();
      fieldscalendarios[i].setFont(new java.awt.Font(fontletra, 0, 25));
      fieldscalendarios[i].setEnabled(false);
    }
    for(int i=0;i<boxscalendarios.length;i++){
      boxscalendarios[i]= new JComboBox();
      boxscalendarios[i].setFont(new java.awt.Font(fontletra, 0, 25));
      boxscalendarios[i].setEnabled(false);
      boxscalendarios[i].setEditable(true); 
    }    
    String[] titulocalendarios1={"Contrato","Modificar","Guardar","Eliminar"};   
    for(int i=0;i<buttonscalendarios.length;i++){
      buttonscalendarios[i]= new JButton(titulocalendarios1[i]);
      buttonscalendarios[i].setFont(new java.awt.Font(fontletra, 0, 40));
      buttonscalendarios[i].setForeground(c2);
      buttonscalendarios[i].setBackground(c1);
    }
    buttonscalendarios[0].setEnabled(usuarioactual.getRes2());
    buttonscalendarios[1].setEnabled(usuarioactual.getRes2());
    buttonscalendarios[2].setEnabled(false);
    buttonscalendarios[3].setEnabled(false);
    fieldscalendarios[9].setText("0");
    fieldscalendarios[10].setText("0");    
    
    final  JDatePickerImpl cal14 = new JDatePickerImpl(datePanel, formatter); 
    cal14.setFont(new java.awt.Font(fontletra, 0, 40));
    cal14.getComponent(1).setEnabled(usuarioactual.getRes1());
    
    boxscalendarios[0].setModel(new DefaultComboBoxModel(comidas));
    boxscalendarios[1].setModel(new DefaultComboBoxModel(comidas1));
    boxscalendarios[2].setModel(new DefaultComboBoxModel(comidas2));
    boxscalendarios[3].setModel(new DefaultComboBoxModel(comidas2));
    boxscalendarios[4].setModel(new DefaultComboBoxModel(comidas3)); 
    boxscalendarios[5].setModel(new DefaultComboBoxModel(comidas4)); 
    boxscalendarios[6].setModel(new DefaultComboBoxModel(horas)); 
    boxscalendarios[7].setModel(new DefaultComboBoxModel(horas)); 
    String[] salones={"1","2"};
    boxscalendarios[8].setModel(new DefaultComboBoxModel(salones));
    boxscalendarios[9].setModel(new DefaultComboBoxModel(descuentos));
    
    for(int i=0;i<boxscalendarios.length;i++){boxscalendarios[i].setSelectedItem(""); }
    
    final   JCheckBox cal27 = new JCheckBox("Musica");
    cal27.setFont(new java.awt.Font(fontletra, 0, 40));
    cal27.setForeground(c2);
    cal27.setBackground(c);
    cal27.setEnabled(false);
    final  JCheckBox cal28 = new JCheckBox("Arreglos");
    cal28.setFont(new java.awt.Font(fontletra, 0, 40));
    cal28.setForeground(c2);
    cal28.setBackground(c);
    cal28.setEnabled(false);
    //SE CREA EL PANEL Y SE LE AJUSTAN LOS COMPONENTES
    JPanel cal39 = new JPanel();
    cal39.setBackground(c);
    GridLayout cal40 = new GridLayout(17,6);
    cal39.setLayout(cal40); 
    
    cal39.add(new JLabel(""));cal39.add(new JLabel(""));cal39.add(new JLabel(""));cal39.add(new JLabel(""));cal39.add(new JLabel(""));cal39.add(new JLabel(""));
    cal39.add(new JLabel(""));cal39.add(new JLabel(""));cal39.add(labelscalendario[9]);cal39.add(cal14);cal39.add(new JLabel(""));cal39.add(new JLabel(""));
    cal39.add(new JLabel(""));cal39.add(labelscalendario[0]); cal39.add(fieldscalendarios[0]);cal39.add(labelscalendario[2]);cal39.add(fieldscalendarios[2]);cal39.add(new JLabel(""));
    cal39.add(new JLabel(""));cal39.add(labelscalendario[4]); cal39.add(fieldscalendarios[4]);cal39.add(labelscalendario[1]);cal39.add(fieldscalendarios[1]);cal39.add(new JLabel(""));
    cal39.add(new JLabel(""));cal39.add(labelscalendario[3]); cal39.add(fieldscalendarios[3]);cal39.add(labelscalendario[5]);cal39.add(fieldscalendarios[5]);cal39.add(new JLabel(""));  
    cal39.add(new JLabel(""));  cal39.add(labelscalendario[6]);cal39.add(fieldscalendarios[6]); cal39.add(labelscalendario[7]);cal39.add(fieldscalendarios[7]);cal39.add(new JLabel(""));
    cal39.add(new JLabel("")); cal39.add(labelscalendario[8]);cal39.add(fieldscalendarios[8]);cal39.add(labelscalendario[20]);cal39.add(boxscalendarios[8]);cal39.add(new JLabel(""));
    cal39.add(new JLabel("")); cal39.add(labelscalendario[10]);cal39.add(boxscalendarios[0]); cal39.add(labelscalendario[11]);cal39.add(boxscalendarios[1]);cal39.add(new JLabel(""));  
    cal39.add(new JLabel("")); cal39.add(labelscalendario[12]);cal39.add(boxscalendarios[2]); cal39.add(labelscalendario[13]);cal39.add(boxscalendarios[3]);cal39.add(new JLabel(""));
    cal39.add(new JLabel("")); cal39.add(labelscalendario[14]);cal39.add(boxscalendarios[4]); cal39.add(labelscalendario[15]);cal39.add(fieldscalendarios[9]);cal39.add(new JLabel(""));
    cal39.add(new JLabel("")); cal39.add(labelscalendario[16]);cal39.add(boxscalendarios[5]);cal39.add(labelscalendario[17]); cal39.add(fieldscalendarios[10]);cal39.add(new JLabel(""));
    cal39.add(new JLabel(""));  cal39.add(labelscalendario[18]);cal39.add(boxscalendarios[6]); cal39.add(labelscalendario[19]);cal39.add(boxscalendarios[7]);cal39.add(new JLabel(""));
    cal39.add(new JLabel("")); cal39.add(cal27);cal39.add(cal28);cal39.add(labelscalendario[21]);cal39.add(boxscalendarios[9]);cal39.add(new JLabel(""));
    cal39.add(new JLabel("")); cal39.add(new JLabel("")); cal39.add(new JLabel(""));cal39.add(labelscalendario[22]);cal39.add(fieldscalendarios[11]);cal39.add(new JLabel(""));
    cal39.add(new JLabel(""));cal39.add(new JLabel(""));cal39.add(new JLabel(""));cal39.add(new JLabel(""));cal39.add(new JLabel(""));cal39.add(new JLabel(""));
    cal39.add(new JLabel(""));  cal39.add(buttonscalendarios[1]); cal39.add(buttonscalendarios[2]);cal39.add(buttonscalendarios[3]); cal39.add(buttonscalendarios[0]);cal39.add(new JLabel(""));
    cal39.add(new JLabel(""));cal39.add(new JLabel(""));cal39.add(new JLabel(""));cal39.add(new JLabel(""));cal39.add(new JLabel(""));cal39.add(new JLabel(""));
    
    //ACTION LISTENERS CALENDARIO 
    //SE AJUSTA LA INFORMACION ADECUADA EN JTEXTFIELDS Y JCOMOBOXS DEPENDIENDO LA FECHA INGRESADA
    
    cal14.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        int count=0; 
        for(int x=0;x<eventos.length;x++){
          if(eventos[x]!=null){
            if(eventos[x].getFecha().equals(cal14.getJFormattedTextField().getText())){count++;}
          }}
        if(count==1){
          for(int x=0;x<eventos.length;x++){
            if(eventos[x]!=null){
              if(eventos[x].getFecha().equals(cal14.getJFormattedTextField().getText())){
                fieldscalendarios[0].setText(eventos[x].clientes.getNombre());
                fieldscalendarios[1].setText(eventos[x].clientes.getTelefono());
                fieldscalendarios[6].setText(eventos[x].clientes.getNreferente());
                fieldscalendarios[7].setText(eventos[x].clientes.getTreferente());
                fieldscalendarios[8].setText(eventos[x].getNombre());
                boxscalendarios[0].setSelectedItem(eventos[x].getPrimerT());
                boxscalendarios[1].setSelectedItem(eventos[x].getSegundoT1());
                boxscalendarios[2].setSelectedItem(eventos[x].getSegundoT2());
                boxscalendarios[3].setSelectedItem(eventos[x].getSegundoT3());
                boxscalendarios[4].setSelectedItem(eventos[x].getTercerT());
                fieldscalendarios[9].setText(String.valueOf(eventos[x].getCantidadAdt()));
                boxscalendarios[5].setSelectedItem(eventos[x].getComidaNiño());
                fieldscalendarios[10].setText(String.valueOf(eventos[x].getCantidadNiño()));
                boxscalendarios[6].setSelectedItem(eventos[x].getHoraInicial());
                boxscalendarios[7].setSelectedItem(eventos[x].getHoraFinal());
                cal27.setSelected(eventos[x].getMusica());
                cal28.setSelected(eventos[x].getArreglo());
                boxscalendarios[8].setSelectedItem(eventos[x].getSalon());
                fieldscalendarios[11].setText(String.valueOf(eventos[x].getTotal()));
                boxscalendarios[9].setSelectedItem(eventos[x].getDescuento());
                fieldscalendarios[2].setText(eventos[x].clientes.getApellido());
                fieldscalendarios[5].setText(eventos[x].clientes.getDomicilio());
                fieldscalendarios[4].setText(eventos[x].clientes.getCorreo());
                fieldscalendarios[3].setText(String.valueOf((eventos[x].clientes.getRfc())));}}
          }}
        if(count>=2){
          final JComboBox cal52= new JComboBox();
          cal52.setFont(new java.awt.Font(fontletra, 0, 25));
          for(int x=0;x<eventos.length;x++){
            if(eventos[x]!=null)
              if(eventos[x].getFecha().equals(cal14.getJFormattedTextField().getText())){
              cal52.addItem(eventos[x].getNombre());
            }}
          JPanel mainPanel2 = new JPanel();
          mainPanel2.add(cal52);
          JButton mainPanelbutton2 = new JButton("Seleccionar");
          mainPanelbutton2.setFont(new java.awt.Font(fontletra, 0, 40));
          mainPanelbutton2.setForeground(c2);
          mainPanelbutton2.setBackground(c1);
          mainPanel2.add(mainPanelbutton2);
          mainPanel2.setBackground(c);
          
          final JFrame frame = new JFrame("Eventos:");          
          frame.setContentPane(mainPanel2);
          frame.pack();
          frame.setLocationByPlatform(true);
          frame.setVisible(true);frame.setIconImage(icon.getImage());
          
          mainPanelbutton2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
              String cal54=(String)cal52.getSelectedItem();
              frame.setVisible(false);
              for(int x=0;x<eventos.length;x++){
                if(eventos[x]!=null)
                  if((eventos[x].getFecha()).equals(cal14.getJFormattedTextField().getText())&&(eventos[x].getNombre()).equals(cal54)){
                  fieldscalendarios[0].setText(eventos[x].clientes.getNombre());
                  fieldscalendarios[1].setText(eventos[x].clientes.getTelefono());
                  fieldscalendarios[6].setText(eventos[x].clientes.getNreferente());
                  fieldscalendarios[7].setText(eventos[x].clientes.getTreferente());
                  fieldscalendarios[8].setText(eventos[x].getNombre());
                  boxscalendarios[0].setSelectedItem(eventos[x].getPrimerT());
                  boxscalendarios[1].setSelectedItem(eventos[x].getSegundoT1());
                  boxscalendarios[2].setSelectedItem(eventos[x].getSegundoT2());
                  boxscalendarios[3].setSelectedItem(eventos[x].getSegundoT3());
                  boxscalendarios[4].setSelectedItem(eventos[x].getTercerT());
                  fieldscalendarios[9].setText(String.valueOf(eventos[x].getCantidadAdt()));
                  boxscalendarios[5].setSelectedItem(eventos[x].getComidaNiño());
                  fieldscalendarios[10].setText(String.valueOf(eventos[x].getCantidadNiño()));
                  boxscalendarios[6].setSelectedItem(eventos[x].getHoraInicial());
                  boxscalendarios[7].setSelectedItem(eventos[x].getHoraFinal());
                  cal27.setSelected(eventos[x].getMusica());
                  cal28.setSelected(eventos[x].getArreglo());
                  boxscalendarios[8].setSelectedItem(eventos[x].getSalon());
                  fieldscalendarios[11].setText(String.valueOf(eventos[x].getTotal()));
                  boxscalendarios[9].setSelectedItem(eventos[x].getDescuento());
                  fieldscalendarios[2].setText(eventos[x].clientes.getApellido());
                  fieldscalendarios[5].setText(eventos[x].clientes.getDomicilio());
                  fieldscalendarios[4].setText(eventos[x].clientes.getCorreo());
                  fieldscalendarios[3].setText(String.valueOf((eventos[x].clientes.getRfc())));
                }}
            }});          
        }
        if(count==0){
          for(int i=0;i<fieldscalendarios.length;i++){fieldscalendarios[i].setText("");}
          for(int i=0;i<boxscalendarios.length;i++){boxscalendarios[i].setSelectedItem("");}
          cal27.setSelected(false);
          cal28.setSelected(false);
          fieldscalendarios[9].setText(String.valueOf(0));
          fieldscalendarios[10].setText(String.valueOf(0));
        }}}); 
    buttonscalendarios[2].addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        int count=0;
    //SE VERIFIRCA CUANTOS EVENTOS HAY ESE DIA
        for(int x=0;x<eventos.length;x++){
          if(eventos[x]!=null){
            if(eventos[x].getFecha().equals(cal14.getJFormattedTextField().getText())){
              count++;}}}
        //EN CASO DE HABER UNO SOLO
        if(count==1){
          for(int x=0;x<eventos.length;x++){
            if(eventos[x]!=null){
              if(eventos[x].getFecha().equals(cal14.getJFormattedTextField().getText())){
                eventos[x].clientes.setNombre(fieldscalendarios[0].getText());
                eventos[x].clientes.setTelefono(fieldscalendarios[1].getText());
                eventos[x].clientes.setNreferente(fieldscalendarios[6].getText());
                eventos[x].clientes.setTreferente(fieldscalendarios[7].getText());
                eventos[x].setNombre(fieldscalendarios[8].getText());
                eventos[x].setPrimerT((String)boxscalendarios[0].getSelectedItem());
                eventos[x].setSegundoT1((String)boxscalendarios[1].getSelectedItem());
                eventos[x].setSegundoT2((String)boxscalendarios[2].getSelectedItem());
                eventos[x].setSegundoT3((String)boxscalendarios[3].getSelectedItem());
                eventos[x].setTercerT((String)boxscalendarios[4].getSelectedItem());
                eventos[x].setCantidadAdt( Integer.parseInt(fieldscalendarios[9].getText()));
                eventos[x].setComidaNiño((String)boxscalendarios[5].getSelectedItem());
                eventos[x].setCantidadNiño(Integer.parseInt(fieldscalendarios[10].getText()));
                eventos[x].setHoraInicial((String)boxscalendarios[6].getSelectedItem());
                eventos[x].setHoraFinal((String)boxscalendarios[7].getSelectedItem());
                eventos[x].setMusica(cal27.isSelected());
                eventos[x].setArreglo(cal28.isSelected());
                eventos[x].setSalon((String)boxscalendarios[8].getSelectedItem());
                eventos[x].setTotal(Integer.parseInt(fieldscalendarios[11].getText()));
                eventos[x].setDescuento((String)boxscalendarios[9].getSelectedItem());
                eventos[x].clientes.setApellido(fieldscalendarios[2].getText());
                eventos[x].clientes.setDomicilio(fieldscalendarios[5].getText());
                eventos[x].clientes.setRfc((fieldscalendarios[3].getText()));
                eventos[x].clientes.setCorreo(fieldscalendarios[4].getText());   
                guardarEventos();
              }}}}
        
        //EN CASO DE HABER DOS O MÁS SE DEPILIEGA UN JFRAME QUE DEJA ELEGIR CUAL QUIERE VER EL USUARIO
        if(count>=2){ final JComboBox cal52= new JComboBox(); cal52.setFont(new java.awt.Font(fontletra, 0, 25));
          for(int x=0;x<eventos.length;x++){
            if(eventos[x]!=null)
              if(eventos[x].getFecha().equals(cal14.getJFormattedTextField().getText())){
              cal52.addItem(eventos[x].getNombre());
            }}
          JPanel mainPanel2 = new JPanel();
          mainPanel2.add(cal52);
          JButton mainPanelbutton2 = new JButton("Seleccionar");
          mainPanel2.add(mainPanelbutton2);
          mainPanelbutton2.setFont(new java.awt.Font(fontletra, 0, 40));
          mainPanelbutton2.setForeground(c2);
          mainPanelbutton2.setBackground(c1);
          mainPanel2.setBackground(c);
          final JFrame frame = new JFrame("Modificar:");
          
          frame.setContentPane(mainPanel2);
          frame.pack();
          frame.setLocationByPlatform(true);
          frame.setVisible(true);frame.setIconImage(icon.getImage());
          
          mainPanelbutton2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
              try{
                String cal54=(String)cal52.getSelectedItem();
                frame.setVisible(false);
                for(int x=0;x<eventos.length;x++){
                  if(eventos[x]!=null)
                    if((eventos[x].getFecha()).equals(cal14.getJFormattedTextField().getText())&&(eventos[x].getNombre()).equals(cal54)){
                    eventos[x].clientes.setNombre(fieldscalendarios[0].getText());
                    eventos[x].clientes.setTelefono(fieldscalendarios[1].getText());
                    eventos[x].clientes.setNreferente(fieldscalendarios[6].getText());
                    eventos[x].clientes.setTreferente(fieldscalendarios[7].getText());
                    eventos[x].setNombre(fieldscalendarios[8].getText());
                    eventos[x].setPrimerT((String)boxscalendarios[0].getSelectedItem());
                    eventos[x].setSegundoT1((String)boxscalendarios[1].getSelectedItem());
                    eventos[x].setSegundoT2((String)boxscalendarios[2].getSelectedItem());
                    eventos[x].setSegundoT3((String)boxscalendarios[3].getSelectedItem());
                    eventos[x].setTercerT((String)boxscalendarios[4].getSelectedItem());
                    eventos[x].setCantidadAdt( Integer.parseInt(fieldscalendarios[9].getText()));
                    eventos[x].setComidaNiño((String)boxscalendarios[5].getSelectedItem());
                    eventos[x].setCantidadNiño(Integer.parseInt(fieldscalendarios[10].getText()));
                    eventos[x].setHoraInicial((String)boxscalendarios[6].getSelectedItem());
                    eventos[x].setHoraFinal((String)boxscalendarios[7].getSelectedItem());
                    eventos[x].setMusica(cal27.isSelected());
                    eventos[x].setArreglo(cal28.isSelected());
                    eventos[x].setSalon((String)boxscalendarios[8].getSelectedItem());
                    eventos[x].setTotal(Integer.parseInt(fieldscalendarios[11].getText()));
                    eventos[x].setDescuento((String)boxscalendarios[9].getSelectedItem());
                    eventos[x].clientes.setApellido(fieldscalendarios[2].getText());
                    eventos[x].clientes.setDomicilio(fieldscalendarios[5].getText());
                    eventos[x].clientes.setRfc((fieldscalendarios[3].getText()));
                    eventos[x].clientes.setCorreo(fieldscalendarios[4].getText());  
                    guardarEventos();
                  }}
              }catch(Exception c){alerta1("Error,revise que las casillas esten completas");}
            }}); 
        }        
        int i=0;
        int utilizados=-1;
        boolean salir= true;
        
        try{
          while(salir && i<eventos.length){           
            if(eventos[i]==null){utilizados=i;salir=false;}
            i++;}
          if(utilizados!=-1){
            if(count==0){
              eventos[utilizados]=new Evento((fieldscalendarios[0].getText()),(fieldscalendarios[2].getText()),fieldscalendarios[3].getText(),(fieldscalendarios[1].getText()),(fieldscalendarios[5].getText()),(fieldscalendarios[4].getText()),(fieldscalendarios[6].getText()),(fieldscalendarios[7].getText()), (fieldscalendarios[8].getText()),(cal14.getJFormattedTextField().getText()),((String)boxscalendarios[0].getSelectedItem()),((String)boxscalendarios[1].getSelectedItem()),((String)boxscalendarios[2].getSelectedItem()),((String)boxscalendarios[3].getSelectedItem()),((String)boxscalendarios[4].getSelectedItem()),( Integer.parseInt(fieldscalendarios[9].getText())),((String)boxscalendarios[5].getSelectedItem()),(Integer.parseInt(fieldscalendarios[10].getText())),((String)boxscalendarios[6].getSelectedItem()),((String)boxscalendarios[7].getSelectedItem()),((String)boxscalendarios[8].getSelectedItem()),cal27.isSelected(),cal28.isSelected(),Integer.parseInt(fieldscalendarios[11].getText()),"nada",(String)boxscalendarios[9].getSelectedItem());
              utilizados++;
            }
            guardarEventos();
          }
        }catch(Exception c){alerta1("Error,revise que las casillas esten completas");}
      }});
    //ELIMINA EL EVENTO Y LIMPIA LAS CASILLAS 
    buttonscalendarios[3].addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        int count=0;
        //CUENTA CUANTOS EVENTOS HAY POR DIA
        for(int x=0;x<eventos.length;x++){
          if(eventos[x]!=null)
            if(eventos[x].getFecha().equals(cal14.getJFormattedTextField().getText())){
            count++;          
          }}
        //CASO QUE SOLO HAYA UNO
        if(count<=1){
          for(int x=0;x<eventos.length;x++){
            if(eventos[x]!=null)
              if(eventos[x].getFecha().equals(cal14.getJFormattedTextField().getText())){
              eventos[x]=null;
              for(int i=0;i<fieldscalendarios.length;i++){fieldscalendarios[i].setText("");}
              for(int i=0;i<boxscalendarios.length;i++){boxscalendarios[i].setSelectedItem("");}
              cal27.setSelected(false);
              cal28.setSelected(false);
              fieldscalendarios[9].setText(String.valueOf(0));
              fieldscalendarios[10].setText(String.valueOf(0));
              guardarEventos();
            }}
        }
        //CASO DE 2 O MÁS
        else{ final JComboBox cal52= new JComboBox(); cal52.setFont(new java.awt.Font(fontletra, 0, 25));
          for(int x=0;x<eventos.length;x++){
            if(eventos[x]!=null)
              if(eventos[x].getFecha().equals(cal14.getJFormattedTextField().getText())){
              cal52.addItem(eventos[x].getNombre());
            }}
          JPanel mainPanel2 = new JPanel();
          mainPanel2.add(cal52);
          JButton mainPanelbutton2 = new JButton("Seleccionar");
          mainPanel2.add(mainPanelbutton2);
          mainPanelbutton2.setFont(new java.awt.Font(fontletra, 0, 40));
          mainPanelbutton2.setForeground(c2);
          mainPanelbutton2.setBackground(c1);
          mainPanel2.setBackground(c);
          
          final JFrame frame = new JFrame("Eliminar");          
          frame.setContentPane(mainPanel2);
          frame.pack();
          frame.setLocationByPlatform(true);
          frame.setVisible(true);frame.setIconImage(icon.getImage());
          
          mainPanelbutton2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
              String cal54=(String)cal52.getSelectedItem();
              frame.setVisible(false);
              for(int x=0;x<eventos.length;x++){
                if(eventos[x]!=null)
                  if((eventos[x].getFecha()).equals(cal14.getJFormattedTextField().getText())&&(eventos[x].getNombre()).equals(cal54)){
                  eventos[x]=null;
                  for(int i=0;i<fieldscalendarios.length;i++){fieldscalendarios[i].setText("");}
                  for(int i=0;i<boxscalendarios.length;i++){boxscalendarios[i].setSelectedItem("");}
                  cal27.setSelected(false);
                  cal28.setSelected(false);
                  fieldscalendarios[9].setText(String.valueOf(0));
                  fieldscalendarios[10].setText(String.valueOf(0));
                  guardarEventos();
                }}
            }});          
        }}});
    //BUSCA ENTRE LOS CONTRATOS ACTUALES Y ABRE EL CORRESPONDIENTE
    //EN CASO DE NO EXISTIR LO CREA Y POSTERIORMENTE LO ABRE
    buttonscalendarios[0].addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
       
          try {          
          for(int x=0;x<eventos.length;x++){
            if(eventos[x]!=null){
              if((eventos[x].clientes.getRfc().equals(fieldscalendarios[3].getText()))&& (eventos[x].getNombre().equals(fieldscalendarios[8].getText()))){
                if(!eventos[x].getPath().equals("nada")){
                 //CASO EXSITE
                Runtime.getRuntime().exec("cmd /c start "+eventos[x].getPath());
                   
              }
                //CASO NO EXISTE
              else{
              
                    n2t numero = new n2t();
                    //SE LLAMA EL METODO ESRIBIR PARA PONER LA INFORMACION CORRESPONDIENTE AL EVENTO EN EL LUGAR ADECUADO
                    String[][] cambios={{"VAR$",(String.valueOf(Nevento))},{"VAR1$",eventos[x].clientes.getNombre()+" "+eventos[x].clientes.getApellido()}
                    ,{"VAR2$",eventos[x].clientes.getDomicilio()},{"VAR35",eventos[x].clientes.getRfc()},{"VAR4",eventos[x].clientes.getTelefono()},{"VAR5",eventos[x].clientes.getCorreo()}
                    ,{"VAR6",String.valueOf(eventos[x].getCantidadAdt()+eventos[x].getCantidadNiño())},{"VAR7",eventos[x].getFecha().substring(0,2)},{"VAR8",eventos[x].getFecha().substring(3,5)}
                    ,{"VAR9",eventos[x].getFecha().substring(6)},{"VAR10",String.valueOf(boxscalendarios[7].getSelectedIndex()-boxscalendarios[6].getSelectedIndex())},{"VAR11",eventos[x].getHoraInicial()}
                    ,{"VAR12",eventos[x].getHoraFinal()},{"VAR13",String.valueOf((eventos[x].getTotal())*(.2))},{"VAR14", numero.convertirLetras((int)((eventos[x].getTotal())*(.2)))},
                     {"VAR15","20"},{"VAR16",String.valueOf((eventos[x].getTotal())*.8)},{"VAR17",numero.convertirLetras((int)((eventos[x].getTotal())*.8))},{"VAR18","80"},
                     {"VAR19",String.valueOf(dia)},{"VAR20",String.valueOf(mes)},{"VAR21",String.valueOf(año)}};
      
                    escribir2(cambios,String.valueOf(Nevento));
  
                Runtime.getRuntime().exec("cmd /c start "+".\\CONTRATOS\\CONTRATOBASE"+String.valueOf(Nevento)+".docx"); 
                eventos[x].setPath(".\\CONTRATOS\\CONTRATOBASE"+String.valueOf(Nevento)+".docx");
                
                Nevento++;
                guardarNumero();
                guardarEventos();
                x=eventos.length;
              }
            }
            }  
          }        
        }catch(FileNotFoundException ex){alerta1("El archivo no se encuentra, revise que no  este abierto");}
        catch (IOException ex) {
          alerta1("Revisa las casillas");
          // ex.printStackTrace();
        }
      }});
    
    JLabel cal41 = new JLabel("CALENDARIO",SwingConstants.CENTER);
    cal41.setFont(new java.awt.Font(fontletra, 0, 120));
    cal41.setForeground(c2);
    //SE DECLARA EL PANEL Y SE LE AGREGA LO CORRESPONDIENTE
    JPanel main10= new JPanel();
    main10.setBackground(c);
    main10.setLayout(new BorderLayout());
    main10.add(cal41, BorderLayout.NORTH);
    main10.add(cal39); 
    
    //EMPLEADOS MENU PRINCIAPL
    //SE DECLARA EL PANEL, SUS COMPONENTES Y SE AJUSTAN SUS PROPIEDADES
    JPanel empleadosmenu= new JPanel();
    empleadosmenu.setBackground(c);
    JLabel empleadosmenu0 = new JLabel("EMPLEADOS",SwingConstants.CENTER);
    empleadosmenu0.setFont(new java.awt.Font(fontletra, 0, 120));
    empleadosmenu0.setForeground(c2);
    GridLayout empleadosmenu1 = new GridLayout(5,3);
    empleadosmenu.setLayout(empleadosmenu1); 
    JButton empleadosmenu2= new JButton("Ver");
    empleadosmenu2.setFont(new java.awt.Font(fontletra, 0, 60));
    empleadosmenu2.setForeground(c2);
    empleadosmenu2.setBackground(c1);
    empleadosmenu2.setEnabled(usuarioactual.getRes5());
    
    JButton empleadosmenu3= new JButton("Agregar");
    empleadosmenu3.setFont(new java.awt.Font(fontletra, 0, 60));
    empleadosmenu3.setForeground(c2);
    empleadosmenu3.setBackground(c1);
    empleadosmenu3.setEnabled(usuarioactual.getRes6());
    JButton empleadosmenu4= new JButton("Quitar");
    empleadosmenu4.setFont(new java.awt.Font(fontletra, 0, 60));
    empleadosmenu4.setForeground(c2);
    empleadosmenu4.setBackground(c1);
    empleadosmenu4.setEnabled(usuarioactual.getRes6());
    
    empleadosmenu.add(new JLabel("")); empleadosmenu.add(new JLabel("")); empleadosmenu.add(new JLabel(""));
    empleadosmenu.add(new JLabel(""));empleadosmenu.add(empleadosmenu2); empleadosmenu.add(new JLabel(""));
    empleadosmenu.add(new JLabel(""));empleadosmenu.add(empleadosmenu3); empleadosmenu.add(new JLabel(""));
    empleadosmenu.add(new JLabel(""));empleadosmenu.add(empleadosmenu4); empleadosmenu.add(new JLabel(""));
    empleadosmenu.add(new JLabel("")); empleadosmenu.add(new JLabel("")); empleadosmenu.add(new JLabel(""));
    
    JPanel main11= new JPanel();
    main11.setBackground(c);
    main11.setLayout(new BorderLayout());
    main11.add(empleadosmenu0, BorderLayout.NORTH);
    main11.add(empleadosmenu);
    
//EMPLEADOS-VER
    //SE DECLARA EL PANEL Y SUS COMPONENTES CON SUS RESPECTIVAS PROPIEDADES
    JPanel empleadosver= new JPanel();
    empleadosver.setBackground(c);
    JLabel empleadosver0 = new JLabel("VER",SwingConstants.CENTER);
    empleadosver0.setFont(new java.awt.Font(fontletra, 0, 120));
    empleadosver0.setForeground(c2);
    GridLayout empleadosver1 = new GridLayout(10,4);
    empleadosver.setLayout(empleadosver1); 
    
    JLabel empleadosver2= new JLabel("Nombres:");
    empleadosver2.setFont(new java.awt.Font(fontletra, 0, 60));
    empleadosver2.setForeground(c2);
    JComboBox empleadosver3= new JComboBox();
    empleadosver3.setFont(new java.awt.Font(fontletra, 0, 30));
    
    //ACTION LISTENER QUE REFRESCA JCOMOBOX CADA VEZ QUE SE ELIGA LA OPCION DE VER EN EL MENU
    empleadosmenu2.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        empleadosver3.removeAllItems();
        for(int x=0;x<empleados.length;x++){
          if(empleados[x]!=null)
            empleadosver3.addItem(empleados[x].getNombre());
        }
      }});
    
    JLabel empleadosver4= new JLabel("Apellidos:");
    empleadosver4.setFont(new java.awt.Font(fontletra, 0, 60));
    empleadosver4.setForeground(c2);
    JTextField empleadosver5= new JTextField(20);
    empleadosver5.setEnabled(false);
    empleadosver5.setFont(new java.awt.Font(fontletra, 0, 30));
    
    
    JLabel empleadosver17= new JLabel("Telefono:");
    empleadosver17.setFont(new java.awt.Font(fontletra, 0, 60));
    empleadosver17.setForeground(c2); 
    JTextField empleadosver18= new JTextField(20);
    empleadosver18.setEnabled(false);
    empleadosver18.setFont(new java.awt.Font(fontletra, 0, 30));
    
    JLabel empleadosver13= new JLabel("Direccion:");
    empleadosver13.setFont(new java.awt.Font(fontletra, 0, 60));
    empleadosver13.setForeground(c2); 
    JTextField empleadosver14= new JTextField(20);
    empleadosver14.setEnabled(false);
    empleadosver14.setFont(new java.awt.Font(fontletra, 0, 30));
    
    JLabel empleadosver15= new JLabel("Correo:");
    
    empleadosver15.setFont(new java.awt.Font(fontletra, 0, 60));
    empleadosver15.setForeground(c2); 
    JTextField empleadosver16= new JTextField(20);
    empleadosver16.setEnabled(false);
    empleadosver16.setFont(new java.awt.Font(fontletra, 0, 30));
     
    JLabel empleadosver6= new JLabel("Nomina:");
    empleadosver6.setFont(new java.awt.Font(fontletra, 0, 60));
    empleadosver6.setForeground(c2); 
    JTextField empleadosver7= new JTextField(20);
    empleadosver7.setEnabled(false);
    empleadosver7.setFont(new java.awt.Font(fontletra, 0, 30));
    
    JLabel empleadosver8= new JLabel("Puesto:");
    empleadosver8.setFont(new java.awt.Font(fontletra, 0, 60));
    empleadosver8.setForeground(c2); 
    JTextField empleadosver9= new JTextField(20);
    empleadosver9.setEnabled(false);
    empleadosver9.setFont(new java.awt.Font(fontletra, 0, 30));
    JLabel empleadosver10= new JLabel("Sueldo:");
    empleadosver10.setFont(new java.awt.Font(fontletra, 0, 60));
    empleadosver10.setForeground(c2); 
    JTextField empleadosver11= new JTextField(20);
    empleadosver11.setEnabled(false);
    empleadosver11.setFont(new java.awt.Font(fontletra, 0, 30));
    JButton empleadosver12 = new JButton("Volver Menu");
    empleadosver12.setFont(new java.awt.Font(fontletra, 0, 60));
    empleadosver12.setForeground(c2);
    empleadosver12.setBackground(c1);
    
    //ACTION LISTENER QUE AJUSTA LA INFORMACION ADECUADA EN LOS JTEXTFIELDS
    empleadosver3.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        for(int x=0;x<empleados.length;x++){
          if(empleados[x]!=null)
            if(empleados[x].getNombre().equals(empleadosver3.getSelectedItem())){
            empleadosver5.setText(empleados[x].getApellido());
            empleadosver7.setText(empleados[x].getNomina());
            empleadosver9.setText(empleados[x].getPuesto());
            empleadosver11.setText(String.valueOf(empleados[x].getSueldo()));
            empleadosver18.setText(empleados[x].getTelefono());
            empleadosver14.setText(empleados[x].getDomicilio());
            empleadosver16.setText(empleados[x].getCorreo());
          }
        }
      }});
    //SE AÑADEN CORRESPONDIENTEME AL PANEL LOS COMPONENTES
    empleadosver.add(new JLabel("")); empleadosver.add(new JLabel("")); empleadosver.add(new JLabel(""));empleadosver.add(new JLabel(""));
    empleadosver.add(new JLabel(""));empleadosver.add(empleadosver2);empleadosver.add(empleadosver3); empleadosver.add(new JLabel(""));
    empleadosver.add(new JLabel(""));empleadosver.add(empleadosver4);empleadosver.add(empleadosver5); empleadosver.add(new JLabel(""));
    empleadosver.add(new JLabel(""));empleadosver.add(empleadosver17);empleadosver.add(empleadosver18); empleadosver.add(new JLabel(""));
    empleadosver.add(new JLabel(""));empleadosver.add(empleadosver13);empleadosver.add(empleadosver14); empleadosver.add(new JLabel(""));
    empleadosver.add(new JLabel(""));empleadosver.add(empleadosver15);empleadosver.add(empleadosver16); empleadosver.add(new JLabel(""));     
    empleadosver.add(new JLabel(""));empleadosver.add(empleadosver6);empleadosver.add(empleadosver7); empleadosver.add(new JLabel(""));
    empleadosver.add(new JLabel(""));empleadosver.add(empleadosver8);empleadosver.add(empleadosver9); empleadosver.add(new JLabel(""));
    empleadosver.add(new JLabel(""));empleadosver.add(empleadosver10);empleadosver.add(empleadosver11); empleadosver.add(new JLabel(""));
    empleadosver.add(new JLabel("")); empleadosver.add(new JLabel("")); empleadosver.add(new JLabel(""));empleadosver.add(new JLabel(""));
    //SE CREA EL PANEL Y SE LE AÑADEN LOS COMPONENTES CORRESPONDIENTES
    JPanel main12= new JPanel();
    main12.setBackground(c);
    main12.setLayout(new BorderLayout());
    main12.add(empleadosver0, BorderLayout.NORTH);
    main12.add(empleadosver);
    main12.add(empleadosver12, BorderLayout.SOUTH);
    
    //EMPLEADOSAGREGAR
    //SE CREA EL PANEL Y SUS COMPONENTES, SE AJUSTAN LAS PROPIEDADES CORRESPONDIENTES
    JPanel empleadosagregar= new JPanel();
    empleadosagregar.setBackground(c);
    JLabel empleadosagregar0 = new JLabel("AGREGAR",SwingConstants.CENTER);
    empleadosagregar0.setFont(new java.awt.Font(fontletra, 0, 120));
    empleadosagregar0.setForeground(c2);
    GridLayout empleadosagregar1 = new GridLayout(11,4);
    empleadosagregar.setLayout(empleadosagregar1);
    JLabel empleadosagregar2= new JLabel("Nombres:");
    empleadosagregar2.setFont(new java.awt.Font(fontletra, 0, 60));
    empleadosagregar2.setForeground(c2);
    JTextField empleadosagregar3= new JTextField(20);
    empleadosagregar3.setFont(new java.awt.Font(fontletra, 0, 30));
    JLabel empleadosagregar4= new JLabel("Apellidos:");
    empleadosagregar4.setFont(new java.awt.Font(fontletra, 0, 60));
    empleadosagregar4.setForeground(c2);
    JTextField empleadosagregar5= new JTextField(20);
    empleadosagregar5.setFont(new java.awt.Font(fontletra, 0, 30));
    JLabel empleadosagregar6= new JLabel("Nomina:");
    empleadosagregar6.setFont(new java.awt.Font(fontletra, 0, 60));
    empleadosagregar6.setForeground(c2); 
    JTextField empleadosagregar7= new JTextField(20);
    empleadosagregar7.setFont(new java.awt.Font(fontletra, 0, 30));
    String[] puestosss={"ENCARGADO","COORDINADOR","CHEF","JEFE MESEROS","MESERO","AYUDANTE GENERAL","ASEO","RECEPCIONISTA","EJECUTIVO"};
    JLabel empleadosagregar8= new JLabel("Puesto:");
    empleadosagregar8.setFont(new java.awt.Font(fontletra, 0, 60));
    empleadosagregar8.setForeground(c2); 
    JComboBox empleadosagregar9= new JComboBox(puestosss );
    empleadosagregar9.setFont(new java.awt.Font(fontletra, 0, 30));
    JLabel empleadosagregar10= new JLabel("Sueldo:");
    empleadosagregar10.setFont(new java.awt.Font(fontletra, 0, 60));
    empleadosagregar10.setForeground(c2); 
    JTextField empleadosagregar11= new JTextField(20);
    empleadosagregar11.setFont(new java.awt.Font(fontletra, 0, 30));
    JLabel empleadosagregar14= new JLabel("Telefono:");
    empleadosagregar14.setFont(new java.awt.Font(fontletra, 0, 60));
    empleadosagregar14.setForeground(c2); 
    JTextField empleadosagregar15= new JTextField(20);
    empleadosagregar15.setFont(new java.awt.Font(fontletra, 0, 30));
    JLabel empleadosagregar16= new JLabel("Direccion:");
    empleadosagregar16.setFont(new java.awt.Font(fontletra, 0, 60));
    empleadosagregar16.setForeground(c2); 
    JTextField empleadosagregar17= new JTextField(20);
    empleadosagregar17.setFont(new java.awt.Font(fontletra, 0, 30));
    JLabel empleadosagregar18= new JLabel("Correo:");
    empleadosagregar18.setFont(new java.awt.Font(fontletra, 0, 60));
    empleadosagregar18.setForeground(c2); 
    JTextField empleadosagregar19= new JTextField(20);
    empleadosagregar19.setFont(new java.awt.Font(fontletra, 0, 30));
    JButton empleadosagregar13 = new JButton("Agregar"); 
    empleadosagregar13.setFont(new java.awt.Font(fontletra, 0, 60));
    empleadosagregar13.setForeground(c2);
    empleadosagregar13.setBackground(c1); 
    JButton empleadosagregar12 = new JButton("Volver Menu");
    empleadosagregar12.setFont(new java.awt.Font(fontletra, 0, 60));
    empleadosagregar12.setForeground(c2);
    empleadosagregar12.setBackground(c1);
    
    //ACTION LISTENER QUE CREA EL EMPLEADO Y SE LIMPIAN LOS CAMPOS
    empleadosagregar13.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        try{
          for(int x=0;x<empleados.length;x++){
            if(empleados[x]==null){
              empleados[x]= new Empleado(empleadosagregar3.getText(),empleadosagregar5.getText(),'M',empleadosagregar15.getText(),empleadosagregar17.getText(),empleadosagregar19.getText(),empleadosagregar7.getText(),(String)empleadosagregar9.getSelectedItem(), Double.parseDouble(empleadosagregar11.getText()));;
              empleadosagregar3.setText("");
              empleadosagregar5.setText("");
              empleadosagregar7.setText("");
              empleadosagregar11.setText("");
              empleadosagregar15.setText("");
              empleadosagregar17.setText("");
              empleadosagregar19.setText("");
              x=empleados.length;
            }
          }
          guardarEmpleados();}catch(Exception c){alerta1("Error,revise que las casillas esten completas");}
      }});
    
    //SE AGREGAN LOS COMPONENTES AL PANEL
    empleadosagregar.add(new JLabel("")); empleadosagregar.add(new JLabel("")); empleadosagregar.add(new JLabel(""));empleadosagregar.add(new JLabel(""));
    empleadosagregar.add(new JLabel(""));empleadosagregar.add(empleadosagregar2);empleadosagregar.add(empleadosagregar3); empleadosagregar.add(new JLabel(""));
    empleadosagregar.add(new JLabel(""));empleadosagregar.add(empleadosagregar4);empleadosagregar.add(empleadosagregar5); empleadosagregar.add(new JLabel(""));  
    empleadosagregar.add(new JLabel(""));empleadosagregar.add(empleadosagregar14);empleadosagregar.add(empleadosagregar15); empleadosagregar.add(new JLabel(""));
    empleadosagregar.add(new JLabel(""));empleadosagregar.add(empleadosagregar16);empleadosagregar.add(empleadosagregar17); empleadosagregar.add(new JLabel(""));
    empleadosagregar.add(new JLabel(""));empleadosagregar.add(empleadosagregar18);empleadosagregar.add(empleadosagregar19); empleadosagregar.add(new JLabel(""));
    empleadosagregar.add(new JLabel(""));empleadosagregar.add(empleadosagregar6);empleadosagregar.add(empleadosagregar7); empleadosagregar.add(new JLabel(""));
    empleadosagregar.add(new JLabel(""));empleadosagregar.add(empleadosagregar8);empleadosagregar.add(empleadosagregar9); empleadosagregar.add(new JLabel(""));
    empleadosagregar.add(new JLabel(""));empleadosagregar.add(empleadosagregar10);empleadosagregar.add(empleadosagregar11); empleadosagregar.add(new JLabel(""));
    empleadosagregar.add(new JLabel("")); empleadosagregar.add(new JLabel("")); empleadosagregar.add(empleadosagregar13);empleadosagregar.add(new JLabel(""));
    empleadosagregar.add(new JLabel("")); empleadosagregar.add(new JLabel("")); empleadosagregar.add(new JLabel(""));empleadosagregar.add(new JLabel(""));
    //SE CREA AL PANEL Y SE AJUSTAN LOS COMPONENTES
    JPanel main13= new JPanel();
    main13.setBackground(c);
    main13.setLayout(new BorderLayout());
    main13.add(empleadosagregar0, BorderLayout.NORTH);
    main13.add(empleadosagregar);
    main13.add(empleadosagregar12, BorderLayout.SOUTH);
    
    //EMPLEADOS QUITAR
    //SE CREAN LOS COMPONENTES Y SE LES AJUSTAN LAS PROPIEDADES
    JLabel quitarempleado1 = new JLabel("Nombre:");
    quitarempleado1.setFont(new java.awt.Font(fontletra, 0, 60));
    quitarempleado1.setForeground(c2);
    JComboBox quitarempleado2 = new JComboBox();
    quitarempleado2.setFont(new java.awt.Font(fontletra, 0, 30));
    //ACTION LISTENER QUE REFRESCA JCOMOBOX CADA VEZ QUE SE ELIGA LA OPCION DE VER EN EL MENU
    empleadosmenu4.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        quitarempleado2.removeAllItems();
        for(int x=0;x<empleados.length;x++){
          if(empleados[x]!=null)
            quitarempleado2.addItem(empleados[x].getNombre()+" "+empleados[x].getApellido());
        }
      }});
    JButton quitarempleado3 = new JButton("Quitar"); 
    quitarempleado3.setFont(new java.awt.Font(fontletra, 0, 60));
    quitarempleado3.setForeground(c2);
    quitarempleado3.setBackground(c1);
    //ACTION LISTENER QUE ELIMINA EMPLEADOS Y GUARDA LOS CAMBIOS
    quitarempleado3.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        for(int x=0;x<empleados.length;x++){
          if(empleados[x]!=null){
            if((empleados[x].getNombre()+" "+empleados[x].getApellido()).equals(quitarempleado2.getSelectedItem())){
              empleados[x]=null;
            }}
          guardarEmpleados();
        }
        quitarempleado2.removeAllItems();
        for(int x=0;x<empleados.length;x++){
          if(empleados[x]!=null)
            quitarempleado2.addItem(empleados[x].getNombre()+" "+empleados[x].getApellido());
        }
        guardarEmpleados();
      }});
    //SE CREA EL PANEL Y SE LE AÑADEN LOS COMPONENTES
    JPanel quitarempleado= new JPanel();
    quitarempleado.setBackground(c);
    GridLayout quitarempleado0 = new GridLayout(5,4);
    quitarempleado.setLayout(quitarempleado0);
    quitarempleado.add(new JLabel("")); quitarempleado.add(new JLabel("")); quitarempleado.add(new JLabel("")); quitarempleado.add(new JLabel(""));
    quitarempleado.add(new JLabel(""));quitarempleado.add(quitarempleado1); quitarempleado.add(quitarempleado2); quitarempleado.add(new JLabel(""));
    quitarempleado.add(new JLabel("")); quitarempleado.add(new JLabel("")); quitarempleado.add(new JLabel("")); quitarempleado.add(new JLabel(""));
    quitarempleado.add(new JLabel("")); quitarempleado.add(new JLabel(""));quitarempleado.add(quitarempleado3); quitarempleado.add(new JLabel(""));
    quitarempleado.add(new JLabel("")); quitarempleado.add(new JLabel("")); quitarempleado.add(new JLabel("")); quitarempleado.add(new JLabel(""));
    
    JLabel quitarempleado4 = new JLabel("QUITAR",SwingConstants.CENTER);
    quitarempleado4.setFont(new java.awt.Font(fontletra, 0, 120));
    quitarempleado4.setForeground(c2);
    JButton quitarempleado5 = new JButton("Volver Menu");
    quitarempleado5.setFont(new java.awt.Font(fontletra, 0, 60));
    quitarempleado5.setForeground(c2);
    quitarempleado5.setBackground(c1);
    //SE CREA EL PANEL Y SE LE AÑADEN LOS COMPONENTES
    JPanel main14= new JPanel();
    main14.setBackground(c);
    main14.setLayout(new BorderLayout());
    main14.add(quitarempleado4, BorderLayout.NORTH);
    main14.add(quitarempleado);
    main14.add(quitarempleado5, BorderLayout.SOUTH);
    
    //SEGURIDAD MENU PRINCIAAL
    //SE CREAL EL PANEL, COMPONENTES Y SE AJUSTAN LAS PROPIEDADES
    JPanel smenu= new JPanel();
    smenu.setBackground(c);
    JLabel smenu0 = new JLabel("SEGURIDAD",SwingConstants.CENTER);
    smenu0.setFont(new java.awt.Font(fontletra, 0, 120));
    smenu0.setForeground(c2);
    GridLayout smenu1 = new GridLayout(5,3);
    smenu.setLayout(smenu1); 
    JButton smenu2= new JButton("Agregar");
    smenu2.setFont(new java.awt.Font(fontletra, 0, 60));
    smenu2.setForeground(c2);
    smenu2.setBackground(c1);
    JButton smenu3= new JButton("Modificar");
    smenu3.setFont(new java.awt.Font(fontletra, 0, 60));
    smenu3.setForeground(c2);
    smenu3.setBackground(c1);
    JButton smenu4= new JButton("Quitar");
    smenu4.setFont(new java.awt.Font(fontletra, 0, 60));
    smenu4.setForeground(c2);
    smenu4.setBackground(c1);
    //SE AÑADEN LOS COMPONENTES AL PANEL
    smenu.add(new JLabel("")); smenu.add(new JLabel("")); smenu.add(new JLabel(""));
    smenu.add(new JLabel(""));smenu.add(smenu2); smenu.add(new JLabel(""));
    smenu.add(new JLabel(""));smenu.add(smenu3); smenu.add(new JLabel(""));
    smenu.add(new JLabel(""));smenu.add(smenu4); smenu.add(new JLabel(""));
    smenu.add(new JLabel("")); smenu.add(new JLabel("")); smenu.add(new JLabel(""));
    //SE CREA EL PANEL Y SE AÑADEN LOS COMPONENTES
    JPanel main15= new JPanel();
    main15.setBackground(c);
    main15.setLayout(new BorderLayout());
    main15.add(smenu0, BorderLayout.NORTH);
    main15.add(smenu);
    
    //SEGURIDAD AGREGAR
    //CREA COMPONENTES Y AJUSTA PROPIEDADES
    JLabel sagregar3 =new JLabel("Contraseña Act:");
    sagregar3.setFont(new java.awt.Font(fontletra, 0, 40));
    sagregar3.setForeground(c2);
    JPasswordField sagregar4 = new JPasswordField(20);
    sagregar4.setFont(new java.awt.Font(fontletra, 0, 40));
    JLabel sagregar5 =new JLabel("Nueva Cuenta:");
    sagregar5.setFont(new java.awt.Font(fontletra, 0, 40));
    sagregar5.setForeground(c2);
    JTextField sagregar6 = new JTextField(20);
    sagregar6.setFont(new java.awt.Font(fontletra, 0, 40));
    JLabel sagregar7 =new JLabel("Contraseña:");
    sagregar7.setFont(new java.awt.Font(fontletra, 0, 40));
    sagregar7.setForeground(c2);
    JPasswordField sagregar8 = new JPasswordField(20);
    sagregar8.setFont(new java.awt.Font(fontletra, 0, 40));
    JLabel sagregar9 =new JLabel("Confirmacion:");
    sagregar9.setFont(new java.awt.Font(fontletra, 0, 40));
    sagregar9.setForeground(c2);
    JPasswordField sagregar10 = new JPasswordField(20);
    sagregar10.setFont(new java.awt.Font(fontletra, 0, 40));
    JCheckBox sagregar14 = new JCheckBox("Contratos");
    sagregar14.setFont(new java.awt.Font(fontletra, 0, 40));
    sagregar14.setForeground(c2);
    sagregar14.setBackground(c);
    JCheckBox sagregar15 = new JCheckBox("Comidas");
    sagregar15.setFont(new java.awt.Font(fontletra, 0, 40));
    sagregar15.setForeground(c2);
    sagregar15.setBackground(c);
    JCheckBox sagregar16 = new JCheckBox("Empleados");
    sagregar16.setFont(new java.awt.Font(fontletra, 0, 40));
    sagregar16.setForeground(c2);
    sagregar16.setBackground(c);
    JCheckBox sagregar18 = new JCheckBox("Contratos");
    sagregar18.setFont(new java.awt.Font(fontletra, 0, 40));
    sagregar18.setForeground(c2);
    sagregar18.setBackground(c);
    JCheckBox sagregar19 = new JCheckBox("Comidas");
    sagregar19.setFont(new java.awt.Font(fontletra, 0, 40));
    sagregar19.setForeground(c2);
    sagregar19.setBackground(c);
    JCheckBox sagregar20 = new JCheckBox("Empleados");
    sagregar20.setFont(new java.awt.Font(fontletra, 0, 40));
    sagregar20.setForeground(c2);
    sagregar20.setBackground(c);
    JCheckBox sagregar21 = new JCheckBox("Seguridad");
    sagregar21.setFont(new java.awt.Font(fontletra, 0, 40));
    sagregar21.setForeground(c2);
    sagregar21.setBackground(c);
    JLabel sagregar22 =new JLabel("Ver");
    sagregar22.setFont(new java.awt.Font(fontletra, 0, 40));
    sagregar22.setForeground(c2);
    JLabel sagregar23 =new JLabel("Editar");
    sagregar23.setFont(new java.awt.Font(fontletra, 0, 40));
    sagregar23.setForeground(c2);
    JButton sagregar11 = new JButton("Guardar");
    sagregar11.setFont(new java.awt.Font(fontletra, 0, 40));
    sagregar11.setForeground(c2);
    sagregar11.setBackground(c1);
    JLabel sagregar12 = new JLabel("AGREGAR",SwingConstants.CENTER);
    sagregar12.setFont(new java.awt.Font(fontletra, 0, 120));
    sagregar12.setForeground(c2);
    JButton sagregar13 = new JButton("Volver Menu");
    sagregar13.setFont(new java.awt.Font(fontletra, 0, 60));
    sagregar13.setForeground(c2);
    sagregar13.setBackground(c1);
    //ACTION LISTENER QUE CREA EK USUARIO Y LIMPIA LOS CAMPOS
    sagregar11.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        boolean boleano=true;
        for(int x=0;x<usuarios.length;x++){
          if(usuarios[x]!=null){
              //REVISA LAS CONTRASEÑAS, QUE COINCIDAN
            if(sagregar6.getText().equals(usuarios[x].getCuenta())){
              boleano=false;
            }
          }}
        if(boleano){
          if(sagregar8.getText().equals(sagregar10.getText())){
            if(sagregar4.getText().equals(usuarioactual.getPassword())){
              for(int x=0;x<usuarios.length;x++){
                if(usuarios[x]==null){
                  usuarios[x]= new Usuario(sagregar6.getText(),sagregar8.getText(),sagregar14.isSelected(),sagregar18.isSelected(),sagregar15.isSelected(),sagregar19.isSelected(),sagregar16.isSelected(),sagregar20.isSelected(),sagregar21.isSelected());
                  x=usuarios.length; 
                  guardarCuentas();
                  sagregar6.setText("");
                  sagregar8.setText("");
                  sagregar10.setText("");
                  sagregar4.setText("");
                }
              }}else{alerta1("Error,revise la contraseña de la cuenta actual");}
          }else{alerta1("Error,revise las contraseñas, no coinciden");}
        }else{alerta1("Error,cuenta ocupada");}
      }});
    //SE CREA EL PANEL Y SE LE AÑADEN LOS COMPONENTES
    JPanel sagregar= new JPanel();
    sagregar.setBackground(c);
    GridLayout sagregar0 = new GridLayout(12,4);
    sagregar.setLayout(sagregar0);
    
    sagregar.add(new JLabel(""));sagregar.add(new JLabel(""));sagregar.add(new JLabel(""));sagregar.add(new JLabel(""));
    sagregar.add(new JLabel(""));sagregar.add(sagregar3);sagregar.add(sagregar4);sagregar.add(new JLabel(""));
    sagregar.add(new JLabel(""));sagregar.add(sagregar5);sagregar.add(sagregar6);sagregar.add(new JLabel(""));
    sagregar.add(new JLabel(""));sagregar.add(sagregar7);sagregar.add(sagregar8);sagregar.add(new JLabel(""));
    sagregar.add(new JLabel(""));sagregar.add(sagregar9);sagregar.add(sagregar10);sagregar.add(new JLabel(""));
    sagregar.add(new JLabel(""));sagregar.add(sagregar22);sagregar.add(sagregar23);sagregar.add(new JLabel(""));
    sagregar.add(new JLabel(""));sagregar.add(sagregar14);sagregar.add(sagregar18);sagregar.add(new JLabel(""));
    sagregar.add(new JLabel(""));sagregar.add(sagregar15);sagregar.add(sagregar19);sagregar.add(new JLabel(""));
    sagregar.add(new JLabel(""));sagregar.add(sagregar16);sagregar.add(sagregar20);sagregar.add(new JLabel(""));
    sagregar.add(new JLabel(""));sagregar.add(new JLabel(""));sagregar.add(sagregar21);sagregar.add(new JLabel(""));
    sagregar.add(new JLabel(""));sagregar.add(new JLabel(""));sagregar.add(sagregar11);sagregar.add(new JLabel(""));
    sagregar.add(new JLabel(""));sagregar.add(new JLabel(""));sagregar.add(new JLabel(""));sagregar.add(new JLabel(""));
    //SE CREA EL PANEL Y SE LE AÑADEN LOS COMPONENTES
    JPanel main16= new JPanel();
    main16.setBackground(c);
    main16.setLayout(new BorderLayout());
    main16.add(sagregar12, BorderLayout.NORTH);
    main16.add(sagregar);
    main16.add(sagregar13, BorderLayout.SOUTH);
    
    //SEGURIDAD MODIFICAR
    //SE CREAN LOS COMPONENTES Y SE AJUSTAN LAS PROPIEDADES
    JLabel smod3 =new JLabel("Contraseña:");
    smod3.setFont(new java.awt.Font(fontletra, 0, 40));
    smod3.setForeground(c2);
    JPasswordField smod4 = new JPasswordField(20);
    smod4.setFont(new java.awt.Font(fontletra, 0, 40));
    JLabel smod5 =new JLabel("Modificar Cuenta:");
    smod5.setFont(new java.awt.Font(fontletra, 0, 40));
    smod5.setForeground(c2);
    JComboBox smod6 = new JComboBox();
    smod6.setFont(new java.awt.Font(fontletra, 0, 40));
    JLabel smod7 =new JLabel("Nueva Contraseña:");
    smod7.setFont(new java.awt.Font(fontletra, 0, 40));
    smod7.setForeground(c2);
    JPasswordField smod8 = new JPasswordField(20);
    smod8.setFont(new java.awt.Font(fontletra, 0, 40));
    JLabel smod9 =new JLabel("Confirmacion:");
    smod9.setFont(new java.awt.Font(fontletra, 0, 40));
    smod9.setForeground(c2);
    JPasswordField smod10 = new JPasswordField(20);
    smod10.setFont(new java.awt.Font(fontletra, 0, 40));
    JCheckBox smod14 = new JCheckBox("Contratos");
    smod14.setFont(new java.awt.Font(fontletra, 0, 40));
    smod14.setForeground(c2);
    smod14.setBackground(c);
    JCheckBox smod15 = new JCheckBox("Comidas");
    smod15.setFont(new java.awt.Font(fontletra, 0, 40));
    smod15.setForeground(c2);
    smod15.setBackground(c);
    JCheckBox smod16 = new JCheckBox("Empleados");
    smod16.setFont(new java.awt.Font(fontletra, 0, 40));
    smod16.setForeground(c2);
    smod16.setBackground(c);
    JCheckBox smod18 = new JCheckBox("Contratos");
    smod18.setFont(new java.awt.Font(fontletra, 0, 40));
    smod18.setForeground(c2);
    smod18.setBackground(c);
    JCheckBox smod19 = new JCheckBox("Comidas");
    smod19.setFont(new java.awt.Font(fontletra, 0, 40));
    smod19.setForeground(c2);
    smod19.setBackground(c);
    JCheckBox smod20 = new JCheckBox("Empleados");
    smod20.setFont(new java.awt.Font(fontletra, 0, 40));
    smod20.setForeground(c2);
    smod20.setBackground(c);
    JCheckBox smod21 = new JCheckBox("Seguridad");
    smod21.setFont(new java.awt.Font(fontletra, 0, 40));
    smod21.setForeground(c2);
    smod21.setBackground(c);
    JLabel smod22 =new JLabel("Ver");
    smod22.setFont(new java.awt.Font(fontletra, 0, 40));
    smod22.setForeground(c2);
    JLabel smod23 =new JLabel("Editar");
    smod23.setFont(new java.awt.Font(fontletra, 0, 40));
    smod23.setForeground(c2);
    JButton smod11 = new JButton("Guardar");
    smod11.setFont(new java.awt.Font(fontletra, 0, 40));
    smod11.setForeground(c2);
    smod11.setBackground(c1);
    JLabel smod12 = new JLabel("MODIFICAR",SwingConstants.CENTER);
    smod12.setFont(new java.awt.Font(fontletra, 0, 120));
    smod12.setForeground(c2);
    JButton smod13 = new JButton("Volver Menu");
    smod13.setFont(new java.awt.Font(fontletra, 0, 60));
    smod13.setForeground(c2);
    smod13.setBackground(c1);
    //ACTION LISTENER QUE GUARDA LOS CAMBIOS Y LIMPIA LOS CAMPOS
    smod11.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        
        if(smod8.getText().equals(smod10.getText())){
          if(smod4.getText().equals(usuarioactual.getPassword())){
            for(int x=0;x<usuarios.length;x++){
              if(usuarios[x]!=null){
                if(usuarios[x].getCuenta().equals(smod6.getSelectedItem())){
                  usuarios[x]= new Usuario((String)smod6.getSelectedItem(),smod8.getText(),smod14.isSelected(),smod18.isSelected(),smod15.isSelected(),smod19.isSelected(),smod16.isSelected(),smod20.isSelected(),smod21.isSelected());
                  x=usuarios.length; 
                  guardarCuentas();
                  smod6.setSelectedIndex(0);
                  smod8.setText("");
                  smod10.setText("");
                  smod4.setText("");
                }}
            }}else{alerta1("Error,revise la contraseña de la cuenta actual");}
        }else{alerta1("Error,revise las contraseñas, no coinciden");}
        
      }});
    //SE CREA EL PANEL Y SE LE AÑADEN LOS COMPONENTES
    JPanel smod= new JPanel();
    smod.setBackground(c);
    GridLayout smod0 = new GridLayout(12,4);
    smod.setLayout(smod0);
    
    smod.add(new JLabel(""));smod.add(new JLabel(""));smod.add(new JLabel(""));smod.add(new JLabel(""));
    smod.add(new JLabel(""));smod.add(smod3);smod.add(smod4);smod.add(new JLabel(""));
    smod.add(new JLabel(""));smod.add(smod5);smod.add(smod6);smod.add(new JLabel(""));
    smod.add(new JLabel(""));smod.add(smod7);smod.add(smod8);smod.add(new JLabel(""));
    smod.add(new JLabel(""));smod.add(smod9);smod.add(smod10);smod.add(new JLabel(""));
    smod.add(new JLabel(""));smod.add(smod22);smod.add(smod23);smod.add(new JLabel(""));
    smod.add(new JLabel(""));smod.add(smod14);smod.add(smod18);smod.add(new JLabel(""));
    smod.add(new JLabel(""));smod.add(smod15);smod.add(smod19);smod.add(new JLabel(""));
    smod.add(new JLabel(""));smod.add(smod16);smod.add(smod20);smod.add(new JLabel(""));
    smod.add(new JLabel(""));smod.add(new JLabel(""));smod.add(smod21);smod.add(new JLabel(""));
    smod.add(new JLabel(""));smod.add(new JLabel(""));smod.add(smod11);smod.add(new JLabel(""));
    smod.add(new JLabel(""));smod.add(new JLabel(""));smod.add(new JLabel(""));smod.add(new JLabel(""));
  
    //SE CREA EL PANEL Y SE LE AÑADEN LOS COMPONENTES
    JPanel main17= new JPanel();
    main17.setBackground(c);
    main17.setLayout(new BorderLayout());
    main17.add(smod12, BorderLayout.NORTH);
    main17.add(smod);
    main17.add(smod13, BorderLayout.SOUTH);
    
    //SEGURIDAD QUITAR
    JLabel squitar3 =new JLabel("Contraseña:");
    squitar3.setFont(new java.awt.Font(fontletra, 0, 40));
    squitar3.setForeground(c2);
    JPasswordField squitar4 = new JPasswordField(20);
    squitar4.setFont(new java.awt.Font(fontletra, 0, 40));
    JLabel squitar5 =new JLabel("Eliminar Cuenta:");
    squitar5.setFont(new java.awt.Font(fontletra, 0, 40));
    squitar5.setForeground(c2);
    JComboBox squitar6 = new JComboBox();
    squitar6.setFont(new java.awt.Font(fontletra, 0, 40));
    JButton squitar11 = new JButton("Eliminar");
    squitar11.setFont(new java.awt.Font(fontletra, 0, 40));
    squitar11.setForeground(c2);
    squitar11.setBackground(c1);
    JLabel squitar12 = new JLabel("ELIMINAR",SwingConstants.CENTER);
    squitar12.setFont(new java.awt.Font(fontletra, 0, 120));
    squitar12.setForeground(c2);
    JButton squitar13 = new JButton("Volver Menu");
    squitar13.setFont(new java.awt.Font(fontletra, 0, 60));
    squitar13.setForeground(c2);
    squitar13.setBackground(c1);
    //ACTION LISTENER PARA ELIMINAR EL USUARIO Y LIMPIAR LOS CAMPOS
    squitar11.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){  
        if(squitar4.getText().equals(usuarioactual.getPassword())){
          for(int x=0;x<usuarios.length;x++){
            if(usuarios[x]!=null){
              if(usuarios[x].getCuenta().equals(squitar6.getSelectedItem())){
                usuarios[x]= null;
                x=usuarios.length; 
                guardarCuentas();
                squitar6.setSelectedIndex(0);
                squitar4.setText("");
                squitar6.removeAllItems();
                for(int y=0;y<usuarios.length;y++){
                  if(usuarios[y]!=null){
                    squitar6.addItem(usuarios[y].getCuenta());
                  }
                }
              }}
          }}else{alerta1("Error,revise la contraseña de la cuenta actual");}
      }});
    //SE CREA EL PANEL Y SE LE AÑADEN LOS COMPONENTES
    JPanel squitar= new JPanel();
    squitar.setBackground(c);
    GridLayout squitar0 = new GridLayout(5,4);
    squitar.setLayout(squitar0);
    
    squitar.add(new JLabel(""));squitar.add(new JLabel(""));squitar.add(new JLabel(""));squitar.add(new JLabel(""));
    squitar.add(new JLabel(""));squitar.add(squitar3);squitar.add(squitar4);squitar.add(new JLabel(""));
    squitar.add(new JLabel(""));squitar.add(squitar5);squitar.add(squitar6);squitar.add(new JLabel(""));
    squitar.add(new JLabel(""));squitar.add(new JLabel(""));squitar.add(squitar11);squitar.add(new JLabel(""));
    squitar.add(new JLabel(""));squitar.add(new JLabel(""));squitar.add(new JLabel(""));squitar.add(new JLabel(""));
    
    //SE CREA EL PANEL Y SE LE AÑADEN LOS COMPONENTES
    JPanel main18= new JPanel();
    main18.setBackground(c);
    main18.setLayout(new BorderLayout());
    main18.add(squitar12, BorderLayout.NORTH);
    main18.add(squitar);
    main18.add(squitar13, BorderLayout.SOUTH);
       
//SE CREAN EL PANEL DE CARTAS 

    final   JPanel cards = new JPanel(new CardLayout());
    //SE AÑADEN LOS PANELES AL PANEL DE CARTAS AÑADIENDO REFERECIAS RESPECTIVAS
    cards.add(main10,"CALENDARIO");
    cards.add(main3,"COMIDASMENU");
    cards.add(main2,"COMIDASVER");
    cards.add(main4,"COMIDASMODIFICAR");
    cards.add(main5,"COMIDASAGREGAR");
    cards.add(main6,"COMIDASQUITAR");
    cards.add(main,"CONTRATOSAGREGAR");
    cards.add(main7,"CONTRATOSMENU");
    cards.add(main8,"CONTRATOSBUSCAR");
    cards.add(main11,"EMPLEADOS");
    cards.add(main12,"EMPLEADOSVER");
    cards.add(main13,"EMPLEADOSAGREGAR");
    cards.add(main14,"EMPLEADOSQUITAR");
    cards.add(main15,"SEGURIDAD");
    cards.add(main16,"SEGURIDADAGREGAR");
    cards.add(main17,"SEGURIDADMODIFICAR");
    cards.add(main18,"SEGURIDADQUITAR");
    cards.add(tablapanel,"PANELTABLA");
    
    //AJUSTAR A ADENTRO
    final  Container cp = getContentPane();
    cp.add(adentro1, BorderLayout.WEST);
    cp.add(cards,BorderLayout.CENTER);
    final CardLayout cl = (CardLayout)(cards.getLayout());
    
    //AREA DE ACTION LISTENERS
        //SE HABILITAN E INHABILITA COMPONENTES/COMPONENTE AL HACER CLICK EN EL BOTON MODIFICAR
    buttonscalendarios[1].addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        boxscalendarios[2].setEnabled(true);boxscalendarios[3].setEnabled(true); fieldscalendarios[2].setEnabled(true);fieldscalendarios[3].setEnabled(true);fieldscalendarios[4].setEnabled(true);fieldscalendarios[5].setEnabled(true);boxscalendarios[1].setEnabled(true);boxscalendarios[4].setEnabled(true);boxscalendarios[1].setEnabled(true);boxscalendarios[4].setEnabled(true);fieldscalendarios[0].setEnabled(true);fieldscalendarios[1].setEnabled(true);fieldscalendarios[6].setEnabled(true);fieldscalendarios[7].setEnabled(true);fieldscalendarios[8].setEnabled(true);boxscalendarios[9].setEnabled(true);boxscalendarios[0].setEnabled(true);fieldscalendarios[9].setEnabled(true);boxscalendarios[5].setEnabled(true);fieldscalendarios[10].setEnabled(true);boxscalendarios[6].setEnabled(true);boxscalendarios[7].setEnabled(true);cal28.setEnabled(true);boxscalendarios[8].setEnabled(true);fieldscalendarios[11].setEnabled(true);boxscalendarios[9].setEnabled(true);buttonscalendarios[2].setEnabled(true);buttonscalendarios[3].setEnabled(true);cal27.setEnabled(true);
        buttonscalendarios[0].setEnabled(false);
      }});
        //SE HABILITAN E INHABILITA COMPONENTES/COMPONENTE AL HACER CLICK EN EL BOTON 
    buttonscalendarios[2].addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        boxscalendarios[2].setEnabled(false);boxscalendarios[3].setEnabled(false); fieldscalendarios[2].setEnabled(false);fieldscalendarios[3].setEnabled(false);fieldscalendarios[4].setEnabled(false);fieldscalendarios[5].setEnabled(false);boxscalendarios[1].setEnabled(false);boxscalendarios[4].setEnabled(false); fieldscalendarios[0].setEnabled(false);fieldscalendarios[1].setEnabled(false);fieldscalendarios[6].setEnabled(false);fieldscalendarios[7].setEnabled(false);fieldscalendarios[8].setEnabled(false);boxscalendarios[9].setEnabled(false);boxscalendarios[0].setEnabled(false);fieldscalendarios[9].setEnabled(false);boxscalendarios[5].setEnabled(false);fieldscalendarios[10].setEnabled(false);boxscalendarios[6].setEnabled(false);boxscalendarios[7].setEnabled(false);cal28.setEnabled(false);boxscalendarios[8].setEnabled(false);boxscalendarios[9].setEnabled(false);fieldscalendarios[11].setEnabled(false);buttonscalendarios[2].setEnabled(false);buttonscalendarios[3].setEnabled(false);cal27.setEnabled(false);
        buttonscalendarios[0].setEnabled(true);
      }});
    //SE HABILITAN E INHABILITA COMPONENTES/COMPONENTE AL HACER CLICK EN EL BOTON 
    buttonscalendarios[3].addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        boxscalendarios[2].setEnabled(false);boxscalendarios[3].setEnabled(false);fieldscalendarios[2].setEnabled(false);fieldscalendarios[3].setEnabled(false);fieldscalendarios[4].setEnabled(false);fieldscalendarios[5].setEnabled(false);boxscalendarios[1].setEnabled(false);boxscalendarios[4].setEnabled(false);fieldscalendarios[0].setEnabled(false);fieldscalendarios[1].setEnabled(false);fieldscalendarios[6].setEnabled(false);fieldscalendarios[7].setEnabled(false);fieldscalendarios[8].setEnabled(false);boxscalendarios[9].setEnabled(false);boxscalendarios[0].setEnabled(false);fieldscalendarios[9].setEnabled(false);boxscalendarios[5].setEnabled(false);fieldscalendarios[10].setEnabled(false);boxscalendarios[6].setEnabled(false);boxscalendarios[7].setEnabled(false);cal28.setEnabled(false);boxscalendarios[8].setEnabled(false);boxscalendarios[9].setEnabled(false);fieldscalendarios[11].setEnabled(false);buttonscalendarios[2].setEnabled(false);buttonscalendarios[3].setEnabled(false);cal27.setEnabled(false);
        buttonscalendarios[0].setEnabled(true);
      }});
    //SE MUESTRA EL PANEL ADECUADO HACIENDO SU REFERENCIA
    quitarempleado5.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        cl.show(cards, "EMPLEADOS"); 
      }});
    //SE MUESTRA EL PANEL ADECUADO HACIENDO SU REFERENCIA
    empleadosagregar12.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        cl.show(cards, "EMPLEADOS"); 
      }});
    //SE MUESTRA EL PANEL ADECUADO HACIENDO SU REFERENCIA
    empleadosver12.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        cl.show(cards, "EMPLEADOS"); 
      }});
    //SE MUESTRA EL PANEL ADECUADO HACIENDO SU REFERENCIA
    empleadosmenu3.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        cl.show(cards, "EMPLEADOSAGREGAR"); 
      }});
    //SE MUESTRA EL PANEL ADECUADO HACIENDO SU REFERENCIA
    empleadosmenu4.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        cl.show(cards, "EMPLEADOSQUITAR"); 
      }});
    //SE MUESTRA EL PANEL ADECUADO HACIENDO SU REFERENCIA
    empleadosmenu2.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        cl.show(cards, "EMPLEADOSVER");
      }});
     //SE MUESTRA EL PANEL ADECUADO HACIENDO SU REFERENCIA Y LE AJUSTA LA INFORMACION EN LOS CAMPOS CORRESPONDIENTES A LA FECHA, REFRESCANDO LOS JCOMBOBOXS
    contratosmenu14.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        if(contratosmenu11.getSelectedItem()!=null){
          fieldscalendarios[8].setText((String)contratosmenu11.getSelectedItem());}
        else{alerta1("Error,revise las casillas");}
        for(int x=0;x<eventos.length;x++){
          if(eventos[x]!=null){
            if(eventos[x].getNombre().equals((String)contratosmenu11.getSelectedItem())){
              cal14.getJFormattedTextField().setText(eventos[x].getFecha()); 
            }
          }}
        int count=0; 
        for(int x=0;x<eventos.length;x++){
          if(eventos[x]!=null){
            if(eventos[x].getFecha().equals(cal14.getJFormattedTextField().getText())){
              count++; }}}
        if(count==1){
          for(int x=0;x<eventos.length;x++){
            if(eventos[x]!=null){
              if(eventos[x].getFecha().equals(cal14.getJFormattedTextField().getText())){
                fieldscalendarios[0].setText(eventos[x].clientes.getNombre());
                fieldscalendarios[1].setText(eventos[x].clientes.getTelefono());
                fieldscalendarios[6].setText(eventos[x].clientes.getNreferente());
                fieldscalendarios[7].setText(eventos[x].clientes.getTreferente());
                fieldscalendarios[8].setText(eventos[x].getNombre());
                boxscalendarios[0].setSelectedItem(eventos[x].getPrimerT());
                boxscalendarios[1].setSelectedItem(eventos[x].getSegundoT1());
                boxscalendarios[2].setSelectedItem(eventos[x].getSegundoT2());
                boxscalendarios[3].setSelectedItem(eventos[x].getSegundoT3());
                boxscalendarios[4].setSelectedItem(eventos[x].getTercerT());
                fieldscalendarios[9].setText(String.valueOf(eventos[x].getCantidadAdt()));
                boxscalendarios[5].setSelectedItem(eventos[x].getComidaNiño());
                fieldscalendarios[10].setText(String.valueOf(eventos[x].getCantidadNiño()));
                boxscalendarios[6].setSelectedItem(eventos[x].getHoraInicial());
                boxscalendarios[7].setSelectedItem(eventos[x].getHoraFinal());
                cal27.setSelected(eventos[x].getMusica());
                cal28.setSelected(eventos[x].getArreglo());
                boxscalendarios[8].setSelectedItem(eventos[x].getSalon());
                fieldscalendarios[11].setText(String.valueOf(eventos[x].getTotal()));
                boxscalendarios[9].setSelectedItem(eventos[x].getDescuento());
                fieldscalendarios[2].setText(eventos[x].clientes.getApellido());
                fieldscalendarios[5].setText(eventos[x].clientes.getDomicilio());
                fieldscalendarios[4].setText(eventos[x].clientes.getCorreo());
                fieldscalendarios[3].setText(String.valueOf((eventos[x].clientes.getRfc())));}}
          }}
        if(count>=2){
          String cal54=fieldscalendarios[8].getText();
          
          for(int x=0;x<eventos.length;x++){
            if(eventos[x]!=null)
              if((eventos[x].getFecha()).equals(cal14.getJFormattedTextField().getText())&&(eventos[x].getNombre()).equals(cal54)){
              fieldscalendarios[0].setText(eventos[x].clientes.getNombre());
              fieldscalendarios[1].setText(eventos[x].clientes.getTelefono());
              fieldscalendarios[6].setText(eventos[x].clientes.getNreferente());
              fieldscalendarios[7].setText(eventos[x].clientes.getTreferente());
              fieldscalendarios[8].setText(eventos[x].getNombre());
              boxscalendarios[0].setSelectedItem(eventos[x].getPrimerT());
              boxscalendarios[1].setSelectedItem(eventos[x].getSegundoT1());
              boxscalendarios[2].setSelectedItem(eventos[x].getSegundoT2());
              boxscalendarios[3].setSelectedItem(eventos[x].getSegundoT3());
              boxscalendarios[4].setSelectedItem(eventos[x].getTercerT());
              fieldscalendarios[9].setText(String.valueOf(eventos[x].getCantidadAdt()));
              boxscalendarios[5].setSelectedItem(eventos[x].getComidaNiño());
              fieldscalendarios[10].setText(String.valueOf(eventos[x].getCantidadNiño()));
              boxscalendarios[6].setSelectedItem(eventos[x].getHoraInicial());
              boxscalendarios[7].setSelectedItem(eventos[x].getHoraFinal());
              cal27.setSelected(eventos[x].getMusica());
              cal28.setSelected(eventos[x].getArreglo());
              boxscalendarios[8].setSelectedItem(eventos[x].getSalon());
              fieldscalendarios[11].setText(String.valueOf(eventos[x].getTotal()));
              boxscalendarios[9].setSelectedItem(eventos[x].getDescuento());
              fieldscalendarios[2].setText(eventos[x].clientes.getApellido());
              fieldscalendarios[5].setText(eventos[x].clientes.getDomicilio());
              fieldscalendarios[4].setText(eventos[x].clientes.getCorreo());
              fieldscalendarios[3].setText(String.valueOf((eventos[x].clientes.getRfc())));
            }} }
        if(count==0){
          for(int i=0;i<fieldscalendarios.length;i++){fieldscalendarios[i].setText("");}
          for(int i=0;i<boxscalendarios.length;i++){boxscalendarios[i].setSelectedItem("");}
          cal27.setSelected(false);
          cal28.setSelected(false);
          fieldscalendarios[9].setText(String.valueOf(0));
          fieldscalendarios[10].setText(String.valueOf(0));
        }
        if(boxscalendarios[0].getSelectedItem()==null || boxscalendarios[0].getSelectedItem().equals("")){
          for(int i=0;i<5;i++){boxscalendarios[i].removeAllItems();}
          boxscalendarios[0].setModel(new DefaultComboBoxModel(comidas));
          boxscalendarios[1].setModel(new DefaultComboBoxModel(comidas1));
          boxscalendarios[2].setModel(new DefaultComboBoxModel(comidas2));
          boxscalendarios[3].setModel(new DefaultComboBoxModel(comidas2));
          boxscalendarios[4].setModel(new DefaultComboBoxModel(comidas3));
          for(int i=0;i<5;i++){boxscalendarios[i].setSelectedItem("");}}         
        else{
          
          String temp=(String) boxscalendarios[0].getSelectedItem();String temp1=(String) boxscalendarios[1].getSelectedItem();String temp2=(String) boxscalendarios[2].getSelectedItem();String temp3=(String) boxscalendarios[3].getSelectedItem();String temp4=(String) boxscalendarios[4].getSelectedItem();
          boxscalendarios[0].setModel(new DefaultComboBoxModel(comidas));
          boxscalendarios[1].setModel(new DefaultComboBoxModel(comidas1));
          boxscalendarios[2].setModel(new DefaultComboBoxModel(comidas2));
          boxscalendarios[3].setModel(new DefaultComboBoxModel(comidas2));
          boxscalendarios[4].setModel(new DefaultComboBoxModel(comidas3)); 
          boxscalendarios[0].setSelectedItem(temp); boxscalendarios[1].setSelectedItem(temp1);boxscalendarios[2].setSelectedItem(temp2);boxscalendarios[3].setSelectedItem(temp3);boxscalendarios[4].setSelectedItem(temp4);    
        }
        cl.show(cards, "CALENDARIO");   
      }});
     //SE MUESTRA EL PANEL ADECUADO HACIENDO SU REFERENCIA Y LE AJUSTA LA INFORMACION EN LOS CAMPOS CORRESPONDIENTES A LA FECHA, REFRESCANDO LOS JCOMBOBOXS
    contratosmenu15.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        String [] parLineas = ((String)contratosmenu12.getSelectedItem()).split("-");
        if(parLineas[0]!=null){
          fieldscalendarios[0].setText(parLineas[0]);
        }
        else{alerta1("Error,revise las casillas");}
        for(int x=0;x<eventos.length;x++){
          if(eventos[x]!=null){
            if((eventos[x].clientes.getNombre()).equals(parLineas[0])&&(eventos[x].clientes.getApellido()).equals(parLineas[1]) ){
              cal14.getJFormattedTextField().setText(eventos[x].getFecha()); 
            }
          }}
        int count=0; 
        for(int x=0;x<eventos.length;x++){
          if(eventos[x]!=null){
            if(eventos[x].getFecha().equals(cal14.getJFormattedTextField().getText())){
              count++; }}}
        if(count==1){
          for(int x=0;x<eventos.length;x++){
            if(eventos[x]!=null){
              if(eventos[x].getFecha().equals(cal14.getJFormattedTextField().getText())){
                fieldscalendarios[0].setText(eventos[x].clientes.getNombre());
                fieldscalendarios[1].setText(eventos[x].clientes.getTelefono());
                fieldscalendarios[6].setText(eventos[x].clientes.getNreferente());
                fieldscalendarios[7].setText(eventos[x].clientes.getTreferente());
                fieldscalendarios[8].setText(eventos[x].getNombre());
                boxscalendarios[0].setSelectedItem(eventos[x].getPrimerT());
                boxscalendarios[1].setSelectedItem(eventos[x].getSegundoT1());
                boxscalendarios[2].setSelectedItem(eventos[x].getSegundoT2());
                boxscalendarios[3].setSelectedItem(eventos[x].getSegundoT3());
                boxscalendarios[4].setSelectedItem(eventos[x].getTercerT());
                fieldscalendarios[9].setText(String.valueOf(eventos[x].getCantidadAdt()));
                boxscalendarios[5].setSelectedItem(eventos[x].getComidaNiño());
                fieldscalendarios[10].setText(String.valueOf(eventos[x].getCantidadNiño()));
                boxscalendarios[6].setSelectedItem(eventos[x].getHoraInicial());
                boxscalendarios[7].setSelectedItem(eventos[x].getHoraFinal());
                cal27.setSelected(eventos[x].getMusica());
                cal28.setSelected(eventos[x].getArreglo());
                boxscalendarios[8].setSelectedItem(eventos[x].getSalon());
                fieldscalendarios[11].setText(String.valueOf(eventos[x].getTotal()));
                boxscalendarios[9].setSelectedItem(String.valueOf(eventos[x].getDescuento()));
                fieldscalendarios[2].setText(eventos[x].clientes.getApellido());
                fieldscalendarios[5].setText(eventos[x].clientes.getDomicilio());
                fieldscalendarios[4].setText(eventos[x].clientes.getCorreo());
                fieldscalendarios[3].setText(String.valueOf((eventos[x].clientes.getRfc())));}}
          }}
        if(count>=2){  
          String cal54="";
          for(int x=0;x<eventos.length;x++){
            if(eventos[x]!=null){
              if(fieldscalendarios[0].getText().equals(eventos[x].clientes.getNombre()) && (parLineas[1]).equals(eventos[x].clientes.getApellido()) && (eventos[x].getFecha()).equals(cal14.getJFormattedTextField().getText())){
                cal54=eventos[x].getNombre();
              }
            }
          }
          for(int x=0;x<eventos.length;x++){
            if(eventos[x]!=null)
              if((eventos[x].getFecha()).equals(cal14.getJFormattedTextField().getText())&&(eventos[x].getNombre()).equals(cal54)){
              fieldscalendarios[0].setText(eventos[x].clientes.getNombre());
              fieldscalendarios[1].setText(eventos[x].clientes.getTelefono());
              fieldscalendarios[6].setText(eventos[x].clientes.getNreferente());
              fieldscalendarios[7].setText(eventos[x].clientes.getTreferente());
              fieldscalendarios[8].setText(eventos[x].getNombre());
              boxscalendarios[0].setSelectedItem(eventos[x].getPrimerT());
              boxscalendarios[1].setSelectedItem(eventos[x].getSegundoT1());
              boxscalendarios[2].setSelectedItem(eventos[x].getSegundoT2());
              boxscalendarios[3].setSelectedItem(eventos[x].getSegundoT3());
              boxscalendarios[4].setSelectedItem(eventos[x].getTercerT());
              fieldscalendarios[9].setText(String.valueOf(eventos[x].getCantidadAdt()));
              boxscalendarios[5].setSelectedItem(eventos[x].getComidaNiño());
              fieldscalendarios[10].setText(String.valueOf(eventos[x].getCantidadNiño()));
              boxscalendarios[6].setSelectedItem(eventos[x].getHoraInicial());
              boxscalendarios[7].setSelectedItem(eventos[x].getHoraFinal());
              cal27.setSelected(eventos[x].getMusica());
              cal28.setSelected(eventos[x].getArreglo());
              boxscalendarios[8].setSelectedItem(eventos[x].getSalon());
              fieldscalendarios[11].setText(String.valueOf(eventos[x].getTotal()));
              boxscalendarios[9].setSelectedItem(String.valueOf(eventos[x].getTotal()));
              fieldscalendarios[2].setText(eventos[x].clientes.getApellido());
              fieldscalendarios[5].setText(eventos[x].clientes.getDomicilio());
              fieldscalendarios[4].setText(eventos[x].clientes.getCorreo());
              fieldscalendarios[3].setText(String.valueOf((eventos[x].clientes.getRfc())));
            }}    
        }
        if(count==0){
          for(int i=0;i<fieldscalendarios.length;i++){fieldscalendarios[i].setText("");}
          for(int i=0;i<boxscalendarios.length;i++){boxscalendarios[i].setSelectedItem("");}
          cal27.setSelected(false);
          cal28.setSelected(false);
          fieldscalendarios[9].setText(String.valueOf(0));
          fieldscalendarios[10].setText(String.valueOf(0));
        }
        if(boxscalendarios[0].getSelectedItem()==null || boxscalendarios[0].getSelectedItem().equals("")){
          for(int i=0;i<5;i++){boxscalendarios[i].removeAllItems();}
          boxscalendarios[0].setModel(new DefaultComboBoxModel(comidas));
          boxscalendarios[1].setModel(new DefaultComboBoxModel(comidas1));
          boxscalendarios[2].setModel(new DefaultComboBoxModel(comidas2));
          boxscalendarios[3].setModel(new DefaultComboBoxModel(comidas2));
          boxscalendarios[4].setModel(new DefaultComboBoxModel(comidas3));
          for(int i=0;i<5;i++){boxscalendarios[i].setSelectedItem("");}}
        else{     
          String temp=(String) boxscalendarios[0].getSelectedItem();String temp1=(String) boxscalendarios[1].getSelectedItem();String temp2=(String) boxscalendarios[2].getSelectedItem();String temp3=(String) boxscalendarios[3].getSelectedItem();String temp4=(String) boxscalendarios[4].getSelectedItem();
          boxscalendarios[0].setModel(new DefaultComboBoxModel(comidas));
          boxscalendarios[1].setModel(new DefaultComboBoxModel(comidas1));
          boxscalendarios[2].setModel(new DefaultComboBoxModel(comidas2));
          boxscalendarios[3].setModel(new DefaultComboBoxModel(comidas2));
          boxscalendarios[4].setModel(new DefaultComboBoxModel(comidas3)); 
          boxscalendarios[0].setSelectedItem(temp); boxscalendarios[1].setSelectedItem(temp1);boxscalendarios[2].setSelectedItem(temp2);boxscalendarios[3].setSelectedItem(temp3);boxscalendarios[4].setSelectedItem(temp4);          
        }
        cl.show(cards, "CALENDARIO");   
      }});
     //SE MUESTRA EL PANEL ADECUADO HACIENDO SU REFERENCIA Y LE AJUSTA LA INFORMACION EN LOS CAMPOS CORRESPONDIENTES A LA FECHA, REFRESCANDO LOS JCOMBOBOXS
    contratosmenu13.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        if(contratosmenu10.getSelectedItem()!=null){
          cal14.getJFormattedTextField().setText((String)contratosmenu10.getSelectedItem());}
        else{cal14.getJFormattedTextField().setText("30.08.2017");}
        int count=0; 
        for(int x=0;x<eventos.length;x++){
          if(eventos[x]!=null){
            if(eventos[x].getFecha().equals(cal14.getJFormattedTextField().getText())){
              count++; }}}
        if(count==1){
          for(int x=0;x<eventos.length;x++){
            if(eventos[x]!=null){
              if(eventos[x].getFecha().equals(cal14.getJFormattedTextField().getText())){
                fieldscalendarios[0].setText(eventos[x].clientes.getNombre());
                fieldscalendarios[1].setText(eventos[x].clientes.getTelefono());
                fieldscalendarios[6].setText(eventos[x].clientes.getNreferente());
                fieldscalendarios[7].setText(eventos[x].clientes.getTreferente());
                fieldscalendarios[8].setText(eventos[x].getNombre());
                boxscalendarios[0].setSelectedItem(eventos[x].getPrimerT());
                boxscalendarios[1].setSelectedItem(eventos[x].getSegundoT1());
                boxscalendarios[2].setSelectedItem(eventos[x].getSegundoT2());
                boxscalendarios[3].setSelectedItem(eventos[x].getSegundoT3());
                boxscalendarios[4].setSelectedItem(eventos[x].getTercerT());
                fieldscalendarios[9].setText(String.valueOf(eventos[x].getCantidadAdt()));
                boxscalendarios[5].setSelectedItem(eventos[x].getComidaNiño());
                fieldscalendarios[10].setText(String.valueOf(eventos[x].getCantidadNiño()));
                boxscalendarios[6].setSelectedItem(eventos[x].getHoraInicial());
                boxscalendarios[7].setSelectedItem(eventos[x].getHoraFinal());
                cal27.setSelected(eventos[x].getMusica());
                cal28.setSelected(eventos[x].getArreglo());
                boxscalendarios[8].setSelectedItem(eventos[x].getSalon());
                boxscalendarios[9].setSelectedItem(eventos[x].getDescuento());
                fieldscalendarios[11].setText(String.valueOf(eventos[x].getTotal()));
                fieldscalendarios[2].setText(eventos[x].clientes.getApellido());
                fieldscalendarios[5].setText(eventos[x].clientes.getDomicilio());
                fieldscalendarios[4].setText(eventos[x].clientes.getCorreo());
                fieldscalendarios[3].setText(String.valueOf((eventos[x].clientes.getRfc())));}}
          }}
        if(count>=2){
          final JComboBox cal52= new JComboBox();cal52.setFont(new java.awt.Font(fontletra, 0, 40));
          for(int x=0;x<eventos.length;x++){
            if(eventos[x]!=null)
              if(eventos[x].getFecha().equals(cal14.getJFormattedTextField().getText())){
              cal52.addItem(eventos[x].getNombre());
            }}
          JPanel mainPanel2 = new JPanel();
          mainPanel2.add(cal52);
          JButton mainPanelbutton2 = new JButton("Seleccionar");
          mainPanel2.add(mainPanelbutton2);
          mainPanelbutton2.setFont(new java.awt.Font(fontletra, 0, 40));
          mainPanelbutton2.setForeground(c2);
          mainPanelbutton2.setBackground(c1);
          mainPanel2.setBackground(c);
          final JFrame frame = new JFrame("Eventos:");
          
          frame.setContentPane(mainPanel2);
          frame.pack();
          frame.setLocationByPlatform(true);
          frame.setVisible(true);frame.setIconImage(icon.getImage());
          
          mainPanelbutton2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
              String cal54=(String)cal52.getSelectedItem();
              frame.setVisible(false);
              for(int x=0;x<eventos.length;x++){
                if(eventos[x]!=null)
                  if((eventos[x].getFecha()).equals(cal14.getJFormattedTextField().getText())&&(eventos[x].getNombre()).equals(cal54)){
                  fieldscalendarios[0].setText(eventos[x].clientes.getNombre());
                  fieldscalendarios[1].setText(eventos[x].clientes.getTelefono());
                  fieldscalendarios[6].setText(eventos[x].clientes.getNreferente());
                  fieldscalendarios[7].setText(eventos[x].clientes.getTreferente());
                  fieldscalendarios[8].setText(eventos[x].getNombre());
                  boxscalendarios[0].setSelectedItem(eventos[x].getPrimerT());
                  boxscalendarios[1].setSelectedItem(eventos[x].getSegundoT1());
                  boxscalendarios[2].setSelectedItem(eventos[x].getSegundoT2());
                  boxscalendarios[3].setSelectedItem(eventos[x].getSegundoT3());
                  boxscalendarios[4].setSelectedItem(eventos[x].getTercerT());
                  fieldscalendarios[9].setText(String.valueOf(eventos[x].getCantidadAdt()));
                  boxscalendarios[5].setSelectedItem(eventos[x].getComidaNiño());
                  fieldscalendarios[10].setText(String.valueOf(eventos[x].getCantidadNiño()));
                  boxscalendarios[6].setSelectedItem(eventos[x].getHoraInicial());
                  boxscalendarios[7].setSelectedItem(eventos[x].getHoraFinal());
                  cal27.setSelected(eventos[x].getMusica());
                  cal28.setSelected(eventos[x].getArreglo());
                  boxscalendarios[8].setSelectedItem(eventos[x].getSalon());
                  boxscalendarios[9].setSelectedItem(eventos[x].getDescuento());
                  fieldscalendarios[11].setText(String.valueOf(eventos[x].getTotal()));
                  fieldscalendarios[2].setText(eventos[x].clientes.getApellido());
                  fieldscalendarios[5].setText(eventos[x].clientes.getDomicilio());
                  fieldscalendarios[4].setText(eventos[x].clientes.getCorreo());
                  fieldscalendarios[3].setText(String.valueOf((eventos[x].clientes.getRfc())));
                }}
            }});
        }
        if(count==0){
          for(int i=0;i<fieldscalendarios.length;i++){fieldscalendarios[i].setText("");}
          for(int i=0;i<boxscalendarios.length;i++){boxscalendarios[i].setSelectedItem("");}
          cal27.setSelected(false);
          cal28.setSelected(false);
          fieldscalendarios[9].setText(String.valueOf(0));
          fieldscalendarios[10].setText(String.valueOf(0));
        }
        if(boxscalendarios[0].getSelectedItem()==null || boxscalendarios[0].getSelectedItem().equals("")){
          for(int i=0;i<5;i++){boxscalendarios[i].removeAllItems();}
          boxscalendarios[0].setModel(new DefaultComboBoxModel(comidas));
          boxscalendarios[1].setModel(new DefaultComboBoxModel(comidas1));
          boxscalendarios[2].setModel(new DefaultComboBoxModel(comidas2));
          boxscalendarios[3].setModel(new DefaultComboBoxModel(comidas2));
          boxscalendarios[4].setModel(new DefaultComboBoxModel(comidas3));
          for(int i=0;i<5;i++){boxscalendarios[i].setSelectedItem("");}}
        else{
          String temp=(String) boxscalendarios[0].getSelectedItem();String temp1=(String) boxscalendarios[1].getSelectedItem();String temp2=(String) boxscalendarios[2].getSelectedItem();String temp3=(String) boxscalendarios[3].getSelectedItem();String temp4=(String) boxscalendarios[4].getSelectedItem();
          boxscalendarios[0].setModel(new DefaultComboBoxModel(comidas));
          boxscalendarios[1].setModel(new DefaultComboBoxModel(comidas1));
          boxscalendarios[2].setModel(new DefaultComboBoxModel(comidas2));
          boxscalendarios[3].setModel(new DefaultComboBoxModel(comidas2));
          boxscalendarios[4].setModel(new DefaultComboBoxModel(comidas3)); 
          boxscalendarios[0].setSelectedItem(temp); boxscalendarios[1].setSelectedItem(temp1);boxscalendarios[2].setSelectedItem(temp2);boxscalendarios[3].setSelectedItem(temp3);boxscalendarios[4].setSelectedItem(temp4);
        }
        cl.show(cards, "CALENDARIO");   
      }});
    //SE MUESTRA EL PANEL ADECUADO HACIENDO SU REFERENCIA
    volvermenucontratos1.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        cl.show(cards, "CONTRATOSMENU");   
      }});
    //SE MUESTRA EL PANEL ADECUADO HACIENDO SU REFERENCIA
    volvermenucontratos2.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        cl.show(cards, "CONTRATOSMENU");   
      }});
    //SE MUESTRA EL PANEL ADECUADO HACIENDO SU REFERENCIA
    volvermenucontratos0.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        cl.show(cards, "CONTRATOSMENU");   
      }});
    //SE MUESTRA EL PANEL ADECUADO HACIENDO SU REFERENCIA, Y ACTUALIZA LOS JCOMBOBOX
    contratosmenu1.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        contratosmenu11.removeAllItems();
        contratosmenu10.removeAllItems();
        contratosmenu12.removeAllItems();
        for(int x=0;x<eventos.length;x++){
          if(eventos[x]!=null)
            contratosmenu11.addItem(eventos[x].getNombre());
        }
        for(int y=0;y<eventos.length;y++){
          if(eventos[y]!=null){
            contratosmenu10.addItem(eventos[y].getFecha());
          }
        }
        for(int y=0;y<eventos.length;y++){
          if(eventos[y]!=null){
            contratosmenu12.addItem(eventos[y].clientes.getNombre()+"-"+eventos[y].clientes.getApellido());
          }
        }
        cl.show(cards, "CONTRATOSBUSCAR");   
      }});
    //ACTUALIZA JCOMBOBOXS
    contratosmenu3.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        cl.show(cards, "CONTRATOSAGREGAR");  
        for(int i=0;i<6;i++){boxscalendarios[i].removeAllItems();}
        boxscontratos[0].setModel(new DefaultComboBoxModel(comidas));
        boxscontratos[1].setModel(new DefaultComboBoxModel(comidas1));
        boxscontratos[2].setModel(new DefaultComboBoxModel(comidas2));
        boxscontratos[3].setModel(new DefaultComboBoxModel(comidas2));
        boxscontratos[4].setModel(new DefaultComboBoxModel(comidas3));
        boxscontratos[5].setModel(new DefaultComboBoxModel(comidas4));
      }});
    //SE MUESTRA EL PANEL ADECUADO HACIENDO SU REFERENCIA
    buttonscomidas[3].addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        cl.show(cards, "COMIDASMENU");   
      }});
    //SE MUESTRA EL PANEL ADECUADO HACIENDO SU REFERENCIA
    buttonscomidas[4].addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        cl.show(cards, "COMIDASMENU");   
      }});
    //SE MUESTRA EL PANEL ADECUADO HACIENDO SU REFERENCIA
    buttonscomidas[5].addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        cl.show(cards, "COMIDASMENU");   
      }});
    //SE MUESTRA EL PANEL ADECUADO HACIENDO SU REFERENCIA
    buttonscomidas[6].addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        cl.show(cards, "COMIDASMENU");   
      }});
    //SE MUESTRA EL PANEL ADECUADO HACIENDO SU REFERENCIA
    buttonscomidas[7].addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        cl.show(cards, "COMIDASVER");   
      }});
    //SE MUESTRA EL PANEL ADECUADO HACIENDO SU REFERENCIA Y ACTUALIZA JCOMBOBOX
    buttonscomidas[8].addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        
        boxscomidas[3].removeAllItems();
        for(int y=0;y<eventos.length;y++){
          if(eventos[y]!=null){
            boxscomidas[3].addItem(eventos[y].getNombre());
          }
        }
        cl.show(cards, "COMIDASMODIFICAR");   
      }});
    //SE MUESTRA EL PANEL ADECUADO HACIENDO SU REFERENCIA
    buttonscomidas[9].addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        cl.show(cards, "COMIDASAGREGAR");   
      }});
    //SE MUESTRA EL PANEL ADECUADO HACIENDO SU REFERENCIA
    buttonscomidas[10].addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        cl.show(cards, "COMIDASQUITAR");   
      }});
    //SE MUESTRA EL PANEL ADECUADO HACIENDO SU REFERENCIA Y ACTUALIZA JCOMOBOXS
    botonesprincipales[0].addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        cl.show(cards, "CALENDARIO");   
        if(boxscalendarios[0].getSelectedItem()==null || boxscalendarios[0].getSelectedItem().equals("")){
          for(int i=0;i<5;i++){boxscalendarios[i].removeAllItems();}
          boxscalendarios[0].setModel(new DefaultComboBoxModel(comidas));
          boxscalendarios[1].setModel(new DefaultComboBoxModel(comidas1));
          boxscalendarios[2].setModel(new DefaultComboBoxModel(comidas2));
          boxscalendarios[3].setModel(new DefaultComboBoxModel(comidas2));
          boxscalendarios[4].setModel(new DefaultComboBoxModel(comidas3));
          for(int i=0;i<5;i++){boxscalendarios[i].setSelectedItem("");}}  
        else{
          
          String temp=(String) boxscalendarios[0].getSelectedItem();String temp1=(String) boxscalendarios[1].getSelectedItem();String temp2=(String) boxscalendarios[2].getSelectedItem();String temp3=(String) boxscalendarios[3].getSelectedItem();String temp4=(String) boxscalendarios[4].getSelectedItem();
          boxscalendarios[0].setModel(new DefaultComboBoxModel(comidas));
          boxscalendarios[1].setModel(new DefaultComboBoxModel(comidas1));
          boxscalendarios[2].setModel(new DefaultComboBoxModel(comidas2));
          boxscalendarios[3].setModel(new DefaultComboBoxModel(comidas2));
          boxscalendarios[4].setModel(new DefaultComboBoxModel(comidas3)); 
          boxscalendarios[0].setSelectedItem(temp); boxscalendarios[1].setSelectedItem(temp1);boxscalendarios[2].setSelectedItem(temp2);boxscalendarios[3].setSelectedItem(temp3);boxscalendarios[4].setSelectedItem(temp4);
        }}});
    //SE MUESTRA EL PANEL ADECUADO HACIENDO SU REFERENCIA
    botonesprincipales[1].addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){      
        cl.show(cards, "COMIDASMENU");    
      }});
    //SE MUESTRA EL PANEL ADECUADO HACIENDO SU REFERENCIA
    botonesprincipales[2].addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        cl.show(cards, "CONTRATOSMENU");
      }});
    //SE MUESTRA EL PANEL ADECUADO HACIENDO SU REFERENCIA
    botonesprincipales[3].addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        cl.show(cards, "EMPLEADOS");
      }});
    //SE MUESTRA EL PANEL ADECUADO HACIENDO SU REFERENCIA
    sagregar13.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        cl.show(cards, "SEGURIDAD");
      }});
    //SE MUESTRA EL PANEL ADECUADO HACIENDO SU REFERENCIA
    botonesprincipales[4].addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        cl.show(cards, "SEGURIDAD");
      }});
    //SE MUESTRA EL PANEL ADECUADO HACIENDO SU REFERENCIA
    smenu2.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        cl.show(cards, "SEGURIDADAGREGAR");
      }});
    //SE MUESTRA EL PANEL ADECUADO HACIENDO SU REFERENCIA Y ACTUALIZA JCOMBOBOX
    smenu3.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        cl.show(cards, "SEGURIDADMODIFICAR");
        smod6.removeAllItems();
        for(int x=0;x<usuarios.length;x++){
          if(usuarios[x]!=null){
            smod6.addItem(usuarios[x].getCuenta());
          }
        }
      }});
    //SE MUESTRA EL PANEL ADECUADO HACIENDO SU REFERENCIA Y ACTUALIZA JCOMOBOX
    smenu4.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        cl.show(cards, "SEGURIDADQUITAR");
        squitar6.removeAllItems();
        for(int x=0;x<usuarios.length;x++){
          if(usuarios[x]!=null){
            squitar6.addItem(usuarios[x].getCuenta());
          }
        }   
      }});
    //SE MUESTRA EL PANEL ADECUADO HACIENDO SU REFERENCIA
    smod13.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        cl.show(cards, "SEGURIDAD");
      }});
    //SE MUESTRA EL PANEL ADECUADO HACIENDO SU REFERENCIA
    squitar13.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        cl.show(cards, "SEGURIDAD");
      }}); 
    //SE MUESTRA EL PANEL ADECUADO HACIENDO SU REFERENCIA
    contratosmenu4.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        cl.show(cards, "PANELTABLA");
      }}); 
    //SE AGREGA UN ACTION LISTENER A UN COMPONENTE
    contratosmenu4.addActionListener(new ButtonListener6());
    //GUARDAR EN ARCHIVOS
    guardarPref();
    guardarEventos();
    guardarComidas();
    //SE CIERRAN LOS ARCHIVOS
    arch1.close();
    arch2.close();
    arch3.close();
    //SE LLAMA EL METODO RELOJ PARA EMPEZAR A MOSTRARLO
    reloj();  
  }
}
