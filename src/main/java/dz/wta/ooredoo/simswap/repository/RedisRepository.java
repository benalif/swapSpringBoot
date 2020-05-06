package dz.wta.ooredoo.simswap.repository;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import lombok.Data;

@Repository
@Data
public class RedisRepository {

	private RedisTemplate<String, Object> redisTemplate;
	private HashOperations hashOperations;

	public RedisRepository(RedisTemplate<String, Object> redisTemplates) {
		super();
		this.redisTemplate = redisTemplate;
		this.hashOperations = redisTemplates.opsForHash();
	}

	public void save(String token) {
	//	this.hashOperations.put(key, hashKey, value);

	}

	public void delete(String key, Object hashKye) {
		this.hashOperations.delete(key, hashKye);
	}

}
