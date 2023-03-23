import java.util.Scanner;

public class Calculatrice {


    private final Operande operande1;
    private final Operande operande2;
    private final TypeOperation typeOperation;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Bienvenue sur Calculinette, quel opération souhaitez vous effectuer ?");
        System.out.println("1. Addition ( + )\n2. Soustraction ( - )\n3. Multiplication ( * )\n4. Division ( / )");
        TypeOperation operateur = new TypeOperation(scan.next().charAt(0));
        System.out.println("Vous avez choisis une opération de type " + operateur.getSymbole());
        System.out.println("Rentrez les chiffres que vous souhaitez additionner un par un.");
        Operande operande1 = new Operande(scan.nextDouble());
        Operande operande2 = new Operande(scan.nextDouble());
        Calculatrice calculinette = new Calculatrice(operateur, operande1, operande2);
        System.out.println("Le résultat de votre opération est " + calculinette.calculinette());
        calculinette.direAurevoir();
    }

    public Calculatrice(TypeOperation typeOperation, Operande operande1, Operande operande2) {
        this.typeOperation = typeOperation;
        this.operande1 = operande1;
        this.operande2 = operande2;
    }

    public double calculinette(){
        double result = 0;
        if(typeOperation.getSymbole() == '+'){
            result = operande1.operande + operande2.operande;
        }
        return result;
    }

    public void direAurevoir(){
        System.out.println("Calculinette vous souhaite une excellente journée!");
    }
}