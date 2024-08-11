module gs.apppuertocayosbd {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens gs.apppuertocayosbd to javafx.fxml;
    exports gs.apppuertocayosbd;
}
