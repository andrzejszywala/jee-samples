package pl.andrzejszywala.samples.patterns.builder.media.parts;

public class MediaItem {
	private String s;

	public MediaItem(String s) {
		super();
		this.s = s;
	}
	
	@Override
	public String toString() {
		return s;
	}
}
