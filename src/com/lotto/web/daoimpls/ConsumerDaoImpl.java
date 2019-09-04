package com.lotto.web.daoimpls;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import com.lotto.web.daos.ConsumerDao;
import com.lotto.web.domains.ConsumerBean;

public class ConsumerDaoImpl implements ConsumerDao{
	final public static String SETFILE_PATH = "C:"+File.separator+
			"Users"+File.separator+"user"+File.separator+
			"eclipse_jee"+File.separator+"jee-lotto"+File.separator+
			"WebContent"+File.separator+"resources"+File.separator+"text"+File.separator;
//	final public static String SETFILE_PATH = "E:"+File.separator+
//			"공부"+File.separator+"java"+File.separator+"jee-lotto"+File.separator+
//			"WebContent"+File.separator+"resources"+File.separator+"text"+File.separator;
	@Override
	public void insertConsumer(ConsumerBean param) {
		try {
			File file = new File(SETFILE_PATH+"consumers.txt");
			@SuppressWarnings("resource")
			BufferedWriter writer = new BufferedWriter(new FileWriter(file,false));
			writer.write(String.format("%s,%s\n",param.getCid(),param.getPass()));
			writer.newLine();
			writer.flush();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
