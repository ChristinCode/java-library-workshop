package org.wecancodeit.library;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;
import org.wecancodeit.library.controllers.CampusController;
import org.wecancodeit.library.models.Campus;
import org.wecancodeit.library.storage.CampusStorage;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class CampusControllerTest {

    private MockMvc mockMvc;
    private CampusController underTest;
    private CampusStorage mockStorage;
    private Model mockModel;

    @BeforeEach
    public void setUp() {
        mockModel = mock(Model.class);
        mockStorage = mock(CampusStorage.class);
        underTest = new CampusController(mockStorage);
        mockMvc = MockMvcBuilders.standaloneSetup(underTest).build();
    }

    @Test
    public void shouldReturnViewWithOneCampus(){
        Campus testCampus = new Campus("TESTER TOWN");
        when(mockStorage.findCampusByLocation("LOS TESTA")).thenReturn(testCampus);

        underTest.displaySingleCampus("LOS TESTA", mockModel);

        verify(mockStorage).findCampusByLocation("LOS TESTA");
        verify(mockModel).addAttribute("campus", testCampus);
    }
    @Test
    public void shouldReturnViewNamedCampusViewWhenDisplaySingleCampusIsCalled(){
        String viewName = underTest.displaySingleCampus("LosTesta", mockModel);
        assertThat(viewName).isEqualTo("campusView");
    }

    @Test
    public void shouldGoToINdivudualEndPoint() throws Exception {
        Campus testCampus = new Campus("TESTER TOWN");
        when(mockStorage.findCampusByLocation("LOS TESTA")).thenReturn(testCampus);

        mockMvc.perform(get("/campuses/LOS TESTA"))
                .andExpect(status().isOk())
                .andExpect(view().name("campusView"))
                .andExpect(model().attributeExists("campus"))
                .andExpect(model().attribute("campus", testCampus));;
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
