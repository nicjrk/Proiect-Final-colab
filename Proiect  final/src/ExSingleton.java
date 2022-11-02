public class ExSingleton {
    private static ExSingleton instance;

    private String parola;
    private ExSingleton(){
        parola="";
    }
    public static ExSingleton getInstance(){
        if(null == instance){
            instance = new ExSingleton();
        }
        return instance;
    }
    public Object modificaCamp1(String parola){
        this.parola=parola;
        return parola;
    }


}