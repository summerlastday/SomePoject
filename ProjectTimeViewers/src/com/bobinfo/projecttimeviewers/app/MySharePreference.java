package com.bobinfo.projecttimeviewers.app;

import android.content.Context;
import android.content.SharedPreferences;

import com.bobinfo.projecttimeviewers.modle.UserInfos;

/**
 * 保存配置文件
 * 
 * @author Change
 * 
 */
public class MySharePreference {
	private SharedPreferences preferences = null;
	private SharedPreferences.Editor editor = null;

	public MySharePreference(Context context) {
		preferences = context.getSharedPreferences("System",
				Context.MODE_PRIVATE);
		editor = preferences.edit();
	}

	// 保存用户信息
	public void saveUserInfos(UserInfos user) {
		editor.putString("userName", user.userInfo.userName);
		editor.putString("password", user.userInfo.password);
		editor.commit();
	}

	// 获取用户信息
	public UserInfos getUserInfo() {
		UserInfos user = new UserInfos();
		user.userInfo.userName = preferences.getString("userName", "");
		user.userInfo.password = preferences.getString("password", "");
		return user;
	}
}
