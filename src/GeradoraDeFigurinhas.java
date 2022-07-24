import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;


public class GeradoraDeFigurinhas {

    private  void  printSimpleString ( Graphics2D  g2d , String  s , int  width , int  XPos , int  YPos ){
        int  stringLen = ( int )
            g2d . getFontMetrics (). getStringBounds ( s , g2d ). getWidth();
        int  start = width/2 - stringLen / 2 ;
        g2d . drawString ( s , start + XPos , YPos );
	}        

    public void cria(InputStream inputStream,String nomeArquivo) throws IOException {

     BufferedImage imagemOriginal = ImageIO.read(inputStream);
     int largura = imagemOriginal.getWidth();
     int altura = imagemOriginal.getHeight();
     int novaAltura = altura + 200;
     

     BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);
     Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
     graphics.drawImage(imagemOriginal, 0, 0, null);

         var fonte = new Font("Comic Sans MS",Font.BOLD,70);
     graphics.setColor(Color.yellow);
     graphics.setFont(fonte);
     
     
     printSimpleString(graphics,"Topzera", largura, 0, novaAltura - 100);
        
     ImageIO.write(novaImagem, "png", new File(nomeArquivo));

    
    }

    
}
