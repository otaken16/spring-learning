package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.entity.ReviewDto;
import com.example.demo.repository.ReviewRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RegistServiceImpl implements RegistService {

	//	DI
	private final ReviewRepository resitRepository;

	@Override
	public void regist(ReviewDto reviewDto) {
		resitRepository.add(reviewDto);
	}

}
