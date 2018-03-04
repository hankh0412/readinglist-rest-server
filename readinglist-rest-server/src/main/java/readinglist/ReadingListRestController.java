package readinglist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
class ReadingListRestController {

    @Autowired
    private ReadingListRepository readingListRepository;

    @Autowired
    private BookRepository bookRepository;

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET)
    Page<BookWithRating> getBooks(Pageable pageable) {
        return this.bookRepository.findAllWithRating(pageable);
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, value = "/{bookId}")
    List<ReadingList> getReadingList(@PathVariable Long bookId) {
        Book book = new Book();
        book.setBook_id(bookId);
        return this.readingListRepository.findByBook(book);
    }

}