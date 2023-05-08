import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLOutput;

public class Ventana extends JFrame {
    private JPanel panel1;
    private JButton botonpanel1;
    private JLabel etiqueta1;


    private JPanel panel2;
    private JLabel etiquetapanel2;


    private JPanel panel3;
    private JComboBox<String> comboBoxPanel3;
    private JPanel panel4;
    private GridLayout layout;

    public Ventana(String title) throws HeadlessException {
        super(title);
        this.setSize(800,600);
        layout = new GridLayout(2,2);
        this.getContentPane().setLayout(layout);
        //Panel1
        panel1 = new JPanel();
        panel1.setBackground(new Color(221,237,250));
        panel1.setLayout(new FlowLayout(FlowLayout.LEFT));
        botonpanel1 = new JButton("Presioname");
        panel1.add(botonpanel1);
        etiqueta1 = new JLabel("....");
        panel1.add(etiqueta1);
        botonpanel1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                etiqueta1.setText("Hola , presionaste el boton ");
            }
        });
        this.getContentPane().add(panel1,0);

        //Panel2
        String urlImagen = "https://static.motor.es/fotos-noticias/2020/03/que-coche-es-rayo-mcqueen-202066150-1585635516_1.jpg";
        panel2 = new JPanel();
        panel2.setBackground(new Color(250,224,221));
        panel2.setLayout( new FlowLayout());
        //cargar la iamgen de internet
        try {
            URL url = new URL(urlImagen);
            Image imagen = ImageIO.read(url);
            ImageIcon imageIcon = new ImageIcon(imagen);
            etiquetapanel2 = new JLabel(imageIcon);
            panel2.add(etiquetapanel2);
            this.getContentPane().add(panel2,1);
        }catch (MalformedURLException me){
            System.out.println("URL no valida");
        }catch (Exception e){
            System.out.println("Error al cargar la imagen ");
        }

        //Panel3
        panel3 = new JPanel();
        panel3.setBackground( new Color(231,221,250));
        this.getContentPane().add(panel3,2);

        //Panel4
        panel4 = new JPanel();
        panel4.setBackground( new Color(222,245,204));
        this.getContentPane().add(panel4,3);
        panel3.setLayout(new FlowLayout(FlowLayout.RIGHT));
        String [] elementos = {"Opcion 1","Opcion 2","Opcion 3","Opcion 4"};
        comboBoxPanel3 = new JComboBox<>(elementos);
        comboBoxPanel3.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println( e.getSource().toString());
                System.out.println(comboBoxPanel3.getSelectedIndex());
            }
        });
        panel3.add(comboBoxPanel3);

        this.setVisible(true);
    }
}
