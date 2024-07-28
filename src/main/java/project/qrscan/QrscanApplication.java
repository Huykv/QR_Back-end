package project.qrscan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;
import project.qrscan.Controller.ImageController;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@SpringBootApplication
public class QrscanApplication {

	public static void main(String[] args) throws IOException {
		ConfigurableApplicationContext context = SpringApplication.run(QrscanApplication.class, args);
//		addImageProduct(context);
	}

	public static void addImageProduct(ConfigurableApplicationContext context) throws IOException {
		ImageController imageController = context.getBean(ImageController.class);
		imageController.uploadImage(convertFileToMultipartFile("src/main/java/project/qrscan/Image/Beverage/pepsi.jpg"), 1L);
		imageController.uploadImage(convertFileToMultipartFile("src/main/java/project/qrscan/Image/Beverage/pepsikc.png"), 2L);
		imageController.uploadImage(convertFileToMultipartFile("src/main/java/project/qrscan/Image/Beverage/pepsivckc.png"), 3L);
		imageController.uploadImage(convertFileToMultipartFile("src/main/java/project/qrscan/Image/Beverage/chaipepsi.png"), 4L);
		imageController.uploadImage(convertFileToMultipartFile("src/main/java/project/qrscan/Image/Beverage/chaipepsikc.png"), 5L);
		imageController.uploadImage(convertFileToMultipartFile("src/main/java/project/qrscan/Image/Beverage/chaipepsivckc.png"), 6L);
		imageController.uploadImage(convertFileToMultipartFile("src/main/java/project/qrscan/Image/Beverage/loncoca235.png"), 7L);
		imageController.uploadImage(convertFileToMultipartFile("src/main/java/project/qrscan/Image/Beverage/loncoca320.png"), 8L);
		imageController.uploadImage(convertFileToMultipartFile("src/main/java/project/qrscan/Image/Beverage/chaicoca390.png"), 9L);
		imageController.uploadImage(convertFileToMultipartFile("src/main/java/project/qrscan/Image/Beverage/chaicoca1500.png"), 10L);
		imageController.uploadImage(convertFileToMultipartFile("src/main/java/project/qrscan/Image/Beverage/thungcoca.png"), 11L);
		imageController.uploadImage(convertFileToMultipartFile("src/main/java/project/qrscan/Image/DryFood/xucxichCP.png"), 12L);
		imageController.uploadImage(convertFileToMultipartFile("src/main/java/project/qrscan/Image/DryFood/khobochoiceL.png"), 13L);
		imageController.uploadImage(convertFileToMultipartFile("src/main/java/project/qrscan/Image/DryFood/mamtomNL.png"), 14L);
		imageController.uploadImage(convertFileToMultipartFile("src/main/java/project/qrscan/Image/DryFood/mucrimmechoiceL.png"), 15L);
		imageController.uploadImage(convertFileToMultipartFile("src/main/java/project/qrscan/Image/IceCream/kemquevanillawalls.png"), 16L);
		imageController.uploadImage(convertFileToMultipartFile("src/main/java/project/qrscan/Image/IceCream/kemquesclNestle.png"), 17L);
		imageController.uploadImage(convertFileToMultipartFile("src/main/java/project/qrscan/Image/IceCream/kemhopcacao.png"), 18L);
		imageController.uploadImage(convertFileToMultipartFile("src/main/java/project/qrscan/Image/IceCream/kemhopsuadua.png"), 19L);
		imageController.uploadImage(convertFileToMultipartFile("src/main/java/project/qrscan/Image/Milk/suavaninuti.png"), 20L);
		imageController.uploadImage(convertFileToMultipartFile("src/main/java/project/qrscan/Image/Milk/suaTHtrueMilk.png"), 21L);
		imageController.uploadImage(convertFileToMultipartFile("src/main/java/project/qrscan/Image/Milk/suasclvinamilk.png"), 22L);
		imageController.uploadImage(convertFileToMultipartFile("src/main/java/project/qrscan/Image/Milk/suamilohop.png"), 23L);
		imageController.uploadImage(convertFileToMultipartFile("src/main/java/project/qrscan/Image/Snack/snack1.png"), 24L);
		imageController.uploadImage(convertFileToMultipartFile("src/main/java/project/qrscan/Image/Snack/snack2.png"), 25L);
		imageController.uploadImage(convertFileToMultipartFile("src/main/java/project/qrscan/Image/Snack/snack3.png"), 26L);
		imageController.uploadImage(convertFileToMultipartFile("src/main/java/project/qrscan/Image/Snack/snack4.png"), 27L);
		imageController.uploadImage(convertFileToMultipartFile("src/main/java/project/qrscan/Image/Snack/snack5.png"), 28L);
		imageController.uploadImage(convertFileToMultipartFile("src/main/java/project/qrscan/Image/Snack/snack6.png"), 29L);
	}

	public static MultipartFile convertFileToMultipartFile(String filePath) throws IOException {
		// Load the file from the file system
		File file = new File(filePath);

		// Convert File to MultipartFile
		FileInputStream input = new FileInputStream(file);
		MultipartFile multipartFile = new MockMultipartFile("image",
				file.getName(), "image/png", input);

		return multipartFile;
	}
}
