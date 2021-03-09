import exception.EmployeeNotFound;
import model.Like;
import model.Position;
import service.LikeCounterImpl;
import service.LikeList;
import service.LikeListImpl;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws EmployeeNotFound {
        // sukurti listą
        List<Like> list = new ArrayList<>();
        list.add(new Like("Jonas", Position.MID_DEVELOPER, "very good work"));
        list.add(new Like("Jonas", Position.MID_DEVELOPER, "very good work yes"));
        list.add(new Like("Jonas", Position.MID_DEVELOPER, "good work ye"));
        list.add(new Like("Petras", Position.PROJECT_MANAGER, "very good"));

        LikeCounterImpl lc = new LikeCounterImpl();
        LikeList ll = new LikeListImpl();


        Scanner scanner = new Scanner(System.in);
        boolean program = true;
        String action;
        while (program) {
            System.out.println("Pasirinkite veiksma: ");
            System.out.println("[i] - ivesti pagyrima; [s] - skaiciuoti darbuotojo pagyrimus; [m] - gauti manager'iu pagyrimu skaiciu; [d] - gauti developer'iu pagyrimu skaiciu; [v] - visu pagyrimu skaicius; [x] - baigti programa.");
            action = scanner.next();
            switch (action) {
                case "i":
                    System.out.println("Iveskite darbuotojo varda: ");
                    String name = scanner.next();
                    System.out.println("Pasirinkite darbuotojo pareigas: ");
                    System.out.println("1 - project manager; 2 - senior developer; 3 - mid developer; 4 - junior developer");
                    int choice = scanner.nextInt();
                    Position position = null;
                    switch (choice) {
                        case 1:
                            position = Position.PROJECT_MANAGER;
                            break;
                        case 2:
                            position = Position.SENIOR_DEVELOPER;
                            break;
                        case 3:
                            position = Position.MID_DEVELOPER;
                            break;
                        case 4:
                            position = Position.JUNIOR_DEVELOPER;
                            break;
                        //default:
                        // throw new IllegalStateException("Pasirinkta netinkama reiksme: " + choice);
                        // kazkodel jei sitas yra paskui meta pasirinkimus du kartus
                    }
                    System.out.println("Iveskite norima zinute darbuotojui: ");
                    String message = scanner.next();

                    ll.addLike(list, name, position, message);
                    // list.add(new Like(name, position, message));
                    System.out.println("Pagyrimas irasytas.");
                    break;
                case "s":
                    System.out.println("Iveskite darbuotojo varda: ");
                    String entry = scanner.next();
                    try {
                        if (lc.getStatisticsByName(list, entry) == 0) {
                            throw new EmployeeNotFound();
                        } else {
                            System.out.println(entry + " is viso turi " + lc.getStatisticsByName(list, entry) + " pagyrimus");
                        }
                    } catch (EmployeeNotFound e) {
                        System.out.println("Darbuotojas siuo vardu irasu dar neturi");
                    }
                    System.out.println(lc.retrieveMessages(list, entry));
                    break;
                case "m":
                    System.out.println("Is viso manageriai turi " + lc.getManagerStatistics(list) + " pagyrimu.");
                    break;
                case "d":
                    System.out.println("Is viso developer'iai turi " + lc.getDeveloperStatistics(list) + " pagyrimu");
                    break;
                case "v":
                    System.out.println("Is viso sarase yra " + lc.getTotalStatistics(list) + " pagyrimu(-ai)");
                    break;
                case "x":
                    program = false;
                    break;
            }

        }
    }
}
