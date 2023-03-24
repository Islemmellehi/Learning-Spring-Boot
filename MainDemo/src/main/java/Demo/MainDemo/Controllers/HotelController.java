package Demo.MainDemo.Controllers;

import Demo.MainDemo.Models.Hotel;
import Demo.MainDemo.Repositories.Hotelrepos;
import Demo.MainDemo.ServiceImp.HotelServiceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RequestMapping
@RestController
public class HotelController {
    @Autowired
    private Hotelrepos HotelRepos;

    @GetMapping("/hotels")
    public List<Hotel> getAllHotels() {
        return HotelRepos.findAll();
    }

    @GetMapping("/hotels/{id}")
    public ResponseEntity<Hotel> getHotelById(@PathVariable Long id) {
        Hotel hotel = HotelRepos.findById(id).orElse(null);
        if (hotel == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(hotel);
    }

    @PostMapping("/add")
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel) {
        Hotel savedHotel = HotelRepos.save(hotel);
        return ResponseEntity.ok(savedHotel);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteHotel(@PathVariable("id") Long id) {
        HotelRepos.deleteById(id);
        return ResponseEntity.noContent().build();
    }


    @PutMapping("/hotels/{id}/name")
    public ResponseEntity<Hotel> updateResourceProperty1(@PathVariable("id") Long id, @RequestBody String Name) {
        Optional<Hotel> optionalHotel = HotelRepos.findById(id);
        if (optionalHotel.isPresent()) {
            Hotel hotel = optionalHotel.get();
            hotel.setHotelName(Name);
            HotelRepos.save(hotel);
            return ResponseEntity.ok(hotel);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
