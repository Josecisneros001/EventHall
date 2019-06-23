package proyecto1;

//OBJETO DEL TIPO CLIENTE, EXTIENDE EL OBJETO DE TIPO PERSONA

public class Cliente extends Persona{
  //DECLARACIÓN DE VARIABLES
  private String nreferente;
  private String treferente;
  private String rfc;
  
  //CONSTRUCTOR BASE, INCIALIDOR DE ATRIBUTOS
    public Cliente(){
        super();
        nreferente="";
        treferente="";
  }
  //CONSTRUCTOR PARA DECLARAR ATRIBUTOS
  public Cliente(String n0, String n1,String n2,String n3,String n4,String n5, String n6,String n7){
   super( n0,  n1,'M', n2, n3, n4);
    nreferente=n5;
    treferente=n6;
    rfc=n7;
  }
  //SECCION DE SETS
  public void setNreferente(String n){
  nreferente=n;
  }
  public void setRfc(String n2){
  rfc=n2;
  }
  public void setTreferente(String n2){
  treferente=n2;
  }
  
  //SECCIÓN DE GETS
  public String getTreferente(){
  return treferente;
  }
  public String getNreferente(){
  return nreferente;
  }
  public String getRfc(){
  return rfc;
  }  
  
  }


    