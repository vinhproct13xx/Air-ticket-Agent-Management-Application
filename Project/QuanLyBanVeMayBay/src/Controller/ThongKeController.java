/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;

/**
 * FXML Controller class
 *
 * @author win10pro
 */
public class ThongKeController implements Initializable {

    @FXML
    private BarChart<?, ?> bcDanhThu;
    @FXML
    private NumberAxis y;
    @FXML
    private CategoryAxis x;
    @FXML
    private BarChart<?, ?> bcHK;
    @FXML
    private NumberAxis xChiPhiTB;
    @FXML
    private CategoryAxis yChiPhiTB;
    @FXML
    private BarChart<?, ?> bcHKTB;
    @FXML
    private NumberAxis yHS;
    @FXML
    private CategoryAxis xHS;
    @FXML
    private BarChart<?, ?> bcCB;
    @FXML
    private NumberAxis yCD;
    @FXML
    private CategoryAxis xCD;
    @FXML
    private JFXButton btnXem;
    @FXML
    private JFXComboBox<?> cboNam;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void btnXemClick(ActionEvent event) {
    }
    
}
