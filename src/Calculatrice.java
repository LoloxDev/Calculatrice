import java.util.Scanner;

public class Calculatrice {

    static Operande chiffre1;
    static Operande chiffre2;
    static TypeOperation typeoperation;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Bienvenue sur Calculinette, quel opération souhaitez vous effectuer ?");
        System.out.println("1. Addition ( + )\n2. Soustraction ( - )\n3. Multiplication ( * )\n4. Division ( / )");
        TypeOperation typeoperation = new TypeOperation(scan.next().charAt(0));

        System.out.println("choississez un premier nombre");
        Operande chiffre1 = new Operande(scan.nextFloat());

        System.out.println("choississez un premier nombre");
        Operande chiffre2 = new Operande(scan.nextFloat());
        Calculatrice calculatrice=new Calculatrice(chiffre1,  chiffre2, typeoperation);
        calculatrice.calculer();




    }

    public Calculatrice(Operande chiffre1, Operande chiffre2, TypeOperation typeoperation){
        this.typeoperation=typeoperation;
        this.chiffre1=chiffre1;
        this.chiffre2=chiffre2;
    }

    public static void calculer(){


         int valeur=0;
         if (typeoperation.getSigne()=='+'){
             valeur= (int) (chiffre1.getNombre()+chiffre2.getNombre());
         } else if (typeoperation.getSigne()=='-') {
             valeur= (int) (chiffre1.getNombre()-chiffre2.getNombre());
         }else {
             System.out.println("mettez un signe existant");
         }
        System.out.println("la valeur est " + valeur);
    }


    }
