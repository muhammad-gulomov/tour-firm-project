package uz.muhammadtrying.tourfirmproject.service;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import uz.muhammadtrying.tourfirmproject.entity.TourPackage;
import uz.muhammadtrying.tourfirmproject.repo.TourPackageRepo;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TourPackageServiceImpl implements TourPackageService {
    private final TourPackageRepo tourPackageRepo;

    @Override
    public List<TourPackage> findAll() {
        return tourPackageRepo.findAllByOrderByIdAsc();
    }

    @Override
    public void deleteById(Integer packageId) {
        TourPackage tourPackage = tourPackageRepo.findById(packageId).get();
        if (tourPackage.getDeleted()) {
            tourPackage.setDeleted(false);
        } else {
            tourPackage.setDeleted(true);
        }
        tourPackageRepo.save(tourPackage);
    }

    @Override
    public void alterStatus(Integer packageId) {
        TourPackage tourPackage = tourPackageRepo.findById(packageId).get();
        if (tourPackage.getArchived()) {
            tourPackage.setArchived(false);
        } else {
            tourPackage.setArchived(true);
        }
        tourPackageRepo.save(tourPackage);
    }

    @SneakyThrows
    @Override
    public void save(String place, String duration, String time, String price, String description, String image) {
        TourPackage tourPackage = TourPackage.builder()
                .place(place)
                .duration(duration)
                .time(time)
                .price(price)
                .archived(true)
                .description(description)
                .imageUrl(image)
                .build();
        tourPackageRepo.save(tourPackage);
    }

    @Override
    public TourPackage findById(Integer packageId) {
        return tourPackageRepo.findById(packageId).get();
    }

    @Override
    public void update(Integer packageId, String place, String duration, String time, String price, String description, String imageUrl) {
        TourPackage tourPackage = TourPackage.builder()
                .id(packageId)
                .place(place)
                .duration(duration)
                .time(time)
                .price(price)
                .archived(true)
                .description(description)
                .imageUrl(imageUrl)
                .build();
        tourPackageRepo.save(tourPackage);
    }
}
