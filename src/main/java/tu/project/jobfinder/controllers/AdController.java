package tu.project.jobfinder.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tu.project.jobfinder.entities.Ad;
import tu.project.jobfinder.repositories.AdRepository;

import java.util.List;

@RestController
@RequestMapping("ad")
public class AdController {

    @Autowired
    AdRepository adRepository;

    @GetMapping("/all")
    public List<Ad> getAllAds(){
        return adRepository.findAll();
    }

}
