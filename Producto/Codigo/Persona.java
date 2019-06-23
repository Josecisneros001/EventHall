package proyecto1;

//OBJETO DEL TIPO PERSONA

public class Persona {
  //SE DECLARAN LOS ATRIBUTOS
  private String nombre;
  private String apellido;
  private char genero;
  private String telefono;
  private String domicilio;
  private String correo;
  //CONSTRUCTOS VACIO, INCIALIZADOR DE ATRIBUTOS
  public Persona(){
  
  nombre="";
  apellido="";
  genero=' ';
  telefono="";
  domicilio="";
  correo="";
 }
  //CONSTRUCTOR PARA DECLARAR ATRIBUTOS
  public Persona(String n0, String n1,char g,String n2,String n3,String n4){

  nombre=n0;
  apellido=n1;
  genero=g;
  telefono=n2;
  domicilio=n3;
  correo=n4;
  }
  //AREA DE SETS
  public void setNombre(String n){
  nombre=n;
  }
  public void setGenero(char s){
  genero=s;
  }
  public void setApellido(String n2){
  apellido=n2;
  }
  public void setTelefono(String n){
  telefono=n;
  }
  public void setDomicilio(String n2){
  domicilio=n2;
  }
  public void setCorreo(String s){
  correo=s;
  }
  //AREA DE GETS
  public String getApellido(){
  return apellido;
  }  
  public String getNombre(){
  return nombre;
  }
  public char getGenero(){
  return genero;
  }
  public String getTelefono(){
  return telefono;
  }
  public String getCorreo(){
  return correo;
  }  
  public String getDomicilio(){
  return domicilio;
  }

}
    