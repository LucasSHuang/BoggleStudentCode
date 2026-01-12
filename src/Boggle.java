import java.util.ArrayList;
import java.util.Arrays;

public class Boggle {

    public static String[] findWords(char[][] board, String[] dictionary) {

        ArrayList<String> goodWords = new ArrayList<String>();
        TST tst = new TST();
        boolean[][] visited = new boolean[board.length][board[0].length];

        // Added all dictionary words into TST
        for (int i = 0; i < dictionary.length; i++) {
            tst.insert(dictionary[i]);
        }

        // Go through every possible word and perform DFS
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                DFS(tst, board, visited, goodWords, i, j, "");
            }
        }

        // Convert the list into a sorted array of strings, then return the array.
        String[] sol = new String[goodWords.size()];
        goodWords.toArray(sol);
        Arrays.sort(sol);
        return sol;
    }

    public static void DFS(TST tst, char[][] board, boolean[][] visited, ArrayList<String> goodWords, int i, int j, String word) {

        // Make sure there aren't any index out of bounds errors or already visited the letter
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j]) {
            return;
        }
        word += board[i][j];

        // Check if the word can be valid in the dictionary and if is a word and not already added to arraylist add it
        if (!tst.hasPrefix(word)) {
            return;
        }
        if (tst.find(word) && !goodWords.contains(word)) {
            goodWords.add(word);
        }

        // Perform DFS recursively down, up, left, and right and at the end reset the visited to false for next searches
        visited[i][j] = true;
        DFS(tst, board, visited, goodWords, i - 1, j, word);
        DFS(tst, board, visited, goodWords, i + 1, j, word);
        DFS(tst, board, visited, goodWords, i, j - 1, word);
        DFS(tst, board, visited, goodWords, i, j + 1, word);
        visited[i][j] = false;
    }
}
