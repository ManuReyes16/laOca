package org.JuegoOca;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;

public class JuegoOcaView extends Application {

    private final JuegoOcaController controller = new JuegoOcaController();

    private Tablero tablero;
    private DadoC dado;
    private ArrayList<Jugador> jugadores;
    private int turnoActual;

    private Label lblTurno;
    private Label lblResultadoDado;
    private TextArea historial;
    private VBox panelJugadores;

    @Override
    public void start(Stage stage) {

        tablero = new Tablero();
        dado = new DadoC();
        jugadores = new ArrayList<>();
        turnoActual = 0;

        Jugador manuel = new Jugador("Manuel");
        Jugador alberto = new Jugador("Alberto");
        Jugador nacho = new Jugador("Nacho");

        jugadores.add(manuel);
        jugadores.add(alberto);
        jugadores.add(nacho);

        Label titulo = new Label("EL JUEGO DE LA OCA");
        titulo.setStyle("-fx-font-size: 26px; -fx-font-weight: bold;");

        GridPane panelTablero = crearPanelTablero();

        lblTurno = new Label();
        lblTurno.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        lblResultadoDado = new Label("Dado: -");
        lblResultadoDado.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        panelJugadores = new VBox(10);
        panelJugadores.setPadding(new Insets(10));
        panelJugadores.setStyle("-fx-border-color: #999999; -fx-border-width: 1;");

        Button btnTirar = new Button("Tirar dado");
        btnTirar.setStyle("-fx-font-size: 16px; -fx-background-color: #4CAF50; -fx-text-fill: white;");
        btnTirar.setOnAction(e -> jugarTurno());

        historial = new TextArea();
        historial.setEditable(false);
        historial.setPrefRowCount(8);

        VBox panelDerecho = new VBox(15);
        panelDerecho.setPadding(new Insets(15));
        panelDerecho.setPrefWidth(250);
        panelDerecho.getChildren().addAll(lblTurno, lblResultadoDado, panelJugadores, btnTirar);

        VBox zonaSuperior = new VBox(10);
        zonaSuperior.setAlignment(Pos.CENTER);
        zonaSuperior.setPadding(new Insets(15));
        zonaSuperior.getChildren().add(titulo);

        VBox zonaInferior = new VBox(10);
        zonaInferior.setPadding(new Insets(10));
        zonaInferior.getChildren().addAll(new Label("Historial de partida:"), historial);

        BorderPane root = new BorderPane();
        root.setTop(zonaSuperior);
        root.setCenter(panelTablero);
        root.setRight(panelDerecho);
        root.setBottom(zonaInferior);

        actualizarPanelJugadores();
        actualizarTurno();

        Scene scene = new Scene(root, 1000, 750);
        stage.setTitle("Juego de la Oca - Alberto, Manuel y Nacho");
        stage.setScene(scene);
        stage.show();
    }

    private GridPane crearPanelTablero() {

        GridPane panelTablero = new GridPane();
        panelTablero.setHgap(10);
        panelTablero.setVgap(10);
        panelTablero.setAlignment(Pos.CENTER);
        panelTablero.setPadding(new Insets(20));

        int columnasMaximas = 8;
        int totalCasillas = controller.getNumeroCasillas();

        for (int i = 1; i <= totalCasillas; i++) {

            Casilla casillaDatos = controller.getCasilla(i);

            VBox cuadroCasilla = new VBox(5);
            cuadroCasilla.setAlignment(Pos.CENTER);
            cuadroCasilla.setPrefSize(70, 70);

            Label lblNumero = new Label(String.valueOf(i));
            lblNumero.setStyle("-fx-font-weight: bold;");

            Label lblTipo = new Label(casillaDatos.getNombre());
            lblTipo.setStyle("-fx-font-size: 10px;");

            cuadroCasilla.getChildren().addAll(lblNumero, lblTipo);

            String nombreLower = casillaDatos.getNombre().toLowerCase();

            if (nombreLower.contains("oca")) {
                cuadroCasilla.setStyle("-fx-background-color: #81C784; -fx-border-color: #2E7D32; -fx-border-width: 2;");
            } else if (nombreLower.contains("muerte") || nombreLower.contains("calavera")) {
                cuadroCasilla.setStyle("-fx-background-color: #E57373; -fx-border-color: #C62828; -fx-border-width: 2;");
            } else if (nombreLower.contains("puente") || nombreLower.contains("posada") || nombreLower.contains("laberinto")) {
                cuadroCasilla.setStyle("-fx-background-color: #64B5F6; -fx-border-color: #1565C0; -fx-border-width: 2;");
            } else if (nombreLower.contains("meta") || nombreLower.contains("final")) {
                cuadroCasilla.setStyle("-fx-background-color: #FFD54F; -fx-border-color: #FF8F00; -fx-border-width: 2;");
            } else if (nombreLower.contains("dado")) {
                cuadroCasilla.setStyle("-fx-background-color: #CE93D8; -fx-border-color: #6A1B9A; -fx-border-width: 2;");
            } else {
                cuadroCasilla.setStyle("-fx-background-color: #F5F5F5; -fx-border-color: #BDBDBD; -fx-border-width: 1;");
            }

            int columna = (i - 1) % columnasMaximas;
            int fila = (i - 1) / columnasMaximas;

            panelTablero.add(cuadroCasilla, columna, fila);
        }

        return panelTablero;
    }

