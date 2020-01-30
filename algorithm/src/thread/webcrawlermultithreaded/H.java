package thread.webcrawlermultithreaded;

import java.util.List;

interface HtmlParser {
	public List<String> getUrls(String url);
}