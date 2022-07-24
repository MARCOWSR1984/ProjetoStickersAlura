import java.io.InputStream;
import java.net.URL;
import java.util.List;


public class App {
    public static void main(String[] args) throws Exception {

       //String url = "https://imdb-api.com/en/API/Top250Movies/k_czw6w2c0";   
       //ExtratorDeConteudo extrator = new ExtratorDeConteudoDoIMDB();


       //String url = "https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY&start_date=2022-6-12&end_date=2022-06-14";
       //ExtratorDeConteudo extrator = new ExtratorDeConteudoDaNasa();

       String url = "https://aluramwsr-linguagens-api.herokuapp.com/linguagens";
       ExtratorDeConteudo extrator = new ExtratorDeConteudoDoIMDB();

       var http = new ClientHttp();
       String json = http.buscaDados(url);

       
       
       List<Conteudo> conteudos = extrator.extraiConteudos(json);
       var geradora = new GeradoraDeFigurinhas();
       
       for (int i = 0; i < 3; i++) {

          Conteudo conteudo = conteudos.get(i);
        
          InputStream inputStream = new URL(conteudo.getUrlImagem()).openStream();
          String nomeArquivo = "saida/" + conteudo.getTitulo() + ".png";

          geradora.cria(inputStream, nomeArquivo);

        
          System.out.println(conteudo.getTitulo());
          System.out.println();
       
       }
    }
}
