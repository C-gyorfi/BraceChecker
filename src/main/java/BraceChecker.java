public class BraceChecker {

    public boolean isValid(String braces) {
        char[][] bracePairsArray = new char[][] {{'(', ')'}, {'[', ']'}, {'{', '}'}};

        for(char[] bracesPairs : bracePairsArray) {
            int openIndex = braces.indexOf(bracesPairs[0]);
            int firstCloseIndex = braces.indexOf(bracesPairs[1]);
            if ((firstCloseIndex < openIndex || (openIndex == -1 && firstCloseIndex >-1))) return false;

            if (openIndex > -1) {
                int lastCloseIndex = braces.lastIndexOf(bracesPairs[1]);
                boolean[] anyValid = new boolean[2];

                for (int closeIndex : new int[]{firstCloseIndex, lastCloseIndex}) {
                    String innerChunk = braces.substring(openIndex+1, closeIndex);
                    String beforeBraces = braces.substring(0, openIndex);
                    String afterBraces = braces.substring(closeIndex+1);
                    String outerChunk = beforeBraces + afterBraces;
                    int currentIndex = (closeIndex == firstCloseIndex) ? 0 : 1;
                    anyValid[currentIndex] = ((isValid(innerChunk) && isValid(outerChunk)));
                }
                return anyValid[0] || anyValid[1];
            }
        }
        return true;
    }
}