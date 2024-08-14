package b;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ImageCrawler {

    private static final String BASE_URL = "https://www.5gcamp.com/?c=camp&p=";

    public static void main(String[] args) {
        int startPage = 1; // 시작 페이지 번호
        int endPage = 10;  // 끝 페이지 번호

        List<ImageData> allImages = new ArrayList<>();

        for (int pageNumber = startPage; pageNumber <= endPage; pageNumber++) {
            String url = BASE_URL + pageNumber;
            System.out.println("Fetching images from " + url);

            try {
                List<ImageData> images = fetchImages(url);
                allImages.addAll(images);
            } catch (IOException e) {
                System.err.println("Failed to fetch images from " + url);
                e.printStackTrace();
            }
        }

        // 결과 출력
        for (ImageData image : allImages) {
            System.out.println("Large Image: " + image.getLargeImageUrl());
            System.out.println("Small Image: " + image.getSmallImageUrl());
            System.out.println("---");
        }
    }

    private static List<ImageData> fetchImages(String url) throws IOException {
        List<ImageData> imageList = new ArrayList<>();
        Document doc = Jsoup.connect(url).get();

        Elements imageElements = doc.select(".timg a");
        for (Element imgLink : imageElements) {
            String largeImageUrl = imgLink.attr("href");
            String smallImageUrl = imgLink.select("img").attr("src");
            imageList.add(new ImageData(largeImageUrl, smallImageUrl));
        }

        return imageList;
    }

    static class ImageData {
        private final String largeImageUrl;
        private final String smallImageUrl;

        public ImageData(String largeImageUrl, String smallImageUrl) {
            this.largeImageUrl = largeImageUrl;
            this.smallImageUrl = smallImageUrl;
        }

        public String getLargeImageUrl() {
            return largeImageUrl;
        }

        public String getSmallImageUrl() {
            return smallImageUrl;
        }
    }
}
