package HomeWork;

public class DVDMovie extends Movie implements HomeWork.DVD {
	private int regionCode;
	private String[] audioTracks;
	private String[] subtitles;

	public DVDMovie(String initialTitle , String[] initialActors , String initialDirector , int initialRegionCode , String[] initialAudioTracks , String[] initialSubtitles){
		super(initialTitle , initialActors , initialDirector);
		this.regionCode = initialRegionCode;
		this.audioTracks = initialAudioTracks;
		this.subtitles = initialSubtitles;
	}

	@Override
	public int getRegionCode(){
		return regionCode;
	}
	@Override

	public String[] getAudioTracks(){
		return audioTracks;
	}

	@Override
	public String[] getSubtitles(){
		return subtitles;
	}

	@Override
	public String toString(){
		return super.getTitle()+","+getRegionCode();
	}
}
