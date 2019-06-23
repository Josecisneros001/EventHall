package proyecto1;

    //OBJETO DEL TIPO USUARIO
    public class Usuario {
        //SE DECLARAN LOS ATRIBUTOS
     private String cuenta; 
     private String password; 
     private boolean restriccion1; //RESTRICCION CONTRATOS1
     private boolean restriccion2; //RESTRICCION CONTRATOS2
     private boolean restriccion3; //RESTRICCION COMIDAS1
     private boolean restriccion4; //RESTRICCION COMIDAS2
     private boolean restriccion5; //RESTRICCION EMPLEADOS1
     private boolean restriccion6; //RESTRICCION EMPLEADOS2
     private boolean restriccion7; //RESTRICCION SEGURIDAD
     //CONSTRUCTOS VACIO, INCIALIZADOR DE ATRIBUTOS
     public Usuario(){
       cuenta="";
       password="";
       restriccion1=false;
       restriccion2=false;
       restriccion3=false;
       restriccion4=false;
       restriccion5=false;
       restriccion6=false;
       restriccion7=false;
     }
      //CONSTRUCTOR PARA DECLARAR ATRIBUTOS
     public Usuario(String n1, String n2, boolean n4,boolean n5,boolean n6,boolean n7,boolean n8,boolean n9,boolean n10){
       cuenta=n1;
       password=n2;
       restriccion1=n4;
       restriccion2=n5;
       restriccion3=n6;
       restriccion4=n7;
       restriccion5=n8;
       restriccion6=n9;
       restriccion7=n10;
     } 
     //AREA DE SETS
      public void setCuenta(String var){cuenta=var;}
      public void setPassword(String var){password=var;}
      public void setRes1(boolean var){restriccion1=var;}
      public void setRes2(boolean var){restriccion2=var;}
      public void setRes3(boolean var){restriccion3=var;}
      public void setRes4(boolean var){restriccion4=var;}
      public void setRes5(boolean var){restriccion5=var;}
      public void setRes6(boolean var){restriccion6=var;}
      public void setRes7(boolean var){restriccion7=var;}
      //AREA DE GETS
      public String getCuenta(){return cuenta;}
      public String getPassword(){return password;}
      public boolean getRes1(){return restriccion1;}
      public boolean getRes2(){return restriccion2;}
      public boolean getRes3(){return restriccion3;}
      public boolean getRes4(){return restriccion4;}
      public boolean getRes5(){return restriccion5;}
      public boolean getRes6(){return restriccion6;}
      public boolean getRes7(){return restriccion7;}
    }