package uz.muhammadtrying.tourfirmproject.service;

import org.springframework.stereotype.Service;
import uz.muhammadtrying.tourfirmproject.entity.TourPackage;

import java.util.List;

@Service
public interface TourPackageService {
    List<TourPackage> findAll();

    void deleteById(Integer packageId);

    void alterStatus(Integer packageId);

    void save(String place, String duration, String time, String price, String description, String imageUrl);

    TourPackage findById(Integer packageId);

    void update(Integer packageId, String place, String duration, String time, String price, String description, String imageUrl);
}
