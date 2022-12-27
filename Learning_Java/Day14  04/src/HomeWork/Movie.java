package HomeWork;

public abstract class Movie {
	private String title;
	private String[] actors;
	private String director;

	public Movie(String initialTitle , String[] initialActors , String initialDirector){
		this.title = initialTitle;
		this.actors = initialActors;
		this.director = initialDirector;
	}

	public String getTitle(){
		return title;
	}

	public String[] getActors(){
		return actors;
	}

	public String getDirector(){
		return director;
	}

	@Override
	public String toString(){
		return title;
	}
}

