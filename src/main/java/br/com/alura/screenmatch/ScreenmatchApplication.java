package br.com.alura.screenmatch;

import br.com.alura.screenmatch.model.DadosSerie;
import br.com.alura.screenmatch.service.ConsumoApi;
import br.com.alura.screenmatch.service.ConverterDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

    public static void main(String[] args) {

        SpringApplication.run(ScreenmatchApplication.class, args);
    }

    @Override
    public void run(String... args) {
        var consumoApi = new ConsumoApi();
        String json = consumoApi.obterDados("http://www.omdbapi.com/?t=gilmore+girls&apikey=4ffc513b");
        System.out.println(json);
//       json = consumoApi.obterDados("https://coffee.alexflipnote.dev/random.json");
//        System.out.println(json);
        ConverterDados con = new ConverterDados();
        DadosSerie dados = con.obterDados(json, DadosSerie.class);
        System.out.println(dados);
    }
}
