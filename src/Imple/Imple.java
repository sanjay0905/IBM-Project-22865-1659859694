package Imple;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



import Bean.cidbean;
import Bean.managebean;
import Bean.sregbean;
import Bean.taskbean;
import Bean.tlfilebean;
import Bean.tlregbean;
import Dbconn.dbconn;
import Inter.Inter;

public class Imple implements Inter {

	Connection con;
	@Override
	public int sreg(sregbean sb) {
int reg=0;
		
		con=dbconn.create();
		
		try {
 			
				PreparedStatement ps=con.prepareStatement("INSERT INTO `cricket`.userreg VALUES(id,?,?,?,?,?,?,?,?)");
				ps.setString(1, sb.getName());
				ps.setString(2, sb.getEmail());
				ps.setString(3, sb.getMobile());
				ps.setString(4, sb.getPassword());
				ps.setString(5, sb.getCpassword());
				ps.setString(6, sb.getImage());
				ps.setLong(7, sb.getTeam());
				ps.setString(8, "request");
				reg=ps.executeUpdate();

} catch (SQLException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}
return reg;

}
	@Override
	public boolean slog(sregbean sl) {
		boolean log=false;
		 
		con=dbconn.create();
		
		 try {
				PreparedStatement ps=con.prepareStatement("SELECT * FROM `cricket`.`userreg` where upi=? and cpassword=? and status='approved'");
				
				ps.setString(1, sl.getEmail());
				ps.setString(2, sl.getPassword());
				System.out.println("succees");
				ResultSet rs=ps.executeQuery();
				log=rs.next();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return log;

	}
	
	
	public int adet(cidbean ck) {
		// TODO Auto-generated method stub
		int reg=0;
		 
		 con=dbconn.create();
		 
		 		try {
		 			
		 			PreparedStatement ps=con.prepareStatement("INSERT INTO `cricket`.`criminaldetails` VALUES(id,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		 			ps.setString(1,ck.getName());
		 			ps.setString(2,ck.getDate());
		 			ps.setString(3,ck.getAge());
		 			ps.setString(4,ck.getHeight());
		 			ps.setString(5,ck.getWeight());
		 			ps.setString(6,ck.getGender());
		 			ps.setString(7,ck.getZone());
		 			ps.setString(8,ck.getCaseno());
		 			ps.setString(9,ck.getSection());
		 			ps.setString(10,ck.getCasedetails());
		 			ps.setString(11, ck.getFilename());
		 			ps.setString(12, ck.getFilesize());
		 			ps.setString(13, ck.getFiletype());
		 			ps.setString(14, ck.getFilecontent());
		 			ps.setString(15, ck.getEncrypt());
		 			ps.setString(16, ck.getDecrypt());
		 			ps.setString(17, "Upload");
		 			ps.setString(18, ck.getAadhar());
		 			ps.setString(19, ck.getLicense());
		 			reg=ps.executeUpdate();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 		
		return reg;
		
		
	}
}
