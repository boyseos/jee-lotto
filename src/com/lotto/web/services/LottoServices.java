package com.lotto.web.services;
import java.util.List;

import com.lotto.web.domains.LottoBean;

public interface LottoServices {
	public void createLotto(LottoBean param);
	//lottoSeq = No.4자리랜덤수_
	public String createLottoSeq();
	public String createBall();
	public String createLotteryNum();
	public boolean seqDuplicateCheck(String str);
	public boolean duplicateCheck(List<String> param, String num);
	public String[] minSort(String[] param);
}
