/**
 * Mark Truitt
 * CMIS 242
 * Week 4 - GUI
 *
 * This class represents a panel for capturing information about a movie. It includes a title field, a year picker,
 * a rating field, and a submit button.
 *
 * The information entered by the user can be retrieved and printed by pressing the submit button.
 * The year picker is set to only select the year.
 */

import java.awt.*;
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.WindowConstants;

public class MovieInfo extends JPanel {
    private JLabel titleLabel;
    private JTextField titleField;
    private JLabel yearLabel;
    private JSpinner yearSpinner;
    private JLabel ratingLabel;
    private JTextField ratingField;
    private JButton submitButton;

    // Set new image for the icon
    ImageIcon icon = new ImageIcon("reel.png");
    Image newImage = icon.getImage().getScaledInstance(120, 120, java.awt.Image.SCALE_SMOOTH);
    ImageIcon resizedIcon = new ImageIcon(newImage);

    // constructor
    public MovieInfo() {
        // Create the labels
        titleLabel = new JLabel("Title:");
        yearLabel = new JLabel("Year:");
        ratingLabel = new JLabel("Rating:");

        // Create the text field for the movie title
        titleField = new JTextField();
        titleField.setPreferredSize(new Dimension(200, 26));

        // Create the spinner for the year
        Calendar calendar = Calendar.getInstance();
        int currentYear = calendar.get(Calendar.YEAR);
        SpinnerModel yearModel = new SpinnerNumberModel(currentYear, currentYear - 100, currentYear + 100, 1);
        yearSpinner = new JSpinner(yearModel);
        JSpinner.NumberEditor yearEditor = new JSpinner.NumberEditor(yearSpinner, "#"); // Remove comma
        yearSpinner.setEditor(yearEditor);

        // Create the text field for the rating
        ratingField = new JTextField();
        ratingField.setPreferredSize(new Dimension(100, 26));

        // Create the submit button
        submitButton = new JButton("Submit");
        submitButton.addActionListener(e -> { // Updated to use Lambda Expression - https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html
            String title = titleField.getText();
            int year = (Integer) yearSpinner.getValue();
            String rating = ratingField.getText();

            if (title.isEmpty()) {
                JOptionPane.showMessageDialog(MovieInfo.this, "Title cannot be empty", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                String message = "Movie: " + title + ", Year: " + year + ", Rating: " + rating;
                int result = JOptionPane.showConfirmDialog(null, message, "Confirm Movie Info", JOptionPane.YES_NO_OPTION);

                if (result == JOptionPane.YES_OPTION) {
                    System.out.println("Movie info confirmed: " + message);
                } else {
                    System.out.println("Movie info denied.");
                }
            }
        });

        // Set the layout for the panel
        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(10, 10, 10, 10);

        // Add the title label and field to the panel
        constraints.anchor = GridBagConstraints.WEST;
        constraints.gridx = 0;
        constraints.gridy = 0;
        add(titleLabel, constraints);

        constraints.gridx = 2;
        add(titleField, constraints);

        // Add the year label and spinner to the panel
        constraints.gridx = 0;
        constraints.gridy = 1;
        add(yearLabel, constraints);

        constraints.gridx = 2;
        add(yearSpinner, constraints);

        // Add the rating label and field to the panel
        constraints.gridx = 0;
        constraints.gridy = 2;
        add(ratingLabel, constraints);

        constraints.gridx = 2;
        add(ratingField, constraints);

        // Add the submit button to the panel
        constraints.gridx = 0;
        constraints.gridy = 3;
        add(submitButton, constraints);

        // Create the JFrame and add the panel to it
        JFrame frame = new JFrame("Movie Information");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setIconImage(resizedIcon.getImage());
        frame.add(this);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}