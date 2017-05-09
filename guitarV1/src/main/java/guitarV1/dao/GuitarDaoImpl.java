package guitarV1.dao;

import guitarV1.dbutil.DbUtil;
import guitarV1.entity.Guitar;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GuitarDaoImpl implements GuitarDao{
	@Override
	public boolean add(Guitar guitar) {
		// TODO Auto-generated method stub
		return DbUtil.executeUpdate("insert into guitar values(?,?,?,?,?,?,?)", new Object[]{guitar.getSerialNumber(),guitar.getPrice(),guitar.getBuilder(),guitar.getModel(),guitar.getType(),guitar.getBackWood(),guitar.getTopWood()});		
	}
	@Override
	public List<Guitar> getAll(double price, String serialNumber, String builder, String model, String type,
			String backWood, String topWood) {
		// TODO Auto-generated method stub
		String strsql= "select * from guitar where 1 = 1 ";
		if(type.length() > 0){
			strsql+=String.format("and type='"+type+"'");
		}
		if(backWood.length() > 0){
			strsql+=String.format("and backWood='"+backWood+"'");
		}
		if(model.length() > 0){
			strsql+=String.format("and model='"+model+"'");
		}
		if(price!=0){
			strsql+=String.format("and price='"+price+"'");
	   }
		if(serialNumber.length() > 0){
			strsql+=String.format("and serialNumber='"+serialNumber+"'");
	   }	
		if(topWood.length() > 0){
			strsql+=String.format("and topWood='"+topWood+"'");
       }	
	    if(type.length() > 0){
	    	strsql+=String.format("and type='"+type+"'");
       }
		List<Guitar> guitarList=new ArrayList<Guitar>();
		Guitar guitar=null;
		try{
			ResultSet rs= DbUtil.executeQuery(strsql, new Object[]{});
			while(rs.next()){
				guitar=new Guitar();
				guitar.setSerialNumber(rs.getString(1));
				guitar.setPrice(rs.getDouble(2));
				guitar.setBuilder(rs.getString(3));
				guitar.setModel(rs.getString(4));
				guitar.setType(rs.getString(5));
				guitar.setBackWood(rs.getString(6));
				guitar.setTopWood(rs.getString(7));
				guitarList.add(guitar);
			}					
		}catch(SQLException e){
			e.printStackTrace();
		}
		return guitarList;
}
}