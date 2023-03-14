package com.wkd.akiriapi.configuration

import org.springframework.boot.autoconfigure.cache.RedisCacheManagerBuilderCustomizer
import org.springframework.cache.annotation.EnableCaching
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.cache.RedisCacheConfiguration
import org.springframework.data.redis.cache.RedisCacheManager.RedisCacheManagerBuilder
import java.time.Duration


@Configuration
@EnableCaching
class CacheConfiguration {

    @Bean
    fun redisCacheManagerBuilderCustomizer(): RedisCacheManagerBuilderCustomizer? {
        return RedisCacheManagerBuilderCustomizer { builder: RedisCacheManagerBuilder ->
            builder
                .withCacheConfiguration(
                    "a-product",
                    RedisCacheConfiguration.defaultCacheConfig()
                        .entryTtl(Duration.ofMinutes(60))
                )
        }
    }
}
