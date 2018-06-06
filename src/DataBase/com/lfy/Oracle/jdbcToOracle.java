package DataBase.com.lfy.Oracle;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

/**
 * ���⣺���ô洢����
     JDBC���ô洢����: CallableStatement
	  ��Java������ô洢���̣�д�������൱�Ĺ̶���
	 Class.forName(....
	 Connection conn = DriverManager.getConnection(....
	 p��Ҫ���õĴ洢���̵����֣��洢���̵�4����������4������ռλ������
	  ����ط�д���̶�
	 CallableStatement cstmt = conn.prepareCall("{call p(?,?,?,?)}");
 *	 
 * @author lfy
 * @since 2018/06/06
 * */
public class jdbcToOracle {

	static final String DB_USER="scott";
    static final String DB_PWD="scott";
    static final String ORCL_URL="jdbc:oracle:thin:@localhost:1521/orcl";
    
    private static Connection con=null;
//    private PreparedStatement pre=null;
    
    public Connection getConnection(){
    	try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			try {
				con=DriverManager.getConnection(ORCL_URL,DB_USER,DB_PWD);
//				String sql="";
//	            pre=con.prepareStatement(sql);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
    	return con;
    }
    
    public void executeProcedure(String ProcedureName,String[] params){
    	
    	try {
    		/**
    		*ProcedureName��Ҫ���õĴ洢���̵����֣��洢���̵�4����������4������ռλ������
    		*/
			CallableStatement cstmt = con.prepareCall("{call "+ProcedureName+"(?,?,?,?)}");
			/**
			*����JDBC����Щ��������Щ��������������������������java.sql.Types��ָ��
			*�������˼�ǣ���3�����͵�4���������������������INTEGER��
			*Types�������дʲô���ͣ��ÿ���Ĵ洢���̲�����ô�����
			*/
			cstmt.registerOutParameter(3, Types.INTEGER);
			cstmt.registerOutParameter(4, Types.INTEGER);
			/**
			*���������1�����͵�2�����������������3���������������4�������������
			*�������������ǵ�ֵ,��һ����Ϊ3���ڶ�����Ϊ4����4������Ϊ5
			*û���3������Ϊ�����������
			*/
			cstmt.setInt(1, 3);
			cstmt.setInt(2, 12);
			cstmt.setInt(4, 5);
			//ִ��
			cstmt.execute();
			//�ѵ�3��������ֵ����int�����ó���
			int three = cstmt.getInt(3);
			System.out.println(three);
			//�ѵ�4��������ֵ����int�����ó���
			int four = cstmt.getInt(4);
			System.out.println(four);
			//����������˼ҹ��ˣ��󿪵��ȹ�
			cstmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
    
    public static void main(String[] agrs){
    	
    	jdbcToOracle temp=new jdbcToOracle();
    	temp.getConnection();
    	String[] params=null;
    	temp.executeProcedure("sp201806062359", params);
    }
}
/**
 * �����õĴ洢�������£�
        create or replace procedure sp201806062359(
		    v_a    in number,
		    v_b    number,
		    v_ret  out number,
		    v_temp in out number) is
		begin
		  if (v_a > v_b) then
		    v_ret := v_a;
		  else
		    v_ret := v_b;
		  end if;
		  v_temp := v_temp + 1;
		end;
 * */
