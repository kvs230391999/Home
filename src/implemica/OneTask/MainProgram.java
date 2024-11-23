package implemica.OneTask;

public class MainProgram {

    public static void main(String[] args){

        Arithmetic arithmetic = new Arithmetic();

        System.out.println("Количество правильных скобочных вариантов: " + arithmetic.arithmeticNum(0));
    }
}
