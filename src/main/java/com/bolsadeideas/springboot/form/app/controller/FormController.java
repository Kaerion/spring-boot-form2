package com.bolsadeideas.springboot.form.app.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.bolsadeideas.springboot.form.app.models.domain.Usuario;

@Controller
public class FormController {

	@GetMapping("/form")
	public String form(Model model) {
		model.addAttribute("titulo", "Formulario usuario");
		model.addAttribute("usuario", new Usuario());
		return "form";
	}

	@PostMapping("/form")
	public String procesar(@Valid Usuario user, BindingResult result, Model model) {

		model.addAttribute("titulo", "Formulario usuario");

		if (result.hasErrors()) {
			Map<String, String> errores = new HashMap<>();
			result.getFieldErrors().forEach(err -> {
				errores.put(err.getField(), "El campo " + err.getField() + " " + err.getDefaultMessage());
			});
			model.addAttribute("error", errores);
			return "form";
		}

		model.addAttribute("usuario", user);
		return "resultado";
	}

//	@PostMapping("/form")
//	public String procesar(Model model, @RequestParam(name = "username") String username,
//			@RequestParam(name = "password") String password, @RequestParam(name = "email") String email) { // Para que
//																											// Spring
//																											// lo
//																											// obtenga,
//																											// la
//																											// variable
//																											// tiene que
//																											// tener el
//																											// mismo
//																											// nombre
//																											// que el
//																											// name
//																											// del campo
//																											// del
//																											// form o
//																											// especificarle
//																											// el name
//																											// con
//																											// parentesis
//																											// en
//																											// el
//																											// request
//																											// param
//
//		Usuario user = new Usuario(username, password, email);
//
//		model.addAttribute("titulo", "Resultado form");
//		model.addAttribute("user", user);
//
//		return "resultado";
//	}

}
