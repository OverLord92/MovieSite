package com.movies.dao;

public class Movie {
	
	private int id;
	
//	@NotBlank
	private String name;
	
//	@NotNull
//	@Range(min = 1896, max = 2015)
	private int year;
	
//	@NotBlank
//	@Size(min=5, max=20)
	private String genre;
	
//	@NotBlank
//	@Size(min=5, max=20)
	private String director;
	
//	@NotNull
//	@DecimalMin("0")
	private int runtime;
	
	public Movie(){
	}
	
	public Movie(String name, int year, String genre, String director, int runtime) {
		this.name = name;
		this.year = year;
		this.genre = genre;
		this.director = director;
		this.runtime = runtime;
	}
	
	public Movie(int id, String name, int year, String genre, String director, int runtime) {
		this.id = id;
		this.name = name;
		this.year = year;
		this.genre = genre;
		this.director = director;
		this.runtime = runtime;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public int getRuntime() {
		return runtime;
	}
	public void setRuntime(int runtime) {
		this.runtime = runtime;
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", name=" + name + ", year=" + year + ", genre=" + genre + ", director=" + director
				+ ", runtime=" + runtime + "]";
	}
	
}
