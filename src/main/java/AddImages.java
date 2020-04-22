import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;

public class AddImages extends HttpServlet{
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("image/jpg");
        OutputStream out = response.getOutputStream();
        try {
            // Тут можн загрузить файл с диска не через URL а напрямую - сами найдете
            URL imageURL = AddImages.class.getResource("insurants.jpg");
            BufferedImage bi = ImageIO.read(imageURL);
            ImageIO.setUseCache(false);
            ImageIO.write(bi, "jpg", out);
        } finally {
            out.close();
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
}

