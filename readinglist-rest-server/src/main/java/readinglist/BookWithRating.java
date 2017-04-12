package readinglist;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "BookWithRating", types = { Book.class }) 
interface BookWithRating { 

  Float getRating(); 
  
  String getReview();

  Book getBook(); 
}
