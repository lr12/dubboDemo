package nju.software.javaapp.dynamicds;

import nju.software.javaapp.util.StringUtil;

import org.apache.commons.dbcp.BasicDataSource;


/**
 * ���ܵ����Դ
 * 
 * @author zym
 * 
 */
public class EncryptDataSource extends BasicDataSource {

	@Override
	public void setPassword(String password) {

		password = encryptPassword(password);
		super.setPassword(password);
	}

	/**
	 * ������ݿ�����Ĺ���
	 * 
	 * @param password
	 * @return
	 */
	private String encryptPassword(String password) {

		String result = password;
		if (StringUtil.isBlank(password) && password.indexOf(",") < 0) {
			// if(StringUtil.indexOf(password, ",")<0){
			return result;
		}
		String[] separate = password.split(",");
		String fydm = separate[0];
		String xlh = separate[1];
		if (StringUtil.equals(fydm, "000000")) {
			result = xlh;
		} else {
			Getpasswd oo = new Getpasswd();
			result = oo.passwd(fydm, xlh);
		}

		return result;
	}
}
