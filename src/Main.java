import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Main {
    static JFrame frame = new JFrame();
    static int width = 500, height = 500;
    static JPanel panel = new JPanel();

    public static void changeCursor(MouseEvent e){ // Метод изменения курсора
        panel.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }
    public static void defaultCursor(MouseEvent e){ // Метод возврата курсора к default
        panel.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }

    public static void main(String[] args) {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Изменения курсора мыши");
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setBounds(dim.width / 2 - width / 2, dim.height / 2 - height / 2, width, height);
        panel.setFocusable(true); // Делаем у панели возможность принимать фокус, иначе она не сможет отловить события клавиатуры
        frame.add(panel);
        panel.addMouseListener(new MouseAdapter() { // Добавляем слушателя мыши на панель
            public void mouseEntered(MouseEvent e) { // Если мышь зашла на панель, то меняем курсор
                changeCursor(e);
            }
            public void mouseExited(MouseEvent e) { // Если мышь вышла с панели, то курсор делаем default
                defaultCursor(e);
            }
        });
        frame.setVisible(true);
    }
}