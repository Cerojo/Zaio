import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        print(containsDuplicates(new int[]{ 5, 2, 17, 13, 12, 19, 5, 7, 3, 9, 15 }));
        for(int[] a: rotateImage(new int[][]{{1,2,3},{4,5,6},{7,8,9}})){
            print(Arrays.toString(a));
        }
        print(firstDuplicate(new int[]{2, 1, 3, 5, 3, 2}));
    }

    private static boolean containsDuplicates(int[] array){
        Arrays.sort(array); //Presort O[nlog(n)]
        for(int i = 1; i < array.length; i++){ //Search O[n]
            if(array[i-1] == array[i]){ //compare index n-1 with n
                return true; //n-1 equals n
            }
        }
        return false; //no duplicates
    }

    private static int[][] rotateImage(int[][] image){
        int size = image.length; //Array size
        int[][] rotated = new int[size][size]; //Rotated Array
        int mul = size*size; //Number of ints
        for(int i = 0; i < mul; i++){ //0 to Number of ints
            rotated[i/size][i%size] = image[(mul-1-i)%size][i/size];
        }
        return rotated; //Rotated image
    }

    private static int firstDuplicate(int[] array){
        ArrayList<Integer> arrayList = new ArrayList<>(); //Contain unique integers
        for(int i: array){ //Go through integers
            if(!arrayList.contains(i)){ //Check if unique integer
                arrayList.add(i); //Add unique integer
            }
            else{
                return i; //Return first occurrence
            }
        }
        return -1; //No duplicate found
    }

    private static void print(Object text){
        System.out.println(text);
    }
}
