package api.backwine.util;

public class PathConverter {
    public static String convertToApiPath(String input) {
        String kebabCaseName = input.replaceAll("([a-z])([A-Z])", "$1-$2").toLowerCase();
        return StringPatternUtil.API_PATH + pluralize(kebabCaseName);
    }

    private static String pluralize(String word) {
        if (word.endsWith("s") || word.endsWith("x") || word.endsWith("z")
                || word.endsWith("ch") || word.endsWith("sh")) {
            return word + "es/"; // Plural form with 'es'
        } else if (word.endsWith("y")) {
            // Check if the 'y' is preceded by a vowel or not
            char secondToLastChar = word.charAt(word.length() - 2);
            if (isVowel(secondToLastChar)) {
                return word + "s/"; // Plural form with 's'
            } else {
                return word.substring(0, word.length() - 1) + "ies/"; // Plural form with 'ies'
            }
        } else {
            return word + "s/"; // Default plural form with 's'
        }
    }

    private static boolean isVowel(char c) {
        return "AEIOUaeiou".indexOf(c) != -1;
    }
}
