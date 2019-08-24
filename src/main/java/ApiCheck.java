
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;

public class ApiCheck {

	private static final Logger log = LoggerFactory.getLogger(ApiCheck.class);

	public static void main(String[] args) {

		RestTemplate restTemplate = new RestTemplate();
		Gson gson = new Gson();
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(args[0]));
			String name = reader.readLine();
			log.info("Success fully load  the file is " + args[0]);

			PrintWriter pWrite = new PrintWriter("pass.txt");
			PrintWriter fWrite = new PrintWriter("fail.txt");

			while (name != null) {

				String body = restTemplate.getForObject(
						"http://api.casey.vic.gov.au/property?term=" + name + "&status=C&bin_colllection_day=true",
						String.class);
				log.info("success fully hit the API for the name " + name);

				ApiModel apiModel = gson.fromJson(body, ApiModel.class);

				if (apiModel.getResult().length > 0) {
					log.info("\u001B[32m" + "pass : " + body + "\u001B[0m");
					pWrite.println(name);
				} else {

					log.info("\u001B[31m" + "fail : " + body + "\u001B[0m");
					fWrite.println(name);
				}
				name = reader.readLine();
			}
			reader.close();
			pWrite.close();
			fWrite.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		log.info("\u001B[32m"
				+ "Susscully program completed , you can see two files pass.txt and fail.txt in your current working directory"
				+ "\u001B[0m");
		// git remote add origin
		// https://github.com/mudumalavamsikrishna/ApiCheck.git
	}

}
