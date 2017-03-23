package readinglist;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
class ReadingListRestController {

	@Autowired
	private ReadingListRepository readingListRepository;
	
	@Autowired
	private BookRepository bookRepository;


	@CrossOrigin(origins = "http://localhost:8002")
	@RequestMapping(method = RequestMethod.GET)
	//Iterable<ReadingList> getBooks(@PageableDefault(sort = { "readinglist_id" }, direction = Direction.DESC, size = 2) Pageable pageable) {
	Page<Book> getBooks(Pageable pageable) {
		
		return this.bookRepository.findAll(pageable);
	}
	
	
	@CrossOrigin(origins = "http://localhost:8002")
	@RequestMapping(method = RequestMethod.GET, value = "/{bookId}")
	List<ReadingList> getReadingList(@PathVariable Long bookId) {
		Book book = new Book();
		book.setBook_id(bookId);
		return this.readingListRepository.findByBook(book);
	}
	
	

/*
	@RequestMapping(method = RequestMethod.GET, value = "/{bookmarkId}")
	Bookmark readBookmark(@PathVariable String userId, @PathVariable Long bookmarkId) {
		this.validateUser(userId);
		return this.bookmarkRepository.findOne(bookmarkId);
	}

	private void validateUser(String userId) {
		this.accountRepository.findByUsername(userId).orElseThrow(
				() -> new UserNotFoundException(userId));
	}*/
}