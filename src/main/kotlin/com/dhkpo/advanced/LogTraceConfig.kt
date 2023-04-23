package com.dhkpo.advanced

import com.dhkpo.advanced.trace.logtrace.LogTrace
import com.dhkpo.advanced.trace.logtrace.ThreadLocalLogTrace
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class LogTraceConfig {

    @Bean
    fun logTrace(): LogTrace {
        return ThreadLocalLogTrace()
    }
}
