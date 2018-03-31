import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Scanner;

public class GroceryList {

    public static LinkedList<String> linkedList = new LinkedList<>();

    public void getGroceries(){
        System.out.println("Enter in your groceries line by line. Type in -q to end input.");
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()){
            String grocery = scanner.nextLine();
            if (grocery.contains("-q")){
                break;
            }else{
                linkedList.add(grocery);
            }
        }
    }

    public LinkedList<String> quickSortGroceries(LinkedList<String> list){
        if (!list.isEmpty()){
            String pivot = list.get(0);
            LinkedList<String> before = new LinkedList<>();
            LinkedList<String> current = new LinkedList<>();
            LinkedList<String> after = new LinkedList<>();

            for (String word : list){
                if (word.compareTo(pivot) < 0){
                    before.add(word);
                }else if (word.compareTo(pivot) > 0){
                    after.add(word);
                }else {
                    current.add(word);
                }
            }

            before = quickSortGroceries(before);
            after = quickSortGroceries(after);
            before.addAll(current);
            before.addAll(after);
            return before;

        }

        return list;
    }

    public void exportgroceries(){
        try {
            PrintWriter printWriter = new PrintWriter("Groceries.txt");
            for (String line : linkedList){
                printWriter.println(line);
            }
            printWriter.flush();
            printWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] ivara){
        GroceryList list = new GroceryList();
        list.getGroceries();
        linkedList = list.quickSortGroceries(linkedList);
        list.exportgroceries();
        System.out.println("Thanks for using LinkedList demo code by ivara !");
    }

}
