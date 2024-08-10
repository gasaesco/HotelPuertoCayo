module gs.apppuertocayosbd {
    requires javafx.controls;
    requires javafx.fxml;

    opens gs.apppuertocayosbd to javafx.fxml;
    exports gs.apppuertocayosbd;
}
