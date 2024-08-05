package estudos.projeto;

public class ati {
    private String nome_da_atividade;
    private int dia;
    private float hora;
    
    public void set(String nome_d_ativ,int dia,float hora){
        this.nome_da_atividade=nome_d_ativ;
        this.dia=dia;
        this.hora=hora;
    }
    public String get_nome_d_ativ(){
        return this.nome_da_atividade;
    }
    public int get_dia(){
        return this.dia;
    }
    public float get_hora(){
        return this.hora;
    }
}
