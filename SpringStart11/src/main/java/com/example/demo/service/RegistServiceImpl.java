package com.example.demo.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("registServiceImpl")
public class RegistServiceImpl implements RegistService {
	@Override
	public String regist() {
		return "[DI]レビュー登録が完了しました。";
	}
}
