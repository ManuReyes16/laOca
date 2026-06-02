package org.JuegoOca;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class JuegoOcaView extends Application {

    // Instanciamos nuestro controlador (igual que hacía la profesora)
    private final JuegoOcaController controller = new JuegoOcaController();

    @Override
    public void start(Stage stage) {
        
        // 1. Título del juego
        Label titulo = new Label("EL JUEGO DE LA OCA");
        titulo.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");

        // 2. Creamos la cuadrícula para el tablero visual
        GridPane panelTablero = new GridPane();
        panelTablero.setHgap(10); // Espacio horizontal entre casillas
        panelTablero.setVgap(10); // Espacio vertical entre casillas
        panelTablero.setAlignment(Pos.CENTER);

        // 3. ¡EL BUCLE MÁGICO! Leemos del JSON a través del controlador
        int columnasMaximas = 8; // Queremos filas de 8 casillas
        int totalCasillas = controller.getNumeroCasillas();

        for (int i = 1; i <= totalCasillas; i++) {
            // Pedimos los datos de la casilla actual al controlador
            Casilla casillaDatos = controller.getCasilla(i);
            
            // Creamos un contenedor visual para ESTA casilla concreta (un cuadro texturizado)
            VBox cuadroCasilla = new VBox(5);
            cuadroCasilla.setAlignment(Pos.CENTER);
            cuadroCasilla.setPrefSize(70, 70); // Tamaño de cada casilla (ancho, alto)
            
            // Ponemos el número y el tipo de casilla dentro del cuadro
            Label lblNumero = new Label(String.valueOf(i));
            lblNumero.setStyle("-fx-font-weight: bold;");
            
            // Suponiendo que tu clase Casilla tiene un método para saber su tipo o nombre abreviado
            Label lblTipo = new Label(casillaDatos.getNombre()); 
            lblTipo.setStyle("-fx-font-size: 10px;");

            cuadroCasilla.getChildren().addAll(lblNumero, lblTipo);

            // 🎨 DISEÑO DINÁMICO REACCIONANDO AL JSON:
            // Dependiendo del tipo de casilla que venga en vuestro JSON, le pintamos un fondo diferente
            // Cambiamos a casillaDatos.getNombre()
            String nombreLower = casillaDatos.getNombre().toLowerCase();

            if (nombreLower.contains("oca")) {
                cuadroCasilla.setStyle("-fx-background-color: #81C784; -fx-border-color: #2E7D32; -fx-border-width: 2;"); // Verde Oca
            } else if (nombreLower.contains("muerte") || nombreLower.contains("calavera")) {
                cuadroCasilla.setStyle("-fx-background-color: #E57373; -fx-border-color: #C62828; -fx-border-width: 2;"); // Rojo Muerte
            } else if (nombreLower.contains("puente") || nombreLower.contains("posada") || nombreLower.contains("laberinto") || nombreLower.contains("cárcel")) {
                cuadroCasilla.setStyle("-fx-background-color: #64B5F6; -fx-border-color: #1565C0; -fx-border-width: 2;"); // Azul Especiales
            } else if (nombreLower.contains("meta") || nombreLower.contains("final")) {
                cuadroCasilla.setStyle("-fx-background-color: #FFD54F; -fx-border-color: #FF8F00; -fx-border-width: 2;"); // Dorado Meta
            } else {
                cuadroCasilla.setStyle("-fx-background-color: #F5F5F5; -fx-border-color: #BDBDBD; -fx-border-width: 1;"); // Gris Normal
            }

            // Calculamos en qué fila y columna del GridPane debe colocarse matemática mente
            int columna = (i - 1) % columnasMaximas;
            int fila = (i - 1) / columnasMaximas;

            // Añadimos el cuadro visual al panel en su posición correcta
            panelTablero.add(cuadroCasilla, columna, fila);
        }

        // 4. Panel raíz (VBox) que junta el título y el tablero
        VBox root = new VBox(20);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(20));
        root.getChildren().addAll(titulo, panelTablero);

        // 5. Crear la escena y mostrar la ventana (Modificamos el tamaño para que quepan las casillas)
        Scene scene = new Scene(root, 700, 600);
        
        stage.setTitle("Juego de la Oca - Alberto, Manuel y Nacho");
        stage.setScene(scene);
        stage.show();
    }
}