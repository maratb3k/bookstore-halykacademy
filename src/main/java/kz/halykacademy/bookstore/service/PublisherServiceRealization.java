package kz.halykacademy.bookstore.service;
import kz.halykacademy.bookstore.dao.Publisher;
import kz.halykacademy.bookstore.exception.PublisherNotFoundException;
import kz.halykacademy.bookstore.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PublisherServiceRealization implements PublisherService {

    @Autowired
    private PublisherRepository publisherRepository;


    @Override
    public Publisher savePublisher(Publisher publisher) {
        return publisherRepository.save(publisher);
    }

    @Override
    public List<Publisher> savePublishers(List<Publisher> publishers) {
        return publisherRepository.saveAll(publishers);
    }

    @Override
    public Publisher getPublisher(long id) {
        return publisherRepository.findById(id).orElseThrow(() -> new PublisherNotFoundException("Publisher with id " + id + " was not found"));
    }

    @Override
    public List<Publisher> getPublishers() {
        return publisherRepository.findAll();
    }

    @Override
    public Publisher updatePublisher(Publisher publisher) {
        return publisherRepository.save(publisher);
    }

    @Override
    public String deletePublisher(long id) {
        publisherRepository.deleteById(id);
        return "Publisher with id " + id + " removed";
    }

    @Override
    public List<Publisher> findPublishersByName(String name) {
        return publisherRepository.findAllByNameContaining(name);
    }
}
