import java.util.Random;
import java.util.Scanner;
public class WaterSort {

    static Character red= new Character('r');
    static Character blue= new Character('b');
    static Character green= new Character('g');

    public static void ShowAll(StackAsMyArrayList[] ourbottles)
    {
        for(int x = 0; x < ourbottles.length; x++)
        {
            System.out.println("Bottle " + x + ": "  + ourbottles[x].toString());
        }
    }

    public static boolean solved(StackAsMyArrayList bottles[])
    {
        boolean isSolved = false;
        for(int x = 0; x < bottles.length ;x++)
        {
            if(bottles[x].checkStackUniform() == true && (bottles[x].getStackSize() == 4 || (bottles[x].getStackSize() == 0)))
            {
                isSolved = true;
            }
            else{
                isSolved = false;
                return isSolved;
            }
        }
        return isSolved;

    }


    public static void main(String[] args) {
        int maxrand = 5;
        int thenum;
        Random rand = new Random();
        StackAsMyArrayList<Character> myStack = new StackAsMyArrayList<Character>();
        StackAsMyArrayList<Character> myStack2 = new StackAsMyArrayList<Character>();
        StackAsMyArrayList<Character> myStack3 = new StackAsMyArrayList<Character>();
        StackAsMyArrayList<Character> myStack4 = new StackAsMyArrayList<Character>();
        StackAsMyArrayList<Character> myStack5 = new StackAsMyArrayList<Character>();

        StackAsMyArrayList[] bottles = new StackAsMyArrayList[5];
        bottles[0] = myStack;
        bottles[1] = myStack2;
        bottles[2] = myStack3;
        bottles[3] = myStack4;
        bottles[4] = myStack5;

        bottles[0].push(green);
        bottles[0].push(green);
        bottles[0].push(green);
        bottles[0].push(green);

        bottles[1].push(red);
        bottles[1].push(red);
        bottles[1].push(red);
        bottles[1].push(red);

        bottles[2].push(blue);
        bottles[2].push(blue);
        bottles[2].push(blue);
        bottles[2].push(blue);

        for(int i = 0; i < 100;i++)
        {
            for(int x =0; x < bottles.length;x++)
            {
                thenum = rand.nextInt(maxrand);

                if(bottles[thenum].getStackSize() < 4 && bottles[x].getStackSize() > 0)//Dont Spill INK
                {
                    Object tItem = bottles[x].pop();
                    bottles[thenum].push(tItem);
                }

            }
        }


        ShowAll(bottles);


        Scanner scan = new Scanner(System.in);

        while(solved(bottles) == false)
        {
            System.out.println("\nEnter source bottle number: ");

            String x = scan.nextLine();

            try{
                int tester = Integer.parseInt(x);
            }catch (NumberFormatException ex)
            {
                System.out.println("Please enter a valid number!");
                continue;
            }

            int b = Integer.parseInt(x);

            if(b < 0 || b > bottles.length -1)
            {
                System.out.println("Numbers must be between 0 and 4");
                continue;
            }



            if(bottles[b].getStackSize() != 0)
            {
                Object temp = bottles[b].peek();
            }
            else
            {
                System.out.println("That bottle is empty!");
                continue;
            }

            System.out.println("Select bottle to fill to: ");

            String y = scan.nextLine();

            try{
                int tester = Integer.parseInt(y);
            }catch (NumberFormatException ex)
            {
                System.out.println("Please enter a valid number!");
                continue;
            }
            int fillto = Integer.parseInt(y);
            if(fillto == b)
            {
                System.out.println("You must fill to another bottle!");
                continue;
            }

            if(fillto > bottles.length - 1)
            {
                System.out.println("That bottle does not exist");
                continue;
            }


            if(bottles[b].peek() == bottles[fillto].peek() && bottles[fillto].getStackSize() < 4 || bottles[fillto].getStackSize()== 0)
            {
                while(bottles[b].peek() == bottles[fillto].peek() && bottles[fillto].getStackSize() < bottles.length - 1 || bottles[fillto].getStackSize() == 0)
                    bottles[fillto].push(bottles[b].pop());

            }
            else
            {
                System.out.println("You may not fill to this bottle!");
                continue;
            }

            ShowAll(bottles);
        }
        System.out.println("\nYou WIN !!!");





    }
}
