package com.cameon8868.emsbackend.Controller;

import com.cameon8868.emsbackend.database.VulnerableLoginDao;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class VulnerableTestController {
    
    private final VulnerableLoginDao vulnerableLoginDao;
    
    public VulnerableTestController(VulnerableLoginDao vulnerableLoginDao) {
        this.vulnerableLoginDao = vulnerableLoginDao;
    }

    @PostMapping("/vulnerable-login")
    public String handleVulnerableLogin(@RequestParam String login, @RequestParam String password) {
        List<?> users = vulnerableLoginDao.findByLoginAndPassword(login, password);

        if (users.isEmpty()) {
            return "Invalid login or password";
        }
        return "redirect:/general?username=" + login;
    }
}
