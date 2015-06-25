import com.sample.controller.BusinessController;
import com.sun.org.apache.bcel.internal.classfile.Code;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.io.UnsupportedEncodingException;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

/**
 * Created with IntelliJ IDEA.
 * User: liuwang
 * Date: 15-6-25
 * Time: 上午2:03
 * To change this template use File | Settings | File Templates.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = { "classpath:spring.xml" })
public class BusinessControllerTest {
    @Autowired

    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Before

    public void setup() throws Exception {

        this.mockMvc = webAppContextSetup(this.wac).build();

    }


    @Test
    public void addBusinesstTest(){

        String datajson="{\"id\":1,\"createTime\":\"2015-6-24 12:22:30\",\"status\":\"交易成功\",\"type\":\"支付\",\"money\":5.6,\"currency\":\"RMB\",\"customerId\":1,\"customerName\":\"张三\"}";

        try {
            this.mockMvc.perform(get("/business/add.json","json").contentType(MediaType.APPLICATION_JSON).content( datajson.getBytes())).andExpect(status().isOk());

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getBusinesstListTest(){

        String datajson="{\"status\":\"交易成功\"}";

        try {
            this.mockMvc.perform(
                    get("/business/query.json").contentType(MediaType.APPLICATION_JSON).content( datajson.getBytes())).andExpect(status().isOk());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
