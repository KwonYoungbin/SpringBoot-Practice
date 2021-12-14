package com.springbootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.web.servlet.MockMvc;
import com.springbootTest.domain.BoardVO;
import com.springbootTest.service.BoardService;

//@WebMvcTest					컨트롤러만 테스트하기 위해서는 @WebMvcTest를 사용해야 함
@SpringBootTest(webEnvironment=WebEnvironment.MOCK)
@AutoConfigureMockMvc			// @AutoConfigureMockMvc는 컨트롤러뿐만 아니라 테스트 대상이 아닌 @Service나 @Repository가 붙은 객체들도 모두 메모리에 올림
//@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class BoardControllerTest {
//	@Autowired
//	private MockMvc mockMvc;
	
//	@Test
//	public void testHello() throws Exception{
//		mockMvc.perform(get("/hello").param("name","둘리"))
//		.andExpect(status().isOk())
//		.andExpect(content().string("Hello : 둘리"))
//		.andDo(print());
//	}

	
//	@Autowired
//	private TestRestTemplate restTemplace;
//	
//	@Test
//	public void testHello() throws Exception{
//		String result = restTemplace.getForObject("/hello?name=둘리", String.class);
//		assertEquals("Hello : 둘리", result);
//		System.out.println(result);
//	}
//	
//	@Test
//	public void testGetBoard() throws Exception{
//		BoardVO board = restTemplace.getForObject("/getBoard", BoardVO.class);
//		assertEquals("테스터", board.getWriter());
//		System.out.println(board.getWriter());
//	}
	
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private BoardService boardService;
	
	@Test
	public void testHello() throws Exception{
		when(boardService.hello("둘리")).thenReturn("Hello : 둘리");
		
		mockMvc.perform(get("/hello").param("name","둘리"))
		.andExpect(status().isOk())
		.andExpect(content().string("Hello : 둘리"))
		.andDo(print());
	}
}
