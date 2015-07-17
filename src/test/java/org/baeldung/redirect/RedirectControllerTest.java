package org.baeldung.redirect;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("file:src/main/webapp/WEB-INF/mvc-dispatcher-servlet.xml")
public class RedirectControllerTest {

    private MockMvc mockMvc;

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    protected WebApplicationContext wac;

    @Before
    public void setup() {
        this.mockMvc = webAppContextSetup(this.wac).build();
    }

    @Test
    public void whenRedirectOnUrlWithUsingXMLConfig_thenStatusRedirectionAndRedirectedOnUrl() throws Exception {
        this.mockMvc.perform(get("/redirectWithXMLConfig")).andExpect(status().is3xxRedirection()).andExpect(model().attribute("attribute", "redirectWithXMLConfig")).andExpect(redirectedUrl("redirectedUrl?attribute=redirectWithXMLConfig"));
    }

    @Test
    public void whenRedirectOnUrlWithRedirectPrefix_thenStatusRedirectionAndRedirectedOnUrl() throws Exception {
        this.mockMvc.perform(get("/redirectWithRedirectPrefix")).andExpect(status().is3xxRedirection()).andExpect(model().attribute("attribute", "redirectWithRedirectPrefix")).andExpect(redirectedUrl("/redirectedUrl?attribute=redirectWithRedirectPrefix"));
    }

    @Test
    public void whenRedirectOnUrlWithRedirectView_thenStatusRedirectionAndRedirectedOnUrl() throws Exception {
        this.mockMvc.perform(get("/redirectWithRedirectView")).andExpect(status().is3xxRedirection()).andExpect(model().attribute("attribute", "redirectWithRedirectView")).andExpect(redirectedUrl("redirectedUrl?attribute=redirectWithRedirectView"));
    }

    @Test
    public void whenRedirectOnUrlWithForwardPrefix_thenStatusOkAndForwardedOnUrl() throws Exception {
        this.mockMvc.perform(get("/redirectWithForwardPrefix")).andExpect(status().isOk()).andExpect(model().attribute("attribute", "redirectWithForwardPrefix")).andExpect(forwardedUrl("/redirectedUrl"));
    }

}