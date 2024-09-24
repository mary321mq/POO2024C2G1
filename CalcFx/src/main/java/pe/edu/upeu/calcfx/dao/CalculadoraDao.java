package pe.edu.upeu.calcfx.dao;

import pe.edu.upeu.calcfx.conexion.ConnDB;
import pe.edu.upeu.calcfx.modelo.CalcTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CalculadoraDao {
    PreparedStatement ps;
    ResultSet rs;
    ConnDB con;
    Connection conn;

    CalculadoraDao(){
        con = new ConnDB();
        conn= con.getConn();
    }

    public List<CalcTO> listar(){
        List<CalcTO> listC = new ArrayList<>();
        try {
            ps=conn.prepareStatement("SELECT * from calculadora;");
            rs=ps.executeQuery();
            while(rs.next()){
                CalcTO calcTO = new CalcTO();
                calcTO.setNum1(rs.getString("num1"));
                calcTO.setNum2(rs.getString("num2"));
                calcTO.setOperador(rs.getString("operador").charAt(0));
                calcTO.setResultado(rs.getString("resultado"));
                listC.add(calcTO);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return listC;
    }


}
