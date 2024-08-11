module gs.apppuertocayosbd {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires java.sql;

    opens gs.apppuertocayosbd to javafx.fxml;
    exports gs.apppuertocayosbd;
}
