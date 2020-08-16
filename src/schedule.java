import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;


public class schedule {
        Connection conn;
	ArrayList<Program> programW = new ArrayList<Program>();
	ArrayList<Program> program = new ArrayList<Program>();
        JTextArea textArea;
        
        schedule(JTextArea textArea){
            this.textArea = textArea;
        }
	
	void setProgram() {
		Channel_ad.setA();
                ResultSet rs = null;
		try {
                    conn = databaseConnection.connection();
                    Statement stmt = conn.createStatement();
                    rs = stmt.executeQuery("SELECT id,program_name,start_time,duration,category,apm FROM program WHERE day=3 OR day=1  ORDER BY hour");
                    Statement stmt2 = conn.createStatement();
                    ResultSet rs2 = stmt2.executeQuery("SELECT id,program_name,start_time,duration,category,apm FROM program WHERE (day=3 OR day=1) and (hour BETWEEN 13 and 17.9)  ORDER BY hour");
                    if(rs2.next()==false) {
                        System.out.println("No such program present in database.");
                    }
                    else{
			 do{
                            double h = Timer.convert(rs2.getString(3),rs2.getString(6));
                            Program p = new Program(rs2.getString(2),rs2.getString(3),h,rs2.getInt(4),rs2.getString(5),"AM");
                            p.setAd();
                            program.add(p);
			}while(rs2.next());	
                    }
                   if(rs.next()==false) {
                        System.out.println("No such program present in database.");
                    }
                    else{
			 do{
                            double h = Timer.convert(rs.getString(3),rs.getString(6));
                            Program p = new Program(rs.getString(2),rs.getString(3),h,rs.getInt(4),rs.getString(5),rs.getString(6));
                            p.setAd();
                            program.add(p);
			}while(rs.next());	
                    }
		}catch(Exception e) {
                    e.printStackTrace();
		}
//                System.out.println("\n\n\n");
//                textArea.setText(textArea.getText()+"\n\n\n\n");
//		System.out.println("Week days program schedule");
                textArea.setText(textArea.getText()+"\n"+"Week days program schedule");
//		System.out.println("program name               |Start time        |Duration          ");
                textArea.setText(textArea.getText()+"\n"+"program name                                |Start time                                   |Duration          ");
//		System.out.println("---------------------------+------------------+-------------------");
                textArea.setText(textArea.getText()+"\n"+"--------------------------------------------+--------------------------------------+-------------------");
                
		for(int i = 0;i < program.size() ;i++)
		{
                    try {
//                        System.out.println(String.format("%-27s|%-18s|%-5d min",program.get(i).name ,program.get(i).start_time,program.get(i).duration));
                        textArea.setText(textArea.getText()+"\n"+String.format("%-47s|%-49s|%-5d min",program.get(i).name ,program.get(i).start_time+" "+program.get(i).apm,program.get(i).duration));
//                        textArea.setText(textArea.getText()+"\n"+String.format("%-5d|%-31s|%-17s|%-9d|%-20s",rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5)));
                        program.get(i).getAd(program.get(i).duration,textArea);
                    } catch (Exception ex) {
                        Logger.getLogger(schedule.class.getName()).log(Level.SEVERE, null, ex);
                    }
		}
		
		
		
		try {
                    Statement stmt1 = conn.createStatement();
                    ResultSet rs1 = stmt1.executeQuery("SELECT id,program_name,start_time,duration,category,apm FROM program WHERE day=2 OR day=3 ORDER BY hour");
                    Statement stmt3 = conn.createStatement();
                    ResultSet rs3 = stmt3.executeQuery("SELECT id,program_name,start_time,duration,category,apm FROM program WHERE day=2 OR day=3 ORDER BY hour");
                    if(rs3.next()==false) {
                        System.out.println("No such program present in database.");
                    }
                    else{
			do{
                            double h = Timer.convert(rs3.getString(3),rs3.getString(6));
                            Program p = new Program(rs3.getString(2),rs3.getString(3),h,rs3.getInt(4),rs3.getString(5),"AM");
                            p.setAd();
                            programW.add(p);
                        }while(rs3.next());
				
                    }
                    
                    if(rs1.next()==false) {
                        System.out.println("No such program present in database.");
                    }
                    else{
			do{
                            double h = Timer.convert(rs1.getString(3),rs1.getString(6));
                            Program p = new Program(rs1.getString(2),rs1.getString(3),h,rs1.getInt(4),rs1.getString(5),rs1.getString(6));
                            p.setAd();
                            programW.add(p);
                        }while(rs1.next());
				
                    }
		}catch(Exception e) {
			e.printStackTrace();
		}

                
//                System.out.println("\n\n\n");
                textArea.setText(textArea.getText()+"\n\n\n\n");
//		System.out.println("Week end program schedule");
                textArea.setText(textArea.getText()+"\n"+"Week end program schedule");
//		System.out.println("program name               |Start time        |Duration          ");
                textArea.setText(textArea.getText()+"\n"+"program name                                |Start time                                   |Duration          ");
//		System.out.println("---------------------------+------------------+-------------------");
                textArea.setText(textArea.getText()+"\n"+"--------------------------------------------+--------------------------------------+-------------------");
 
                for(int i = 0;i < programW.size() ;i++)
		{
//			System.out.println(String.format("%-27s|%-18s|%-5d min",programW.get(i).name ,programW.get(i).start_time,programW.get(i).duration));
			textArea.setText(textArea.getText()+"\n"+String.format("%-47s|%-4s %-4s|%-5d min",programW.get(i).name ,programW.get(i).start_time,programW.get(i).apm,programW.get(i).duration));
                        programW.get(i).getAd(programW.get(i).duration,textArea);
		}
		
		
	}
}
