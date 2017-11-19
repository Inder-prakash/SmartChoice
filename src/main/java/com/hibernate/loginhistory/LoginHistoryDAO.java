package com.hibernate.loginhistory;

import java.util.List;

public interface LoginHistoryDAO {
	void insert(LoginHistory lh);
	List<LoginHistory> getAll();
}
