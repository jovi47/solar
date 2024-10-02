package com.solar;

import javax.swing.*;
import net.miginfocom.swing.MigLayout;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Configurações da janela principal
        JFrame frame = new JFrame("Teste JGoodies e MigLayout");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);

        // Painel principal usando MigLayout
        JPanel panel = new JPanel(new MigLayout("wrap 2", "[grow][grow]", "[]10[]"));

        // Adicionando componentes ao painel
        panel.add(new JLabel("Nome:"), "cell 0 0, align right");
        panel.add(new JTextField(20), "cell 1 0, growx");

        panel.add(new JLabel("Email:"), "cell 0 1, align right");
        panel.add(new JTextField(20), "cell 1 1, growx");

        panel.add(new JButton("Enviar"), "cell 0 2 2 1, align center");

        // Adicionando o painel ao frame
        frame.add(panel);
        frame.setVisible(true);
    }
}