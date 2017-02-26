package pl.andrzejszywala.samples.patterns.builder.media.directors;

import java.util.Iterator;
import java.util.List;

import pl.andrzejszywala.samples.patterns.builder.media.builders.MediaBuilder;
import pl.andrzejszywala.samples.patterns.builder.media.parts.MediaItem;
import pl.andrzejszywala.samples.patterns.builder.media.products.Media;

public class MediaDirector { // a.k.a. "Context"
	private MediaBuilder mb;

	public MediaDirector(MediaBuilder mb) {
		this.mb = mb; // Strategy-ish
	}

	public Media produceMedia(List input) {
		mb.buildBase();
		for (Iterator it = input.iterator(); it.hasNext();)
			mb.addMediaItem((MediaItem) it.next());
		return mb.getFinishedMedia();
	}
};