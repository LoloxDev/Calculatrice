import java.util.ArrayList;
import java.util.Scanner;

public class Calculatrice {


    private Operande[] operande;
    private final TypeOperation typeOperation;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        char choice = '\0';
        ArrayList<Operande> values = new ArrayList<>();


        System.out.println("Bienvenue sur Calculinette, quel opération souhaitez vous effectuer ?");
        System.out.println("1. Addition ( + )\n2. Soustraction ( - )\n3. Multiplication ( * )\n4. Division ( / )");
        TypeOperation operateur = new TypeOperation(scan.next().charAt(0));
        System.out.println("Vous avez choisis une opération de type " + operateur.getSymbole());
        System.out.println("Rentrez les chiffres que vous souhaitez additionner un par un, puis terminez par =");
        while (true){
            if (scan.hasNextInt()){
                int nombre = scan.nextInt();
                Operande operande = new Operande(nombre);
                values.add(operande);
            } else {
                String saisie = scan.next();
                if (saisie.equals("=")){
                    break;
                } else {
                    System.out.println("Saisie invalide, veuillez entrer un nombre ou le caractère =");
                }
            }
        }

        Calculatrice calculinette = new Calculatrice(operateur, values);
       System.out.println("Le résultat de votre opération est " + calculinette.calcul());
       calculinette.direAurevoir();
    }

    public Calculatrice(TypeOperation typeOperation, ArrayList<Operande> values) {
        this.typeOperation = typeOperation;
        this.operande = new Operande[values.size()];
        for (int i=0; i<values.size(); i++){
            this.operande[i] = values.get(i);
        }
    }

    public double calcul(){
        double result = 0;
        for (int i = 0; i < operande.length; i++) {
            switch (typeOperation.getSymbole()) {
                case '+' -> result += operande[i].getOperande();
                case '-' -> result -= operande[i].operande;
                case '*' -> result *= operande[i].operande;
                case '/' -> result /= operande[i].operande;
            }
        }
        //    result = operande1.operande typeOperation.getSymbole() operande2.operande; <-- J'aimerais arriver à faire ça pour éviter la condition ou le switch.
        return result;
    }

        public void direAurevoir(){
            System.out.println("Calculinette vous souhaite une excellente journée!");
        }
}