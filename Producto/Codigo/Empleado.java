package proyecto1;

//OBJETO DEL TIPO EMPLEADO, EXTIENDE EL OBJETO DE TIPO PERSONA

public class Empleado extends Persona{
 //DECLARACIÓN DE VARIABLES
  private String nomina;
  private String puesto;
  private Double sueldo;
  
     //CONSTRUCTOR BASE, INCIALIDOR DE ATRIBUTOS 
  public Empleado(){
    super();
    nomina="";
    puesto="";
    sueldo=0.0;
  }
   //CONSTRUCTOR PARA DECLARAR ATRIBUTOS
  public Empleado(String n0, String n1,char g,String n3,String n4,String n5,String n, String n2,Double s){
   super( n0,  n1, g, n3, n4, n5);
   nomina=n;
   puesto=n2;
   sueldo=s;
  }
   //SECCION DE SETS
  public void setNomina(String n){
  nomina=n;
  }
  public void setPuesto(String n2){
  nomina=n2;
  }
  public void setSueldo(Double s){
  sueldo=s;
  }
  //SECCION DE GETS
  public Double getSueldo(){
  return sueldo;
  }
  public String getNomina(){
  return nomina;
  }
    public String getPuesto(){
  return puesto;
  }  

}
    