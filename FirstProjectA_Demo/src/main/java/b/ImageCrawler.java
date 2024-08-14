package b;

import b.CampImageDAO;
import b.CampImageVO;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class ImageCrawlerr {

    public static void main(String[] args) {
        ImageCrawler mc = new ImageCrawler();
        mc.campData();
    }

    public void campData() {
        CampImageDAO dao = CampImageDAO.newInstance();
        try {
            int k = 1;
            for (int i = 1; i <= 200; i++) {
                Document doc = Jsoup.connect("https://www.5gcamp.com/?c=camp&p=" + i).get();
                Elements link = doc.select("div.contright div.subject a");

                for (int j = 0; j < link.size(); j++) {
                    try {
                        System.out.println("번호:" + k++);
                        String url = link.get(j).attr("href");
                        if (!url.contains("http")) {
                            url = "http://www.5gcamp.com" + link.get(j).attr("href");
                        }
                        Document doc2 = Jsoup.connect(url).get();

                        Elements images = doc2.select("div.photos div.timg a");
                        List<String> imageList = new ArrayList<>();
                        for (Element img : images) {
                            imageList.add(img.attr("href"));
                        }

                        CampImageVO vo = new CampImageVO();
                        vo.setNo(k);  // 번호 설정
                        
                        // 첫 번째부터 10번째 이미지까지 차례로 설정
                        String[] imageArray = new String[10];
                        String[] imageThumbArray = new String[10];
                        for (int idx = 0; idx < 10; idx++) {
                            if (idx < imageList.size()) {
                                imageArray[idx] = imageList.get(idx);
                                imageThumbArray[idx] = "thumb_" + imageList.get(idx); // 가정된 썸네일 이름
                            } else {
                                // 이전 이미지로 채움 (만약 앞의 이미지들도 없다면 기본 이미지 사용)
                                imageArray[idx] = (idx > 0 && imageArray[idx - 1] != null) ? imageArray[idx - 1] : "no_image_available.jpg";
                                imageThumbArray[idx] = (idx > 0 && imageThumbArray[idx - 1] != null) ? imageThumbArray[idx - 1] : "no_image_available_thumb.jpg";
                            }
                        }

                        // 이미지 설정
                        vo.setImage1(imageArray[0]);
                        vo.setImage2(imageArray[1]);
                        vo.setImage3(imageArray[2]);
                        vo.setImage4(imageArray[3]);
                        vo.setImage5(imageArray[4]);
                        vo.setImage6(imageArray[5]);
                        vo.setImage7(imageArray[6]);
                        vo.setImage8(imageArray[7]);
                        vo.setImage9(imageArray[8]);
                        vo.setImage10(imageArray[9]);

                        // 썸네일 이미지 설정
                        vo.setImage1s(imageThumbArray[0]);
                        vo.setImage2s(imageThumbArray[1]);
                        vo.setImage3s(imageThumbArray[2]);
                        vo.setImage4s(imageThumbArray[3]);
                        vo.setImage5s(imageThumbArray[4]);
                        vo.setImage6s(imageThumbArray[5]);
                        vo.setImage7s(imageThumbArray[6]);
                        vo.setImage8s(imageThumbArray[7]);
                        vo.setImage9s(imageThumbArray[8]);
                        vo.setImage10s(imageThumbArray[9]);

                        dao.campInsert(vo);
                        System.out.println("캠핑장 이미지 저장 완료: " + url);

                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
            System.out.println("저장 완료!!");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