    private void jugarTurno() {

        Jugador jugador = jugadores.get(turnoActual);

        if (jugador.getTurnosPerdidos() > 0) {
            historial.appendText(jugador.getNombre() + " pierde este turno.\n");
            jugador.restarTurnoPerdido();
            pasarTurno();
            return;
        }

        ejecutarTurno(jugador);

        actualizarPanelJugadores();

        if (jugador.getPosicionActual() == tablero.getNumCasillas()) {
            historial.appendText("\n¡¡¡ " + jugador.getNombre() + " ha ganado la partida !!!\n");
            lblTurno.setText("Ganador: " + jugador.getNombre());
            return;
        }

        if (!jugador.getPuedeRepetirTurno()) {
            pasarTurno();
        } else {
            historial.appendText(jugador.getNombre() + " repite turno.\n");
        }

        actualizarPanelJugadores();
        actualizarTurno();
    }

    private void ejecutarTurno(Jugador jugador) {

        jugador.setPuedeRepetirTurno(false);

        int tirada = dado.lanzar();
        lblResultadoDado.setText("Dado: " + tirada);

        historial.appendText("\nTurno de " + jugador.getNombre() + "\n");
        historial.appendText("Posición inicial: " + jugador.getPosicionActual() + "\n");
        historial.appendText(jugador.getNombre() + " ha sacado un " + tirada + "\n");

        int nuevaPosicion = jugador.getPosicionActual() + tirada;

        if (nuevaPosicion > tablero.getNumCasillas()) {
            int exceso = nuevaPosicion - tablero.getNumCasillas();
            nuevaPosicion = tablero.getNumCasillas() - exceso;

            historial.appendText("Se ha pasado de la meta. Rebota hasta la casilla " + nuevaPosicion + "\n");
        }

        jugador.setPosicionActual(nuevaPosicion);

        historial.appendText(jugador.getNombre() + " cae en la casilla " + jugador.getPosicionActual() + "\n");

        Casilla casillaActual = tablero.getCasilla(jugador.getPosicionActual());

        if (casillaActual != null) {
            casillaActual.aplicarEfecto(jugador);
            historial.appendText("Efecto aplicado: " + casillaActual.getNombre() + "\n");
        } else {
            historial.appendText("Error: no existe la casilla " + jugador.getPosicionActual() + "\n");
        }

        historial.appendText(jugador.getNombre() + " termina en la casilla " + jugador.getPosicionActual() + "\n");
    }

    private void pasarTurno() {
        turnoActual++;

        if (turnoActual >= jugadores.size()) {
            turnoActual = 0;
        }
    }

    private void actualizarTurno() {
        Jugador jugador = jugadores.get(turnoActual);
        lblTurno.setText("Turno actual: " + jugador.getNombre());
    }

    private void actualizarPanelJugadores() {

        panelJugadores.getChildren().clear();

        Label tituloJugadores = new Label("Jugadores");
        tituloJugadores.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");
        panelJugadores.getChildren().add(tituloJugadores);

        for (Jugador jugador : jugadores) {
            Label label = new Label(jugador.getNombre() + " - Casilla " + jugador.getPosicionActual());
            panelJugadores.getChildren().add(label);
        }
    }
}