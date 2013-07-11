/**
 * 
 */
package datasource.web;

/**
 * @author Administrator
 *
 */
public class Datasource {
	String username;
	String password;
	String tablename;
	
	
	public Datasource(String username, String password, String tablename) {
		super();
		this.username = username;
		this.password = password;
		this.tablename = tablename;
	}
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the tablename
	 */
	public String getTablename() {
		return tablename;
	}
	/**
	 * @param tablename the tablename to set
	 */
	public void setTablename(String tablename) {
		this.tablename = tablename;
	}

}
