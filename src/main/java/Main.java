import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) throws IOException {
        Document doc = Jsoup.connect("https://web.archive.org/web/20140301191716/http://pokemondb.net/pokedex/national").get();

        Elements pokemonList = doc.select(".infocard-tall");
        for (Element pokemon : pokemonList) {
            Elements pokemonName = pokemon.select(".ent-name");
            Elements pokemonType = pokemon.select(".itype");
            System.out.print("{ \"" + pokemonName.text() + "\",");

            for (Element type : pokemonType) {
                System.out.print(" \"" + type.text() + "\",");
            }

            System.out.print(" },\n");
        }
    }
}