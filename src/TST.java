public class TST {
    private TSTNode root;

    public TST() {
        root = new TSTNode('m');
    }

    // Inserts words into TST
    public void insert (String word) {

        TSTNode current = root;
        int index = 0;

        // Iterates through entire word
        while (index < word.length()) {
            char c = word.charAt(index);
            char middle = current.getLetter();

            // If the letter is 'less' than the value of the TSTNode's letter than you go left
            if (c < middle) {
                // If there is nothing to the left of the node than you just put the letter there
                if (current.getLeft() == null) {
                    current.setLeft(new TSTNode(c));
                }
                // Otherwise you check the letter again against the left node the next time around
                current = current.getLeft();
            }
            // If letter is 'more' than the values of the TSTNode's letter go right and do the same thing as before
            else if (c > middle) {
                if (current.getRight() == null) {
                    current.setRight(new TSTNode(c));
                }
                current = current.getRight();
            }
            // Case where the letter is matching the TSTNode's letter
            else {
                // If the letter was the last letter in the word set it to a real word
                if (index == word.length() - 1) {
                    current.setWord(true);
                    break;
                }
                // Increment index to go to next letter since the previous one was correct
                index++;
                // Check like both right and left inserts
                if (current.getMid() == null) {
                    current.setMid(new TSTNode(word.charAt(index)));
                }
                current = current.getMid();
            }
        }
    }

    // Find if the word is in the dictionary
    public boolean find(String word) {
        TSTNode current = root;
        int index = 0;
        // Goes until reaching the length of the word or the node you need to go to doesn't have a letter
        while (current != null && index < word.length()) {
            char c = word.charAt(index);
            char middle = current.getLetter();
            // If letter is less than letter you are checking go left
            if (c < middle) {
                current = current.getLeft();
            }
            // Same thing but go right for greater letter
            else if (c > middle) {
                current = current.getRight();
            }
            // Letter is same as letter you are checking
            else {
                index++;
                // If you have reached the end of the word return whether it is a word or not
                if (index == word.length()) {
                    return current.isWord();
                }
                // Otherwise move on
                current = current.getMid();
            }
        }
        // If not found then return false
        return false;
    }

    public boolean hasPrefix(String word) {
        TSTNode current = root;
        int index = 0;
        // Goes until reaching the length of the word or the node you need to go to doesn't have a letter
        while (current != null && index < word.length()) {
            char c = word.charAt(index);
            char middle = current.getLetter();
            // If letter is less than letter you are checking go left
            if (c < middle) {
                current = current.getLeft();
            }
            // Same thing but go right for greater letter
            else if (c > middle) {
                current = current.getRight();
            }
            // Letter is same as letter you are checking
            else {
                index++;
                // If you have reached the prefix return true
                if (index == word.length()) {
                    return true;
                }
                // Otherwise move on
                current = current.getMid();
            }
        }
        // If not found then return false
        return false;
    }

    // Class for node for tst
    private class TSTNode {
        private boolean isWord;
        private boolean isVisited;
        private char letter;
        private TSTNode left;
        private TSTNode right;
        private TSTNode mid;
        private TSTNode(char c) {
            isWord = false;
            letter = c;
        }

        // Getters and setters
        private boolean isWord() {
            return isWord;
        }

        private void setWord(boolean word) {
            isWord = word;
        }

        private char getLetter() {
            return letter;
        }

        private TSTNode getLeft() {
            return left;
        }

        private void setLeft(TSTNode left) {
            this.left = left;
        }

        private TSTNode getRight() {
            return right;
        }

        private void setRight(TSTNode right) {
            this.right = right;
        }

        private TSTNode getMid() {
            return mid;
        }

        private void setMid(TSTNode mid) {
            this.mid = mid;
        }
    }
}


