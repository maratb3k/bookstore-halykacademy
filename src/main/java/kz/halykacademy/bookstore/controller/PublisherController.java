package kz.halykacademy.bookstore.controller;


import kz.halykacademy.bookstore.dao.Publisher;
import kz.halykacademy.bookstore.service.PublisherServiceRealization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/publishers")
public class PublisherController {

    @Autowired
    private PublisherServiceRealization publisherService;

    @PostMapping(path = "/publisher")
    public Publisher addPublisher(@RequestBody Publisher publisher) {
        return publisherService.savePublisher(publisher);
    }

    @PostMapping
    public List<Publisher> addPublishers(@RequestBody List<Publisher> publishers) {
        return publisherService.savePublishers(publishers);
    }

    @GetMapping
    public List<Publisher> findAllPublishers() {
        return publisherService.getPublishers();
    }

    @GetMapping(value = "/publisher/{id}/")
    public Publisher findPublisherByID(@PathVariable long id) {
        return publisherService.getPublisher(id);
    }

    @PutMapping(value = "/{id}/")
    public Publisher updatePublisher(@PathVariable long id, @RequestBody Publisher publisher) {
        publisher.setId(id);
        return publisherService.updatePublisher(publisher);
    }

    @DeleteMapping(value = "/{id}/")
    public String deletePublisher(@PathVariable long id) {
        return publisherService.deletePublisher(id);
    }

    @GetMapping(value = "/{name}/")
    public List<Publisher> findPublishersByName(@PathVariable String name) {
        return publisherService.findPublishersByName(name);
    }

}
