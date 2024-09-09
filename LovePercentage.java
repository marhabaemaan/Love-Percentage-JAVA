import java.util.Scanner;
import java.util.ArrayList;

public class P {
    public static void main(String[] args) {

        String name, name2;
        int counter = 0;
        char temp;

        Scanner obj = new Scanner(System.in);
        ArrayList<Character> list1 = new ArrayList<Character>();
        ArrayList<Integer> count = new ArrayList<Integer>(); 


        System.out.println("Welcome to percentage game: ");
        System.out.println("Enter first name: ");
        name = obj.nextLine();
        System.out.println("Enter second name: ");
        name2 = obj.nextLine();

        char[] o = name.toCharArray();
        char[] d = name2.toCharArray();
        for(int i = 0; i < o.length; i++)
        {
            list1.add(o[i]);
        }
        for(int i = 0; i < d.length; i++)
        {
            list1.add(d[i]);
        }

        for(int i = 0; i < list1.size(); i++) // its size doesnt matter as as soon list1 becomes empty outer loop breaks
        
        {

            if(list1.isEmpty())
                break;

            if(list1.get(i) != null)
            {
                temp = list1.get(i);
            
                for(int j = 0; j < list1.size(); j++) {

                    if(list1.get(j) != null)
                    {                       
                            if (temp == list1.get(j)) {
                                if (list1.get(i) != null && i!=j) {
                                    list1.add(i, null);
                                    list1.remove(i+1);
                                    counter++;
                                }
                                list1.add(j, null);
                                list1.remove(j+1);
                                counter++;
                            }       
                    }
                    if(list1.isEmpty())
                    break;
                }
            }
            
            count.add(counter);
            counter = 0;
        } // till here alphabets are done
        
        for(int j = 0; j < count.size(); j++)
        {
            for(int i = 0; i < count.size(); i++)
            {
                if(count.get(i) == 0)
                count.remove(i);
            }
        } // this removes zeroes, now we have the real non zero integer array left
      
        int sizeCatch = count.size();
        int total = 0;
        while(count.size()!=2)
        {
            for(int i = 0; i < count.size()/2+1; i++)
            {
                if(i == sizeCatch-i-1)
                {
                    count.add(count.get(i));
                    total++;
                    break;
                }
                else if(i == sizeCatch-i)
                {
                    break;
                }
                else
                {
                    total++;
                    count.add(count.get(i) + count.get(sizeCatch-i-1));
                }
            }

            int j = 0;
            for(int i = 0; i < count.size(); i++)
            {
                if(j == sizeCatch)
                break;
                count.remove(i);
                i--;
                j++;
            }

            sizeCatch = count.size();

        }

        System.out.println("The love percentage is: " + count.get(0) + count.get(1) + "%");

    }

}
