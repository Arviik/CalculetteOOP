package math.prompt;

import java.util.regex.Pattern;

public class PromptValidator {
    private static final String REGEX = "\\d+|[+\\-*/]";

    private static final Pattern pattern = Pattern.compile(REGEX);

    private PromptValidator() {
    }

    public static boolean checkPrompt(String userInput) {
        return pattern.matcher(userInput).find();
    }
}
