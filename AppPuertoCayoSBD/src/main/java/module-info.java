module gs.apppuertocayosbd {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires java.sql;

    opens gs.apppuertocayosbd to javafx.base, javafx.fxml;
    
    opens Proyectito to javafx.base, javafx.fxml;
    
    exports Proyectito;
    
    exports gs.apppuertocayosbd;
}
