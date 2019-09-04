package com.lotto.web.daos;

import java.util.List;

import com.lotto.web.domains.LottoBean;

public interface LottoDao {
	public void insertLotto(LottoBean param);
	public List<LottoBean> getFile();
}
