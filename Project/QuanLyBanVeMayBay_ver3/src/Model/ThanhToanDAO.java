/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author hoangdang
 */
public class ThanhToanDAO {
    public void LuuThongTinVeVoDB(ThanhToan tt)throws SQLException{

            String sql = "insert into ChiTietChuyenBay(MaVe,MaCB,TenHK,LoaiHK,Gia) values("+tt.getMaVeString()+","+tt.getMaCBString()+","+"'"+tt.getKhachhangString()+"'"+","+tt.getLoaiVeInt()+","+tt.getTienve()+")";
            System.out.println("Model.ThanhToanDAO.LuuThongTinVeVoDB()"+sql);
            try{
            ResultSet rs;
            rs = DBConnect.dbExcute(sql);
            }catch (SQLException e){
                System.err.println("Can't insert ticket!");
            }
    }
    
}
