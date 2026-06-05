package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.entity.ReviewDto;
import com.example.demo.repository.RegistRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RegistServiceImpl implements RegistService {

	//	DI
	private final RegistRepository resitRepository;

	@Override
	public void regist(ReviewDto reviewDto) {
		resitRepository.add(reviewDto);
	}

}
