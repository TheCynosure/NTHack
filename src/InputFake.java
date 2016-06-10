import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.*;

/**
 * Created by Jack on 6/9/2016.
 */
public class InputFake {

    int[] probs;
    private Robot robot;


    public InputFake() {
        loadProbs("probs.txt");
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }

    }

    private void loadProbs(String fileName) {
        int index = 0;
        try {
            probs = new int[findLineNum(fileName) + 2];
            File file = new File(fileName);
            FileReader fr = new FileReader(file);
            BufferedReader bf = new BufferedReader(fr);
            String line = "";
            while ((line = bf.readLine()) != null) {
                probs[index] = (int) line.charAt(0);
                index++;
            }
            //Add the space
            probs[index] = 32;
            probs[index + 1] = 222;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private int findLineNum(String fileName) {
        File file = new File("probs.txt");
        FileReader fr = null;
        try {
            fr = new FileReader(file);
            LineNumberReader ln = new LineNumberReader(fr);
            int lineNums = 0;
            while(ln.readLine() != null) {
                lineNums++;
            }
            ln.close();
            return lineNums;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public void emulateKeys(Manager manager) {
        pressKey(32);
        //Lowercase
        for(int i = 0; i < probs.length; i++) {
            pressKey(probs[i]);
        }
        if(manager.isLetterCorrect()) {
            return;
        }
        //Special Characters
//        for(int i = 44; i <= 46; i++) {
//            pressKey(i);
//        }
//        pressKey(96);
//        pressKey(KeyEvent.VK_QUOTE);
//        if(manager.isLetterCorrect()) {
//            return;
//        }
        //Capitals
        for(int i = KeyEvent.VK_A; i < KeyEvent.VK_Z; i++) {
            robot.keyPress(16);
            pressKey(i);
            robot.keyRelease(16);
        }
        if(manager.isLetterCorrect()) {
            return;
        }
        //Numbers
        for(int i = KeyEvent.VK_0; i <= KeyEvent.VK_9; i++) {
            pressKey(i);
        }
        pressKey(37);
    }

    public void pressKey(int code) {
        try {
            robot.keyPress(code);
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            robot.keyRelease(code);
        } catch (IllegalArgumentException e) {
            System.out.println(code + ": Failed");
        }
    }
}
