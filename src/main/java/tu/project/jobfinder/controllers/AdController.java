package tu.project.jobfinder.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tu.project.jobfinder.entities.Ad;
import tu.project.jobfinder.repositories.AdRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("ad")
public class AdController {

    @Autowired
    AdRepository adRepository;

    @GetMapping("/all")
    public List<Ad> getAllAds() {
        return adRepository.findAll();
    }

    @GetMapping("/id/{id}")
    public Ad getAdById(@PathVariable Long id){
        Optional<Ad> result = adRepository.findById(id);
        return result.isPresent()? result.get() : null;
    }

    @GetMapping("/title/{title}")
    public ResponseEntity<?> getAdByTitle(@PathVariable(required = false) String title){
        if(title == null || title.isBlank()){
            return ResponseEntity.ok().body("No title inserted!");
        }
        Optional<Ad> result = adRepository.findAdByTitle(title.toLowerCase());
        return result.isPresent()? ResponseEntity.ok(result.get()) : ResponseEntity.ok("No Ad found!");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAd(@PathVariable Long id){
        adRepository.deleteById(id);
        return ResponseEntity.ok("Deleted successfully!");
    }
}
