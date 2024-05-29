package uz.muhammadtrying.tourfirmproject.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uz.muhammadtrying.tourfirmproject.entity.Client;
import uz.muhammadtrying.tourfirmproject.service.ClientService;
import uz.muhammadtrying.tourfirmproject.service.CommentService;
import uz.muhammadtrying.tourfirmproject.service.TourPackageService;

@Controller
@RequiredArgsConstructor
@RequestMapping("/")
public class PageController {
    private final ClientService clientService;
    private final CommentService commentService;
    private final TourPackageService tourPackageService;

    @GetMapping
    public String index() {
        return "index";
    }

    @GetMapping("login")
    public String login() {
        return "login";
    }

    @GetMapping("contact")
    private String goToContactPage() {
        return "contact";
    }

    @PostMapping("leave/message")
    private String leaveMessage(
            @RequestParam String clientName,
            @RequestParam String clientPhone,
            @RequestParam String comment
    ) {
        if (clientName.isBlank() || clientPhone.isBlank()) {
            return "redirect:contact";
        }
        if (comment.isBlank()) {
            comment = "*COMMENT BO'SH KELDI* *INFO OLMOQCHI*";
        }

        Client savedClient = clientService.save(clientName, clientPhone);
        commentService.save(savedClient, comment);
        return "redirect:/";
    }

    @GetMapping("get/admin/page/csrf")
    private String goToAdminPage(Model model) {
        model.addAttribute("packages", tourPackageService.findAll());
        return "admin";
    }

    @GetMapping("get/further/details")
    private String goToFurtherDetailsPage(Model model) {
        model.addAttribute("packages", tourPackageService.findAll());
        return "further";
    }

    @GetMapping("go/to/delete")
    private String goToToDeletePage(Model model) {
        model.addAttribute("packages", tourPackageService.findAll());
        return "delete";
    }

    @GetMapping("delete/package/{packageId}")
    private String deletePackage(@PathVariable Integer packageId) {
        tourPackageService.deleteById(packageId);
        return "redirect:/go/to/delete";
    }

    @GetMapping("archive/package/{packageId}")
    private String archivePackage(@PathVariable Integer packageId, Model model) {
        tourPackageService.alterStatus(packageId);
        model.addAttribute("packages", tourPackageService.findAll());
        return "admin";
    }

    @GetMapping("add/package/tour")
    private String goToAddPackagePage() {
        return "add-package";
    }

    @PostMapping("add/package/db")
    private String addPackage(
            @RequestParam String place,
            @RequestParam String duration,
            @RequestParam String time,
            @RequestParam String price,
            @RequestParam String description,
            @RequestParam String imageUrl,
            Model model
    ) {
        tourPackageService.save(place, duration, time, price, description, imageUrl);
        model.addAttribute("packages", tourPackageService.findAll());
        return "redirect:/get/admin/page/csrf";
    }

    @GetMapping("view/deleted/packages")
    private String deletedPackages(Model model) {
        model.addAttribute("packages", tourPackageService.findAll());
        return "deleted-packages";
    }

    @GetMapping("edit/package/info/{packageId}")
    private String goToEditPackagePage(@PathVariable Integer packageId, Model model) {
        model.addAttribute("package", tourPackageService.findById(packageId));
        return "edit-package";
    }

    @PostMapping("update/package/db")
    private String updatePackage(
            @RequestParam String place,
            @RequestParam String duration,
            @RequestParam String time,
            @RequestParam String price,
            @RequestParam String description,
            @RequestParam String imageUrl,
            @RequestParam Integer packageId,
            Model model
    ) {
        tourPackageService.update(packageId,place, duration, time, price, description, imageUrl);
        model.addAttribute("packages", tourPackageService.findAll());
        return "redirect:/get/admin/page/csrf";
    }
}
