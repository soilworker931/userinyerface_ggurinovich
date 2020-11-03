package utils;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Utility {
    private static File file = new File("src\\main\\resources\\primary-test-it.png");
    private static String absolutePath = file.getAbsolutePath();

    public String textGeneration(int textLength) {
        String capitalChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String smallChars = "abcdefghijklmnopqrstuvwxyz";
        String cyrillicChars = "АБВГДЕЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";
        String numbers = "0123456789";
        String specialSymb = "!@#$%^&*()";
        Random rnd = new Random();
        int randomCapitalChars = (int) (Math.random() * capitalChars.length());
        int randomnumber = (int) (Math.random() * numbers.length());
        int randomCyrillicChar = (int) (Math.random() * cyrillicChars.length());
        int randomSpecialSymb = (int) (Math.random() * specialSymb.length());
        String generatedCapitalChar = capitalChars.substring(randomCapitalChars, randomCapitalChars + 1);
        String generatedCyrillicChar = cyrillicChars.substring(randomCyrillicChar, randomCyrillicChar + 1);
        String generatedSpecialSymb = specialSymb.substring(randomSpecialSymb, randomSpecialSymb + 1);
        StringBuilder generatedSmallChars = new StringBuilder(textLength);
        for (int i = 0; i < textLength; i++) {
            generatedSmallChars.append(smallChars.charAt(rnd.nextInt(smallChars.length())));}
        String generatedText = generatedCapitalChar + generatedCyrillicChar + generatedSpecialSymb + generatedSmallChars + randomnumber;
        return generatedText;
    }

    public static void uploadFile(){
        StringSelection stringSelection = new StringSelection(absolutePath);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, stringSelection);

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Robot robot = null;
        try {
            robot = new Robot();

        } catch (AWTException e) {
            e.printStackTrace();
        }
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }
}