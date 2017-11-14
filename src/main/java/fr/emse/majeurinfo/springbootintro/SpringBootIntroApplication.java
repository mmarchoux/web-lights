package fr.emse.majeurinfo.springbootintro;

import fr.emse.majeurinfo.springbootintro.hello.ConsoleGreetingService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootIntroApplication {

	//private ConsoleGreetingService consoleGreetingService;

	public static void main(String[] args) {

		//private ConsoleGreetingService consoleGreetingService;

		SpringApplication.run(SpringBootIntroApplication.class, args);
	}


	/*public CommandLineRunner greetingCommandLine() {

		return new CommandLineRunner() {

			@Override
			public void run(String... args) throws Exception {

			}


		};
	}*/
}
