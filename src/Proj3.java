import java.io.*;
import java.util.*;

import static java.lang.Double.parseDouble;

public class Proj3 {
    // Sorting Method declarations
    // Merge Sort
    public static <T extends Comparable> void mergeSort(ArrayList<T> a, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            mergeSort(a, left, mid);
            mergeSort(a, mid + 1, right);
            merge(a, left, mid, right);
        }
    }

    //method to merge lists back together
    public static <T extends Comparable> void merge(ArrayList<T> a, int left, int mid, int right) {

        ArrayList<T> temp = new ArrayList<>();
        int i = left;
        int j = mid + 1;
        while (i <= mid && j <= right) {
            if (a.get(i).compareTo(a.get(j)) <= 0) {
                temp.add(a.get(i));
                i++;
            }
            else {
                temp.add(a.get(j));
                j++;
            }
        }
        //remaining elements from left
        while (i <= mid) {
            temp.add(a.get(i));
            i++;
        }
        //remaining elements from right
        while (j <= right) {
            temp.add(a.get(j));
            j++;
        }
        for (int k = 0; k < temp.size(); k++) {
            a.set(left + k, temp.get(k));
        }
    }

    // Quick Sort
    public static <T extends Comparable> void quickSort(ArrayList<T> a, int left, int right) {
        if (left < right) {
            int partition = partition(a, left, right);

            quickSort(a, left, partition - 1);
            quickSort(a, partition + 1, right);
        }
    }

    //method to partition  for quicksort
    public static <T extends Comparable> int partition (ArrayList<T> a, int left, int right) {

        T pivot = a.get(right);
        int i = left - 1;

        //comparing to pivot
        for (int j = left; j < right; j++) {
            if (a.get(j).compareTo(pivot) < 0) {
                i++;
                T temp = a.get(i);
                a.set(i, a.get(j));
                a.set(j, temp);
            }
        }
        //swap
        T temp = a.get(i+1);
        a.set(i+1, a.get(right));
        a.set(right, temp);

        return i+1;
    }

    //method for simple swap
    static <T> void swap(ArrayList<T> a, int i, int j) {
        T temp = a.get(i);
        a.set(i, a.get(j));
        a.set(j, temp);
    }

    // Heap Sort
    public static <T extends Comparable> void heapSort(ArrayList<T> a, int left, int right) {
        for (int i = right - 1; i >= left; i--) {
            heapify(a, i, right);
        }
        for (int i = left -1; i > 0; i--) {
            swap(a, 0, i);
            heapify(a, i, 0);
        }
    }

    public static <T extends Comparable> void heapify (ArrayList<T> a, int left, int right) {
        int largest = left;
        int leftChild = 2*left + 1;
        int rightChild = 2*left + 2;

        if (leftChild < right && a.get(leftChild).compareTo(a.get(largest)) > 0) {
            largest = leftChild;
        }
        if (rightChild < right && a.get(rightChild).compareTo(a.get(largest)) > 0) {
            largest = rightChild;
        }

        if (largest != left) {
            swap(a, largest, left);
            heapify(a, largest, right);
        }

    }

    // Bubble Sort
    public static <T extends Comparable> int bubbleSort(ArrayList<T> a, int size) {
        int counter = 0;
        boolean swapped = true;
        while (swapped) {
            swapped = false;
            for (int i = 0; i < size-1; i++) {
                counter++;
                if (a.get(i).compareTo(a.get(i + 1)) > 0) {
                    swap(a, i, i + 1);
                    swapped = true;
                }
            }
        }
        return counter;
    }

    // Odd-Even Transposition Sort
    public static <T extends Comparable> int transpositionSort(ArrayList<T> a, int size) {
        boolean isSorted = false;
        int counter = 0;

        while (!isSorted) {
            isSorted = true;


            //even
            for (int i = 0; i < size - 1; i+=2) {
                counter++;
                if (a.get(i).compareTo(a.get(i + 1)) > 0) {
                    swap(a, i, i + 1);
                    isSorted = false;
                }
            }

            //odd

            for (int i = 1; i < size - 1; i+=2) {
                counter++;
                if (a.get(i).compareTo(a.get(i + 1)) > 0) {
                    swap(a, i, i + 1);
                    isSorted = false;
                }
            }
        }
        return counter;
    }

    public static void main(String [] args)  throws IOException {

        String filename = args[0];
        String type = args[1];
        int numLines = Integer.parseInt(args[2]);


        // For file input
        FileInputStream inputFileNameStream = null;
        Scanner inputFileNameScanner = null;

        // Open the input file
        inputFileNameStream = new FileInputStream(filename);
        inputFileNameScanner = new Scanner(inputFileNameStream);

        //ignore first line
        inputFileNameScanner.nextLine();
        //create an original list
        ArrayList<NBAPlayer> origList = new ArrayList<>();
        int counter = 0;
        while (inputFileNameScanner.hasNextLine() && counter < numLines) {
            String line = inputFileNameScanner.nextLine();
            String [] values = line.split(",");

            // creating NBAPlayer object out of string input
            try {
                if (values.length == 17){
                    int playerID = Integer.parseInt(values[0].trim());
                    int gp = Integer.parseInt(values[1].trim());
                    int gs = Integer.parseInt(values[2].trim());
                    double mpg = parseDouble(values[3].trim());
                    double ppg = parseDouble(values[4].trim());
                    int fgm = Integer.parseInt(values[5].trim());
                    int fga = Integer.parseInt(values[6].trim());
                    double fgp = parseDouble(values[7].trim());
                    int threesMade = Integer.parseInt(values[8].trim());
                    int threesAttempted = Integer.parseInt(values[9].trim());
                    double threePercentage = parseDouble(values[10].trim());
                    int ftm = Integer.parseInt(values[11].trim());
                    int fta = Integer.parseInt(values[12].trim());
                    double ftp = parseDouble(values[13].trim());
                    String player = values[14].trim();
                    String position = values[15].trim();
                    String team = values[16].trim();

                    NBAPlayer newPlayer = new NBAPlayer(playerID, gp, gs, mpg,ppg,fgm, fga, fgp, threesMade,
                            threesAttempted, threePercentage, ftm, fta, ftp, player, position, team);

                    origList.add(newPlayer);
                }

            }
            catch (Exception e) {
                e.printStackTrace();
            }
            counter++;
        }


        // getting run times and outputting lists
        if (!origList.isEmpty()) {

            FileWriter writer1 = new FileWriter("analysis.txt",true);
            BufferedWriter br1 = new BufferedWriter(writer1);

            FileWriter writer2 = new FileWriter("sorted.txt");
            BufferedWriter br2 = new BufferedWriter(writer2);

            //bubble
            if (type.equals("bubble")) {

                //sorted
                Collections.sort(origList);
                double t1 = System.nanoTime();
                int sortNumOps = bubbleSort(origList, origList.size());
                double t2 = System.nanoTime();
                for (NBAPlayer a : origList) {
                    br2.write(a.getPlayerID() + ", " + a.getFieldGoalPercentage() + ", ");
                }
                br2.newLine();
                double sortedBubbleTime = t2 - t1;
                br1.write(args[1] + ", " + "sorted, " + numLines + ", " + sortedBubbleTime);
                br1.newLine();
                br1.write(args[1] + ", " + "sorted, " + numLines + ", " + sortNumOps);
                br1.newLine();

                //shuffled
                Collections.shuffle(origList);
                double t3 = System.nanoTime();
                int shuffledNumOps = bubbleSort(origList, origList.size());
                double t4 = System.nanoTime();
                for (NBAPlayer a : origList) {
                    br2.write(a.getPlayerID() + ", " + a.getFieldGoalPercentage() + ", ");
                }
                br2.newLine();
                double shuffledBubbleTime = t4 - t3;
                br1.write(args[1] + ", " + "shuffled, " + numLines + ", " + shuffledBubbleTime);
                br1.newLine();
                br1.write(args[1] + ", " + "shuffled, " + numLines + ", " + shuffledNumOps);
                br1.newLine();

                //reversed
                Collections.sort(origList, Collections.reverseOrder());
                double t5 = System.nanoTime();
                int reversedNumOps = bubbleSort(origList, origList.size());
                double t6 = System.nanoTime();
                for (NBAPlayer a : origList) {
                    br2.write(a.getPlayerID() + ", " + a.getFieldGoalPercentage() + ", ");
                }
                br2.newLine();
                double reverseBubbleTime = t6 - t5;
                br1.write(args[1] + ", " + "reversed, " + numLines + ", " + reverseBubbleTime);
                br1.newLine();
                br1.write(args[1] + ", " + "reversed, " + numLines + ", " + reversedNumOps);
                br1.newLine();
            }
            //odd-even
            else if (type.equals("odd-even")) {

                //sorted
                Collections.sort(origList);
                int sortedNumOps = transpositionSort(origList, origList.size());
                for (NBAPlayer a : origList) {
                    br2.write(a.getPlayerID() + ", " + a.getFieldGoalPercentage() + ", ");
                }
                br2.newLine();
                br1.write(args[1] + ", " + "sorted, " + numLines + ", " + sortedNumOps);
                br1.newLine();

                //shuffled
                Collections.shuffle(origList);
                int shuffledNumOps = transpositionSort(origList, origList.size());
                for (NBAPlayer a : origList) {
                    br2.write(a.getPlayerID() + ", " + a.getFieldGoalPercentage() + ", ");
                }
                br2.newLine();
                br1.write(args[1] + ", " + "shuffled, " + numLines + ", " + shuffledNumOps);
                br1.newLine();

                //reversed
                Collections.sort(origList, Collections.reverseOrder());
                int reverseNumOps = transpositionSort(origList, origList.size());
                for (NBAPlayer a : origList) {
                    br2.write(a.getPlayerID() + ", " + a.getFieldGoalPercentage() + ", ");
                }
                br2.newLine();
                br1.write(args[1] + ", " + "reversed, " + numLines + ", " + reverseNumOps);
                br1.newLine();
            }
            //merge sort
            else if (type.equals("merge")) {

                //sorted
                Collections.sort(origList);
                double t1 = System.nanoTime();
                mergeSort(origList, 0, origList.size()-1);
                double t2 = System.nanoTime();
                for (NBAPlayer a : origList) {
                    br2.write(a.getPlayerID() + ", " + a.getFieldGoalPercentage() + ", ");
                }
                br2.newLine();
                double sortedMergeTime = t2 - t1;
                br1.write(args[1] + ", " + "sorted ," + numLines + ", " + sortedMergeTime);
                br1.newLine();

                //shuffled
                Collections.shuffle(origList);
                double t3 = System.nanoTime();
                mergeSort(origList, 0, origList.size()-1);
                double t4 = System.nanoTime();
                for (NBAPlayer a : origList) {
                    br2.write(a.getPlayerID() + ", " + a.getFieldGoalPercentage() + ", ");
                }
                br2.newLine();
                double shuffledMergeTime = t4 - t3;
                br1.write(args[1] + ", " + "shuffled, " + numLines + ", " + shuffledMergeTime);
                br1.newLine();

                //reverse
                Collections.sort(origList, Collections.reverseOrder());
                double t5 = System.nanoTime();
                mergeSort(origList, 0, origList.size()-1);
                double t6 = System.nanoTime();
                for (NBAPlayer a : origList) {
                    br2.write(a.getPlayerID() + ", " + a.getFieldGoalPercentage() + ", ");
                }
                br2.newLine();
                double reverseMergeTime = t6 - t5;
                br1.write(args[1] + ", " + "reversed, " + numLines + ", " + reverseMergeTime);
                br1.newLine();
            }

            //quick
            else if (type.equals("quick")) {
                //sorted
                Collections.sort(origList);
                double t1 = System.nanoTime();
                quickSort(origList, 0, origList.size()-1);
                double t2 = System.nanoTime();
                for (NBAPlayer a : origList) {
                    br2.write(a.getPlayerID() + ", " + a.getFieldGoalPercentage() + ", ");
                }
                br2.newLine();
                double sortedQuickTime = t2 - t1;
                br1.write(args[1] + ", " + "sorted, " + numLines + ", " + sortedQuickTime);
                br1.newLine();

                //shuffled
                Collections.shuffle(origList);
                double t3 = System.nanoTime();
                quickSort(origList, 0, origList.size()-1);
                double t4 = System.nanoTime();
                for (NBAPlayer a : origList) {
                    br2.write(a.getPlayerID() + ", " + a.getFieldGoalPercentage() + ", ");
                }
                br2.newLine();
                double shuffledQuickTime = t4 - t3;
                br1.write(args[1] + ", " + "shuffled, " + numLines + ", " + shuffledQuickTime);
                br1.newLine();

                //reversed
                Collections.sort(origList, Collections.reverseOrder());
                double t5 = System.nanoTime();
                quickSort(origList, 0, origList.size()-1);
                double t6 = System.nanoTime();
                for (NBAPlayer a : origList) {
                    br2.write(a.getPlayerID() + ", " + a.getFieldGoalPercentage() + ", ");
                }
                br2.newLine();
                double reverseQuickTime = t6 - t5;
                br1.write(args[1] + ", " + "reversed, " + numLines + ", " + reverseQuickTime);
                br1.newLine();
            }

            //heap
            else if (type.equals("heap")) {
                //sorted
                Collections.sort(origList);
                double t1 = System.nanoTime();
                heapSort(origList, 0, origList.size()-1);
                double t2 = System.nanoTime();
                for (NBAPlayer a : origList) {
                    br2.write(a.getPlayerID() + ", " + a.getFieldGoalPercentage() + ", ");
                }
                br2.newLine();
                double sortedHeapTime = t2 - t1;
                br1.write(args[1] + ", " + "sorted, " + numLines + ", " + sortedHeapTime);
                br1.newLine();

                //shuffled
                Collections.shuffle(origList);
                double t3 = System.nanoTime();
                heapSort(origList, 0, origList.size()-1);
                double t4 = System.nanoTime();
                for (NBAPlayer a : origList) {
                    br2.write(a.getPlayerID() + ", " + a.getFieldGoalPercentage() + ", ");
                }
                br2.newLine();
                double shuffledHeapTime = t4 - t3;
                br1.write(args[1] + ", " + "shuffled, " + numLines + ", " + shuffledHeapTime);
                br1.newLine();

                //reversed
                Collections.sort(origList, Collections.reverseOrder());
                double t5 = System.nanoTime();
                heapSort(origList, 0, origList.size()-1);
                double t6 = System.nanoTime();
                for (NBAPlayer a : origList) {
                    br2.write(a.getPlayerID() + ", " + a.getFieldGoalPercentage() + ", ");
                }
                br2.newLine();
                double reverseHeapTime = t6 - t5;
                br1.write(args[1] + ", " + "reversed, " + numLines + ", " + reverseHeapTime);
                br1.newLine();
            }
            else {
                System.out.println("Invalid algorithm choice; options are: 'bubble', 'odd-even', 'merge', 'quick', or 'heap'.");
            }

            br1.close();
            br2.close();
        }
    }

}
