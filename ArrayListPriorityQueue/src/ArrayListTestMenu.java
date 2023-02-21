import java.io.File;
import java.io.IOException;
import java.util.Scanner;
public class ArrayListTestMenu
{
    private Scanner console;
    private Arraylist<String> myList;

    public ArrayListTestMenu()
    {
        console = new Scanner(System.in);
        myList = new Arraylist<String>();
    }

    private void loadFile(String fileName)
    {
        int id, inv;
        Scanner inFile;
        try
        {
            inFile = new Scanner(new File(fileName));

            while (inFile.hasNext())
            {
                id = inFile.nextInt();
                inv = inFile.nextInt();
            }
        } catch (IOException i)
        {
            System.out.println("Error: " + i.getMessage());
        }
    }

    private void singleInput()
    {
        console = new Scanner(System.in);
        System.out.println("All inputs will be added to the list as strings");
        String input;
        do
        {
            System.out.print("Enter String input (-1 to quit): ");
            input = console.nextLine();
            if(input.equals("-1") == false)
                myList.add(input);
        }
        while(input.equals("-1") == false);
    }

    private void doubleInput()
    {
        console = new Scanner(System.in);
        System.out.println("All inputs will be added to the list as strings");
        String input;
        int index;
        do
        {
            console = new Scanner(System.in);
            System.out.print("Enter valid index (-1 to quit): ");
            index = console.nextInt();
            if (index == -1)
                return;
            console.nextLine();
            System.out.print("Enter String input (-1 to quit): ");
            input = console.nextLine();
            if (input.equals("-1"))
                return;
            try
            {
                myList.add(index,input);
                System.out.println("String '" + input + "' has been added to slot " + index);
            }
            catch(IndexOutOfBoundsException e)
            {
                System.out.println(e.getMessage());
            }

        }while(index != -1);
    }

    private void set()
    {
        console = new Scanner(System.in);
        String item;
        int index;
        System.out.println("All new inputs will be handled as Strings");
        do
        {
            System.out.print("Enter Valid Index(-1 to quit): ");
            index = console.nextInt();
            if (index == -1)
                return;
            console.nextLine();
            System.out.print("Enter New String (-1 to quit): ");
            item = console.nextLine();
            if (item.equals("-1"))
                return;
            try
            {
                String temp = myList.set(index,item);
                System.out.println(String.format("Object '%s' at %d has been set to %s", temp, index, item));
            }
            catch(IndexOutOfBoundsException e)
            {
                System.out.println(e.getMessage());
            }
        }while(item.equals("-1") == false);
    }

    private void printList()
    {
        for(int i = 0; i < myList.size(); i++)
        {
            System.out.println(myList.get(i));
        }
        System.out.println();
    }

    private void get()
    {
        console = new Scanner(System.in);
        int index;
        do
        {
            System.out.print("Enter input (-1 to quit): ");
            index = console.nextInt();
            if(index != -1)
            {
                try{
                    Object gotten = myList.get(index);
                    System.out.println("Object at index " + index + " is: " + gotten);
                }
                catch(IndexOutOfBoundsException e){
                    System.out.println(e.getMessage());
                }
            }
        }while(index != -1);
    }

    private void remove()
    {
        console = new Scanner(System.in);
        int index;
        do
        {
            System.out.print("Enter input (-1 to quit): ");
            index = console.nextInt();
            if(index != -1)
            {
                try{
                    myList.remove(index);
                    System.out.println("Object at index " + index + " has been removed.");
                }
                catch(IndexOutOfBoundsException e){
                    System.out.println(e.getMessage());
                }
            }
        }while(index != -1);
    }

    public void mainMenu()
    {
        int choice;
        System.out.println("ArrayList Tester Has Been Initiated");
        do
        {
            System.out.println(" (1) Size");
            System.out.println(" (2) isEmpty");
            System.out.println(" (3) Add w/ 1 Parameter");
            System.out.println(" (4) Add w/ 2 Parameter");
            System.out.println(" (5) Set");
            System.out.println(" (6) Get");
            System.out.println(" (7) Remove");
            System.out.println(" (8) Print List");
            System.out.println("(-1) Quit\n");
            System.out.print("Choice ---> ");
            choice = console.nextInt();
            System.out.println();

            if (choice > 0 && choice <= 8)
            {
                switch(choice)
                {
                    case 1:
                        System.out.println("List Size: " + myList.size());
                        break;

                    case 2:
                        if(myList.size() == 0)
                            System.out.println("List is Empty");
                        else
                            System.out.println("List is not Empty");
                        break;

                    case 3:
                        singleInput();
                        break;

                    case 4:
                        doubleInput();
                        break;

                    case 5:
                        set();
                        break;

                    case 6:
                        get();
                        break;

                    case 7:
                        remove();
                        break;

                    case 8:
                        printList();
                        break;
                }
            }
            else if(choice == -1)
            {
                break;
            }
            else
            {
                System.out.println("Invalid Option Selected");
            }
        }
        while (choice != -1);
    }
}

