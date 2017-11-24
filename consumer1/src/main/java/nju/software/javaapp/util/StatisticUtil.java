package nju.software.javaapp.util;

public class StatisticUtil {
	public final static String[] job_List = { "基层干部", "人民团体成员", "事业单位职员",
			"专业技术人员", "工商业人员", "社区工作者", "普通居民", "农民", "进城务工人员", "其他人员" };
	public final static String[] gender_List = { "男", "女" };
	public final static String[] education_List = { "(xl='硕士' or xl='博士及以上')",
			"(xl='大专' or xl='本科')", "(xl='高中' or xl='初中及以下')" };
	public final static String[] political_List = { "zzmm='中国共产党党员'",
			"zzmm!='中国共产党党员' and zzmm!='普通公民'", "zzmm='普通公民'" };
	public final static String[] zone_List = { "城镇人口", "农村人口" };
	public final static String[] age_List = {
			"DateDiff(year,csrq,getdate()) <= 30",
			"DateDiff(year,csrq,getdate()) > 30 and DateDiff(year,csrq,getdate()) <= 40",
			"DateDiff(year,csrq,getdate()) > 40 and DateDiff(year,csrq,getdate()) <= 50",
			"DateDiff(year,csrq,getdate()) > 50 and DateDiff(year,csrq,getdate()) <= 60",
			"DateDiff(year,csrq,getdate()) > 60" };
	public final static String[] applySource_List = { "组织推荐", "个人申请" };
}
