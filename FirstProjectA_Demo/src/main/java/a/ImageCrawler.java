package a;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ImageCrawler {
    
    public static void main(String[] args) {
        final String baseUrl = "https://www.5gcamp.com/?c=camp&p=";
        final int startPage = 1;  // 시작 페이지 번호
        final int endPage = 235;    // 끝 페이지 번호
        List<String> imageUrls = new ArrayList<>();

        for (int i = startPage; i <= endPage; i++) {
            String url = baseUrl + i;
            System.out.println("Crawling page: " + url);

            try {
                Document doc = Jsoup.connect(url).get();
                Elements imgElements = doc.select("img"); // 모든 <img> 태그 선택

                for (Element img : imgElements) {
                    String imgSrc = img.absUrl("src"); // 이미지 URL
                    // 이미지 URL이 빈 문자열이 아닌 경우만 추가
                    if (!imgSrc.isEmpty() && !imgSrc.contains("small")) {
                        imageUrls.add(imgSrc);
                        System.out.println("Found image: " + imgSrc);
                    }
                }

            } catch (IOException e) {
                System.err.println("Error connecting to " + url);
                e.printStackTrace();
            }
        }

        // 크롤링된 이미지 URL을 출력
        System.out.println("Crawled image URLs:");
        for (String imageUrl : imageUrls) {
            System.out.println(imageUrl);
        }

        // 예: 데이터베이스에 저장 등의 후처리 작업
        // storeImageUrlsInDatabase(imageUrls);
    }

    // 데이터베이스에 이미지 URL을 저장하는 예시 메서드
    private static void storeImageUrlsInDatabase(List<String> imageUrls) {
        // 데이터베이스 연결 및 저장 로직 구현
        // 예: JDBC를 사용하여 이미지 URL을 데이터베이스에 저장
    }
}
