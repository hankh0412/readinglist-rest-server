package readinglist;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

//@RepositoryRestResource(collectionResourceRel = "books", path = "books")
public interface ReadingListRepository extends PagingAndSortingRepository<ReadingList, Long> {
	
	@Query("select rl from ReadingList rl join fetch rl.reader join fetch rl.book where rl.book = ?1 ")
	List<ReadingList> findByBook(Book book);

}