import java.util.Arrays;

/**
 * Plagiarism Checker
 * A tool for finding the longest shared substring between two documents.
 *
 * @author Zach Blick
 * @author YOUR NAME HERE
 */
public class PlagiarismChecker {

    /**
     * This method finds the longest sequence of characters that appear in both texts in the same order,
     * although not necessarily contiguously.
     *
     * @param doc1 the first document
     * @param doc2 the second
     * @return The length of the longest shared substring.
     */
    // Non-challenge solution
    public static int longestSharedSubstring(String doc1, String doc2) {

        // 2D array to store tabulated solutions
        int[][] tabulation = new int[doc1.length() + 1][doc2.length() + 1];

        // Traverse array, tabulating solutions
        for (int i = 1; i < tabulation.length; i++) {
            for (int j = 1; j < tabulation[0].length; j++) {
                // If the characters match, take the result up and to the left, and add one
                if (doc1.charAt(i - 1) == doc2.charAt(j - 1)) {
                    tabulation[i][j] = tabulation[i - 1][j - 1] + 1;
                }
                // If they don't, take the max of the spaces directly up and left
                else {
                    tabulation[i][j] = Math.max(tabulation[i - 1][j], tabulation[i][j - 1]);

                }
            }
        }
        return tabulation[tabulation.length - 1][tabulation[0].length - 1];
    }
}
//    // Challenge 1: return the longest substring
//    public static int longestSharedSubstring(String doc1, String doc2) {
//        // 2D array to store tabulated Strings
//        String[][] substrings = new String[doc1.length() + 1][doc2.length() + 1];
//        // Initialize the first row and column with empty strings
//        Arrays.fill(substrings[0], "");
//        for(int i = 1; i < substrings.length; i++) {
//            substrings[i][0] = "";
//        }
//        // Same method as above, but instead of saving numbers, save and add to strings when necessary
//        for(int i = 1; i <= doc1.length(); i++){
//            for(int j = 1; j <= doc2.length(); j++){
//                if(doc1.charAt(i - 1) == doc2.charAt(j - 1)){
//                    substrings[i][j] = substrings[i - 1][j - 1] + doc1.charAt(i - 1);
//                }
//                else{
//                    if(substrings[i - 1][j].length() > substrings[i][j - 1].length()){
//
//                        substrings[i][j] = substrings[i - 1][j];
//                    }
//                    else{
//
//                        substrings[i][j] = substrings[i][j - 1];
//                    }
//
//                }
//            }
//        }
//        System.out.println(substrings[substrings.length - 1][substrings[0].length - 1]);
//        return substrings[substrings.length - 1][substrings[0].length - 1].length();
//    }
//}
