import java.util.Scanner;
class View {
        private Controller c;
        private Scanner sc ;

    View() {
        sc = new Scanner(System.in);
        c = new Controller();
    }

    void option(){
        welcomeMessage();
        String option = sc.nextLine();
        switch (option){
            case "1":
                System.out.println("write a name of your pokemon:");
                String nameToGetI = sc.nextLine();
                c.getInfo(nameToGetI.toLowerCase());
                break;
            case"2":
                System.out.println("Enter the location of the pokemon:");
                String nameToGetL = sc.nextLine();
                c.getLocation(nameToGetL.toLowerCase());
                break;
            default:
                System.out.println("inhaled input");
                break;
        }
    }
     private void welcomeMessage(){
        System.out.println("Welcome to pokemon App \n" +
                "pick an option: \n" +
                " 1 get the pokemon info \n" +
                " 2 get the location info\n" +
                ">> ");
    }
}

