package math.prompt;

import math.MathElement;
import math.MathElementFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Prompt {

    private Prompt() {
    }

    public static List<MathElement> getUserPrompt() {
        Scanner sc = new Scanner(System.in);
        List<MathElement> userPrompt = new ArrayList<>();
        String userInput = "";

        while (!userInput.equals("=")) {
            System.out.print("Please enter a character" + getUserPromptPreview(userPrompt) + ": ");
            userInput = sc.nextLine();

            try {
                addUserInput(userPrompt, userInput);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            if (userInput.equals("=")) {
                if (!userPrompt.isEmpty() && userPrompt.get(userPrompt.size() - 1).isOperator()) {
                    System.out.println("You can't end with an operator");
                    userInput = "";
                }

                if (userPrompt.size() < 3) {
                    System.out.println("You have to enter at least 3 characters");
                    userInput = "";
                }
            }
        }

        return userPrompt;
    }

    private static String getUserPromptPreview(List<MathElement> userPrompt) {
        StringBuilder userPromptPreview = new StringBuilder();

        if (!userPrompt.isEmpty()) {
            userPromptPreview.append(" [");

            for (MathElement mathElement : userPrompt) {
                userPromptPreview.append(mathElement.toChar()).append(" ");
            }

            if (!userPromptPreview.isEmpty()) {
                userPromptPreview.deleteCharAt(userPromptPreview.length() - 1);
            }

            userPromptPreview.append("] ");
        }

        return userPromptPreview.toString();
    }

    private static void addUserInput(List<MathElement> userPrompt, String userInput) throws Exception {
        if (PromptValidator.checkPrompt(userInput)) {
            MathElement mathElement = MathElementFactory.newMathElements(userInput);

            if (userPrompt.isEmpty()) {
                if (!mathElement.isOperator()) {
                    userPrompt.add(mathElement);
                    return;
                }
                throw new Exception("First character can't be an operator");
            }

            boolean previousIsOperator = userPrompt.get(userPrompt.size() - 1).isOperator();

            if (userPrompt.get(userPrompt.size() - 1).toChar().contentEquals("/") && mathElement.toChar().contentEquals("0")) {
                throw new Exception("Nice try but you can't divide by zero");
            }

            if (mathElement.isOperator() != previousIsOperator) {
                userPrompt.add(mathElement);
                return;
            }

            throw new Exception("Previous entry and current entry aren't compatible");
        } else if (!userInput.equals("=")) {
            throw new Exception("Impossible character");
        }
    }
}
