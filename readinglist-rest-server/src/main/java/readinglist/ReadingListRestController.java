package readinglist;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

@RepositoryRestController
@RequestMapping("/")
class ReadingListRestController {

	@Autowired
	private ReadingListRepository readingListRepository;
	
	@Autowired
	private BookRepository bookRepository;

	@CrossOrigin(origins = "http://localhost:8002")
	@RequestMapping(method = RequestMethod.GET)
	ResponseEntity<?>  getBooks(Pageable pageable) {
		Page<BookWithRating> books = bookRepository.findAllWithRating(pageable);
		return ResponseEntity.ok(books);
	}
	
	@CrossOrigin(origins = "http://localhost:8002")
	@RequestMapping(method = RequestMethod.GET, value = "/{bookId}")
	List<ReadingList> getReadingList(@PathVariable Long bookId) {
		Book book = new Book();
		book.setBook_id(bookId);
		return this.readingListRepository.findByBook(book);
	}
	
}