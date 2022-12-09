module co.edu.cue.proyectofinalcorte3 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens co.edu.cue.proyectofinalcorte3 to javafx.fxml;
    exports co.edu.cue.proyectofinalcorte3;
}