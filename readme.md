##TEST
  1.一般测试
  
     需要注解配置
     @RunWith(SpringRunner.class)
     @SpringBootTest
     

 2.测试controller
 
    配置@TestConfiguration仅在测试环境起效
    测试类 @SpringBootTest(classes=ApplicationConfig.class)
    使用Assert.assertNotNull(context.getBean(ApplicationConfig.class));

 3.测试接口mock
 
    使用@MockBean
    假设创建一个admin, 返回一个admin
    BDDMockito.given(login.createName("admin")).willReturn("admin");
    BDDMockito.given(login.createName("")).willReturn("");
    BDDMockito.given(login.createName(null)).willThrow(NullPointerException.class);
    Assert.assertEquals("admin",login.createName("admin"));
    Assert.assertEquals("",login.createName(""));
    Assert.assertEquals(null,login.createName(null));
   

 4.测试web
 
 第一种
 
    1.使用@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
    2.注入
        @Autowired
        private TestRestTemplate testRestTemplate;
    3.调用String body = testRestTemplate.getForObject("/show?name=wnagxuan", String.class);
 
 第二种
 
    1.@WebMvcTest(controllers= WebHome.class)仅仅加载测试的controller
    2.注入
      @Autowired
      private MockMvc mvc;
      mvc.perform(MockMvcRequestBuilders.get("/show").param("name","wangxaun")).andExpect(MockMvcResultMatchers.status().isOk());
 
 第三种
 
   
        1.@SpringBootTest
        2.@AutoConfigureMockMvc
        3.注入
        @Autowired
        private MockMvc mvc;
        mvc.perform(MockMvcRequestBuilders.get("/show").param("name","wangxaun")).andExpect(MockMvcResultMatchers.status().isOk());
         
    
    