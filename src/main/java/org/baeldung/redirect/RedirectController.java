package org.baeldung.redirect;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/")
public class RedirectController {

    @RequestMapping(value = "/redirectWithXMLConfig", method = RequestMethod.GET)
    public ModelAndView redirectWithUsingXMLConfig(ModelMap model) {
        model.addAttribute("attribute", "redirectWithXMLConfig");
        return new ModelAndView("RedirectedUrl", model);
    }

    @RequestMapping(value = "/redirectWithRedirectPrefix", method = RequestMethod.GET)
    public ModelAndView redirectWithUsingRedirectPrefix(ModelMap model) {
        model.addAttribute("attribute", "redirectWithRedirectPrefix");
        return new ModelAndView("redirect:/redirectedUrl", model);
    }

    @RequestMapping(value = "/redirectWithRedirectView", method = RequestMethod.GET)
    public RedirectView redirectWithUsingRedirectView(ModelMap model) {
        model.addAttribute("attribute", "redirectWithRedirectView");
        return new RedirectView("redirectedUrl");
    }

    @RequestMapping(value = "/redirectWithForwardPrefix", method = RequestMethod.GET)
    public ModelAndView redirectWithUsingForwardPrefix(ModelMap model) {
        model.addAttribute("attribute", "redirectWithForwardPrefix");
        return new ModelAndView("forward:/redirectedUrl", model);
    }
}