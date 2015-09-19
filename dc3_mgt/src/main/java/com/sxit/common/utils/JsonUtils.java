package com.sxit.common.utils;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.text.SimpleDateFormat;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@Component
public class JsonUtils {
	private static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
	private static final ObjectMapper mapper;

	static {
		SimpleDateFormat dateFormat = new SimpleDateFormat(DEFAULT_DATE_FORMAT);
		mapper = new ObjectMapper();
		mapper.setDateFormat(dateFormat);
		mapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
		mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
	}

	/**
	 * @return
	 */
	public ObjectMapper getMapper() {
		return mapper;
	}

	/**
	 * @Description: 
	 * @param args
	 * @throws IOException
	 * @throws JsonParseException
	 */
	public static <T> T deserialize(String json, Class<T> type)
			throws JsonParseException, IOException {
		T t = mapper.readValue(json, type);
		return t;
	}

	/**
	 * 
	 * @param json
	 * @param type
	 * @return
	 * @throws JsonParseException
	 * @throws IOException
	 */
	public static <T> T deserialize(String json, TypeReference<T> type)
			throws JsonParseException, IOException {
		T t = mapper.readValue(json, type);
		return t;
	}

	/**
	 * 
	 * @param json
	 * @param type
	 * @return
	 * @throws JsonParseException
	 * @throws IOException
	 */
	public static <T> T deserialize(String json, JavaType type)
			throws JsonParseException, IOException {
		T t = mapper.readValue(json, type);
		return t;
	}

	/**
	 * 
	 * @param object
	 * @return
	 * @throws JsonGenerationException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public static String serialize(Object object)
			throws JsonGenerationException, JsonMappingException, IOException {
		Writer strWriter = new StringWriter();
		mapper.writeValue(strWriter, object);
		return strWriter.toString();
	}

	/**
	 * 
	 * @param obj
	 * @return
	 */
	public static String toJson(Object obj) {
		try {
			return mapper.writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException("转换json字符失败!");
		}
	}

	/**
	 * 
	 * @param json
	 * @param clazz
	 * @return
	 */
	public static <T> T toObject(String json, Class<T> clazz) {
		try {
			return mapper.readValue(json, clazz);
		} catch (IOException e) {
			throw new RuntimeException("将json字符转换为对象时失败!");
		}
	}

	/**
	 * 多个类型
	 * 
	 * @param collectionClass
	 * @param elementClasses
	 * @return
	 */
	public static JavaType getCollectionType(Class<?> collectionClass,
			Class<?>... elementClasses) {
		return mapper.getTypeFactory().constructParametricType(collectionClass,
				elementClasses);
	}
}
