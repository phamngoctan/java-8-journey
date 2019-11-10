package com.tanpham.java8.journey.model;

import java.util.HashMap;
import java.util.Map;

public class PostStatistic {
	private Map<BlogPostType, Integer> typeStatistic = new HashMap<>();
	private Map<String, Integer> authorStatistic = new HashMap<>();
	private int totalLikes;

	public int getTotalLikes() {
		return totalLikes;
	}

	public void setTotalLikes(int totalLikes) {
		this.totalLikes = totalLikes;
	}

	public Map<BlogPostType, Integer> getTypeStatistic() {
		return typeStatistic;
	}

	public void setTypeStatistic(Map<BlogPostType, Integer> typeStatistic) {
		this.typeStatistic = typeStatistic;
	}

	public Map<String, Integer> getAuthorStatistic() {
		return authorStatistic;
	}

	public void setAuthorStatistic(Map<String, Integer> authorStatistic) {
		this.authorStatistic = authorStatistic;
	}

	@Override
	public String toString() {
		return "TupleTypeStatistic [typeStatistic=" + typeStatistic + ", authorStatistic=" + authorStatistic
				+ ", totalLikes=" + totalLikes + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((authorStatistic == null) ? 0 : authorStatistic.hashCode());
		result = prime * result + totalLikes;
		result = prime * result + ((typeStatistic == null) ? 0 : typeStatistic.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PostStatistic other = (PostStatistic) obj;
		if (authorStatistic == null) {
			if (other.authorStatistic != null)
				return false;
		} else if (!authorStatistic.equals(other.authorStatistic))
			return false;
		if (totalLikes != other.totalLikes)
			return false;
		if (typeStatistic == null) {
			if (other.typeStatistic != null)
				return false;
		} else if (!typeStatistic.equals(other.typeStatistic))
			return false;
		return true;
	}

}
