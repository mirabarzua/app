package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @Autowired
    UserService us;
    private Persona persona;
    private String error;


    @GetMapping("/login")
    public String login(Model model) {
        
        model.addAttribute("error", error);
        return "login";
    }

    @PostMapping("/login")
    public String loginSubmit(String username, String password) {
        
        if (isValidUser(username, password)) {
            // Redirect to a success page
            persona = us.obtenerUsuarioPorRut(username);
            return "redirect:/dashboard";
        } else {
            // Redirect to a login error page
            error = "Credenciales incorrectas";
            return "redirect:/login?error";
        }
    }

    private boolean isValidUser(String username, String password) {
       return us.validarCredenciales(username, password);
       
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        model.addAttribute("persona", persona);
        return "dashboard";
    }

}
