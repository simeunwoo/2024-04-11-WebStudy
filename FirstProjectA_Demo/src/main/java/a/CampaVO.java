package a;

import lombok.Data;

@Data
public class CampaVO {

	private int camp_no,camp_price;
	private String camp_name,camp_addr,camp_phone,camp_content,
		camp_image,camp_wifi,camp_store,camp_animal;
}
