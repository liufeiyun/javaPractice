package DataBase.com.lfy.Oracle;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

/**
 * 主题：调用存储过程
     JDBC调用存储过程: CallableStatement
	  在Java里面调用存储过程，写法那是相当的固定：
	 Class.forName(....
	 Connection conn = DriverManager.getConnection(....
	 p是要调用的存储过程的名字，存储过程的4个参数，用4个？号占位符代替
	  其余地方写法固定
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
    		*ProcedureName是要调用的存储过程的名字，存储过程的4个参数，用4个？号占位符代替
    		*/
			CallableStatement cstmt = con.prepareCall("{call "+ProcedureName+"(?,?,?,?)}");
			/**
			*告诉JDBC，这些参数，哪些是输出参数，输出参数的类型用java.sql.Types来指定
			*下面的意思是，第3个？和第4个？是输出参数，类型是INTEGER的
			*Types后面具体写什么类型，得看你的存储过程参数怎么定义的
			*/
			cstmt.registerOutParameter(3, Types.INTEGER);
			cstmt.registerOutParameter(4, Types.INTEGER);
			/**
			*在我这里第1个？和第2个？是输入参数，第3个是输出参数，第4个既输入又输出
			*下面是设置他们的值,第一个设为3，第二个设为4，第4个设置为5
			*没设第3个，因为它是输出参数
			*/
			cstmt.setInt(1, 3);
			cstmt.setInt(2, 12);
			cstmt.setInt(4, 5);
			//执行
			cstmt.execute();
			//把第3个参数的值当成int类型拿出来
			int three = cstmt.getInt(3);
			System.out.println(three);
			//把第4个参数的值当成int类型拿出来
			int four = cstmt.getInt(4);
			System.out.println(four);
			//用完别忘给人家关了，后开的先关
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
 * 测试用的存储过程如下：
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
