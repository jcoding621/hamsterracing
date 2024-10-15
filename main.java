// Hamster Racing!!!! (finished model 1.0)

import java.util.Scanner;

class HelloWorld {
    
    public static class Hamster {
        int speed;
        String name;
        int dist;
        
        Hamster(int s, String n) {
            this.speed = s;
            this.name = n;
            this.dist = 0;
        }
        
        Hamster() {
            this.speed = 5;
            this.name = "UserHamster";
            this.dist = 0;
        }
        
        public void displayHamster() {
            System.out.println("Hamster name: " + this.name + ", Speed: " + this.speed);
        }
        
        public int getDistance() {
            return this.dist;
        }
        
        public String getName() {
            return this.name;
        }
        
        public void displayHamInRace() {
            this.dist += speed + Math.round((Math.random() * 4));
            String track = "----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------";
            
            // prints out hamster name, then progress bar, then X (e.g. Beadie: --------X)
            System.out.print(this.name + ":\nO ");
            System.out.print(track.substring(0, this.dist));
            System.out.println("X\n");
        }
    }
    
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        boolean raceActive = false;
        int maxDist;
        
        // setting up the other hamsters as objects
        Hamster porkchop = new Hamster(10, "Porkchop");
        Hamster beadie = new Hamster(4, "Beadie");
        Hamster enpicee = new Hamster(5, "Enpicee");
        
        
        // introduction + get speed for hamster from user
        System.out.println("Welcome to Hamster Racing, a simulation I have no idea of the purpose for!");
        System.out.println("Please enter an integer for the SPEED for your hamster (or type \'0\' to set every setting as default):");
        int speed = input.nextInt();
        input.nextLine();
        
        // declare user's custom hamster
        Hamster userHamster;
        
        // declare a default hamster if speed is 0 and prompt for a name otherwise
        if (speed == 0) {
            userHamster = new Hamster();
            maxDist = 50;
        } else {
            System.out.println("Enter the NAME for your hamster:");
            String userName = input.nextLine();
            userHamster = new Hamster(speed, userName);
            System.out.println("Enter an integer for the length of the race:");
            maxDist = input.nextInt();
        }
        
        // show profile of other hamsters and user's hamster
        porkchop.displayHamster();
        beadie.displayHamster();
        enpicee.displayHamster();
        userHamster.displayHamster();
        
        input.nextLine(); // consume nextLine (prevents duplicate text glitch)
        
        // do not start race until user types "y" in lowercase
        while (raceActive == false) {
            System.out.println("To start the race, type y");
            if (input.nextLine().equals("y")) {
                raceActive = true;
            }
        }
        
        // race display handler loop
        while (raceActive == true) {
            porkchop.displayHamInRace();
            beadie.displayHamInRace();
            enpicee.displayHamInRace();
            userHamster.displayHamInRace();
            System.out.println("_____________________________________");
            if (porkchop.getDistance() > maxDist || beadie.getDistance() > maxDist || enpicee.getDistance() > maxDist || userHamster.getDistance() > maxDist) {
                raceActive = false; // ends race handler loop
            }
        }
        
        // determine the winner by brute force
        String winner = ""; 
        int winnerDist = 0;
        if (porkchop.getDistance() >= winnerDist) {
            winner = "Porkchop ";
            winnerDist = porkchop.getDistance();
        }
        if (beadie.getDistance() >= winnerDist) {
            winner = "Beadie ";
            winnerDist = beadie.getDistance();
        } 
        if (enpicee.getDistance() >= winnerDist) {
            winner = "Enpicee ";
            winnerDist = enpicee.getDistance();
        }
        if (userHamster.getDistance() >= winnerDist) {
            winner = "Your hamster, " + userHamster.getName() + ", ";
        }
        System.out.println(winner + "wins!");
        
    }
}
