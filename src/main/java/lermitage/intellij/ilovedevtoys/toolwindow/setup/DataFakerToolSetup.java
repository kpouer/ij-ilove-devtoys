package lermitage.intellij.ilovedevtoys.toolwindow.setup;

import lermitage.intellij.ilovedevtoys.tools.DataFakerTools;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextArea;

public class DataFakerToolSetup {

    private final JComboBox<String> dataFakerGeneratorComboBox;
    private final JButton dataFakerGenerateButton;
    private final JComboBox<String> dataFakerLocaleComboBox;
    private final JTextArea dataFakerTextArea;

    public DataFakerToolSetup(JComboBox<String> dataFakerGeneratorComboBox,
                              JButton dataFakerGenerateButton,
                              JComboBox<String> dataFakerLocaleComboBox,
                              JTextArea dataFakerTextArea) {
        this.dataFakerGeneratorComboBox = dataFakerGeneratorComboBox;
        this.dataFakerGenerateButton = dataFakerGenerateButton;
        this.dataFakerLocaleComboBox = dataFakerLocaleComboBox;
        this.dataFakerTextArea = dataFakerTextArea;
    }

    public void setup() {
        DataFakerTools.FAKER_GENERATORS.forEach(dataFakerGeneratorComboBox::addItem);
        DataFakerTools.FAKER_LOCALES.forEach(dataFakerLocaleComboBox::addItem);

        dataFakerGenerateButton.addActionListener(e -> {
            dataFakerTextArea.setText(DataFakerTools.generateFakeData(
                (String) dataFakerGeneratorComboBox.getSelectedItem(),
                (String) dataFakerLocaleComboBox.getSelectedItem(),
                20
            ));
            dataFakerTextArea.setCaretPosition(0);
        });
    }
}
