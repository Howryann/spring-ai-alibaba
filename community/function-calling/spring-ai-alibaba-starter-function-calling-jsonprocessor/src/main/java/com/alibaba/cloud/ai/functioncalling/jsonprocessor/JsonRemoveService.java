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
package com.alibaba.cloud.ai.functioncalling.jsonprocessor;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;

import java.util.function.Function;

/**
 * @author 北极星
 */
public class JsonRemoveService implements Function<JsonRemoveService.JsonRemoveRequest, Object> {

	@Override
	public Object apply(JsonRemoveRequest request) throws JsonParseException {
		String content = request.content;
		String field = request.field;
		JsonElement jsonElement = JsonParser.parseString(content);
		if (!jsonElement.isJsonObject())
			throw new IllegalArgumentException("Content is not a valid JSON object .");
		JsonObject jsonObject = jsonElement.getAsJsonObject();
		return jsonObject.remove(field);
	}

	record JsonRemoveRequest(@JsonProperty("content") String content, @JsonProperty("value") String field) {
	}

}