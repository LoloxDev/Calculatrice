import java.util.ArrayList;
import java.util.Scanner;

public class Calculatrice {


    private final Operande[] operande;
    private final TypeOperation typeOperation;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<Operande> values = new ArrayList<>();


        System.out.println("Bienvenue sur Calculinette, quel opération souhaitez vous effectuer ?");
        System.out.println("1. Addition ( + )\n2. Soustraction ( - )\n3. Multiplication ( * )\n4. Division ( / )");
        TypeOperation operateur = new TypeOperation(scan.next().charAt(0));
        System.out.println("Vous avez choisis une opération de type " + operateur.getSymbole());
        System.out.println("Rentrez les chiffres que vous souhaitez additionner un par un, puis terminez par =");
        while (true){
            if (scan.hasNextDouble()){          // Si la saisie est un double, on crée un objet et on le stock dans un arraylist d'opérande.
                double nombre = scan.nextDouble();
                Operande operande = new Operande(nombre);
                values.add(operande);
            } else {            // Sinon si c'est un =, on coupe la boucle.
                String saisie = scan.next();
                if (saisie.equals("=")){
                    break;
                } else {            // Sinon, on demande à l'utilisateur de resaisir un nombre ou le caractère =
                    System.out.println("Saisie invalide, veuillez entrer un nombre ou le caractère =");
                }
            }
        }
        Calculatrice calculinette = new Calculatrice(operateur, values);
        System.out.println("Le résultat de votre opération est " + calculinette.calcul());
        calculinette.direAurevoir();
    }

    public Calculatrice(TypeOperation typeOperation, ArrayList<Operande> values) { // Constructor Calculatrice
        this.typeOperation = typeOperation;
        this.operande = new Operande[values.size()];
        for (int i=0; i<values.size(); i++){
            this.operande[i] = values.get(i);
        }
    }

    public double calcul(){
        double result = operande[0].getOperande(); // On initialise result à la première opérande
        for (int i = 1; i < operande.length; i++) { // On démare notre boucle à la 2eme opérande
            switch (typeOperation.getSymbole()) {
                case '+' -> result += operande[i].getOperande();
                case '-' -> result -= operande[i].getOperande();
                case '*' -> result *= operande[i].getOperande();
                case '/' -> {
                    if(operande[i].getOperande() != 0){ // On vérifie si l'utilisateur veux diviser par 0
                        result /= operande[i].getOperande();
                    } else {
                        System.out.println("Impossible de diviser par 0");
                        result = 0;
                    }
                }
            }
        }
        //    result = operande1.operande typeOperation.getSymbole() operande2.operande; <-- J'aimerais arriver à faire ça pour éviter la condition ou le switch.
        return result;
    }

    public void direAurevoir(){
            System.out.println("Calculinette vous souhaite une excellente journée!");
        }
}