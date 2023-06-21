import application.Application;
import com.formdev.flatlaf.FlatDarkLaf;
import data.DataManager;

import javax.swing.*;
import java.io.IOException;

public class HeartsOfIron4ModdingTool {

    public static void main(String[] args) throws IOException {

        try {
            UIManager.setLookAndFeel( new FlatDarkLaf());
        } catch( Exception ex ) {
            System.err.println( "Failed to initialize LaF" );
        }

        DataManager.init();

        SwingUtilities.invokeLater(Application::new);
    }
}