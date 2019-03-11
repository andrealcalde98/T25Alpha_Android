package cat.copernic.rehabilitat;

public class BDModelo {
    private String usuario,sexe,edad,altura, correo,password;

    public BDModelo(){

    }

    public BDModelo(String usuario,String correo, String sexe, String edad, String altura, String password){
        this.usuario = usuario;
        this.correo = correo;
        this.sexe = sexe;
        this.edad = edad;
        this.altura = altura;
        this.password = password;
    }

    public String getUsuari(){
        return usuario;
    }

    public String getCorreo(){return correo;}

    public String getSexe(){return sexe;}

    public String getEdad(){return edad;}

    public String getAltura(){return altura;}

    public String getPassword(){
        return password;
    }

}
