package org.wecancodeit.library;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@DirtiesContext
@SpringBootTest
@AutoConfigureMockMvc
public class SpringWebApplicationTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private CampusStorage campusStorage;

    @Test
    public void shouldReceiveOKFromCampusesEndpoint() throws Exception {
        mockMvc.perform(get("/campuses"))
               .andDo(print())
               .andExpect(status().isOk());
    }

    @Test
    public void shouldReceiveOKFromSingleCampusEndpoint() throws Exception {
        Campus testCampus = new Campus("Testerville");
        when(campusStorage.findCampusByLocation("Testerville")).thenReturn(testCampus);
        mockMvc.perform(get("/campuses/Testerville"))
               .andExpect(status().isOk());
    }
}
