package estudos.projeto;

import java.util.Random;
import java.util.Scanner;

public class cod {
    private static Random gerar=new Random();
    private static Scanner leitor=new Scanner(System.in);
    
    public static void alocar_mem_de_ativ(ati atividades[],int tam){
        for(int i=0;i<tam;i++){
            atividades[i]=new ati();
        }
    }
    public static void add_ati(ati atividade[],int tam){
        for(int i=0;i<tam;i++){
            String nome_d_ati;
            int dia;
            float hora;
            System.out.print("digite o nome da atividade: ");
            nome_d_ati=leitor.next();
            System.out.print("digite o dia da atividade: ");
            dia=leitor.nextInt();
            System.out.print("digite a hora: ");
            hora=leitor.nextFloat();
            atividade[i].set(nome_d_ati,dia,hora);
        }
    }

    public static void alocar_mem_de_part(infos part[],int num_d_p){
        for(int i=0;i<num_d_p;i++){
            part[i]=new infos();
        }
    }

    public static void add_part(infos part[],int num_d_p){
        for(int i=0;i<num_d_p;i++){
            String nome_d_p;
            String email;
            System.out.print("digite seu nome: ");
            nome_d_p=leitor.next();
            part[i].set_nome(nome_d_p);
            
            System.out.print("digite o seu email: ");
            email=leitor.next();
            part[i].set_email(email);

            part[i].set_num_de_incricao(i+1);
        }
    }

    public static void add_p(ati ativi[],infos part[],int m[][],int l,int c){
        int linha=0;
        String per;
        while (linha<l) {
            int coluna=0;
            while (coluna<c) {
                System.out.print("digite N se a pessoa nao participou\ndigite P se a pessoa participou\ndigite se "+part[linha].get_nome()+" participou da atividade "+ativi[coluna].get_nome_d_ativ()+": ");
                per=leitor.next();
                per=per.toUpperCase();
                if (per.equals("P")||per.equals("N")) {
                    if (per.equals("P")) {
                        m[linha][coluna]=1;
                    }
                    else{
                        m[linha][coluna]=0;
                    }
                    coluna++;
                }
                else{
                    System.out.print("codigo nao exite");
                }
            }
            linha++;
        }
    }

    public static int ver_sort(infos part[],int m[][],int l,int c){
        int p_s=0;
        for(int li=0;li<l;li++){
            float porc=0;
            for(int co=0;co<c;co++){
                if(m[li][co]==1) {
                   porc++; 
                }
            }
            porc=(porc*100)/c;
            if (porc>=75) {               
                p_s++;
            }
            part[li].set_media(porc);
        }
        return p_s;
    }

    public static void add_part_sort(infos part[],infos part_sort[],int num_d_ins){
        int cont=0;
        for(int i=0;i<num_d_ins;i++){
            if (part[i].get_media()>=75) {
                part_sort[cont]=part[i];
                cont++;
            }
        }
    }

    public static boolean ver_p(infos par_sort[],infos sorteados[],int n_g){
        for(int i=0;i<3;i++){
            if(par_sort[n_g].equals(sorteados[i])){
                return false;
            }
        }
        return true;
    } 
    public static void sort(infos par_sort[],infos sorteados[],int n_p_s){
        int cont=0;
        while (cont<3){
            int g=gerar.nextInt((n_p_s));
            if (ver_p(par_sort, sorteados, g)==true) {
                sorteados[cont]=par_sort[g];
                cont++;          
            }
        }
    }

    public static void mostar(infos sorteados[]){
        for(int i=0;i<3;i++){
            System.out.print(sorteados[i].get_nome()+"\n");
        }
    }

    public static void main(String [] args){
      int num_de_participantes,num_de_ativ;

      System.out.print("digite o numero de atividades: ");
      num_de_ativ=leitor.nextInt();
      ati atividades[]=new ati[num_de_ativ];
      alocar_mem_de_ativ(atividades, num_de_ativ);
      add_ati(atividades, num_de_ativ);
      
      System.out.print("digite o numero de vagas: ");
      num_de_participantes=leitor.nextInt();
      infos parti[]=new infos[num_de_participantes];
      alocar_mem_de_part(parti, num_de_participantes);
      add_part(parti, num_de_participantes);
     
      int matriz_de_presenca[][]=new int [num_de_participantes][num_de_ativ];
      add_p(atividades, parti, matriz_de_presenca, num_de_participantes,num_de_ativ);
      int tst=ver_sort(parti,matriz_de_presenca, num_de_participantes, num_de_ativ);
      infos par_sort[]=new infos[tst];
      alocar_mem_de_part(par_sort, tst);
      add_part_sort(parti, par_sort, num_de_participantes);
      if (tst>=3) {
            infos sorteado[]=new infos[3];
            alocar_mem_de_part(sorteado, 3);
            sort(par_sort, sorteado, tst);
            mostar(sorteado);
      }
      else{
        System.out.print("o sorteio nao pode acontecer pois nao tem participantes suficiente");
      }
    }
}
