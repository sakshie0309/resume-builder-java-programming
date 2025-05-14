import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.awt.Desktop;

public class ResumeBuilder extends Frame {
    private TextField nameField, phoneField, emailField, educationField, skillsField, languagesField, experienceField;

    public ResumeBuilder() {
        setTitle("Resume Builder");
        setSize(400, 400);
        setLayout(new GridLayout(8, 2));

        add(new Label("Name:"));
        nameField = new TextField();
        add(nameField);

        add(new Label("Phone:"));
        phoneField = new TextField();
        add(phoneField);

        add(new Label("Email:"));
        emailField = new TextField();
        add(emailField);

        add(new Label("Education:"));
        educationField = new TextField();
        add(educationField);

        add(new Label("Skills:"));
        skillsField = new TextField();
        add(skillsField);

        add(new Label("Languages Known:"));
        languagesField = new TextField();
        add(languagesField);

        add(new Label("Experience:"));
        experienceField = new TextField();
        add(experienceField);

        Button generateButton = new Button("Generate Resume");
        generateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                generateResume();
            }
        });

        add(generateButton);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        setVisible(true);
    }

    private void generateResume() {
        String name = nameField.getText();
        String phone = phoneField.getText();
        String email = emailField.getText();
        String education = educationField.getText();
        String skills = skillsField.getText();
        String languages = languagesField.getText();
        String experience = experienceField.getText();

        String htmlContent = "<html>\n" +
                "<head>\n" +
                "<meta charset=\"UTF-8\">\n" +
                "<title>" + name + "'s Resume</title>\n" +
                "<style>\n" +
                "body { font-family: Arial, sans-serif; background-color: #f2f2f2; padding: 20px; }\n" +
                ".a4-sheet { display: flex; border: 1px solid #ccc; box-shadow: 0 0 10px rgba(0,0,0,0.1); margin: 20px; }\n" +
                ".left-section { flex: 2; background-color: #92d036; color: #171616; padding: 20px; border: 3px solid #000; }\n" +
                ".right-section { flex: 3; background-color: #000000; color: #c2c1c1; padding: 20px; text-align: center; border: 3px solid #000; }\n" +
                "</style>\n" +
                "</head>\n" +
                "<body>\n" +
                "<div class=\"a4-sheet\">\n" +
                "  <div class=\"left-section\">\n" +
                "    <img src=\"https://upload.wikimedia.org/wikipedia/commons/thumb/f/f5/Circle-icons-flower.svg/768px-Circle-icons-flower.svg.png\" width=\"200px\" alt=\"\">\n" +
                "    <h2>" + name + "</h2>\n" +
                "    <p>Phone: " + phone + "</p>\n" +
                "    <p>Email: " + email + "</p>\n" +
                "  </div>\n" +
                "  <div class=\"right-section\">\n" +
                "    <h2>Skills</h2>\n" +
                "    <p>" + skills + "</p>\n" +
                "    <h2>Education</h2>\n" +
                "    <p>" + education + "</p>\n" +
                "    <h2>Languages Known</h2>\n" +
                "    <p>" + languages + "</p>\n" +
                "    <h2>Experience</h2>\n" +
                "    <p>" + experience + "</p>\n" +
                "  </div>\n" +
                "</div>\n" +
                "</body>\n" +
                "</html>";

        try {
            File htmlFile = new File("resume.html");
            FileWriter writer = new FileWriter(htmlFile);
            writer.write(htmlContent);
            writer.close();

            System.out.println("Resume generated successfully. Opening 'resume.html'...");
            Desktop.getDesktop().browse(htmlFile.toURI());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new ResumeBuilder();
    }
}
