package edu.lnu.util;


import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DaoUtils {
	//static  int i=1;
//	static {
//		System.out.println("类初次加载。。。。。。。。。。。。。。。。");
//	}
	private static DataSource source = new ComboPooledDataSource();
	private DaoUtils() {
	}
	
	public static DataSource getSource(){

		//System.out.println("iiiiiiiiiii"+i++);
		return source;
	}
	
	public static Connection getConn(){


		try {
			return source.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
