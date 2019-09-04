package com.lotto.web.daoimpls;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import com.lotto.web.daos.LottoDao;
import com.lotto.web.domains.LottoBean;

public class LottoDaoImpl implements LottoDao{
	final public static String SETFILE_PATH = "C:"+File.separator+
	"Users"+File.separator+"user"+File.separator+
	"eclipse_jee"+File.separator+"jee-lotto"+File.separator+
	"WebContent"+File.separator+"resources"+File.separator+"text"+File.separator;
//	final public static String SETFILE_PATH = "E:" + File.separator + "공부" + File.separator + "java" + File.separator
//			+ "jee-lotto" + File.separator + "WebContent" + File.separator + "resources" + File.separator + "text"
//			+ File.separator;
	@Override
	public void insertLotto(LottoBean param) {
		try {
			File file = new File(SETFILE_PATH+"lottoNum.txt");
			BufferedWriter write = new BufferedWriter(new FileWriter(file, true));
			String result = param.getLottoSeq()+"/"+param.getLotteryNum();
			write.write(result);
			write.newLine();
			write.flush();
			write.close();
		} 
		catch(Exception e){
			e.printStackTrace();
			}
	}
	@Override
	public List<LottoBean> getFile() {
		List<LottoBean> arrL = new ArrayList<LottoBean>();
		try {
			LottoBean member = null;
			String result ="";
			File file = new File(SETFILE_PATH+"lottoNum.txt");
			BufferedReader reader = new BufferedReader(new FileReader(file));
			while((result = reader.readLine()) != null) {
				member = new LottoBean();
				member.setLotteryNum(result.split("/")[1]);
				member.setLottoSeq(result.split("/")[0]);
				arrL.add(member);
			}
			reader.close();
		} 
		catch(Exception e){
			e.printStackTrace();
			}
		return arrL;
	}

}
