package org.baeldung.redirect;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/")
public class RedirectController {

    @RequestMapping(value = "/redirectWithXMLConfig", method = RequestMethod.GET)
    public ModelAndView redirectWithUsingXMLConfig(final ModelMap model) {
        model.addAttribute("attribute", "redirectWithXMLConfig");
        return new ModelAndView("RedirectedUrl", model);
    }

    @RequestMapping(value = "/redirectWithRedirectPrefix", method = RequestMethod.GET)
    public ModelAndView redirectWithUsingRedirectPrefix(final ModelMap model) {
        model.addAttribute("attribute", "redirectWithRedirectPrefix");
        return new ModelAndView("redirect:/redirectedUrl", model);
    }

    @RequestMapping(value = "/redirectWithRedirectView", method = RequestMethod.GET)
    public RedirectView redirectWithUsingRedirectView(final RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("flashAttribute", "redirectWithRedirectView");
        redirectAttributes.addAttribute("attribute", "redirectWithRedirectView");
        return new RedirectView("redirectedUrl");
    }

    @RequestMapping(value = "/redirectWithForwardPrefix", method = RequestMethod.GET)
    public ModelAndView redirectWithUsingForwardPrefix(final ModelMap model) {
        model.addAttribute("attribute", "redirectWithForwardPrefix");
        return new ModelAndView("forward:/redirectedUrl", model);
    }
    
    @RequestMapping(value = "/redirectedUrl", method = RequestMethod.GET)
    public ModelAndView redirection(final ModelMap model, @ModelAttribute("flashAttribute") final Object flashAttribute) {
        model.addAttribute("redirectionAttribute", flashAttribute);
        return new ModelAndView("redirection", model);
    }
}