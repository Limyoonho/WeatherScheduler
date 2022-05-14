package Server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class MyDatabase { //�����ͺ��̽� ��ſ�
	
	String url = "jdbc:mysql://localhost:3306/weather?useSSL=false&useUnicode=true&characterEncoding=euckr"; //������ ���̽� �ּ�
	String rootId = "root"; //��Ʈ id
	String rootPw = "dladbsgh1@"; //��Ʈ pw
	Connection con; //�����ͺ��̽� ��ſ�
	Statement stmt; //�����ͺ��̽� ��� �����
	
	public MyDatabase() { //���� �� �ʱ�ȭ
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch(java.lang.ClassNotFoundException e) {
			e.printStackTrace();
			return;
		} 
		try {
			con = DriverManager.getConnection(url, rootId, rootPw); //������ ���̽� �α���
			stmt = con.createStatement();
		} catch (SQLException e) {		
			e.printStackTrace();
		}
	}
	
	public LinkedHashMap<String, List<String>> getAreaInfo() { //��ü ������� ���
		LinkedHashMap<String, List<String>> areaList = new LinkedHashMap<String, List<String>>(); //hashmap�� ����, list�� �� ������ ���׵�
		try {
			ResultSet result = stmt.executeQuery("SELECT distinct city FROM area"); //���ø�� ���
			if(!result.next()) return null; 
			do { //������ ���� �̸��� areaList�� Ű�μ� ����
				String cityName = result.getString("city");
				areaList.put(cityName, new ArrayList<String>()); //���� ���� ����Ʈ�� �������
			}while(result.next());
			
			for(String cityName : areaList.keySet()) { //�� �����̸����� ���׸� ��ȸ�� ����
				List<String> townList = areaList.get(cityName); //�����̸�
				ResultSet rs = stmt.executeQuery("SELECT town FROM area where city = '"+cityName+"'"); //���׸�� ��� 
				while(rs.next()) {
					townList.add(rs.getString("town")); //�ش� ������ ���� ����Ʈ�� �ֱ�
				}
			}
			
		} catch (SQLException e) {		
			e.printStackTrace();
		}
		
		return areaList.size() == 0 ? null : areaList; //areaList�� ��������� null ��ȯ
	}
	
	public String[] getPos(String cityName, String townName) { //Ư�� �������� �̿��Ͽ� �ش� ������ ������ǥ ���
		String pos[] = null; //��ȯ���� 2���� �ʿ��ϹǷ� �迭�� ����
		try {
			ResultSet result = stmt.executeQuery("SELECT nx, ny FROM area where city = '"+cityName + "' and town = '"+townName+"'");
			//���ø�� ���׸����� ������ǥ ���
			if(!result.next()) return null; 
			pos = new String[2]; //x,y ��ǥ ����
			pos[0] = result.getString("nx");
			pos[1] = result.getString("ny");
			if(pos[0] == null || pos[1] == null) return null; //���� �ϳ��� �� �̻��ϸ� null
		} catch (SQLException e) {		
			e.printStackTrace();
		}
		return pos; //��ǥ ��ȯ
	}
	
}
