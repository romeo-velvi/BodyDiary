package database;
import java.sql.Date;
import java.sql.SQLException;

/* TO TRY ON TERMINAL THE VARIOUS UPDATE 
C:\Users\Velvi\eclipse-workspace\JFX4project1>ij
Versione ij 10.15
ij> CONNECT 'jdbc:derby:C:\Users\Velvi\eclipse-workspace\JFX4project1\newDBderby;';
ij> show tables;
*/

public class Main_db_sample {

	public static void _main(String[] args) throws SQLException{
		
		DBdao db = new DerbydbClass();
		
		/* connection */
		if (db.getConnection()==null) {
			System.out.println("Errore connessione DB");
			return;
		}
		
		/*FOR TEST CASE*/
		db.deleteAllTable();
		
		/* Check & create table UserData */
		db.createTables();
		
		/* REGISTRAZIONE */
		String 	name = "romeo";     
		String 	surname = "velvi";  
		String 	mail  = "rv@sdddd.it";     
		String 	password = "WAO"; 
		Date 	birt_date = Date.valueOf("2000-04-19");
		String 	gender = "male";   
		db.insertUserData(UserData.setInstance(name, surname, mail, password, birt_date, gender));
		// 2
		 name = "ale";     
		 surname = "etwrw";  
		 String mail1  = "a@a.i";     
		 String password1 = "a"; 
		 birt_date = Date.valueOf("1999-04-19");
		 gender = "female"; 
		 db.insertUserData(UserData.setInstance(name, surname, mail1, password1, birt_date, gender));
		
		
		/* CHECK IF USER EXIST */
		UserData ud = null;
		if (db.checkUser("rv@sdddd.it", "WAO")) {
			System.out.println("Utente esistene");
			ud = db.retreiveUserData(mail, password);
			UserData.setInstance(ud);
		}else {
			System.out.println("Login faild");
		}
		System.out.println("Utente "+ ud.getName()+ " Loggato");
		
		/* ADD USER MEASURE */
		Double weight	= 1.1	;    
		Double thighs		= 1.1	;	  
		Double chest	= 1.1	; 	  
		Double height	= 1.1	; 	  
		Double forearms	= 1.1	;  
		Double biceps	= 1.1	; 	  
		Double hips		= 1.1	;	  
		Double waistline = 1.1	; 
		Double calfs	 = 1.1	; 	  
		Measurement mm = new Measurement(mail, weight, thighs, chest, height, forearms, biceps, hips, waistline, calfs, Date.valueOf("2012-12-12"));
		db.insertUserMeasurement(mm);
		//2
		 weight	= 21.1	;    
		 thighs		= 21.1	;	  
		 chest	= 21.1	; 	  
		 height	= 21.1	; 	  
		 forearms	= 21.1	;  
		 biceps	= 21.1	; 	  
		 hips		= 21.1	;	  
		 waistline = 21.1	; 
		 calfs	 = 21.1	; 	  
		mm = new Measurement(mail, weight, thighs, chest, height, forearms, biceps, hips, waistline, calfs, Measurement.getCurrentTime());
		db.insertUserMeasurement(mm);
		
		/* RETREIVE ALL MEASUREMENT */
		Iterator it1 = db.retreiveMeasure(mail);
		Measurement mes;
		while (it1.hasNext()) {
			mes= (Measurement)it1.next();
			System.out.println(mes.toString());
		}
		
		/* RETREIVE LATEST MEASUREMENT */
		Measurement last = db.getLastMeasurement(mail);
		System.out.println("ULTIMO:"+ last.toString());
		
		/* ADD USER GOAL */
		String tipo = "weight";         
		Date data_immissione  = (Goal.getCurrentTime());
		Double value_atteso = 12.3;
		Goal g=new Goal(mail, tipo, Date.valueOf("2012-12-12"), value_atteso);
		db.insertUserGoal(g);
		// 2
		 tipo = "height";         
		 data_immissione  = (Goal.getCurrentTime());
		 value_atteso = 21.1;
		 g=new Goal(mail, tipo, data_immissione, value_atteso);
		 db.insertUserGoal(g);
		
		/* RETREIVE ALL GOALS */
		Iterator it2 = db.retreiveGoal(UserData.getInstance().getMail());
		Goal goa;
		while (it2.hasNext()) {
			goa= (Goal)it2.next();
			goa.updateGoal(last.getMeasureByType(goa.getTipo())); // PRIMA DELLA STAMPA ESEGUIRE L'UPDATE PER LO STATO
			System.out.println(goa.toString());
		}
		
		db.close_db();
		System.out.println("End program");
	}

	
	
	
}
