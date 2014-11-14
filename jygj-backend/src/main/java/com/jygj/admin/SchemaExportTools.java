package com.jygj.admin;

import java.io.File;

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import com.jygj.admin.common.ResourceUtils;

public class SchemaExportTools {

	public static void main(String[] args) throws Exception {
		Configuration configure = new Configuration();
		if (!ResourceUtils.isProdEnvConfig()) {
			configure = configure.configure();// default cfg xml
		} else {
			configure = configure.configure(new File(ResourceUtils
					.getProdCfgXml()));
		}
		new SchemaExport(configure).create(true, true);
	}
}
