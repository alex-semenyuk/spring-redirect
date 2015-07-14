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
	
	@RequestMapping(value="/testRedirectWithXMLConfig",method = RequestMethod.GET)
	public ModelAndView testRedirectWithRedirect(ModelMap model) {
		model.addAttribute("attribute", "testRedirectWithXMLConfig");
		return new ModelAndView("RedirectedUrl", model);
	}

	@RequestMapping(value="/testRedirectWithRedirectPrefix",method = RequestMethod.GET)
	public ModelAndView testRedirectWithRedirectPrefix(ModelMap model) {
		model.addAttribute("attribute", "testRedirectWithRedirectPrefix");
		return new ModelAndView("redirect:/redirectedUrl", model);
	}

	@RequestMapping(value="/testRedirectWithRedirectView", method = RequestMethod.GET)
	public RedirectView testRedirectWithRedirectView(ModelMap model) {
		model.addAttribute("attribute", "testRedirectWithRedirectView");
		return new RedirectView("redirectedUrl");
	}

	@RequestMapping(value="/testRedirectWithForwardPrefix",method = RequestMethod.GET)
	public ModelAndView testRedirectWithForwardPrefix(ModelMap model) {
		model.addAttribute("attribute", "testRedirectWithForwardPrefix");
		return new ModelAndView("forward:/redirectedUrl", model);
	}

	@RequestMapping(value="/redirectedUrl", method = RequestMethod.GET)
	public ModelAndView redirection(ModelMap model) {
		model.addAttribute("message", "Test redirection");
		return new ModelAndView("redirect", model);
	}

}