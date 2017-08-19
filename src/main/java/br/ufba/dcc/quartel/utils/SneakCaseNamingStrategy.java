package br.ufba.dcc.quartel.utils;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;

import com.google.common.base.CaseFormat;

public class SneakCaseNamingStrategy extends PhysicalNamingStrategyStandardImpl
{
	private static final long serialVersionUID = -3874851986261792494L;

	@Override
	public Identifier toPhysicalTableName(Identifier name, JdbcEnvironment context) 
	{
        return context.getIdentifierHelper()
        		.toIdentifier(CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, name.getText()));
	}

	@Override
	public Identifier toPhysicalColumnName(Identifier name, JdbcEnvironment context) 
	{
        return context.getIdentifierHelper()
        		.toIdentifier(CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, name.getText()));
	}	
}
