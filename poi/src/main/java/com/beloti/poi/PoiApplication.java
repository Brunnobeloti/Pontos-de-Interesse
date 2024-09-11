package com.beloti.poi;

import com.beloti.poi.entity.PontoInteresse;
import com.beloti.poi.repository.PontoInteresseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PoiApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(PoiApplication.class, args);
	}

	@Autowired
	private PontoInteresseRepository repository;

	@Override
	public void run(String... args) throws Exception {

		repository.save(new PontoInteresse("Mixto Bão", "Lanchonete","7:00 - 18:00", 27L,12L));
		repository.save(new PontoInteresse("Posto Ipiranga", "Posto","7:00 - 18:00", 31L,18L));
		repository.save(new PontoInteresse("Joia Rara Joalheria", "Joalheria","7:00 - 18:00", 15L,12L));
		repository.save(new PontoInteresse("Boa Rosa", "Floricultura","7:00 - 18:00", 19L,21L));
		repository.save(new PontoInteresse("Cachaça Certa", "Pub","7:00 - 18:00", 12L,8L));
		repository.save(new PontoInteresse("Supermercado São João", "Supermercado","7:00 - 18:00", 23L,6L));
		repository.save(new PontoInteresse("Minuetto", "Churrascaria","7:00 - 18:00", 28L,2L));

	}
}
