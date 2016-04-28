import java.sql.SQLException;

import models.HomeViewModel;

public class prova {

	public static void main(String[] args) {
		
		try {
			HomeViewModel hvm=new HomeViewModel();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("failed to create HomeViewModel");
		}
		

	}

}
