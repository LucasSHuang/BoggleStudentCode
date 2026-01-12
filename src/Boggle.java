import java.util.ArrayList;
import java.util.Arrays;

public class Boggle {

    public static String[] findWords(char[][] board, String[] dictionary) {
        ArrayList<String> goodWords = new ArrayList<String>();

        TST tst = new TST();
        for (int i = 0; i < dictionary.length; i++) {
            tst.insert(dictionary[i]);
        }

        boolean[][] visited = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                DFS(tst, board, visited, goodWords, i, j, "" + board[i][j]);
            }
        }
        // TODO: Complete the function findWords(). Add all words that are found both on the board
        //  and in the dictionary.

        // Convert the list into a sorted array of strings, then return the array.
        String[] sol = new String[goodWords.size()];
        goodWords.toArray(sol);
        Arrays.sort(sol);
        return sol;
    }

    public static void DFS(TST tst, char[][] board, boolean[][] visited, ArrayList<String> goodWords, int i, int j, String word) {
        if (i < 0 || i >= board.length || j < 0 || j >= board.length || visited[i][j]) {
            return;
        }

        word += board[i][j];

    }
}
