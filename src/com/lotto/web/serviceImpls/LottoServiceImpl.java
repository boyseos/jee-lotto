package com.lotto.web.serviceImpls;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;

import com.lotto.web.daoimpls.LottoDaoImpl;
import com.lotto.web.daos.LottoDao;
import com.lotto.web.domains.LottoBean;
import com.lotto.web.services.LottoServices;

public class LottoServiceImpl implements LottoServices{
	LottoDao dao;
	public LottoServiceImpl() {
		dao = new LottoDaoImpl();
	}
	
	@Override
	public void createLotto(LottoBean param) {
		param.setBall(createBall());
		param.setLotteryNum(createLotteryNum());
		String seq = createLottoSeq();
		while(seqDuplicateCheck(seq)) {
			seq = createLottoSeq();
		}
		param.setLottoSeq(seq);
		dao.insertLotto(param);
	}

	@Override
	public String createLottoSeq() {
		return String.format("No.%04d", new Random().nextInt(9999));
	}

	@Override
	public String createBall() {
		return String.valueOf((int)(Math.random()*45)+1);
	}

	@Override
	public String createLotteryNum() {
		String num = "";
		List<String> arrL = new ArrayList<String>();
		for (int i = 1; i < 7; i++) {
			num = createBall();
			while (duplicateCheck(arrL, num)) {
				num = createBall();
			}
			arrL.add(num);
		}
		num = "";
		String[] arr = arrL.toArray(new String[arrL.size()]);
		for (int i = 0; i < 6; i++) {
			arr = minSort(arr);
			num += (i!=5) ? arr[i]+"," : arr[i];
		}
		return num;
	}

	@Override
	public boolean seqDuplicateCheck(String str) {
		boolean result = false;
		for(LottoBean temp : dao.getFile()) {
			if(result = str.equals(temp.getLottoSeq())) {// result 가 매번 할당되는모양. 속도가 느려지지 않나?
				break;
			}
		}
		return result;
	}
	
	@Override
	public boolean duplicateCheck(List<String> param, String num) {
		return param.contains(num);
	}

	@Override
	public String[] minSort(String[] param) {
		String temp = "";
		for(int i = param.length - 1; i >= 1; i--) {
			if(Integer.parseInt(param[i]) < Integer.parseInt(param[i-1])) {
				temp = param[i-1];
				param[i-1] = param[i];
				param[i] = temp;
			}			
		}
		return param;
	}

}
