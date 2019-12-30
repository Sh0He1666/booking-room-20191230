package mrs.domain.model;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

import mrs.domain.model.*;

public class ReservableRoomIdTest {
	
	private Integer roomId;
	private LocalDate reservedDate;
	
	Integer roomId1 = 1111;
	Integer roomId2 = 1222;
	Integer roomId3 = 1111;
	
	LocalDate date1 = LocalDate.of(2019, 12, 18);
	LocalDate date2 = LocalDate.of(2019, 12, 12);
	LocalDate date3 = LocalDate.of(2019, 12, 18);
	
	
	@Test
	public void test1() {
		
		//テスト用のクラス変数を生成します
		ReservableRoomId rri1 = new ReservableRoomId(roomId1, date1);
		ReservableRoomId rri2 = new ReservableRoomId(roomId2, date2);	
		
		//ENV
		boolean expectedTrue = true;
		boolean expectedFalse = false;
		
		//ACT
		assertEquals(rri1.equals(rri2), expectedFalse);
	}

}
