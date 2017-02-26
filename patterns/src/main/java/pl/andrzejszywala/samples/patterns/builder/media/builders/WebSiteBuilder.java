package pl.andrzejszywala.samples.patterns.builder.media.builders;

import pl.andrzejszywala.samples.patterns.builder.media.parts.MediaItem;
import pl.andrzejszywala.samples.patterns.builder.media.products.Media;
import pl.andrzejszywala.samples.patterns.builder.media.products.WebSite;

public class WebSiteBuilder extends MediaBuilder {
	private WebSite w;

	public void buildBase() {
		System.out.println("Building web site framework");
		w = new WebSite();
	}

	public void addMediaItem(MediaItem webItem) {
		System.out.println("Adding web item " + webItem);
		w.add(webItem);
	}

	public Media getFinishedMedia() {
		return w;
	}
}