package com.wkd.akiriapi.configuration

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.connection.RedisClusterConfiguration
import org.springframework.data.redis.connection.RedisConnectionFactory
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory
import org.springframework.data.redis.core.StringRedisTemplate

@Configuration
@ConfigurationProperties(prefix = "spring.redis.cluster")
class RedisConfiguration {
    lateinit var nodes: List<String>

    @Bean
    fun redisConnectionFactory(): RedisConnectionFactory {
        val redisClusterConfiguration = RedisClusterConfiguration(nodes)
        return LettuceConnectionFactory(redisClusterConfiguration)
    }

    @Bean
    fun redisTemplate(redisConnectionFactory: RedisConnectionFactory): StringRedisTemplate {
        return StringRedisTemplate(redisConnectionFactory)
    }
}
