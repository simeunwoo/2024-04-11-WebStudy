package a;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ImageCrawler {

    private static final String DB_URL = "jdbc:oracle:thin:@211.238.142.124:1521:XE";
    private static final String DB_USER = "hr2";
    private static final String DB_PASSWORD = "happy";

    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            // Get valid camp_no values
            String query = "SELECT camp_no FROM camp";
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int campNo = rs.getInt("camp_no");

                for (int i = 1; i <= 316; i++) {
                    String url = "https://www.5gcamp.com/?c=camp&p=" + i;
                    try {
                        Document doc = Jsoup.connect(url).get();
                        Elements imgElements = doc.select("div.photos div.timg a");

                        // Create SQL insert statement
                        String insertSQL = "INSERT INTO image_camp (no, image1, image2, image3, image4, image5, image6, image7, image8, image9, image10, image1s, image2s, image3s, image4s, image5s, image6s, image7s, image8s, image9s, image10s) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

                        PreparedStatement insertStmt = conn.prepareStatement(insertSQL);
                        insertStmt.setInt(1, campNo);

                        int imgCount = imgElements.size();
                        for (int j = 0; j < imgCount; j++) {
                            Element imgElement = imgElements.get(j);
                            String largeImageUrl = imgElement.attr("href");
                            String smallImageUrl = imgElement.select("img").attr("src");

                            // Set values for the SQL insert statement
                            if (j < 5) {
                                insertStmt.setString(2 + j * 2, largeImageUrl);
                                insertStmt.setString(2 + j * 2 + 1, smallImageUrl);
                            } else if (j < 10) {
                                insertStmt.setString(7 + (j - 5) * 2, largeImageUrl);
                                insertStmt.setString(7 + (j - 5) * 2 + 1, smallImageUrl);
                            }
                        }

                        // Fill in nulls for any missing images
                        for (int k = imgCount; k < 10; k++) {
                            insertStmt.setNull(2 + k * 2, java.sql.Types.VARCHAR);
                            insertStmt.setNull(2 + k * 2 + 1, java.sql.Types.VARCHAR);
                        }

                        insertStmt.executeUpdate();
                        insertStmt.close();

                    } catch (Exception e) {
                        // Skip URLs that cause exceptions
                        System.out.println("Error processing URL: " + url);
                        e.printStackTrace();
                    }
                }
            }

            rs.close();
            stmt.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
