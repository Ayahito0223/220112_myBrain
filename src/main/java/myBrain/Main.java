package myBrain;

import myBrain.visualComponents.MainFrame;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import myBrain.visualComponents.DebugFrame;

/**
 *
 * @author Ayahito0223
 */
public class Main {

    public static final int WHITE = 0;
    public static final int DARK = 1;
    public static boolean DEBUG = false;

    private static MainFrame mainFrame;
    private static DebugFrame debugFrame;
    private static File dataSpace;
    public static String myBrainDataFile;

    public static void main(String args[]) {
        Path a1 = Paths.get("");
        dataSpace = new File(a1.toAbsolutePath().toString());
        if (Main.DEBUG) {
            System.out.println("dataSpace: " + new File(dataSpace, myBrainDataFile).toString());
            System.out.println("");
        }
        myBrainDataFile = "myBrainData.json";

        mainFrame = new MainFrame(Main.WHITE);
        mainFrame.init();
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);

        debugFrame = new DebugFrame(DEBUG);
        debugFrame.updateInfo();
        if (DEBUG) {
            debugFrame.setVisible(true);
        } else {
            debugFrame.setVisible(false);
        }
    }

    public static void openDebugFrame(){
        debugFrame.setVisible(true);
    }

    public static MainFrame getMainFrame() {
        return mainFrame;
    }

    public static DebugFrame getDebugFrame() {
        return debugFrame;
    }

    public static File getDataSpace() {
        return dataSpace;
    }

    public static void setDataSpace(File dataSpace) {
        Main.dataSpace = dataSpace;
    }

    public static String getMyBrainDataFile() {
        return myBrainDataFile;
    }

    public static void setMyBrainDataFile(String myBrainDataFile) {
        Main.myBrainDataFile = myBrainDataFile;
    }
}
