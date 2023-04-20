package br.com.automatodev.homeponto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.nuLLcmd.CustomBanner;

@SpringBootApplication
public class HomepontoApplication {

	 private static final String[] CUSTOM_BANNER = {

		",--.  ,--.,--. ,--.,--.   ,--.    ",
		"|  ,'.|  ||  | |  ||  |   |  |    ",
		"|  |' '  ||  | |  ||  |   |  |    ",
		"|  | `   |'  '-'  '|  '--.|  '--. ",
		"`--'  `--' `-----' `-----'`-----' \n"
	 };

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(HomepontoApplication.class);
		CustomBanner customBanner = new CustomBanner();
		customBanner.setCustomBanner(CUSTOM_BANNER);
		application.setBanner(customBanner);
		application.run(args);
	}

}
