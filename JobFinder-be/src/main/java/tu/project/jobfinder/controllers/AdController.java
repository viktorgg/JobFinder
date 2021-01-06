package tu.project.jobfinder.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tu.project.jobfinder.entities.Ad;
import tu.project.jobfinder.repositories.AdRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
@CrossOrigin
@RestController
@RequestMapping("ad")
public class AdController {

    @Autowired
    AdRepository adRepository;

    @GetMapping("/all")
    public List<Ad> getAllAds() {
        return adRepository.findAll();
    }

    @GetMapping("/{id}")
    public Ad getAdById(@PathVariable Long id) {
        Optional<Ad> result = adRepository.findById(id);
        return result.isPresent() ? result.get() : null;
    }

    @GetMapping("/title/{title}")
    public ResponseEntity<?> getAdByTitle(@PathVariable(required = false) String title) {
        if (title == null || title.isBlank()) {
            return ResponseEntity.ok().body("No title inserted!");
        }
        Optional<Ad> result = adRepository.findAdByTitle(title.toLowerCase());
        return result.isPresent() ? ResponseEntity.ok(result.get()) : ResponseEntity.ok("No Ad found!");
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveAd(@RequestParam(required = false) Long id,
                                    @RequestParam(required = false) String title,
                                    @RequestParam(required = false) String description,
                                    @RequestParam(required = false) String company_name) {

        boolean isNew = id == null;

        Ad ad = new Ad(id, title, description, company_name);
        ad = adRepository.save(ad);

        Map<String, Object> response = new HashMap<>();
        response.put("generatedId", ad.getId());
        response.put("generatedTitle", ad.getTitle());
        response.put("generatedDescription", ad.getDescription());
        response.put("generatedCompanyName", ad.getCompany_name());
        if (isNew) {
            response.put("message", "Successfully added!");
        } else {
            response.put("message", "Successfully edited!");
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAd(@PathVariable Long id) {

        if (!adRepository.existsById(id)) {
            return ResponseEntity.ok("No such Ad!");
        }
        adRepository.deleteById(id);
        return ResponseEntity.ok("Deleted successfully!");
    }
}
