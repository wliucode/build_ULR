package com.example.path;

public class BuildURL {

    // Given ABSOLUTE PATH
    // CURRENT: https://a.com/b/c/d.html
    // LINK: /e/f/g.html
    // RESULT : https://a.com/e/f/g.html

    private static String combineURL(String current, String link){
        String result = "";

        char SLASH = '/';
        char[] inputAsChars = current.toCharArray();

        int indexForThirdSlash = 0;
        int THIRD_SLASH_ITERATION = 3;
        int index = 1;
        boolean found = false;

        for(int i=0; i<current.length(); i++){
            if (inputAsChars[i] == SLASH){
                if(!found && (index == THIRD_SLASH_ITERATION)){
                    found = true;
                    indexForThirdSlash = i;
                } else {
                    index++;
                }
            }
        }

        String prefixAsProtocolAndHost = current.substring(0, indexForThirdSlash);
        System.out.println("Prefix retrieved (the Protocol and Host name of current Absolute Path): " + prefixAsProtocolAndHost + "\n");

        result = prefixAsProtocolAndHost + link;

        return result;
    }

    public static void main(String arg[]){
        String input = "https://a.com/b/c/d.html";
        String link = "/e/f/g.html";
        String output = "";

        System.out.println("Input (Current Absolute PATH): " + input);
        System.out.println("Input (Link - Relative PATH): " + link + "\n");

        output = combineURL(input, link);
        System.out.println("Output with the Combined PATH: " + output);
    }
}
