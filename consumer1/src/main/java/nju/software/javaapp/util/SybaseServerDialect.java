package nju.software.javaapp.util;

import java.sql.Types;

import org.hibernate.Hibernate;
import org.hibernate.dialect.SQLServerDialect;

public class SybaseServerDialect extends SQLServerDialect {
	public SybaseServerDialect() {
		super();
		registerHibernateType(Types.LONGVARCHAR, Hibernate.TEXT.getName());
		registerHibernateType(Types.LONGVARCHAR, Hibernate.LONG.getName());
		registerHibernateType(Types.LONGVARBINARY, Hibernate.BLOB.getName());// ע��blob��Types.LONGVARBINARY��ֵ����-4
	}
}
