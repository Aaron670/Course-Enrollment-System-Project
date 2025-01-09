package  enrollmentSystem;
import javax.swing.*;

public class NestedScrollPaneExample{
    public static void main(String[] args) {
        JFrame frame = new JFrame("JTextArea Paragraph Example");
        JTextArea textArea = new JTextArea();
        
        // Array containing a long paragraph
        String[] longTextArray = {
            "This is a long paragraph. It contains multiple sentences. Each sentence should be on a new line."
        };

        // Split the paragraph into individual sentences
        String[] sentences = longTextArray[0].split("\\. ");
        
        // Loop through the sentences and append each to the JTextArea
        for (String sentence : sentences) {
            textArea.append(sentence + ".\n");
        }
        
        frame.add(new JScrollPane(textArea));
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
