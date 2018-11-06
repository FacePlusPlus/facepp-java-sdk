package com.megvii.facepp.api;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

/**
 * @author by licheng on 2018/6/13.
 */

public class HttpUtils {

    private static final MediaType MediaType_APPLICATION = MediaType.parse("application/octet-stream");

    private static final String KEY_IMAGE_FILE = "image_file";
    public static final String KEY_IMAGE_FILE_1 = "image_file1";
    public static final String KEY_IMAGE_FILE_2 = "image_file2";

    public static final String KEY_TEMPLATE_FILE = "template_file";
    public static final String KEY_MERGE_FILE = "merge_file";

    private static OkHttpClient okHttpClient;

    /**
     * 不带文件参数的请求
     */
    public static void post(String url, Map<String, String> params, Callback callback) {
        post(url, params, new byte[]{}, callback);
    }

    /**
     * 带文件参数的请求
     */
    public static void post(String url, final Map<String, String> params, byte[] file, Callback callback) {
        Map<String, byte[]> fileParams = new HashMap<>();
        fileParams.put(KEY_IMAGE_FILE, file);
        post(url, params, fileParams, null, callback);
    }

    /**
     * 带文件参数的请求
     */
    public static void post(String url, final Map<String, String> params, Map<String, byte[]> file, Callback callback) {
        post(url, params, file, null, callback);
    }

    /**
     * 带文件参数的请求
     */
    public static void post(String url, final Map<String, String> params, Map<String, byte[]> file1, Map<String, byte[]> file2, Callback callback) {
        try {
            // 构建请求体
            RequestBody requestBody = buildRequestBody(params, file1, file2);

            // 发送请求
            doPost(new Request.Builder().url(url).post(requestBody).build(), callback);
        } catch (Exception e) {
            if (null != callback) {
                callback.onFailure(null, new IOException(e.getMessage()));
            }
        }
    }

    /**
     * 构建请求参数
     */
    private static RequestBody buildRequestBody(final Map<String, String> params, Map<String, byte[]> filePath1, Map<String, byte[]> filePath2) throws Exception {
        // 普通参数
        final MultipartBody.Builder bodyBuilder = addNormalParams(params);

        // 文件参数
        addFileParamsByKey(filePath1, bodyBuilder);
        addFileParamsByKey(filePath2, bodyBuilder);

        return bodyBuilder.build();
    }

    /**
     * 普通参数
     */
    private static MultipartBody.Builder addNormalParams(final Map<String, String> params) {

        final MultipartBody.Builder bodyBuilder = new MultipartBody.Builder().setType(MultipartBody.FORM);

        // 普通参数
        Iterator<String> iterator = params.keySet().iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            String value = params.get(key);
            bodyBuilder.addFormDataPart(key, value);
        }
        return bodyBuilder;
    }

    /**
     * 发送请求
     */
    private static void doPost(Request request, final Callback callback) {
        if (null == okHttpClient) {
            okHttpClient = new OkHttpClient();
        }
        okHttpClient.newCall(request).enqueue(callback);
    }

    private static void addFileParams(MultipartBody.Builder bodyBuilder, String key, byte[] file) throws Exception {
        bodyBuilder.addFormDataPart(key, key, RequestBody.create(MediaType_APPLICATION, file));
    }

    private static boolean isEmpty(byte[] data) {
        return data == null || data.length == 0;
    }

    private static void addFileParamsByKey(Map<String, byte[]> filePath, MultipartBody.Builder bodyBuilder) throws Exception {
        if (null != filePath) {
            getDataByKey(filePath, KEY_IMAGE_FILE, bodyBuilder);
            getDataByKey(filePath, KEY_IMAGE_FILE_1, bodyBuilder);
            getDataByKey(filePath, KEY_IMAGE_FILE_2, bodyBuilder);
            getDataByKey(filePath, KEY_TEMPLATE_FILE, bodyBuilder);
            getDataByKey(filePath, KEY_MERGE_FILE, bodyBuilder);
        }
    }

    private static void getDataByKey(Map<String, byte[]> file, String key, MultipartBody.Builder bodyBuilder) throws Exception {
        if (!isEmpty(file.get(key))) {
            addFileParams(bodyBuilder, key, file.get(key));
        }
    }
}
