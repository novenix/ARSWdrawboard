package edu.escuelaing.edu.co;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@RestController
public class WhiteBoardAppController
{
    @PostMapping("/reset")
    public void resetBoard(){
        Memory.getInstance().restart();
    }
    @PostMapping("/point")
    public void savePoints(@RequestBody List<Integer> draw){
        Memory.getInstance().addDraw(draw);
    }
    @GetMapping("/point")
    public List<List<Integer>> getDraws (){
        return Memory.getInstance().getDraws();
    }
    @GetMapping("/getusercolor")
    public HashMap getColorSession(){
        String name = (String )request.getSession().getAttribute("name");
        return Memory.getInstance().getUserSession(name);
    }
    @Resource
    private HttpServletRequest request;

    @GetMapping("/draw")
    public List<List<Integer>> getPointsToDraw(){
        return Memory.getInstance().getDraws();
    }

    @GetMapping("/status")
    public String status() {
        getSession();
        String name = (String) request.getSession().getAttribute("name");
        return "{\"status\":\"Greetings from Spring Boot. " +
                name + ". " +
                java.time.LocalDate.now() + ", " +
                java.time.LocalTime.now() +
                ". " + "The server is Runnig!\"}";
    }
    private void getSession() {
        System.out.println(Memory.getInstance().toString());
    }
    @GetMapping("/setname")
    public String setName(@RequestParam(value = "name", defaultValue =
            "Anónimo") String name) {
        request.getSession().setAttribute("name", name);
        return String.format("Hello %s!", name);
    }

    public static void main( String[] args )
    {
        SpringApplication.run(WhiteBoardAppController.class, args);
    }
}
