package com.stusys162.service;

import com.stusys162.pojo.Admininfo;

public interface AdminService {
	public boolean login(Admininfo admin);

	public Admininfo getAdminByUsername(String username);
}
