package com.solar;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MainTest {

    private JTextField textField;
    private JLabel label;
    private JButton button;

    @BeforeEach
    public void setUp() {
        textField = new JTextField();
        label = new JLabel();
        button = new JButton();
    }

    @Test
    public void testTextField() {
        textField.setText("Test Text");
        assertEquals("Test Text", textField.getText());
    }

    @Test
    public void testLabel() {
        label.setText("Test Label");
        assertEquals("Test Label", label.getText());
    }

    @Test
    public void testButtonLabel() {
        button.setText("Test Button");
        assertEquals("Test Button", button.getText());
    }
}