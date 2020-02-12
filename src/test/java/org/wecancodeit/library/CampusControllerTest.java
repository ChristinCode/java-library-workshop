package org.wecancodeit.library;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class CampusControllerTest {

    private MockMvc mockMvc;
    private CampusController underTest;
    private CampusStorage mockStorage;

    @BeforeEach
    public void setUp() {
        mockStorage = mock(CampusStorage.class);
        underTest = new CampusController(mockStorage);
        mockMvc = MockMvcBuilders.standaloneSetup(underTest).build();
    }

    @Test
    public void campusControllerShouldInstantiate() throws Exception {
        Campus testCampus = new Campus("Columbus");

        List<Campus> campusCollection = Collections.singletonList(testCampus);
        when(mockStorage.findAllCampuses()).thenReturn(campusCollection);
        mockMvc.perform(get("/campuses"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("campusesView"))
                .andExpect(model().attributeExists("campuses"))
                .andExpect(model().attribute("campuses", campusCollection));
    }
}
