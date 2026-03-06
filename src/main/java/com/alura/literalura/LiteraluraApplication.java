package com.alura.literalura;

import com.alura.literalura.components.MainMenuComponent;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.io.IOException;

@SpringBootApplication
public class LiteraluraApplication implements CommandLineRunner {
	private final MainMenuComponent main;

	public LiteraluraApplication(MainMenuComponent main){
		this.main = main;
	}

	public static void main(String[] args) throws IOException, InterruptedException {
		ApplicationContext context = SpringApplication.run(LiteraluraApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		main.getMenu();
	}
}
