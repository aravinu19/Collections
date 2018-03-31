import java.util.*;

public class HashingAuhtors {

    private <E> void printMap(Set<E> entrySet){
        Iterator<E> iterator = entrySet.iterator();
        while (iterator.hasNext()){
            E entry = iterator.next();
            System.out.println(entry);
        }
    }

    public static void main(String[] ivara){
        Map<String, List<String>> hash = new HashMap<>();

        System.out.println("Enter in author's last name and book separated by a space. type -q to end input.");
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()){
            String input = scanner.nextLine();
            if (input.contains("-q")){
                break;
            }else {
                String[] entry = new String[2];
                entry[0] = input.substring(0, input.indexOf(' '));
                entry[1] = input.substring(input.indexOf(' ')+1);
                List<String> entryList = new ArrayList<>();
                if (hash.containsKey(entry[0])){
                    entryList = hash.get(entry[0]);
                    entryList.add(entry[1]);
                    hash.put(entry[0], entryList);
                }else {
                    entryList.add(entry[1]);
                    hash.put(entry[0], entryList);
                }
            }
        }

        HashingAuhtors auhtors = new HashingAuhtors();
        Set entrySet = hash.entrySet();
        auhtors.printMap(entrySet);

        System.out.println("\n Thanks for using the mapping demo with hashmap by ivara !");

    }

}
