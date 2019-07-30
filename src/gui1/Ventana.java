package gui1;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import main.ClienteChat;

public class Ventana {
    public Ventana() {
        Bentana();
    }
    private void Bentana(){
        JFrame frame = new JFrame("dou");
        
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(500, 500);
        
        JTextArea areadou = new JTextArea();
        areadou.setBounds(7,20,480,320);
        areadou.setEditable(false);
                
        JTextField txt = new JTextField();
        txt.setBounds(8,380,480,25);
        
        JButton btn1 = new JButton("Enviar");
        btn1.setBounds(115, 420, 100, 30);
        
        JButton btn2 = new JButton("Borrar");
        btn2.setBounds(250, 420, 100, 30); 
        
        JButton btn3 = new JButton("Salir");
        btn3.setBounds(385, 420, 100, 30);
        
        JCheckBox cb = new JCheckBox("Agregar texto al final");
        cb.setBounds(8, 350, 150, 20);
        cb.setSelected(true);
        
        ClienteChat c = new ClienteChat("192.168.61.11", "2000", areadou);
        c.conectar();
        
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (cb.isSelected()) {
                    c.EnviarMensaje("Urqui", txt.getText());                                  
                } else {
                    areadou.append(txt.getText());                                                          
                }
            }        
        });
        
        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int optionPane = JOptionPane.showConfirmDialog(null, "Esta seguro que desa salir?", "Cuidado", JOptionPane.YES_NO_CANCEL_OPTION);
                if (optionPane == JOptionPane.YES_OPTION) {
                    frame.setVisible(false);
                    Login l = new Login(new Usuario("Urqui", "1234"));                  
                }
            }
        });
    
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int optionPane = JOptionPane.showConfirmDialog(null, "Esta seguro que desa borrar?", "Cuidado", JOptionPane.YES_NO_CANCEL_OPTION);
                if (optionPane == JOptionPane.YES_OPTION) {
                    areadou.setText("");
                    txt.setText("");                
                }
            }
        });
                
        frame.add(cb);
        frame.add(btn1);
        frame.add(btn2);
        frame.add(btn3);
        frame.add(areadou);
        frame.add(txt);
        frame.setVisible(true);
    }
}
