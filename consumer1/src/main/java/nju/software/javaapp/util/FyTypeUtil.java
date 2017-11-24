package nju.software.javaapp.util;

import nju.software.javaapp.dynamicds.DataSourceEnum;

/**
 * 判断该法院是高院还是中院还是基层法院
 * 
 * @author storm
 * 
 */
public class FyTypeUtil {

	public final static int GY = 0;
	public final static int ZY = 1;
	public final static int JCFY = 2;

	/**
	 * 一中院辖区法院代码
	 */
	public final static String[] GY_LIST = {"120000 200" ,"120100 210","120101 211", "120104 212",
		"120105 213", "120106 214", "120107 215", "120108 216",
		"120222 217", "120223 218", "120224 219" ,"120225 21A","120200 220","120202 221", "120203 222",
		"120204 223", "120205 224", "120206 225", "120207 226",
		"120208 227", "120221 228", "120241 229", "120242 22A" , "960200 230"};
	public final static String[] YZY_LIST={"120100 210","120101 211", "120104 212",
		"120105 213", "120106 214", "120107 215", "120108 216",
		"120222 217", "120223 218", "120224 219","120225 21A" };
	public final static String[] EZY_LIST= {"120200 220","120202 221", "120203 222",
		"120204 223", "120205 224", "120206 225", "120207 226",
		"120208 227", "120221 228", "120241 229", "120242 22A" };
	public final static String[] YZY_XQFY = { "120101 211", "120104 212",
			"120105 213", "120106 214", "120107 215", "120108 216",
			"120222 217", "120223 218", "120224 219" };
	public final static String[] EZY_XQFY = { "120202 221", "120203 222",
			"120204 223", "120205 224", "120206 225", "120207 226",
			"120208 227", "120221 228", "120241 229", "120242 22A" };

	/**
	 * 通过法院代码获得法院类型
	 * 
	 * @param fydm
	 * @return
	 */
	public static int getFyType(String fydm) {
		if (DataSourceEnum.TJGY.getFydm().equals(fydm))
			return GY;
		if (DataSourceEnum.TJYZY.getFydm().equals(fydm)
				|| DataSourceEnum.TJEZY.getFydm().equals(fydm))
			return ZY;
		return JCFY;
	}
}
