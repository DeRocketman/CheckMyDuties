package de.rocketman.view;

import de.rocketman.MainApp;
import de.rocketman.domain.Duty;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class CompareViewController {

    @FXML
    private TableView<Duty> dutyTable;
    @FXML
    private TableColumn<Duty, String> dutyNameColumn;
    @FXML
    private TableColumn<Duty, String> dutyBeginColumn;
    @FXML
    private TableColumn<Duty, String> dutyEndColumn;
    @FXML
    private TableColumn<Duty, String> dutyBreakColumn;
    @FXML
    private TableColumn<Duty, String> dutyPayedTimeColumn;
    @FXML
    private TableColumn<Duty, String> dutyDurationColumn;
    @FXML
    private TableColumn<Duty, String> dutyCompareSolutionColumn;

    private MainApp mainApp;

}
