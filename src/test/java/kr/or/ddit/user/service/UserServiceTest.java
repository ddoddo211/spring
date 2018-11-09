package kr.or.ddit.user.service;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import kr.or.ddit.test.ServiceDaoTestConfig;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.UserService;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class UserServiceTest extends ServiceDaoTestConfig {
	//junit 실행주기
	// @BeforeClass 이 적용된 메소드 실행(최초1회) , 단 static 메서드로 선언해야한다
	// @Before 어노테이션이 적용된 메서드 실행(테스트 메서드 실행전 매번 실행)
	// @Test
	// @After 어노테이션이 적용된 메서드 실행(테스트 메서드 실행 후 실행)
	// @AfterClass 어노테이션이 적용된 메서드 실행(최초 1회) , 단 static 메서드로 선언해야한다
	
	@Resource(name="userService")
	private UserService us;
	
	@BeforeClass
	public static void beforeClass(){
		System.out.println("beforeclass");
	}
	
	@AfterClass
	public static void afterClass(){
		System.out.println("afterClass");
	}
	
	@Before
	public void before(){
		System.out.println("before");
		
	
	}
	
	@After
	public void after(){
		System.out.println("after");
	}

	@Test
	public void selectUserAllTest() {
		/***Given***/
		

		/***When***/
		List<UserVo> userList = us.selectUserAll();
		
		for(UserVo uv : userList){
			System.out.println(uv);
		}

		/***Then***/
		assertEquals(110, userList.size());
		
		
		
	}
	
	@Test
	public void selectUserByIdTest(){
		/***Given***/
		

		/***When***/
		UserVo uv = us.selectUser("brown");
		System.out.println(uv);

		/***Then***/
		assertEquals("brown", uv.getUserId());
		assertEquals("브라운", uv.getName());

		
		
		
	}
	
	@Test
	public void selectUserByVoTest(){
		
		/***Given***/
		

		/***When***/
		UserVo brown = new UserVo();
		brown.setUserId("brown");
		UserVo uv = us.selectUser(brown);
		System.out.println(uv);

		/***Then***/
		assertEquals("brown", uv.getUserId());
		assertEquals("브라운", uv.getName());

		
	}

}
