package com.mindskip.xzs.controller.admin;

import com.mindskip.xzs.base.RestResponse;
import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.security.auth.login.Configuration;
import java.io.File;

@RestController("FileUploadController")
@RequestMapping(value = "/file/upload")
public class FileUploadController {

    @Value("${qn:access-key}")
    private String accessKey;

    @Value("${qn:secret-key}")
    private String secretKey;

    @Value("${qn:bucket}")
    private String bucket;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public RestResponse fileUpload() {
        Auth auth = Auth.create(accessKey, secretKey);
        String upToken = auth.uploadToken(bucket);
        System.out.println(upToken);
        StringMap putPolicy = new StringMap();
        File file = new File("D:\\cat.jpg");
        putPolicy.put("callbackUrl", "http://api.example.com/qiniu/upload/callback");
        putPolicy.put("callbackBody", "key=$(key)&hash=$(etag)&bucket=$(bucket)&fsize=$(fsize)");

        return RestResponse.ok();
    }
}
