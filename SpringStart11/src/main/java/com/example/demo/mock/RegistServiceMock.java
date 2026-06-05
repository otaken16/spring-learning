package com.example.demo.mock;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.service.RegistService;

@Service
@Qualifier("registServiceMock")
public class RegistServiceMock implements RegistService {
	@Override
	public String regist() {
		return "テスト的に登録しました。";
	}
}
