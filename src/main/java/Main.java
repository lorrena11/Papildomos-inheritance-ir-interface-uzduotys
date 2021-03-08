import model.Like;
import model.Position;
import service.LikeCounter;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // sukurti listą
        List<Like> list = new ArrayList<>();
        list.add(new Like("Jonas", Position.MID_DEVELOPER, "very good work"));
        list.add(new Like("Jonas", Position.MID_DEVELOPER, "very good work yes"));
        list.add(new Like("Jonas", Position.MID_DEVELOPER, "good work ye"));
        list.add(new Like("Petras", Position.PROJECT_MANAGER, "very good"));

        LikeCounter is = new LikeCounter();

//        System.out.println(is.getStatisticsByName(list, "Jonas"));
//        System.out.println(is.getManagerStatistics(list));
//        System.out.println(is.getTotalStatistics(list));

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
                    list.add(new Like(name, position, message));
                    System.out.println("Pagyrimas irasytas.");
                    break;
                case "s":
                    System.out.println("Iveskite darbuotojo varda: ");
                    String entry = scanner.next();
                    System.out.println(entry + " is viso turi " + is.getStatisticsByName(list, entry) + " pagyrimus");
                    break;
                case "m":
                    System.out.println("Is viso manageriai turi " + is.getManagerStatistics(list) + " pagyrimu.");
                    break;
                case "d":
                    System.out.println("Is viso developer'iai turi " + is.getDeveloperStatistics(list) + " pagyrimu");
                    break;
                case "v":
                    System.out.println("Is viso sarase yra " + is.getTotalStatistics(list) + " pagyrimu(-ai)");
                    break;
                case "x":
                    program = false;
                    break;
            }

        }
    }
}
