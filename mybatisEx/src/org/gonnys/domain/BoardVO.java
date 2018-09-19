package org.gonnys.domain;

import java.sql.Date;
import lombok.Data;

@Data
public class BoardVO {
	
	private Integer bno, viewcnt;
	private String title, content, writer;
	private Date regdate, updatedate;

}
