package com.HallBooking.updateService.amazonS3client;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.DeleteObjectRequest;
import com.amazonaws.services.s3.model.PutObjectRequest;

@Service
public class AmazonClient {
    
	private AmazonS3 s3client;

	@Value("${app.aws.s3.bucketname}")
	private String bucketName;
	@Value("${app.aws.iam.accesskey}")
	private String accessKey;
	@Value("${app.aws.iam.secretkey}")
	private String secretKey;

	public AmazonS3 getS3client() {
		return s3client;
	}
	public void setS3client(AmazonS3 s3client) {
		this.s3client = s3client;
	}
	public String getBucketName() {
		return bucketName;
	}
	public void setBucketName(String bucketName) {
		this.bucketName = bucketName;
	}
	public String getAccessKey() {
		return accessKey;
	}
	public void setAccessKey(String accessKey) {
		this.accessKey = accessKey;
	}
	public String getSecretKey() {
		return secretKey;
	}
	public void setSecretKey(String secretKey) {
		this.secretKey = secretKey;
	}
	@SuppressWarnings("deprecation")
	@PostConstruct
	private void initializeAmazon() {
		AWSCredentials credentials = new BasicAWSCredentials(this.accessKey, this.secretKey);
		this.s3client = new AmazonS3Client(credentials);
	}
	public String uploadFile(MultipartFile multipartFile,String email) {

	    String fileUrl = "";
	    try {
	    	String endpointUrl = "https://s3.amazonaws.com";
	        File file = convertMultiPartToFile(multipartFile);
	        String fileName = generateFileName(multipartFile);
	        fileUrl = endpointUrl + "/" + bucketName + "/" + generateFolderName(email).replace("@", "%40") +file.getName();
	        uploadFileTos3bucket(fileName, file,email);
	        file.delete();
	    } catch (Exception e) {
	       e.printStackTrace();
	    }
	    return fileUrl;
	}
	public String deleteFileFromS3Bucket(String fileUrl) {
	    String fileName = fileUrl.substring(fileUrl.lastIndexOf("/") + 1);
	    s3client.deleteObject(new DeleteObjectRequest(bucketName , fileName));
	    return "Successfully deleted";
	}
	private File convertMultiPartToFile(MultipartFile file) throws IOException {
	    File convFile = new File(file.getOriginalFilename());
	    FileOutputStream fos = new FileOutputStream(convFile);
	    fos.write(file.getBytes());
	    fos.close();
	    return convFile;
	}
	
	private String generateFileName(MultipartFile multiPart) {
	    return new Date().getTime() + "-" + multiPart.getOriginalFilename().replace(" ", "_");
	}
	
	private String generateFolderName(String email) {
	    return email +"/";
	}
	private void uploadFileTos3bucket(String fileName, File file,String email) {
		String folderName = generateFolderName(email);
	    s3client.putObject(new PutObjectRequest(bucketName, folderName+ file.getName(), file)
	            .withCannedAcl(CannedAccessControlList.PublicRead));
	}
}
