package com.aaa.aliyun;

import com.aaa.until.FactUtil;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.GetObjectRequest;
import com.aliyun.oss.model.ObjectMetadata;
import com.aliyun.oss.model.PutObjectResult;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * 阿里云存储
 */

public  class AliOSS {
  //  static Logger logger = Logger.getLogger(AliOSS.class);
    private static String endpoint = "http://oss-cn-beijing.aliyuncs.com";
    private static String accessKeyId = "LTAI4GFMYgkZJu6sHeqZFWkP";
    private static String accessKeySecret = "tulW1dZqZgolxB47kbIwB4GjTYxGtG";
    private static String bucketName = "cyj0117";
    private static String firstKey = "my-first-key";
    private static OSS ossClient=null;
    static {
        ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

    }


    /**
     * 向bucket中添加图片;
     *
     */
    private static String Add(String fileKey,String path){
        String url=null;

        //PropertyConfigurator.configure("springboot-aliyunoss/src/log4j.properties");

        // 生成OSSClient，您可以指定一些参数，详见“SDK手册 > Java-SDK > 初始化”，
        // 链接地址是：https://help.aliyun.com/document_detail/oss/sdk/java-sdk/init.html?spm=5176.docoss/sdk/java-sdk/get-start
        try {


            // meta设置请求头
            ObjectMetadata meta = new ObjectMetadata();
            meta.setContentType("image/jpg");
            PutObjectResult putObjectResult = ossClient.putObject(bucketName, fileKey, new File(path),meta);
            System.out.println("Object：" + fileKey + "存入OSS成功。");
            url="https://cyj0117.oss-cn-beijing.aliyuncs.com/"+ FactUtil.toUtf8String(fileKey);
            System.out.println(putObjectResult);
        }catch (Exception e){

        }finally {
            ossClient.shutdown();
        }

        return url;
    }
    /*
    * 删除
    * */
    public static Boolean remove(String firstKey){
        try {
            ossClient.deleteObject(bucketName,firstKey);

        }catch (Exception e){
            return false;
        }
        return  true;
    }

    /**
     * 下载
     */

    public static  boolean install(String firstKey) throws IOException {
        ObjectMetadata ossObject = ossClient.getObject(new GetObjectRequest(bucketName, firstKey), new File("C:\\Users\\Administrator\\Desktop\\music\\童话镇.mp3"));
        ossClient.shutdown();
        return  true;
    }

    /**
     *
     * @param fileKey  文件名称
     * @param file  文件上传
     * @return
     */
    public static String upload(String fileKey, MultipartFile file){
        String url=null;
        ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);


        // PropertyConfigurator.configure("springboot-aliyunoss/src/log4j.properties");
        //logger.info("Started");
        // 生成OSSClient，您可以指定一些参数，详见“SDK手册 > Java-SDK > 初始化”，
        // 链接地址是：https://help.aliyun.com/document_detail/oss/sdk/java-sdk/init.html?spm=5176.docoss/sdk/java-sdk/get-start
        try {


            // meta设置请求头
            ObjectMetadata meta = new ObjectMetadata();
            meta.setContentType("image/jpg");
            PutObjectResult putObjectResult = ossClient.putObject(bucketName, fileKey, file.getInputStream(),meta);
            System.out.println("Object：" + fileKey + "存入OSS成功。");
            url="https://cyj0117.oss-cn-beijing.aliyuncs.com/"+ FactUtil.toUtf8String(fileKey);
            //System.out.println(putObjectResult);
        }catch (Exception e){

        }finally {
            ossClient.shutdown();
        }

        return url;
    }


    public static void main(String[] args) throws IOException {
        String add = AliOSS.Add("1", "C:/Users/1/Desktop/F4Kitchen/image/13-1.jpg");
        System.out.println(add);
    }
}
