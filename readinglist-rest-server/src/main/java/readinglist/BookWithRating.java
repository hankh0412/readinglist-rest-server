package readinglist;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "BookWithRating", types = { Book.class }) 
interface BookWithRating { 

  Integer getRating(); 

  Book getBook(); 
}
