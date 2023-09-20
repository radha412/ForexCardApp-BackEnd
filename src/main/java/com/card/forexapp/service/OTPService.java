package com.card.forexapp.service;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Service;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

@Service
public class OTPService {

	private static final Integer EXPIRE_MINS = 1;
	private LoadingCache<String, Integer> otpCache;

	public OTPService() {
		super();
		otpCache = CacheBuilder.newBuilder().expireAfterWrite(EXPIRE_MINS, TimeUnit.MINUTES)
				.build(new CacheLoader<String, Integer>() {
					public Integer load(String key) {
						return 0;
					}
				});
	}

	public Integer generateOTP(String key) {
		Random random = new Random();
		int otp = 100000 + random.nextInt(900000);
		otpCache.put(key, otp);
		return otp;
	}

	public Integer getOtp(String key) {
		try {
			return otpCache.get(key);
		} catch (Exception e) {
			return 0;
		}
	}

	public Boolean validateOTP(String key, Integer otpNumber) {
		Integer cacheOTP = this.getOtp(key);
		if (cacheOTP != null && cacheOTP.equals(otpNumber)) {
			this.clearOTP(key);
			return true;
		}
		return false;
	}

	public void clearOTP(String key) {
		otpCache.invalidate(key);
	}
}
