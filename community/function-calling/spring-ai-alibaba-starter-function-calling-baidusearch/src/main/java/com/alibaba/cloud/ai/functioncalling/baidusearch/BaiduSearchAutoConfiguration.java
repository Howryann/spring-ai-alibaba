/*
 * Copyright 2024-2025 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.alibaba.cloud.ai.functioncalling.baidusearch;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Description;

/**
 * @author KrakenZJC
 **/
@ConditionalOnClass(BaiduSearchService.class)
@ConditionalOnProperty(value = "spring.ai.alibaba.functioncalling.baidusearch", name = "enabled", havingValue = "true")
public class BaiduSearchAutoConfiguration {

	@Bean
	@ConditionalOnMissingBean
	@Description("Use baidu search engine to query for the latest news.")
	public BaiduSearchService baiduSearchFunction() {
		return new BaiduSearchService();
	}

}