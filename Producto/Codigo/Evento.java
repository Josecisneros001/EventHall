package proyecto1;

//OBJETO DEL TIPO EVENTO
public class Evento {
 //SE DECLARAN LOS ATRIBUTOS
  public Cliente clientes;
  private String nombre;
  private String fecha;
  private String primerT;
  private String segundoT1;
  private String segundoT2;
  private String segundoT3;
  private String tercerT;
  private int cantidadAdt;
  private String comidaNiño;
  private int cantidadNiño;
  private String horainicial;
  private String horafinal;
  private int duracion;
  private String salon; 
  private boolean musica;
  private boolean arreglo;
  private int total;
  private String path;
  private String descuento;
  //CONSTRUCTOS VACIO, INCIALIZADOR DE ATRIBUTOS
    public Evento(){
    clientes= new Cliente();
    nombre="";
    fecha="";
    primerT="";
    segundoT1="";
    segundoT2="";
    segundoT3="";
    tercerT="";
    cantidadAdt=0;
    comidaNiño="";
    cantidadNiño=0;
    horainicial="";
    horafinal="";
    salon="";
    musica=false;
    arreglo=false;
    total=0;
      path="";
  }
  //CONSTRUCTOR PARA DECLARAR ATRIBUTOS
    public Evento(String n0, String n1,String g,String n2,String n3,String n4,String n5, String n6,String n21,String n8,String n9,String n18,String n23,String n22,String n19,int n10,String n11,int n12,String n13,String n14,String n15,boolean n16,boolean n17,int n20,String n24,String n25){
    clientes= new Cliente(n0,n1,n2,n3,n4,n5,n6,g);
    nombre=n21;
    fecha=n8;
    primerT=n9;
    segundoT1=n18;
    segundoT2=n23;
    segundoT3=n22;
    tercerT=n19;
    cantidadAdt=n10;
    comidaNiño=n11;
    cantidadNiño=n12;
    horainicial=n13;
    horafinal=n14;
    salon=n15;
    musica=n16;
    arreglo=n17;
    total=n20; 
    path=n24;
    duracion=0;
    descuento=n25;
  }
      
    //AREA DE GETS
        public String getNombre(){return nombre;}
        public String getFecha(){return fecha;}
        public String getPrimerT(){return primerT;}
        public String getSegundoT1(){return segundoT1;}
        public String getSegundoT2(){return segundoT2;}
        public String getSegundoT3(){return segundoT3;}
        public String getTercerT(){return tercerT;}
        public int getCantidadAdt(){return cantidadAdt;}
        public String getComidaNiño(){return comidaNiño;}
        public int getCantidadNiño(){return cantidadNiño;}
        public String getHoraInicial(){return horainicial;}
        public String getHoraFinal(){return horafinal;}
        public String getSalon(){return salon;}
        public boolean getMusica(){return musica;}
        public boolean getArreglo(){return arreglo;}
        public int getTotal(){return total;}
        public String getPath(){return path;}
        public int getDuracion(){return duracion;}
        public String getDescuento(){return descuento;}
    //AREA DE SETS
        public void setNombre(String var){nombre=var;}
        public void setFecha(String var){ fecha=var;}
        public void setPrimerT(String var){ primerT=var;}
        public void setSegundoT1(String var){ segundoT1=var;}
        public void setSegundoT2(String var){ segundoT2=var;}
        public void setSegundoT3(String var){ segundoT3=var;}
        public void setTercerT(String var){ tercerT=var;}
        public void setCantidadAdt(int var){cantidadAdt=var;}
        public void setComidaNiño(String var){comidaNiño=var;}
        public void setCantidadNiño(int var){ cantidadNiño=var;}
        public void setHoraInicial(String var){ horainicial=var;}
        public void setHoraFinal(String var){horafinal=var;}
        public void setSalon(String var){salon=var;}
        public void setMusica(boolean var){musica=var;}
        public void setArreglo(boolean var){arreglo=var;}
        public void setTotal(int total){this.total=total;}
        public void setPath(String var){path=var;}
        public void setDuracion(int var){duracion=var;}
        public void setDescuento(String var){descuento=var;}
}
    