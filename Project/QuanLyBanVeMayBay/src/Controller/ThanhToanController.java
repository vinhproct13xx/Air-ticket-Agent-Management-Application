/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author hoangdang
 */
public class ThanhToanController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private JFXTextField HoTenLienHe;
    @FXML
    private JFXTextField DienThoai;
    @FXML
    private JFXTextField Email;
    @FXML
    private JFXTextField Diachi;
    @FXML
    private JFXTextField HoTenKhachHang;
    @FXML
    private JFXDatePicker NgaySinh;
    @FXML
    private JFXTextField QuocTich;
    @FXML
    private Label DiemDi;
    @FXML
    private Label DiemDen;
    @FXML
    private Label ThoiDiemXuatPhat;
    @FXML
    private Label HangBay;
    @FXML
    private Label LoaiGhe;
    @FXML
    private Label GioBay;
    @FXML
    private Label GioDen;
    @FXML
    private Label ThoiGianBay;
    @FXML
    private Label LoaiDuongBay;
    @FXML
    private Label TongTien;
    @FXML
    private JFXButton ThanhToan;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    public void ThanhToan(ActionEvent event){
        String khachhang = this.HoTenLienHe.getText();
        double tongtien = 2500000;
        
        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        alert.setContentText("ten khach hang: "+khachhang+"\n"+"tong tien phai thanh toan: "+tongtien);
        alert.show();
    }
}
