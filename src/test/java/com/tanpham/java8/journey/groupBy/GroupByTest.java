package com.tanpham.java8.journey.groupBy;

import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;

import com.tanpham.java8.journey.model.BlogPost;
import com.tanpham.java8.journey.model.BlogPostType;
import com.tanpham.java8.journey.model.Tuple;

public class GroupByTest {

	private List<BlogPost> blogPosts;
	
	// 1 Tan Pham, 1 Lunar, 2 Sonar, 5 Saturn
	@Before
	public void init() {
		blogPosts = new ArrayList<>();
		BlogPost post1 = new BlogPost();
		post1.setId(1L);
		post1.setAuthor("Tan Pham");
		post1.setTitle("Java 8 journey");
		post1.setLikes(100);
		post1.setType(BlogPostType.NEWS);
		blogPosts.add(post1);
		
		BlogPost post2 = new BlogPost();
		post2.setId(2L);
		post2.setAuthor("Lunar");
		post2.setTitle("Journey to the moon");
		post2.setLikes(150);
		post2.setType(BlogPostType.NEWS);
		blogPosts.add(post2);
		
		BlogPost post3 = new BlogPost();
		post3.setId(3L);
		post3.setAuthor("Sonar");
		post3.setTitle("Journey to the sun");
		post3.setLikes(210);
		post3.setType(BlogPostType.NEWS);
		blogPosts.add(post3);
		
		BlogPost post4 = new BlogPost();
		post4.setId(4L);
		post4.setAuthor("Saturn");
		post4.setTitle("Journey to the Sat");
		post4.setLikes(250);
		post4.setType(BlogPostType.GUIDE);
		blogPosts.add(post4);
		
		BlogPost post5 = new BlogPost();
		post5.setId(5L);
		post5.setAuthor("Saturn");
		post5.setTitle("Welcome to Sat");
		post5.setLikes(255);
		post5.setType(BlogPostType.REVIEW);
		blogPosts.add(post5);
		
		
		BlogPost post6 = new BlogPost();
		post6.setId(6L);
		post6.setAuthor("Sonar");
		post6.setTitle("Welcome to Eclipse");
		post6.setLikes(255);
		post6.setType(BlogPostType.REVIEW);
		blogPosts.add(post6);
		
		
		BlogPost post7 = new BlogPost();
		post7.setId(7L);
		post7.setAuthor("Saturn");
		post7.setTitle("Welcome to Sat 2");
		post7.setLikes(295);
		post7.setType(BlogPostType.REVIEW);
		blogPosts.add(post7);
		
		BlogPost post8 = new BlogPost();
		post8.setId(7L);
		post8.setAuthor("Saturn");
		post8.setTitle("Welcome to Sat 3");
		post8.setLikes(295);
		post8.setType(BlogPostType.REVIEW);
		blogPosts.add(post8);
		
		BlogPost post9 = new BlogPost();
		post9.setId(7L);
		post9.setAuthor("Saturn");
		post9.setTitle("Welcome to Sat 4");
		post9.setLikes(295);
		post9.setType(BlogPostType.REVIEW);
		blogPosts.add(post9);
	}
	
	@Test
	public void simpleGroupBy__only_1Property__byAuthorName() {
		Map<String, List<BlogPost>> result = blogPosts.stream().collect(Collectors.groupingBy(BlogPost::getAuthor));
		
		assertThat(result.size(), Matchers.equalTo(4));
		assertThat(result.get("Saturn"), Matchers.notNullValue());
		assertThat(result.get("Saturn").size(), Matchers.equalTo(5));
	}
	
	@Test
	public void complexGroupBy__multipleProperties__byAuthorAndType() {
		Map<Tuple, List<BlogPost>> result = blogPosts.stream()
				.collect(Collectors.groupingBy(post -> new Tuple(post.getAuthor(), post.getType())));
		
		assertThat(result.size(), Matchers.equalTo(6));
		assertThat(result.get(new Tuple("Saturn", BlogPostType.GUIDE)).size(), Matchers.equalTo(1));
		assertThat(result.get(new Tuple("Saturn", BlogPostType.REVIEW)).size(), Matchers.equalTo(4));
	}
	
}
