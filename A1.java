package a1;

import java.io.File;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.*;

public class A1 {

    public static void main(String[] args) throws Exception {
        String line;
        Scanner sc = new Scanner(new File("Top100.csv"));
        final int Maxaccts = 95;
        String[] TopArtist = new String[Maxaccts];
        int k = 0;
        boolean stat;
        PrintStream ps = new PrintStream(new File("Outout.txt"));

        while (sc.hasNext()) {
            line = sc.nextLine();
            String[] tokens = line.split(",");

            if (tokens[2].substring(0, 1).equals("\"")) {
                stat = findAcct(TopArtist,
                        tokens[2].substring(1, tokens[2].length() - 1));

                if (stat == false) {
            TopArtist[k] = tokens[2].substring(1, tokens[2].length() - 1);
              k++;
                }
            } else {
                stat = findAcct(TopArtist, tokens[2]);
                if (stat == false) {
                    TopArtist[k] = tokens[2];
                    k++;
                }

            }
        }
        for (String TopArtist1 : TopArtist) {
            System.out.println(TopArtist1);
        }

        LinkedList<String> Artist = new LinkedList<>();
        Artist.addAll(Arrays.asList(TopArtist));

        Collections.sort(Artist, String.CASE_INSENSITIVE_ORDER);
        System.out.println(Artist);
    }

    public static boolean findAcct(String[] TopArtist, String name) {
        try {
            for (String TopArtist1 : TopArtist) {
                if (TopArtist1.equals(name)) {
                    return true;
                }
            }

        } catch (NullPointerException e) {
            return false;
        }

        return false;
    }
}
