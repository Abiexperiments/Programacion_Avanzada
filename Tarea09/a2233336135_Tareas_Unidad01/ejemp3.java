package a2233336135_Tareas_Unidad01;
import javax.swing.*;
import java.awt.*;

public class ejemp3 extends JFrame {

    public ejemp3() {
        setTitle("Movies");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 400);
        setLayout(new BorderLayout());

        // Panel para el título
        JPanel pnlTitulo = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lblTitulo = new JLabel("Movies");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 24));
        pnlTitulo.add(lblTitulo);
        add(pnlTitulo, BorderLayout.NORTH);

        // Panel para la lista de películas
        JPanel pnlLista = new JPanel(new GridLayout(0, 1, 5, 5)); // GridLayout para la lista
        String[] peliculas = {
            "Back to the Future", "The Goonies", "Top Gun", "Ferris Bueller's Day Off",
            "Die Hard", "Rain Man", "Indiana Jones and the Last Crusade", "Batman",
            "Home Alone", "Pretty Woman", "Terminator 2: Judgment Day",
            "The Silence of the Lambs", "Aladdin", "Reservoir Dogs", "Jurassic Park",
            "Schindler's List", "Forrest Gump", "The Lion King", "Pulp Fiction",
            "The Shawshank Redemption", "Toy Story", "Braveheart"
        };
        for (String pelicula : peliculas) {
            JLabel lblPelicula = new JLabel(pelicula);
            lblPelicula.setFont(new Font("Arial", Font.PLAIN, 16));
            pnlLista.add(lblPelicula);
        }

        // Scroll para la lista (en caso de que no quepan todas las películas)
        JScrollPane scrollPane = new JScrollPane(pnlLista);
        add(scrollPane, BorderLayout.CENTER);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ejemp3());
    }
}