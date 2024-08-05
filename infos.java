package estudos.projeto;

public class infos {
    private String nome;
    private String email;
    private int num_de_incricao;
    private float media;

    public void set_nome(String nome){
        this.nome=nome;
    }
    public String get_nome(){
        return this.nome;
    }

    public void set_email(String email){
        this.email=email;
    }
    public String get_email(){
        return this.email;
    }

    public void set_num_de_incricao(int num_d_ins){
        this.num_de_incricao=num_d_ins;
    }
    public int get_num_d_ins(){
        return this.num_de_incricao;
    }

    public void set_media(float media){
        this.media=media;
    }

    public float get_media(){
       return this.media;
    }
}
