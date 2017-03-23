package readinglist;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BookRepository extends PagingAndSortingRepository<Book, Long> {
	

	@Override
	@Query("select avg(rl.rating) as rating, max(rl.review) as review, b from ReadingList rl join rl.book b group by rl.book order by rating desc")
	Page<Book> findAll(Pageable pageable);
}
