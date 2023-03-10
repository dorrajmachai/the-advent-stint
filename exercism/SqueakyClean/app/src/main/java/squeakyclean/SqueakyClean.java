/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package squeakyclean;
import java.lang.StringBuilder;

// TODO:
// - [x] Replace whitespace with underscores
// - [x] Replace control characters with "CTRL"
// - [x] Convert kebab-case to camelCase
// - [x] Omit characters that aren't letters
// - [ ] Omit Greek lowercase letters

/*

I think the problem is that I am setting the value of these characters to something when I should be deleting them completely. So, I have to figure out what I'm doing wrong with the .delete() and .deleteCharAt() methods in order to get the tests to pass....
*/
public class SqueakyClean {
    static String clean(String identifier) {
        return identifier;
    }

    public static void unusedClean(String identifierU) {
    // the capacity of a StringBuilder instance can be initialized to the value of a string it's passed.
        StringBuilder stringBuilder = new StringBuilder( /* identifierU */ );

        for (int i = 0; i < identifierU.length(); i++) {

            // -- Replace whitespace with underscores - DONE
            if (Character.isWhitespace(stringBuilder.charAt(i))) {
                stringBuilder.setCharAt(i, '_');

            // -- Replace control characters with "CTRL" - DONE
            } else if (Character.isISOControl(stringBuilder.charAt(i))) {
                stringBuilder.replace(i, i + 1, "CTRL");

            // Convert kebab-case to camelCase - DONE
            } else if (stringBuilder.charAt(i) == '-') {
                stringBuilder.setCharAt(stringBuilder.indexOf("-") + 1, 
                                        Character.toUpperCase(stringBuilder.charAt(i + 1)));           
                stringBuilder.setCharAt(i, Character.MIN_VALUE);

            // Omit characters that aren't letters - DONE
            } else if (!Character.isLetter(stringBuilder.charAt(i))) {
                stringBuilder.setCharAt(i, Character.MIN_VALUE);
        
            // Omit Greek lowercase letters
            } else if (Character.UnicodeBlock.of(i) == Character.UnicodeBlock.GREEK) {
                stringBuilder.setCharAt(i, Character.MIN_VALUE);
            }
        }

        System.out.println(stringBuilder);
    }

    public static void main(String[] args) {

        String identifier = "hello-world"; 
        SqueakyClean.clean(identifier);
    }
}
