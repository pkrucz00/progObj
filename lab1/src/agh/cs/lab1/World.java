package agh.cs.lab1;

public class World {
    public static void main(String[] args) {
        System.out.print("System uruchamia się\n");
        Direction[] arguments = strToRun(args);
        run(arguments);
        System.out.print("System zamyka się\n");
    }

    private static void run(Direction[] args) {
        for(Direction arg : args){
            switch(arg){
                case FORWARD:
                    System.out.println("Do przodu");
                    break;
                case BACKWARD:
                    System.out.println("Do tyłu");
                    break;
                case RIGHT:
                    System.out.println("W prawo");
                    break;
                case LEFT:
                    System.out.println("W lewo");
                    break;
                default:
                    break;
            }
        }
    }

    public static Direction[] strToRun(String[] args){
        Direction[] result = new Direction[args.length];
        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "f":
                    result[i] = Direction.FORWARD;
                    break;
                case "b":
                    result[i] = Direction.BACKWARD;
                    break;
                case "r":
                    result[i] = Direction.RIGHT;
                    break;
                case "l":
                    result[i] = Direction.LEFT;
                    break;
                default:
                    break;
            }
        }
        return (result);
    }
}
