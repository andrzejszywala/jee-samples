package pl.andrzejszywala.samples.patterns.builder.media.builders;

import pl.andrzejszywala.samples.patterns.builder.media.parts.MediaItem;
import pl.andrzejszywala.samples.patterns.builder.media.products.Magazine;
import pl.andrzejszywala.samples.patterns.builder.media.products.Media;

public class MagazineBuilder extends MediaBuilder {
	private Magazine m;

	public void buildBase() {
		System.out.println("Building magazine framework");
		m = new Magazine();
	}

	public void addMediaItem(MediaItem article) {
		System.out.println("Adding article " + article);
		m.add(article);
	}

	public Media getFinishedMedia() {
		return m;
	}
}